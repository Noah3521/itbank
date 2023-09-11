<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<div class="layout">
	<form method="POST" enctype="multipart/form-data">
		<input type="text" name="writer" value="${dto.writer }" readonly>
		<input type="text" name="title" value="${dto.title }" placeholder="제목" required autofocus>
		<input type="text" name="content" value="${dto.content }" placeholder="내용" required>
		<input type="file" name="uploadFile">
		<button type="submit">수정</button>
	</form>
</div>

</body>
</html>