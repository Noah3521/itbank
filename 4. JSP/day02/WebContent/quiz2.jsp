<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>quiz2.jsp</h1>
<hr>

<%	if(request.getMethod().equals("GET")) { %>
	<form method="POST">
		<p><input type="text" name="id" placeholder="ID" required autofocus></p>
		<p><input type="password" name="pw" placeholder="Password" required></p>
		<p><input type="text" name="name" placeholder="Name" required></p>
		<p><input type="date" name="birth" required></p>
		<p>
			<label><input type="radio" name="gender" value="남성" required>남성</label>
			<label><input type="radio" name="gender" value="여성" required>여성</label>
		</p>
		<p>
			<select name="age" required>
				<option value="">=== 연령대를 선택하세요 === </option>
				<option value="10대">10대</option>
				<option value="20대">20대</option>
				<option value="20대">30대</option>
				<option value="40대">40대</option>
			</select>
		</p>
		<p><input type="submit" value="가입신청"></p>
	</form>
<% } %>

<% 
	request.setCharacterEncoding("UTF-8");
	if(request.getMethod().equals("POST")) { %>
	<h4>아이디 : 	<%=request.getParameter("id")     %></h4>
	<h4>비밀번호 : 	<%=request.getParameter("pw") 	  %></h4>
	<h4>이름 : 	<%=request.getParameter("name")   %></h4>
	<h4>생일 : 	<%=request.getParameter("birth")  %></h4>
	<h4>성별 : 	<%=request.getParameter("gender") %></h4>
	<h4>연령대 : 	<%=request.getParameter("age") 	  %></h4>
	<a href="quiz2.jsp"><button>뒤로가기</button></a>

<% } %>
</body>
</html>