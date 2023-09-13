<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<div class="layout">
<form method="post" enctype="multipart/form-data">
	<p><input type="text" name="title" value="${dto.title }" placeholder="TITLE"></p>
	<p><input type="text" name="writer" value="${dto.writer }" placeholder="WRITER" readonly></p>
	<p><input type="password" name="password" value="${dto.title }" placeholder="PASSWORD" readonly></p>
	<p><textarea name="content" placeholder="CONTENT">${dto.content }</textarea></p>
	<p><input type="file" name="uploadFile"> <span>${dto.fileName }</span></p>
	<p><button type="submit">작성</button>
</form>
</div>

</body>
</html>