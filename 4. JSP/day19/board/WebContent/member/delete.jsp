<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<c:if test="${param.userid != login.userid }">
	<script>
	alert('본인의 정보가 아닙니다.')
	history.go(-1)
	</script>
</c:if>

<c:set var="row" value="${memberDAO.delete(param.userid) }" />

<script>
	const row = '${row}'
	if(row!=0) {
		location.href = '${cpath}'
	} else {
		alert('탈퇴실패')
		history.go(-1)
	}
</script>

</body>
</html>