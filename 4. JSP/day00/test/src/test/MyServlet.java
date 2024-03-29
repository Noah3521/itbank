package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//
		//  request : 클라이언트에서 보낸 메시지가 담겨있는객체
		// 	response : 클라이언트에서 보낼 메시지를 주고받기 때문에  글자 인코딩 규칙은 필수이다 (UTF: 8)
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>서블릿</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("	<h1>MyServlet</h1>");
		out.println("	<hr>");
		out.println("	<h3>지금은");
		// <%
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss");
		String now = sdf.format(date);
		// %>
		out.println(now + "입니다</h3>");
		out.println("	</body>");
		out.println("</html>");	
	};
	
}
