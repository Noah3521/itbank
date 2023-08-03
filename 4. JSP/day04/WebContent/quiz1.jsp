<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%!
	String exp = "";
%>
<%
	String btn = request.getParameter("btn");
	System.out.println("btn : " + btn);
	
	if("CE".equals(btn)) {
		btn = "";
		exp = "";
	}
	else if("=".equals(btn)) {
		String[] arr = exp.split(" ");
		int n1 = Integer.parseInt(arr[0]);
		String oper = arr[1];
		int n2 = Integer.parseInt(arr[2]);
		switch(oper) {
		case "+": exp = String.valueOf(n1 + n2); break;
		case "-": exp = String.valueOf(n1 - n2); break;
		case "X": exp = String.valueOf(n1 * n2); break;
		case "/": exp = String.valueOf(n1 / (double)n2); break;	
		}
	}
	else {
		exp += btn != null ? btn : "";
	}
		
%>

</body>
</html>