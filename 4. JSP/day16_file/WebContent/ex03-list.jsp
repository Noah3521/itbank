<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="ex03-header.jsp" %>


<div class="list">
	<c:forEach var="dto" items="${dao.selectList() }">
	
	<details>
		<summary><b>${dto.idx} | ${dto.title }</b></summary>
		<img src="${dto.filePath }">
	</details>
	
	</c:forEach>
</div>

</body>
</html>