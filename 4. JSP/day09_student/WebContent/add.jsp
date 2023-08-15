<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<div id="main">
	<h3>추가</h3>
</div>

<form action="add-action.jsp" method="POST">
	<p><input type="text" 	name="name" placeholder="이름"></p>
	<p><input type="number" name="kor" placeholder="국어" min=0 max=100></p>
	<p><input type="number" name="math" placeholder="수학" min=0 max=100></p>
	<p><input type="number" name="eng" placeholder="영어" min=0 max=100></p>
	<p><input type="submit"></p>
</form>

</body>
</html>