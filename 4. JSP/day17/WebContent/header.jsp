<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="board2.BoardDAO, member.MemberDAO, util.FileUtil"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<% request.setCharacterEncoding("utf-8"); %>
<c:set var="boardDAO" value="${BoardDAO.getInstance() }" />
<c:set var="memberDAO" value="${MemberDAO.getInstance() }" />
<c:set var="fileUtil" value="${FileUtil.getInstance() }" />
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>day17 - board2</title>
<style>

</style>
</head>
<body>
<h3>현재 접속 : ${login.userid }(${login.username })</h3>
<ul>
	<li><a href="${cpath }/member/login.jsp">로그인</a></li>
	<li><a href="${cpath }/member/logout.jsp">로그아웃</a></li>
	<li><a href="${cpath }/board/write.jsp">글쓰기</a></li>
	<li><a href="${cpath }/board/list.jsp">게시글보기</a></li>
</ul>
</body>
</html>