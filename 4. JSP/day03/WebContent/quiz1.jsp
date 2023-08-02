<%@page import="java.util.regex.Pattern"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">
<link rel="stylesheet" href="css/style.css">
</head>
<body>

<%!
	public boolean isNum(String num) {
		Pattern pt = Pattern.compile("^[0-9]*$"); // 숫자 체크
		return pt.matcher(num).find();			  // 숫자면 true
	}
	public double calc(int left, int right, String center) {
		switch(center) {
		case "+":
			return left + right;
		case "-":
			return left - right;
		case "×":
			return left * right;
		case "÷":
			return left / (double)right;
		}
		return -1;
	}
	public String exp = "";
%>
<%
	if(request.getMethod().equals("POST")) {
		request.setCharacterEncoding("UTF-8");
		String num = request.getParameter("num");
		if(num.equals("CE")) {
			exp = "";
		}
		else if(num.equals("=")) {
			String[] arr = exp.split(" ");
			double answer = calc(Integer.parseInt(arr[0]), Integer.parseInt(arr[2]), arr[1]);
			exp = String.format("%.0f", answer);
		}
		else {			
			exp += num;
		}
	}
%>
	<form method="POST">
	    <div id="wrap">
	
	        <div id="window">
	            <div class="icon">🎹</div>
	            <div class="title">계산기</div>
	            <div class="win">
	                <div>ㅡ</div>
	                <div>ㅁ</div>
	                <div>X</div>
	            </div>
	        </div>
	
	        <div id="nav">
	            <div>표준</div>
	            <div>❤</div>
	        </div>
	
	        <div id="main">
	            <h1><%=exp.length() == 0 ? "0" : exp%></h1>
	        </div>
	
	        <div id="keys">
	            <div class="menu">
	                <div style="opacity: 0.3;">MC</div>
	                <div style="opacity: 0.3;">MR</div>
	                <div style="font-weight: bold;">M+</div>
	                <div style="font-weight: bold;">M-</div>
	                <div style="font-weight: bold;">MS</div>
	                <div style="opacity: 0.3;">M<i class="las la-angle-down"></i></div>
	            </div>
	            <div class="button">
	                <div class="first outter">%</div><div class="outter"><input type="submit" name="num" value="CE"></div><div class="outter">C</div><div class="last outter"><i class="las la-backspace" style="font-size: large;"></i></div>
	                <div class="first outter">1/x</div><div class="outter"><math xmlns="http://www.w3.org/1998/Math/MathML"><semantics><msup><mi>x</mi><mn>2</mn></msup><annotation encoding="text/plain">x squared</annotation></semantics></math></div><div class="outter">2√x</div><div class="last outter"><input type="submit" name="num" value=" ÷ "></div>
	                <div class="first" style="font-weight: bold;"><input type="submit" name="num" value="7"></div><div style="font-weight: bold;"><input type="submit" name="num" value="5"></div><div style="font-weight: bold;"><input type="submit" name="num" value="9"></div><div class="last outter"><input type="submit" name="num" value=" × "></div>
	                <div class="first" style="font-weight: bold;"><input type="submit" name="num" value="4"></div><div style="font-weight: bold;"><input type="submit" name="num" value="8"></div><div style="font-weight: bold;"><input type="submit" name="num" value="6"></div><div class="last outter"><input type="submit" name="num" value=" - "></div>
	                <div class="first" style="font-weight: bold;"><input type="submit" name="num" value="1"></div><div style="font-weight: bold;"><input type="submit" name="num" value="2"></div><div style="font-weight: bold;"><input type="submit" name="num" value="3"></div><div class="last outter"><input type="submit" name="num" value=" + "></div>
	                <div class="first" style="font-weight: bold;">+/-</div><div style="font-weight: bold;"><input type="submit" name="num" value="0"></div><div style="font-weight: bold;">.</div><div class="last" style="background-color: #7EB5DC; font-size: 30px;"><input type="submit" name="num" value="="></div>
	            </div>
	        </div>
	
	    </div>
	</form>


</body>
</html>