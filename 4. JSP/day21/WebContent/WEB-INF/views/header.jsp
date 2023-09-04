<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.itbank.repository.ArtistDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<fieldset>
	<legend>가수</legend>
	<h3><a href="${cpath }/artist">조회</a></h3>
	<h3><a href="${cpath }/artist/add">추가</a></h3>
</fieldset>

<fieldset>
	<legend>앨범</legend>
	<h3><a href="${cpath }/album">조회</a></h3>
	<h3><a href="${cpath }/album/add">추가</a></h3>
</fieldset>

</body>
</html>