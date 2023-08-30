<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<div class="frame">
	<h2>회원가입</h2>
	<form method="POST" action="join-action.jsp" class="joinForm">
		<p><input type="text" name="userid" placeholder="ID" required autocomplete="off" autofocus></p>
		<p><input type="password" name="userpw" placeholder="PASSWORD" required></p>
		<p><input type="text" name="username" placeholder="USERNAME" required></p>
		<p><input type="text" name="email" placeholder="EMAIL" required></p>
		<p><input type="text" name="birth" placeholder="BIRTH" required></p>
		<p><input type="submit" value="로그인" class="loginBtn"></p>
	</form>
</div>

</body>
</html>