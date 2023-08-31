<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<c:set var="dto" value="${boardDAO.selectOne(param.idx) }" />
<c:if test="${dto.writer != login.userid }">
	<script>alert('잘못된 접근입니다')</script>
	<c:redirect url="/" />
</c:if>
<c:set var="isDel" value="${fileUtil.delete(dto.uploadFile) }" />

${dto.setUploadFile(null)}
<c:set var="row" value="${boardDAO.update(dto)}" />

<script>
	const row = '${row}'
	if(row!=0) {
		location.href='${cpath }/board/modify.jsp?idx=${dto.idx }'
	}
</script>

</body>
</html>