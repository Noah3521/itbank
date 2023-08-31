<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.MemberDAO, board.BoardDAO, util.FileUtil"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("UTF-8"); %>
<c:set var="memberDAO" value="${MemberDAO.getInstance() }" />
<c:set var="boardDAO" value="${BoardDAO.getInstance() }" />
<c:set var="fileUtil" value="${FileUtil.getInstance() }" />
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>test</title>
<link href="${cpath }/css/style.css" rel="stylesheet" />
</head>
<body>

<header class="frame">
	<h1><a href="${cpath }">board</a></h1>
	<ul id="nav">
		<c:if test="${empty login }">		
			<li><h3><a href="${cpath }/member/login.jsp">로그인</a></h3></li>
		</c:if>
		<c:if test="${not empty login }">		
			<li><h3><a href="${cpath }/member/logout.jsp">로그아웃</a></h3></li>
		</c:if>
		<li><h3><a href="${cpath }/board/list.jsp">게시판</a></h3></li>
	</ul>
	<c:if test="${not empty login }">
		<p class="userInfo"><a href="${cpath}/member/modify.jsp?userid=${login.userid}">${login.userid } (${login.username })</a></p>
	</c:if>
</header>



</body>
</html>