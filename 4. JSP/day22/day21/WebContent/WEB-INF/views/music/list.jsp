<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<h3>list</h3>
<table>
<c:forEach var="musicDTO" items="${musicList }">
<tr>
	<th>ID</th>
	<th>${musicDTO.id }</th>
</tr>
<tr>
	<th>artist_id</th>
	<th>${musicDTO.artist_id }</th>
</tr>
<tr>
	<th>album_id</th>
	<th>${musicDTO.album_id }</th>
</tr>
<tr>
	<th>name</th>
	<th>${musicDTO.name }</th>
</tr>
<tr>
	<th>genre</th>
	<th>${musicDTO.genre }</th>
</tr>
<tr>
	<th>playtime</th>
	<th>${musicDTO.playtime }</th>
</tr>
<tr>
	<th>lyrics</th>
	<th>${musicDTO.lyrics }</th>
</tr>
<tr>
	<th>playCount</th>
	<th>${musicDTO.playCount }</th>
</tr>
</c:forEach>
</table>
</body>
</html>