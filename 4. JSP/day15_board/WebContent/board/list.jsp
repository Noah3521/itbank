<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<main>
	<p>${boardDAO.getTotal() }개의 글</p>
	<table>
		<thead>
			<tr>
				<th class="idx">IDX</th>
				<th class="title">제목</th>
				<th class="writer">작성자</th>
				<th class="wdate">작성일</th>
			</tr>
		</thead>
		<tbody>
		<c:set var="list" value="${boardDAO.selectList() }" />
		<c:forEach var="dto" items="${list }">
			<tr>
				<td class="idx">${dto.idx }</td>
				<td class="title"><a href="${cpath }/board/view.jsp?idx=${dto.idx}">${dto.title }</a></td>
				<td class="writer">${dto.writer }</td>
				<td class="wdate">${dto.wdate }</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
</main>

</body>
</html>