package ex05;


import javax.servlet.http.HttpServlet;

public class Ex05Servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected BoardDAO dao = BoardDAO.getInstance();
	
	protected String prefix = "/WEB-INF/views/";
	protected String suffix = ".jsp";
	
}
