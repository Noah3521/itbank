<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<form method="POST">
<input type="hidden" name="artist_id" value="${dto.artist_id }" placeholder="artist_id" required>
<input type="hidden" name="album_id" value='${dto.album_id }' placeholder="album_id" required>
<input type="hidden" name="id" value="${param.id }" required>
<table>
<tr>
	<th>name</th>
	<th><input type="text" name="name" value="${dto.name }" placeholder="name" required></th>
</tr>
<tr>
	<th>genre</th>
	<th><input type="text" name="genre" value="${dto.genre }" placeholder="genre" required></th>
</tr>
<tr>
	<th>playtime</th>
	<th><input type="number" name="playtime" value="${dto.playtime }" placeholder="playtime" required></th>
</tr>
<tr>
	<th>lyrics</th>
	<th><textarea name="lyrics" placeholder="lyrics">${dto.lyrics }</textarea></th>
</tr>
<tr>
	<th>제출</th>
	<th><button>제출</button></th>
</tr>
</table>
</form>
</body>
</html>