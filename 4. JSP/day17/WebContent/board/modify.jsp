<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<c:set var="dto" value="${boardDAO.selectOne(param.idx) }" />
<c:if test="${not (login.userid eq dto.writer) }">
	<script>
		alert('다른 유저가 작성한 글입니다.');
		history.go(-1);
	</script>
</c:if>

<form method="POST" enctype="multipart/form-data" action="modify-action.jsp">
	<input type="hidden" name="idx" value="${dto.idx }">
	<input type="hidden" name="writer" value="${dto.writer }" value="${login.userid }" >
	
	<p><input type="text" name="title" value="${dto.title }" placeholder="제목" required></p>
	<p>
		<textarea name="content" placeholder="내용" required>${dto.content }</textarea>
	</p>
	<p><input type="file" name="image" accept="image/*"></p>
	<p><input type="submit"></p>
</form> 

</body>
</html>