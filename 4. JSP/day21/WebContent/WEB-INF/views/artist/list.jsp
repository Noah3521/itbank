<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<table>
	<thead>
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>COMPANY</th>
			<th>COUNTRY</th>
			<th>MEMBER</th>
			<th>DEBUT</th>
			<th>TYPE</th>
			<th>PROFILIMG</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="dto" items="${list }" >
		<tr>
			<td>${dto.id }</td>
			<td><a href="${cpath}/artist/view?id=${dto.id}">${dto.name }</a></td>
			<td>${dto.company}</td>
			<td>${dto.country}</td>
			<td>${dto.member}</td>
			<td>${dto.debut}</td>
			<td>${dto.type}</td>
			<td>
			<c:if test="${not empty dto.profileimg }">
				<img src="${cpath }/artist_img/${dto.profileimg }" width="200">
			</c:if>
			</td>
		</tr>
		</c:forEach>
	</tbody>
</table>

</body>
</html>