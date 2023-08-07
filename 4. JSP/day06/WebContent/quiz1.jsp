<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>quiz1.jsp</title>
<style>
	table {
		margin: 20px auto;
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

<h1>quiz1.jsp</h1>
<hr>
<%@ page import="java.io.File, java.util.Scanner, java.util.ArrayList" %>
<%
	String filePath = application.getRealPath("passwd.txt");
	File f = new File(filePath );
	Scanner sc = new Scanner(f);
	ArrayList<String> list = new ArrayList<>();
	
	while(sc.hasNextLine()) {
		String line = sc.nextLine();
		if (line.contains("::")) {		
			line.replace("::", ":x:");
		System.out.println(line);
		}
		list.add(line);
	}
	sc.close();
	
	pageContext.setAttribute("list", list);
%>
<table>
	<thead>
		<tr>
			<th>계정이름</th>
			<th>비밀번호</th>
			<th>UID</th>
			<th>GID</th>
			<th>comment</th>
			<th>HomeDirectory</th>
			<th>Shell</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="row" items="${list }">
		<c:set var="arr" value="${fn:split(row, ':')}" />
		<tr>
			<c:forEach var="data" items="${row.split(':') }">
				<td>${data }</td>
			</c:forEach>
<%-- 			<td>${row.split(':')[0] }</td> --%>
<%-- 			<td>${row.split(':')[1] }</td> --%>
<%-- 			<td>${row.split(':')[2] }</td> --%>
<%-- 			<td>${row.split(':')[3] }</td> --%>
<%-- 			<td>${row.split(':')[4] }</td> --%>
<%-- 			<td>${row.split(':')[5] }</td> --%>
<%-- 			<td>${row.split(':')[6] }</td> --%>
<%-- 			<td>${arr[0] }</td> --%>
<%-- 			<td>${arr[1] }</td> --%>
<%-- 			<td>${arr[2] }</td> --%>
<%-- 			<td>${arr[3] }</td> --%>
<%-- 			<td>${arr[4] }</td> --%>
<%-- 			<td>${arr[5] }</td> --%>
<%-- 			<td>${arr[6] }</td> --%>
		</tr>
		</c:forEach>
	</tbody>
</table>

</body>
</html>