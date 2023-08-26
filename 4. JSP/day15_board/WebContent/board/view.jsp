<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<c:set var="dto" value="${boardDAO.selectOne(param.idx) }" />

<style>

</style>

<div id="board">
	<h2>${dto.title }</h2>
	<p><strong>작성자</strong> | ${dto.writer }</p>
	<p>${dto.wdate }</p>
	<hr>
	<p>${dto.content }</p>

	<div class="btns">
		<button id="deleteBtn">삭제</button>
		<a href="${cpath }/board/modify.jsp?idx=${dto.idx }"><button>수정</button></a>
	</div>
</div>


<script>
	const deleteBtn = document.getElementById('deleteBtn');
	
	deleteBtn.onclick = function() {
		if(confirm('진짜?')) {
			location.href='${cpath }/board/delete.jsp?idx=${dto.idx }'
		} 
	}
</script>

</body>
</html>