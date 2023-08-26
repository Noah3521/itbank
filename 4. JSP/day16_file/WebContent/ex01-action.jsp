<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.sun.jmx.snmp.defaults.DefaultPaths"%>
<%@page import="com.oreilly.servlet.multipart.FileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="java.io.File" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>ex01-action.jsp</h1>
<hr>

<%
	String saveDirectory = application.getRealPath("/upload");
	int maxPostSize = 1024*1024*10;
	String encoding = "UTF-8";
	FileRenamePolicy policy = new DefaultFileRenamePolicy();
	
	File dir = new File(saveDirectory);
	if(!dir.exists()) {
		dir.mkdirs();
	}
	
	MultipartRequest mpRequest = new MultipartRequest(
			request,
			saveDirectory,
			maxPostSize, 
			encoding,
			policy
		);
	
	File f = mpRequest.getFile("profileImage");
	
	System.out.println(saveDirectory);
		 
%>
<h3>저장 위치 : <%=saveDirectory %></h3>
<h3>파일 이름 : <%=f.getName() %></h3>
<h3>파일 크기 : <%=f.length() %></h3>


</body>
</html>