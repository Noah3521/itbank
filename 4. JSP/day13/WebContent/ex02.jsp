<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.net.URLDecoder"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>ex02</title>
<style>
	.wrap {
		width: 900px;
		margin: auto;
		display: flex;
		flex-flow: wrap;
	}
	.item {
		width: 200px;
		height:200px;
		border: 1px solid black;
		margin: 10px;
	}
	.item > a {
		color: inherit;
		font-size: 40px;
		text-decoration: none;
		display: block;
		width: 100%;
		height: 100%; 
		display: flex;
		justify-content: center;
		align-items: center;
	}
	.item > a:hover {
		background-color: #eee;
	}
	div.recent{
		position: fixed;
		top: 50%;
		right: 20px;
		transform: tanslate(0, -50%);
		background-color: #dadada;
	}
	div.recent > div.r {
		width: 20px;
		height: 20px;
		padding:10px;
		background-color: white;
		margin: 10px;
	}
	div.recent > div.r > a {
		color: inherit;
		text-decoration: none;
		display: block;
		display: flex;
		width: 100%;
		height: 100%;
		justify-content: center;
		align-items: center;
	}
	
</style>
</head>
<body>
<h1>ex02.jsp</h1>
<hr>

<h3>${URLDecoder.decode(cookie.recent.value, 'UTF-8') }</h3>

<div class="wrap">
	<c:forEach var="i" begin="1" end="12">
	<div class="item">
		<a href="ex02-view.jsp?idx=${i }">${i }</a>
	</div>
	</c:forEach>
</div>

<c:set var="recent" value="${URLDecoder.decode(cookie.recent.value, 'UTF-8') }"></c:set>
<div class="recent">
	<c:forTokens var="r" items="${recent }" delims=",">
	<div class="r">
		<a href="ex02-view.jsp?idx=${r }">${r }</a>
	</div>
	</c:forTokens>
</div>

<fieldset>
	<legend>쿠키 RFC 문서 (RFC 6265)</legend>
	<a href="https://datatracker.ietf.org/doc/html/rfc6265" target="_blank">
		<button>문서 열기</button>
	</a>
</fieldset>

</body>
</html>