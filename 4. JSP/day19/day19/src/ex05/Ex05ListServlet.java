package ex05;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex05ListServlet extends Ex05Servlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewName = "board/list";
		
		List<BoardDTO> list = dao.selectList();
		
		request.setAttribute("list", list);
		
		String path = prefix + viewName + suffix;
		
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}	
}
