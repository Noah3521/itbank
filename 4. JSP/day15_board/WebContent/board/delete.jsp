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

<c:if test="${login.userid eq dto.writer }">
	<c:set var="row" value="${boardDAO.delete(param.idx) }" />
	<c:redirect url="/board/list.jsp" />
</c:if>

</body>
</html>