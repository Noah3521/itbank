<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>day03 - board</title>
</head>
<body>

<div class="layout">
	<ul>
		<li><a href="${cpath }/board/">게시판</a></li>
		<li><a href="${cpath }/board/write">글쓰기</a></li>
	</ul>
</div>

</body>
</html>