<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<div id="main">
	<form method="POST" enctype="multipart/form-data">
		<table>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="content" cols="80" rows="15"></textarea></td>
			</tr>
			
			<tr>
				<td>첨부파일</td>
				<td><input type="file" name="upload"></td>
			</tr>
			
		</table>
		<input type="submit" value="작성완료">
	</form>
</div>

</body>
</html>