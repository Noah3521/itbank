package ex02;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex02Servlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private String prefix = "/WEB-INF/views/";
	private String suffix = ".jsp";
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Ex02Servlet으로 요청이 들어옴");
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String viewName = prefix + "ex02" + suffix;
		
		
		// 요청은 서블릿이 받았지만, 응답은 jsp로 하겠다 (포워딩)
		System.out.println("응답을 처리할 jsp : " + viewName);

		String name = request.getParameter("name");
		request.setAttribute("name", name);
		
		RequestDispatcher rd = request.getRequestDispatcher(viewName);
		rd.forward(request, response);
	}
	
}
