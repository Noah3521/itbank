<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "youtube.YoutubeDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body {
		background-color: #f5f6f7;
	}
	header {
		border-bottom: 0.5px solid #dadada;
	}
	header, main {
		width: 900px;
		margin: 0 auto;
		background-color: white;
		padding: 10px;
		box-sizing: border-box;
	}
	body, h1, h2, h4, h5, h6, div, span {
		margin: 0;
		padding: 0;
	} 
	a {
		text-decoration: none;
		color: inherit;
	}
	a:hover {
		text-decoration: underline;
	}
	h1 {
		text-align: center;
	}
	nav > ul {
		list-style: none;
		padding-left: 0;
		display: flex;
		justify-content: space-around;
		font-size: 1.2em;
		font-weight: bold;
	}
	
	/* list.jsp 에 적용할 스타일 */
	#root {
		width: 100%;
	}
	.wrap {
		display: flex;
		flex-flow: wrap;
		width: 820px;
		margin: auto;
	}
	.item {
		width: 250px;
		margin: 10px;
	}
	.thumbnail > img {
		width: 250px;
	}
	.title {
		font-weight: bold;
	}
	.channel {
		font-size: 0.9em;
		color: grey;
	}
</style>
</head>
<body>

<h1>ex03.jsp</h1>
<hr>

<h3>커넥션풀과 싱글톤이 적용된 dao를 이용하여 목록을 화면에 띄어보세요</h3>
<h3>select * from youtube order by idx</h3>

<c:set var="dao" value="${YoutubeDAO.getInstance() }" />
<c:set var="list" value="${dao.selectList() }" />

<div id="root">
	<div class="wrap">
		<c:forEach var="dto" items="${list }">
		<div class="item">
		 	<div class="thumbnail">
				<img src="${dto.thumbnail }">
			</div>
			<div class="title">${dto.title }</div>
			<div class="channel">${dto.channel }</div>
			<div class="viewCount">조회수 : ${dto.viewCount}</div>	
		</div>
		</c:forEach>
	</div>
</div>


</body>
</html>