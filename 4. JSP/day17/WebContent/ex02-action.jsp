<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<% request.setCharacterEncoding("utf-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex02-action.jsp</title>
</head>
<body>

<jsp:useBean id="dto" class="board2.BoardDTO" />
생성된 dto : ${dto }

<jsp:setProperty property="*" name="dto"/>
<%@ page import="java.text.SimpleDateFormat, java.util.Date" %>
<%
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	Date d1 = sdf.parse(request.getParameter("_wdate"));
	long time = d1.getTime();
	dto.setWdate(new java.sql.Date(time));
	
%>

<ul>
	<li>전송받은 idx : ${dto.idx }</li>
	<li>전송받은 title : ${dto.title }</li>
	<li>전송받은 writer: ${dto.writer}</li>
	<li>전송받은 content: ${dto.content}</li>
	<li>전송받은 uploadFile: ${dto.uploadFile}</li>
	<li>전송받은 wdate: ${dto.wdate}</li>
</ul>

</body>
</html>