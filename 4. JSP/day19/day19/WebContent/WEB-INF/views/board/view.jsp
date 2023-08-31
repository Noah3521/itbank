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
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${dto.idx }</td>
				<td>${dto.title }</td>
				<td>${dto.writer}</td>
				<td>${dto.content}</td>
				<td>${dto.wdate}</td>
			</tr>
		</tbody>
	</table>

</body>
</html>