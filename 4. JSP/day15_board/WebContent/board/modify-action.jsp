<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<jsp:useBean id="board" class="board.BoardDTO" />
<jsp:setProperty property="*" name="board"/>

<c:set var="row" value="${boardDAO.modify(board) }" />

<c:if test="${row!=0 }">
	<c:redirect url="/board/view.jsp?idx=${board.idx }" />
</c:if>
<c:if test="${row==0 }">
	<script>alert('수정실패')</script>
	<c:redirect url="/board/list.jsp" />
</c:if>



</body>
</html>