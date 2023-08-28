<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<table>
	<thead>
		<tr>
			<th>idx</th>
			<td>title</td>
			<td>writer</td>
			<td>content</td>
			<td>uploadFile</td>
			<td>wdate</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="dto" items="${boardDAO.selectList() }">
		<tr>
			<td>${dto.idx }</td>
			<td>
				<a href="${cpath }/board/view.jsp?idx=${dto.idx}">${dto.title }</a>
			</td>
			<td>${dto.writer }</td>
			<td>${dto.content }</td>
			<c:if test="${not empty dto.uploadFile }">
			<td><img src="${cpath }/upload/${dto.uploadFile }"></td>
			</c:if>
			<td>${dto.wdate}</td>
		</tr>
		</c:forEach>
	</tbody>
</table>

</body>
</html>