<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table {
		border: 2px solid black;
		border-collapse: collapse;
	}
	td, th {
		border: 1px solid grey;
		padding: 10px;
	}
	th {
		background-color: #eee;
	}
	
	div {
		box-sizing: border-box;
	}
	#root{
		border: 2px solid black;
		width: fit-content;
	}
	div.item {
		width: fit-content;
		display: flex;
	}
	div.item > div {
		width: 120px;
		padding: 10px;
		border: 1px solid grey;
	}
	div.item > div:nth-child(2) {
		width: 250px;
	}
	div.header {
		background-color: #dadada;
		font-weight: bold;
		text-align: center;
	}
	div.item.white {
		background-color: white;
	}
	div.item.grey {
		background-color: #eee;
	}
</style>
</head>
<body>

<jsp:useBean id="dao" class="ex03.movieDAO" />
<c:set var="list" value="${dao.selectList() }" />

<div id="root">
	<div class="item header">
		<div>순위</div>
		<div>제목</div>
		<div>개봉일자</div>
		<div>예매율</div>
		<div>예매관객수</div>
		<div>누적관객수</div>
	</div>
	<c:forEach var="dto" items="${list }" varStatus="st">
	<div class="item ${st.index % 2 == 0 ? 'white' : 'grey' }">
		<div>${dto.movie_rank }</div>
		<div>${dto.title }</div>
		<div>${dto.openningDate }</div>
		<div>${dto.reserveRate }%</div>
		<div>
			<fmt:formatNumber value="${dto.reserveCount }" />명
		</div>
		<div>
			<fmt:formatNumber value="${dto.watchCount }" />명
		</div>
	</div>
	</c:forEach>
</div>

<table>
	<thead>
		<tr>
			<th>rank</th>
			<th>title</th>
			<th>openningDate</th>
			<th>reserveRate</th>
			<th>reserveCount</th>
			<th>watchCount</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="movie" items="${list }">
		<tr>
			<td>${movie.movie_rank }</td>
			<td>${movie.title }</td>
			<td>${movie.openningDate }</td>
			<td>${movie.reserveRate }</td>
			<td>${movie.reserveCount }</td>
			<td>${movie.watchCount }</td>
		</tr>
		</c:forEach>
	</tbody>
</table>

</body>
</html>