<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<form method="POST" action="login-action.jsp">
	<p><input type="text" name="userid" placeholder="ID" required></p>
	<p><input type="password" name="userpw" placeholder="Password" required></p>
	<p>
		<label><input type="checkbox" name="autologin">자동 로그인</label>
	</p>
	<p><input type="submit" value="로그인"></p>
</form>

</body>
</html>