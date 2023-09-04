package org.springframework.web.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbank.controller.Controller;

public class DispatcherServlet extends HttpServlet {
	// 모든 요청을 받아서 처리하는 유일한 서블릿
	
	private static final long serialVersionUID = 1L;
	private final String prefix = "/WEB-INF/views/";
	private final String suffix = ".jsp";
	
	private Map<String, Controller> map = new HashMap<>();
	
	@Override
	public void init() throws ServletException {
		// 1) web.xml에 서블릿을 등록할 때, 미리 지정한 설정파일을 불러온다
		String configFile = getInitParameter("configFile");
		
		Properties pro = new Properties();	// Map<String, String>	
//		파일을 직접 여는 클래스가 아니므로 FileInputStream 객체를 매개변수로 받음
//		load() 메소드를 통해 파일 정보를 넣어줌
		
		FileInputStream fis = null;	// pro의 매개변수
		
		// command.properties 경로
		String configFilePath = getServletContext().getRealPath(configFile);
		
		try {
			// command.properties의 내용을 key value 형태로 불러옴
			fis = new FileInputStream(configFilePath);

			// 설정파일의 내용을 pro에 담는다 (주소=클래스 ex: [key: /]=[value: controller.HomeController])
			pro.load(fis);	
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fis != null) fis.close(); 
			} catch (Exception e) {}
		}
		
		// pro에 저장된 클래스 이름을 기반으로 실제 클래스를 불러오고, 객체를 하나 생성해서
		// 주소=객체 의 형식으로 map에 저장한다
		
		// 주소 정보를 담은 Iterator 생성
		Iterator<Object> it = pro.keySet().iterator();
		while(it.hasNext()) {
			// command : 주소(url)
			String command = (String) it.next();
			
			// key인 [주소]를 넣으면 해당하는 [클래스 이름]이 담긴 value를 반환함
			String handlerClassName = pro.getProperty(command);
			try {
				// 꺼내온 [클래스 이름]으로 해당하는 [클래스]를 불러옴
				Class<?> handlerClass = Class.forName(handlerClassName);
				
				// 불러온 클래스의 기본생성자를 호출하여 [객체화] 시킴
				Controller handlerInstance = (Controller) handlerClass.newInstance();
				
				// 불러온 객체를 map에 저장함 (key: 주소, value: 객체)
				map.put(command, handlerInstance);
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				System.err.println("\n\t[ 컨트롤러 객체를 로드하는데 실패했습니다 ]\n");
				return;
			}
		}
		System.out.println("\n\t[서블릿 초기화 성공]\n");
		for(String key : map.keySet()) {
			System.out.println(key + " : " + map.get(key));
		}
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 요청받은 주소 (URI)
		String command = request.getRequestURI();
		
		if(command.indexOf(request.getContextPath())==0) {
			// /프로젝트명/요청주소 
			command = command.substring(request.getContextPath().length());
			// /요청주소 
		}
		
		// (key:요청) 주소 로 (value:객체)를 꺼내옴
		Controller controller = map.get(command);
//		if(controller == null) controller = map.get("/");
		
		// 출력할 jsp의 이름
		String viewName = null;
		try {
			switch(request.getMethod()) {
			case "GET": viewName = controller.doGet(request, response); break;
			case "POST": viewName = controller.doPost(request, response); break;
			}
		} catch (Throwable e) {
			e.printStackTrace();
			throw new ServletException(e.getMessage());
		}
		if(viewName != null) {
			// redirect
			if(viewName.startsWith("redirect:")) {
				viewName = viewName.substring("redirect:".length());
				response.sendRedirect(request.getContextPath() + viewName);
			}
			// forward (default)
			else {
				viewName = prefix + viewName + suffix;
				request.getRequestDispatcher(viewName).forward(request, response);
			}
		} 
		
		System.out.println("요청받은 주소 : " + command);
		System.out.println("함수를 실행할 컨트롤러 클래스 이름 : " + map.get(command).getClass().getSimpleName());
		System.out.println("요청 메서드 : " + request.getMethod());
		System.out.println("화면을 보여줄 JSP : " + viewName);
	}


}
