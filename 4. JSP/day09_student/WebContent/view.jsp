<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<div id="main">
	<h3>단일 조회</h3>
	
	<c:set var="dto" value="${dao.selectOne(param.name) }" />

	<ul>
		<li>이름 : ${dto.name }</li>
		<li>국어점수 : ${dto.kor }점</li>
		<li>영어점수 : ${dto.eng }점</li>
		<li>수학점수 : ${dto.math }점</li>
		<li>합계점수 : ${dto.total }점</li>
		<li>평균점수 : ${dto.avg}점</li>
	</ul>
</div>
</body>
</html>