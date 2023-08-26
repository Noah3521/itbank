<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<script>
	if('${login}'!=null) alert('로그인성공')
	else alert('로그인실패')
</script>

<jsp:useBean id="user" class="member.MemberDTO" />
<jsp:setProperty property="*" name="user"/>

<c:set var="login" value="${memberDAO.login(user) }" scope="session" />

<%
	String autologin = request.getParameter("autologin");
	if(autologin!=null) {
		Cookie c = new Cookie("JSESSIONID", session.getId());
		c.setMaxAge(60 * 60 * 24);
		c.setPath(request.getContextPath());
		response.addCookie(c);
	}
	response.sendRedirect(request.getContextPath());
%>


</body>
</html>