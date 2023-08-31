<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<h3>작성 페이지</h3>

<form method="POST">
	<p><input type="text" name="title" placeholder="TITLE" required></p>
	<p><input type="text" name="writer" placeholder="WRITER" required></p>
	<p><input type="text" name="content" placeholder="CONTENT" required></p>
	<p><input type="submit"></p>
</form>

</body>
</html>