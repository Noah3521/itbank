<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>


<script>

</script>

<c:set var="dto" value="${fileUtil.getDTO(pageContext.request) }" />

<script>
	
	const row = '${boardDAO.insert(dto) }';
	if(row!=0) {
		location.href="${cpath}/board/view.jsp?idx=${boardDAO.getMaxIdx()}"
	} else {
		alert('업로드 실패');
		history.go(-1);
	}

</script>

</body>
</html>