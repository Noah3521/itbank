<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<form method="POST" enctype="multipart/form-data">
	<table>
		<tr><th><input type="number" name="artist_id" placeholder="아티스트 번호" required autofocus autocomplete="off"></th></tr>
		<tr><th><input type="text" name="name" placeholder="제목" autocomplete="off"></th></tr>
		<tr><th><input type="text" name="type" placeholder="유형" required></th></tr>
		<tr><th><input type="date" name="rdate" placeholder="발매일" required></th></tr>
		<tr><th><input type="number" name="playtime" placeholder="재생시간" required></th></tr>
		<tr><th><input type="file" name="coverimg" placeholder="앨범커버" accept="image/*"></th></tr>
		<tr><th><input type="submit"></th></tr>
	</table>
</form>

</body>
</html>