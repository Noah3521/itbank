<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<table>
	<c:forEach var="dto" items="${list }" >
	<tr>
		<th rowspan="7">
		<c:if test="${not empty dto.profileimg }">
			<img src="${cpath }/artist_img/${dto.profileimg }" width="200">
		</c:if>
		</th>
	</tr>
	<tr>
		<td><h2><a href="${cpath}/artist/view?id=${dto.id}">${dto.name }</a></h2></td>
	</tr>
	<tr>
		<th>데뷔</th>
		<td>${dto.debut}</td>
	</tr>
	<tr>
		<th>활동유형</th>
		<td>${dto.type}</td>
	</tr>
	<tr>
		<th>멤버</th>
		<td>${dto.member}</td>
	</tr>
	<tr>
		<th>소속사</th>
		<td>${dto.company}</td>
	</tr>
	<tr>
		<th>국적</th>
		<td>${dto.country}</td>
	</tr>
	</c:forEach>
</table>

</body>
</html>