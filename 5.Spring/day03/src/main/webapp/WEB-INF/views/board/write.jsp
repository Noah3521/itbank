<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<div class="layout">
	<form method="POST" enctype="multipart/form-data">
		<input type="text" name="writer" placeholder="작성자" required>
		<input type="password" name="password" placeholder="비밀번호" required>
		<input type="text" name="title" placeholder="제목" required autofocus>
		<input type="text" name="content" placeholder="내용" required>
		<input type="file" name="uploadFile">
		<button type="submit">제출</button>
	</form>
</div>

</body>
</html>