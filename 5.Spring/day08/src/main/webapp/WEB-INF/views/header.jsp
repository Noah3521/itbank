<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>day08</title>
<style>
	table {
		border: 2px solid black;
		border-collapse: collapse;
	}
	td, th {
		padding: 10px;
		border: 1px solid grey;
	}
	th {
		background-color: darkgrey;
	}
</style>
</head>
<body>

<h1><a href="${cpath }">day08</a></h1>
<p align="right">${login.username }</p>

<c:set var="loginLink" value="${empty login ? 'login' : 'logout' }" />
<c:set var="loginMenu" value="${empty login ? '로그인' : '로그아웃' }" />

<ul>
	<li><a href="${cpath }/member/${loginLink}">${loginMenu }</a></li>
	<li><a href="${cpath }/member/list">회원 목록</a></li>
</ul>
<hr>