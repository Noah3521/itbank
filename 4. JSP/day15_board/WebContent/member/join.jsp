<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<form method="POST" action="join-action.jsp">
	<p><input type="text" name="userid" placeholder="userid" required></p>
	<p><input type="password" name="userpw" placeholder="userpw" required></p>
	<p><input type="text" name="username" placeholder="username" required></p>
	<p><input type="email" name="email" placeholder="email" required></p>
	<p><input type="text" name="birth" placeholder="birth" required></p>
	<p><input type="submit" value="회원가입">
</form>

</body>
</html>