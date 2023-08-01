<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%--
	dataList 객체를 생성해두고
	파라미터를 입력받아서
	문자열의 내용을 출력하는 코드를 작성하세요
	request.getMethod()를 활용하여
	GET/POST 일 경우를 현재 페이지에 모두 작성하세요
 --%>
 
 <%@ page import="quiz1.DataList" %>
 <%	DataList dataList = new DataList(); %>
 
 <%	if(request.getMethod().equals("GET")) { %>
	<h1>Quiz1</h1>
	<hr>
 	<form method="POST">
 		<h3>원하는 데이터의 순번을 선택하세요</h3>
 		<p>
 			<label><input type="radio" name="index" value="1">1번</label><br>
 			<label><input type="radio" name="index" value="2">2번</label><br>
 			<label><input type="radio" name="index" value="3">3번</label><br>
 			<label><input type="radio" name="index" value="4">4번</label><br>
 			<label><input type="radio" name="index" value="5">5번</label><br>
 		</p>
 		<input type="submit">
 	</form>
 <% } %>

 <%	if(request.getMethod().equals("POST")) { %>

	<%
	int index = Integer.parseInt(request.getParameter("index")) - 1; 
	String result = dataList.get(index); 
	%>
	<h3>result : <%=result %></h3>
	<a href="quiz1.jsp"><button>돌아가기</button></a>
 <% } %>
</body>
</html>