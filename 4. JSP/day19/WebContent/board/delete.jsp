<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<c:set var="dto" value="${boardDAO.selectOne(param.idx) }" />
<c:if test="${empty login or dto.writer != login.userid }">	
	<script>
		alert('본인의 게시글만 삭제할 수 있습니다.');
		history.go(-1)
	</script>
</c:if>

<c:if test="${dto.writer == login.userid }">

<c:set var="idDel" value="${fileUtil.delete(dto.uploadFile) }" />
<c:set var="row" value="${boardDAO.delete(param.idx) }" />

<script>
	const row = '${row}'
	if(row!=0) location.href = '${cpath}/board/list.jsp'
	else {
		alert('삭제 실패')
		history.go(-1)
	}
</script>

</c:if>
</body>
</html>