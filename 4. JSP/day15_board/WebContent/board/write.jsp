<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<c:if test="${empty login }">
	<c:redirect url="/member/login.jsp" />
</c:if>

<form method="POST" action="write-action.jsp">
	<p><input type="text" name="title" placeholder="title"></p>
	<p><input type="hidden" name="writer" value="${login.userid }"></p>
	<p><textarea name="content" placeholder="content"></textarea></p>
	<p><input type="submit" value="작성완료"></p>
</form>

</body>
</html>