<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<c:set var="dto" value="${memberDAO.selectOne(param.userid) }" />
<c:if test="${dto.userid != login.userid }">
	<script>
		alert('본인의 정보가 아닙니다')
		history.go(-1);
	</script>
</c:if>

<div class="frame">
	<h2>회원정보 수정</h2>
	<form method="POST" action="modify-action.jsp" class="joinForm">
		<p><input type="text" name="userid" value="${dto.userid }" placeholder="ID" required autocomplete="off" readonly></p>
		<p><input type="password" name="userpw" placeholder="PASSWORD" required></p>
		<p><input type="text" name="username" value="${dto.username }" placeholder="USERNAME" required></p>
		<p><input type="text" name="email" value="${dto.email }" placeholder="EMAIL" required></p>
		<p><input type="text" name="birth" value="${dto.birth }" placeholder="BIRTH" required></p>
		<div class="btns">
		<p><input type="submit" value="수정" class="updateBtn"></p>
		<p id="delUserBtn">탈퇴</p>
		</div>
	</form>
</div>

<script>
	const delUserBtn = document.getElementById('delUserBtn')
	delUserBtn.onclick = function() {
		if(confirm('절말 탈퇴하시겠습니까?')) {
			location.href='${cpath}/member/delete.jsp?userid=${login.userid}'
		}
	}
</script>

</body>
</html>