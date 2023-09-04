<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<table>
	<tr>
		<th>id</th>
		<th>artist_id</th>
		<th>name</th>
		<th>type</th>
		<th>rdate</th>
		<th>playtime</th>
		<th>coverimg</th>
	</tr>
	<c:forEach var="dto" items="${list }">
	<tr>
		<td>${dto.id }</td>
		<td>${dto.artist_id }</td>
		<td><a href="${cpath}/album/view?id=${dto.id}">${dto.name }</a></td>
		<td>${dto.type }</td>
		<td>${dto.rdate }</td>
		<td>${dto.playtime }</td>
		<td>
			<c:if test="${not empty dto.coverimg }">
			<img src="${cpath }/album_img/${dto.coverimg }" width="200">
			</c:if>
		</td>
	</tr>
	</c:forEach>
</table>

</body>
</html>