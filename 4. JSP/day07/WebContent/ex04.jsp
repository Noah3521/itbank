<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	table{
		border: 2px solid black;
		border-collapse: collapse;
	}
	th, td {
		padding: 10px;
		border: 1px solid grey;
	}
	th {
		background-color: #eee;
	}
</style>
</head>
<body>

	<details>
		<summary>SQL</summary>
		<fieldset>
		<pre>
		drop table melon;

create table melon (
    ranking         number,
    title              varchar2(100),
    artist             varchar2(50),
    album           varchar2(50),
    likeCount       number
);
delete from melon;

insert into melon values(1, 'Super Shy', 'NewJeans', 'NewJeans 2nd EP ''Get Up''', 124633);
insert into melon values(2, 'ETA', 'NewJeans', 'NewJeans 2nd EP ''Get Up''', 72626);
insert into melon values(3, 'Seven (feat. Latto) - Clean Ver.', '정국', 'Seven (feat. Latto) - Clean Ver.', 137573);
insert into melon values(4, '퀸카 (Queencard)', '(여자)아이들', 'I feel', 127567);
insert into melon values(5, '헤어지자 말해요', '박재정', '1집 Alone', 103465);
insert into melon values(6, 'I AM', 'IVE (아이브)', 'I''ve IVE', 190808);
insert into melon values(7, '이브, 프시케 그리고 푸른 수염의 아내', 'LE SSERAFIM (르세라핌)', 'UNFORGIVEN', 99316);
insert into melon values(8, 'Spicy', 'aespa', 'MY WORLD - The 3rd Mini Album', 116993);
insert into melon values(9, 'Steal The Show (From “엘리멘탈”)', 'Lauv', 'Steal The Show (From “엘리멘탈”)', 117402);
insert into melon values(10, 'New Jeans', 'NewJeans', 'NewJeans 2nd EP ''Get Up''', 62052);

commit;

select * from melon;
		</pre>
		</fieldset>
	</details>

	<jsp:useBean id="dao" class="ex04.MelonDAO" />
	<c:set var="list" value="${dao.selectList() }" />
	
	<table>
		<thead>
			<tr>
				<th>순위</th>
				<th>곡정보</th>
				<th>가수</th>
				<th>앨범</th>
				<th>좋아요</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="dto" items="${list }">
			<tr>
				<td>${dto.ranking }</td>
				<td>${dto.title }</td>
				<td>${dto.artist }</td>
				<td>${dto.album }</td>
				<td>${dto.likeCount }</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>