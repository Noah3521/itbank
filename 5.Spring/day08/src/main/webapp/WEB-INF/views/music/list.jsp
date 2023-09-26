<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<h3>음원 목록</h3>

<table>
	<c:forEach var="dto" items="${list }">
	<tr>
		<td>${dto.id  }</td>
		<td>${dto.isTitle != 0 ? '타이틀' : '' }</td>
		<td>${dto.artist_id  }</td>
		<td>${dto.album_id }</td>
		<td>${dto.name }</td>
		<td>${dto.genre }</td>
		<td>${dto.playTime }</td>
		<td>
			<c:if test="${fn:length(dto.lyrics) > 10 }">
				${fn:substring(dto.lyrics, 0 , 10) }...
			</c:if>
			<c:if test="${fn:length(dto.lyrics) > 10 == false}">
				${dto.lyrics }
			</c:if>
		</td>
	</tr>
	</c:forEach>
</table>

</body>
</html>