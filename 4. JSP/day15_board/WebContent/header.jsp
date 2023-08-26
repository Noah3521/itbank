<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.MemberDAO, board.BoardDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("utf-8"); %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<c:set var="memberDAO" value="${MemberDAO.getInstance() }" />
<c:set var="boardDAO" value="${BoardDAO.getInstance() }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>day15_board</title>
<link href="${cpath }/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>	

<a href="${cpath }/member/test.jsp">테스트</a>


<c:if test="${empty login }">
	<a href="${cpath }/member/join.jsp">회원가입</a>
	<a href="${cpath }/member/login.jsp">로그인</a>
</c:if>
<c:if test="${not empty login }">
	<h3>${login.userid } (${login.username })</h3>
	<a href="${cpath }/member/logout.jsp">로그아웃</a>
</c:if>

<a href="${cpath }/board/list.jsp">게시판</a>
<a href="${cpath }/board/write.jsp">글쓰기</a>

<h3><a href="${cpath }/board/list.jsp">전체글보기</a></h3>

</body>
</html>