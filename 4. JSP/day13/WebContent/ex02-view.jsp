<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.net.URLEncoder, java.net.URLDecoder"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>ex02-view.jsp</title>
</head>
<body>

<h1>ex02-view.jsp</h1>
<hr>

<h3>현재 조회중인 상품 : ${param.idx }</h3>

<p>
	<a href="ex02.jsp"><button>목록으로</button></a>
</p>

<%
	String value="";

	String idx = request.getParameter("idx");
	
	value += idx;
	
	Cookie[] cookies = request.getCookies();
	for(int i = 0 ; cookies != null && i < cookies.length; i++) {
		if(cookies[i].getName().equals("recent")) {
			
			String tmp = URLDecoder.decode(cookies[i].getValue(), "UTF-8");
			ArrayList<String> list = new ArrayList<>(Arrays.asList(tmp.split(",")));
			
			System.out.println("before : " + list);
			if(list.contains(value) == false) {		// 비교를 먼저 한 이후,
				if(value.equals("") == false) {		// 기존 값이 있으면서, 포함하지 않으면
					value += ",";					// 콤마를 추가하고
				}
				value += tmp;
				// 인코딩된 내용을 디코딩한 이후 value에 더한다
			}
			else {
				list.remove(idx);
				for(String s:list){
					if(value.equals("") == false) {		// 기존 값이 있으면서, 포함하지 않으면
						value += ",";					// 콤마를 추가하고
					}
					value+=s;
				}
			}
			
		}
	}
	
	
	String[] values = value.split(","); 
	if(values.length > 5) {
		int lastIndex = value.lastIndexOf(",");
		value=value.substring(0,lastIndex);
	}
	
	Cookie c = new Cookie("recent", URLEncoder.encode(value, "UTF-8"));
	c.setMaxAge(60 * 60 * 24 * 7);
	response.addCookie(c);
	
	/*
	Cookie[] cookies = request.getCookies();
	String idx = request.getParameter("idx");
	List<String> values = null;
	
	for(int i = 0 ; cookies != null && i < cookies.length; i++) {
		if(cookies[i].getName().equals("recent")) {
			values = new ArrayList<>(Arrays.asList(URLDecoder.decode(cookies[i].getValue(), "UTF-8").split(",")));
		}
	}
	
	if(values!=null){
		values.removeIf(s -> s.equals(idx));
	}
	
	String value="";
	value += idx;
	
	if(values!=null){
		for(String s : values) {
			if(value.equals("")==false) {value += ",";}
			value += s;
		}
	}
	
	// 5개 이상이면 자르기
	if(value.split(",").length > 5) {
		int lastIndex = value.lastIndexOf(",");
		value=value.substring(0,lastIndex);
	}
	
	Cookie c = new Cookie("recent", URLEncoder.encode(value, "UTF-8"));
	c.setMaxAge(60 * 60 * 24 * 7);
	response.addCookie(c);
	*/
%>

</body>
</html>