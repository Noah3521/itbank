<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<script>
	const row = '${boardDAO.delete(param.idx) }';
	if (row!=0) {
		location.href = '${cpath}/board/list.jsp';
	} 
	else {
		alert('삭제 실패');
		history.go(-1);
	}
</script>

</body>
</html>