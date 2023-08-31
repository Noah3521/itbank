package ex05;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex05ViewServlet extends Ex05Servlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cpath = request.getContextPath();
		String idx = request.getParameter("idx");
		
		String viewName = "board/view";
		
		if (idx==null) {
			response.sendRedirect(cpath + "/ex05");
			return;
		}
		
		int i = Integer.parseInt(idx);
		
		BoardDTO dto = dao.selectOne(i);
		request.setAttribute("dto", dto);
		
		String path = prefix + viewName + suffix;
		
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
	
}
