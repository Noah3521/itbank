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
제출폼 만들어서 보내기
업다운 표시
정답 맞추면 다시 시작
 -->

<%!
	public Random rand = new Random();
	public int getRand() {
		return rand.nextInt(100) + 1;
	}
	public int result = getRand();
	public int count = 0;
	public String msg = "";
	public boolean flag = false;
%>

<%
	int input = Integer.parseInt(request.getParameter("input"));
	if(request.getParameter("input") != null) {
		if(input == result) {
			msg = count + "회 만에 정답을 맞췄습니다 !!";
			flag = true;
		}
		else if(input < result) {
			msg = ++count + "회 시도 : Up";
		}
		else {
			msg = ++count + "회 시도 : Down";
		}
	}
%>

<form>
	<p><input type="number" name="input" min="1" max="100" placeholder="1 ~ 100" autocomplete="off" autofocus required value="<%=flag ? input : ""%>"></p>
	<button>제출</button>
	<h1><%=msg %></h1>
</form>

<%
if(flag) {
	out.print("<a href=\"quiz3_1.jsp\"><button>다시하기</button></a>");
	result = getRand();
	count = 0;
	flag = false;
	msg = "";
}
%>

</body>
</html>