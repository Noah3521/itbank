<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex02.jsp</title>
</head>
<body>

<h1>ex02.jsp</h1>
<hr>

<h3>Hello, ${empty name ? 'Guest' : name }</h3>

<form>
	<p><input type="text" name="name" placeholder="이름"></p>
	<p><input type="submit"></p>
</form>

</body>
</html>