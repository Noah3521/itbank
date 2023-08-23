<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<c:if test="${empty login }">
	<c:redirect url="/member/login.jsp" />
</c:if>
<c:set var="dto" value="${boardDAO.selectOne(param.idx) }" />
<div>
	<h3>새 글 작성</h3>
	<form method="POST" action="${cpath }/board/modify-action.jsp">
		<input type="hidden" name="idx" value="${dto.idx }">
		<input type="hidden" name="writer" value="${login.userid }">
		<p><input type="text" name="title" value="${dto.title }" placeholder="제목을 입력하세요" autofocus required></p>
		<p>
			<textarea name="content" placeholder="내용을 입력하세요">${dto.content }</textarea>
		</p>
		<p>
			<input type="submit" value="수정완료">;
		</p>
	</form>
</div>

</body>
</html>