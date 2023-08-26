<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<c:set var="dto" value="${boardDAO.selectOne(param.idx) }" />
<c:if test="${not (login.userid eq dto.writer) }">
	<script>
		alert('다른 사용자가 작성한 글입니다');
		history.go(-1);
	</script>
</c:if>

<c:set var="dto" value="${boardDAO.selectOne(param.idx) }" />

<form method="POST" action="modify-action.jsp">
	<input type="hidden" name="idx" value="${dto.idx }">
	<input type="hidden" name="writer" value="${login.userid }">
	<p><input type="text" name="title" value="${dto.title }" placeholder="title"></p>
	<p><textarea name="content" placeholder="content">${dto.content }</textarea></p>
	<p><input type="submit" value="수정완료"></p>
</form>

</body>
</html>