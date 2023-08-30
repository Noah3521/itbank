<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<c:set var="dto" value="${boardDAO.selectOne(param.idx) }" />

<div class="frame">

	<h3>${dto.title }</h3>
	<p>${dto.writer } | ${dto.wdate }</p>
	<hr>
	
	<p>${dto.content }</p>
	
	<c:if test="${not empty dto.uploadFile}">
		<img src="${cpath }/upload/${dto.uploadFile}" width="200">
	</c:if>
	
	<p>
		<a href="${cpath }/board/modify.jsp?idx=${dto.idx}"><button>수정</button></a>
		<button id="deleteBtn">삭제</button>	
	</p>
</div>

<script>
	const deleteBtn = document.getElementById('deleteBtn')
	deleteBtn.onclick = function() {
		if(confirm('진짜 삭제할거임?')) {
			location.href = '${cpath }/board/delete.jsp?idx=${dto.idx}'
		}
	}
</script>
</body>
</html>