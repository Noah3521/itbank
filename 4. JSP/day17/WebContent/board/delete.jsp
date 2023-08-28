<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<c:set var="dto" value="${boardDAO.selectOne(param.idx) }" />
<c:if test="${not (login.userid eq dto.writer) }">
	<script>
		alert('다른 유저가 작성한 글입니다.');
		history.go(-1);
	</script>
</c:if>

<c:if test="${login.userid eq dto.writer }">
<script>
	const row = '${boardDAO.delete(param.idx) }';
	if(row!=0) {
		${fileUtil.deleteFile(dto.uploadFile) }
		location.href="${cpath}/board/list.jsp"
	} else {
		alert('삭제 실패');
		history.go(-1);
	}

</script>
</c:if>
</body>
</html>