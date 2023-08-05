<%@page import="java.util.ArrayList"%>
<%@page import="day05.Movie"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>quiz1-action.jsp</title>
</head>
<body>
<%request.setCharacterEncoding("utf-8"); %>

<jsp:useBean id="movie" class="day05.Movie" scope="request"/>
<jsp:setProperty property="*" name="movie" />
<jsp:forward page="quiz1-movie.jsp" />

</body>
</html>