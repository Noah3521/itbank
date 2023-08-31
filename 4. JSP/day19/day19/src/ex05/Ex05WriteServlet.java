package ex05;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex05WriteServlet extends Ex05Servlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewName = "board/write";
		String path = prefix + viewName + suffix;
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String viewName = "/ex05/view";
		
		BoardDTO dto = new BoardDTO();
		dto.setTitle(request.getParameter("title"));
		dto.setWriter(request.getParameter("writer"));
		dto.setContent(request.getParameter("content"));
		
		int row = dao.insert(dto);
		System.out.println(row + "행이 추가되었습니다");
		
		String cpath = request.getContextPath();
		String path = viewName + "?idx=" + dao.getMaxIdx();
		
		System.out.println(dao.getMaxIdx());
		
		System.out.println(cpath + path);
		response.sendRedirect(cpath + path);
	}
}
