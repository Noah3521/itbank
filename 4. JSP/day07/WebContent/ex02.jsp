<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>ex02.jsp - dao</h1>
<hr>

<jsp:useBean id="dao" class="ex02.TestDAO" />
<h3>version : ${dao.version }</h3>
<h3>dao.version => dao.getVerison()</h3>
<h3>sysdate : ${dao.sysdate }</h3>
</body>
</html>