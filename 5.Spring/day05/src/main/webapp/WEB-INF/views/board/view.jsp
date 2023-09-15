<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<h3>게시글 조회 : ${dto.idx }</h3>

<table style="width: 500px">
	<tr>
		<th>번호</th>
		<td>${dto.idx }</td>
	</tr>
	<tr>
		<th>제목</th>
		<td>${dto.title }</td>
	</tr>
	<tr>
		<th>작성자</th>
		<td>${dto.writer }
	</tr>
	<tr>
		<th>ㄴㅇㅁㄹ</th>
		<td>asdf</td>
	</tr>
	<tr>
		<th>내용</th>
		<td><pre>${dto.content }</pre></td>
	</tr>
</table>

<div style="display: flex; justify-content: space-between; margin: 20px 0; width: 500px;">
	<div>
		<a href="${cpath }/baord/list"><button>목록</button></a>
	</div>
	<div>
		<a href="${cpath }/board/modify/${dto.idx }"><button>수정</button></a>
		<a href="${cpath }/board/delete/${dto.idx }"><button>삭제</button></a>
	</div>
</div>

</body>
</html>