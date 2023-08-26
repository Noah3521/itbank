<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<jsp:useBean id="board" class="board.BoardDTO" />
<jsp:setProperty property="*" name="board"/>

<c:set var="row" value="${boardDAO.insert(board) }" />

<c:if test="${row!=0 }">
<c:redirect url="/board/view.jsp?idx=${boardDAO.getMaxIdx() }" />
</c:if>
<c:if test="${row==0 }">
<script>
alert('작성 실패')
history.go(-1)
</script>
</c:if>
</body>
</html>