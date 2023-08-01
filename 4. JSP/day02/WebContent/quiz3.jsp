<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>quiz3.jsp - 웹 페이지에서 구동되는 updown game</h1>
<hr>

<!-- 
랜덤 숫자를 변수에 저장
제출폼 만들어서 post로 보내기
업다운 표시
정답 맞추면 다시 시작
 -->

<%!
	public Random rand = new Random();
	public int result = rand.nextInt(100) + 1;
%>

<% if(request.getMethod().equals("GET")) { %>
	<h1>(づ￣ 3￣)づ 1 ~ 100</h1>
	<form method="POST">
		<p><input type="number" name="input" min="1" max="100" placeholder="1 ~ 100"></p>
		<button>제출</button>
	</form>
<% } %>

<% if(request.getMethod().equals("POST")) { 
		int input = Integer.parseInt(request.getParameter("input"));
		
		boolean flag = false;
		String output = "";
		
		if(input == result) {
			output = "정답입니다";
			flag = true;
		}
		else if(input < result) {
			output = "업";
		}
		else {
			output = "다운";
		}
		out.print("<h1>" + output + "</h1>");
	
		if(!flag) { // 정답 아닐때 출력되는 부분
%>
		<form method="POST">
			<p><input type="number" name="input" min="1" max="100" placeholder="1 ~ 100"></p>
			<button>제출</button>
		</form>
<%
		}
		else {		// 정답일때 출력되는 부분
%>
		<a href="quiz3.jsp"><button>처음부터</button></a>
<%
		result = rand.nextInt(100) + 1;
		}
	}
%>
</body>
</html>