<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>quiz2.jsp</title>
</head>
<body>

<h1>quiz2.jsp</h1>
<hr>

<ul>
	<li>날짜를 입력받아서, yyyy년 MM월 dd일 형식의 문자열로 바꿔서 출력</li>
</ul>

<form>
	<p><input type="date" name="birth"></p>
	<p><input type="submit"></p>
</form>

<h3>
<%
	String birth = request.getParameter("birth");
	
	if(birth != null) {
	Date date = new SimpleDateFormat("yyyy-MM-dd").parse(birth);
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
	out.print("1) " + sdf.format(date) + "<br>");
	
	String[] arr = birth.split("-");
	out.print("2) " + arr[0] +"년 " + arr[1] + "월 " + arr[2] + "일" + "<br>");
	
	birth = birth.replaceFirst("-", "년 ");
	birth = birth.replace("-", "월 ");
	birth += "일";
	out.print("3) " + birth + "<br>");
	}
%></h3>


</body>
</html>