<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<c:set var="dto" value="${dao.selectOne(param.name) }" />

<form action="modify-action.jsp" method="POST">
	<p><input type="text" 	name="name" placeholder="이름" value="${dto.name }" readonly></p>
	<p><input type="number" name="kor" placeholder="국어" value="${dto.kor }" min=0 max=100></p>
	<p><input type="number" name="math" placeholder="수학" value="${dto.math }" min=0 max=100></p>
	<p><input type="number" name="eng" placeholder="영어" value="${dto.eng }" min=0 max=100></p>
	<p><input type="submit"></p>
</form>

</body>
</html>