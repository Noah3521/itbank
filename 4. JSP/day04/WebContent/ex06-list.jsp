<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>ex06-list.jsp</h1>
<hr>

<ul>
	<li>application 객체에 문자열의 배열을 만들어둔다</li>
	<li>list.jsp에서는 목록을 출력한다</li>
	
	<li>추가하려면 form내부에서 데이터를 입력한다</li>
	<li>form의 action속성으로 지정한 페이지가 파라미터를 받아서 배열에 추가한다</li>
	<li>배열에 추가한 후 다시 목록으로 되돌리기 위해서 list.jsp로 [redirect]한다</li>
	
	<li>목록에서 링크를 클릭하면 view.jsp로 이동한다</li>
	<li>view.jsp에서는 실제로는 배열의 i번째 요소를 attribute로 저장한다</li>
	<li>view.jsp에서 result.jsp로 [forward]한다</li>
	<li>result.jsp에서는 attribute의 내용을 출력한다</li>
</ul>

<%!
	ArrayList<String> list = new ArrayList<>();
%>
<%
	if(application.getAttribute("list")==null) {
		application.setAttribute("list", list);
	}
	
	out.print("<h3>목록</h3>");
	
	for(int i = 0 ; i < list.size(); i++) {
		String s = list.get(i);
		%>
		<div><a href="ex06-view.jsp?i=<%=i%>"><%=i %>) <%=s %></a></div>
		<%
	}
%>
<form method="POST" action="ex06-add.jsp">
	<p><input type="text" name="param" placeholder="추가할 문자열 입력"></p>
	<p><input type="submit" value="제출"></p>	
</form>

</body>
</html>