<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<jsp:useBean id="user" class="member.MemberDTO" />
<jsp:setProperty property="*" name="user"/>

<c:set var="login" value="${memberDAO.login(user) }" scope="session" />

<%
	Cookie c = new Cookie("JSESSIONID", session.getId());
	c.setPath(request.getContextPath());
	c.setMaxAge(60 * 60 * 24 * 7);
	response.addCookie(c);
%>

<script>
	const login = '${login}'
	if(login==''){
		alert('로그인 실패')
		history.go(-1)
	}else {
		location.href='${cpath}'	
	}
</script>

</body>
</html>