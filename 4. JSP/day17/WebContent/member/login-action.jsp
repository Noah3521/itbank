<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<jsp:useBean id="user" class="member.MemberDTO" />
<jsp:setProperty property="*" name="user"/>

<c:set var="login" value="${memberDAO.login(user) }" scope="session" />

<%
	Cookie c = new Cookie("JSESSIONID", session.getId());
	c.setMaxAge(60 * 60 * 24 * 7);
	c.setPath(request.getContextPath());
	response.addCookie(c);
%>

<script>
	if('${login}' !=null) {
		location.href='${cpath}';
	} else {
		alert('로그인실패');
		history.go(-1);
	}
</script>

</body>
</html>