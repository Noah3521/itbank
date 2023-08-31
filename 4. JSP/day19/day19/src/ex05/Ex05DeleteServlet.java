package ex05;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex05DeleteServlet extends Ex05Servlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idx = request.getParameter("idx");
		String cpath = request.getContextPath();
		
		if(idx==null) {
			response.sendRedirect(cpath + "/ex05");
			return;
		}
		
		int i = Integer.parseInt(idx);
		
		int row = dao.delete(i);
		
		System.out.println(row + "행이 삭제되었습니다");
		
		response.sendRedirect(cpath + "/ex05");
	}
	
}
