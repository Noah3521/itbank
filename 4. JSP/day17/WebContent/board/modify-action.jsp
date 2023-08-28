<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<c:set var="dto" value="${fileUtil.getDTO(pageContext.request) }" />
<c:set var="originDto" value="${boardDAO.selectOne(dto.idx) }" />

<script>
	const row = '${boardDAO.update(dto) }';
	if(row!=0) {
		${fileUtil.deleteFile(originDto.uploadFile) }
		location.href="${cpath}/board/view.jsp?idx=${dto.idx}"
	} else {
		alert('수정 실패');
		history.go(-1);
	}
</script>

</body>
</html>