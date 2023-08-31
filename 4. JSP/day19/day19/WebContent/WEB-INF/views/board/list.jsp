<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

	<table>
		<thead>
			<tr>
				<th>IDX</th>
				<th>TITLE</th>
				<th>WRITER</th>
				<th>CONTENT</th>
				<th>WDATE</th>
				<th>DELETE</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="dto" items="${list }">
			<tr>
				<td>${dto.idx }</td>
				<td><a href="${cpath }/ex05/view?idx=${dto.idx}">${dto.title }</a></td>
				<td>${dto.writer}</td>
				<td>${dto.content}</td>
				<td>${dto.wdate}</td>
				<td><a href="${cpath }/ex05/delete?idx=${dto.idx}"><button>삭제</button></a>
			</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>