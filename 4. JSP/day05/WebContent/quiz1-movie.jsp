<%@page import="java.util.ArrayList"%>
<%@page import="day05.Movie"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
	th, td {
		border: 1px solid grey;
		padding: 10px;
	}
	thead {
		background-color: #eee;
	}
</style>
</head>
<body>

<%! ArrayList<Movie> list = new ArrayList<>();%>
<%	request.setCharacterEncoding("utf-8"); %>
<%	
	Movie movie = (Movie)request.getAttribute("movie");
	if(movie!=null)
		list.add(movie);
	// list.sort((a,b) -> a.getRank() - b.getRank());
%>



<h1>quiz1-movie.jsp</h1>
<hr>

<fieldset>
	<legend>데이터 추가</legend>
	<form method="POST" action="quiz1-action.jsp">
		<p><input type="number" name="rank" placeholder="순위"></p>
		<p><input type="text" name="title" placeholder="영화명"></p>
		<p><input type="text" name="openningDate" placeholder="개봉일"></p>
		<p><input type="text" name="reserveRate" placeholder="예매율" min="0" max="100" step="0.1"></p>
		<p><input type="number" name="reserveCount" placeholder="예매관객수"></p>
		<p><input type="number" name="watchCount" placeholder="누적관객수"></p>
		<p><input type="submit"></p>
	</form>
</fieldset>

<h3>추가된 영화 데이터 목록</h3>
<table>
	<thead>
		<tr>
			<th>순위</th>
			<th>영화명</th>
			<th>개봉일</th>
			<th>예매율</th>
			<th>예매관객수</th>
			<th>누적관객수</th>
		</tr>
	</thead>
	<tbody>
<% for(Movie ob : list) { %>
	<tr>
<%-- 		<td>${ob.rank }</td> --%>
<%-- 		<td>${ob.title }</td> --%>
<%-- 		<td>${ob.openningDate }</td> --%>
<%-- 		<td>${ob.reserveRate }</td> --%>
<%-- 		<td>${ob.reserveCount }</td> --%>
<%-- 		<td>${ob.watchCount }</td> --%>
		<td><%=ob.getRank() %></td>
		<td><%=ob.getTitle() %></td>
		<td><%=ob.getOpenningDate() %></td>
		<td><%=ob.getReserveRate() %>%</td>
		<td><%=ob.getReserveCount() %></td>
		<td><%=ob.getWatchCount() %></td>
	</tr>
<% }%>
	</tbody>
</table>

</body>
</html>