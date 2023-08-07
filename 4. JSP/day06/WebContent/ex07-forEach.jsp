<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		padding: 10px;
		border: 1px solid grey;
	}
	thead {
		background-color: #eee;
	}
	tr.red {
		background-color: lightpink;	
	}
	tr.blue {
		background-color: lightskyblue;
	}
</style>
</head>
<body>

<h1>ex07-forEach.jsp</h1>
<hr>

<jsp:useBean id="repo" class="ex07.Repository" />
<c:set var="list" value="${repo.list }" />
<h3>${list }</h3>
<table>
	<thead>
		<tr>
			<th>index</th>
			<th>name</th>
			<th>age</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="member" items="${list }" varStatus="st">
		<tr class="${st.index % 2 == 0 ? 'red' : 'blue' }">
			<td>${st.count }</td>
			<td>${member.name }</td>
			<td>${member.age }</td>
		</tr>
		</c:forEach>
	</tbody>
</table>

</body>
</html>