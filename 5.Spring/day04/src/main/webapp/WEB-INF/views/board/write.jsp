<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<div class="layout">
<form method="post" enctype="multipart/form-data">
	<p><input type="text" name="title" placeholder="TITLE"></p>
	<p><input type="text" name="writer" placeholder="WRITER"></p>
	<p><input type="password" name="password" placeholder="PASSWORD"></p>
	<p><textarea name="content" placeholder="CONTENT"></textarea></p>
	<p><input type="file" name="uploadFile"></p>
	<p><button type="submit">작성</button>
</form>
</div>

</body>
</html>