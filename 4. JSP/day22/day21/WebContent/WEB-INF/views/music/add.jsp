<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<form method="POST">
<input type="hidden" name="artist_id" value="${param.artist_id }" placeholder="artist_id">
<input type="hidden" name="album_id" value="${param.album_id }" placeholder="album_id">
<table>
<tr>
	<th>name</th>
	<th><input type="text" name="name" placeholder="name" required></th>
</tr>
<tr>
	<th>genre</th>
	<th><input type="text" name="genre" placeholder="genre" required></th>
</tr>
<tr>
	<th>playtime</th>
	<th><input type="number" name="playtime" placeholder="playtime" required></th>
</tr>
<tr>
	<th>lyrics</th>
	<th><textarea name="lyrics" placeholder="lyrics" required></textarea></th>
</tr>
<tr>
	<th>제출</th>
	<th><button>제출</button></th>
</tr>
</table>
</form>
</body>
</html>