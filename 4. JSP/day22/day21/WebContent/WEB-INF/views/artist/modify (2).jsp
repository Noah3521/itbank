<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<form method="POST" enctype="multipart/form-data">
	<input type="hidden" name="id" value="${param.id }">
	<table>
		<tr><th><input type="text" name="name" value="${dto.name }" placeholder="이름" required autofocus autocomplete="off"></th></tr>
		<tr><th><input type="text" name="company" value="${dto.company }" placeholder="회사" autocomplete="off"></th></tr>
		<tr><th><input type="text" name="country" value="${dto.country }" placeholder="국적" autocomplete="off"></th></tr>
		<tr><th><input type="text" name="member" value="${dto.member }" placeholder="멤버" required autocomplete="off"></th></tr>
		<tr><th><input type="date" name="debut"  value="${dto.debut }" placeholder="데뷔일"></th></tr>
		<tr><th><input type="text" name="type" value="${dto.type }" placeholder="유형" required autocomplete="off"></th></tr>
		<tr><th>
			<h3>현재 파일 : ${dto.profileimg!=null ? dto.profileimg : '없음' }<span id="profileDelBtn">${dto.profileimg!=null ? '❌' : '' }</span></h3>
		</th></tr>
		<tr><th><input type="file" name="profileimg" placeholder="프로필이미지" accept="image/*"></th></tr>
		<tr><th><input type="submit"></th></tr>
	</table>
</form>

<script>
	const profileDelBtn = document.getElementById('profileDelBtn');
	profileDelBtn.onclick = function() {
	}
</script>

</body>
</html>