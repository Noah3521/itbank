<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<form method="POST" enctype="multipart/form-data">
<input type="hidden" name="id" value="${param.id }">
	<table>
		<tr><th><input type="number" name="artist_id" value="${dto.artist_id }" placeholder="아티스트 번호" required autofocus autocomplete="off"></th></tr>
		<tr><th><input type="text" name="name" value="${dto.name }" placeholder="제목" autocomplete="off"></th></tr>
		<tr><th><input type="text" name="type" value="${dto.type }" placeholder="유형" required></th></tr>
		<tr><th><input type="date" name="rdate" value="${dto.rdate }" placeholder="발매일" required></th></tr>
		<tr><th><input type="number" name="playtime" value="${dto.playtime }" placeholder="재생시간" required></th></tr>
		<tr><th><input type="file" name="coverimg" placeholder="앨범커버" accept="image/*"></th></tr>
		<tr><th><input type="submit"></th></tr>
	</table>
</form>

</body>
</html>