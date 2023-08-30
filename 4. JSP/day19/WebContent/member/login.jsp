<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<div class="frame">
	<h2>로그인</h2>
	<form method="POST" action="login-action.jsp" class="loginForm">
		<p><input type="text" name="userid" placeholder="ID" required autocomplete="off" autofocus></p>
		<p><input type="password" name="userpw" placeholder="PASSWORD" required></p>
		<p><input type="submit" value="로그인" class="loginBtn"></p>
	</form>
	<p class="joinMsg">회원 가입은 <a href="${cpath }/member/join.jsp" class="joinBtn">여기</a>에서 할 수 있습니다.</p>
</div>

</body>
</html>