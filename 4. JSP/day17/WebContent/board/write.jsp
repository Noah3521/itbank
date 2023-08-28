<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<c:if test="${empty login }">
	<c:redirect url="/member/login.jsp" />
</c:if>

<form method="POST" enctype="multipart/form-data" action="write-action.jsp">
	<p><input type="text" name="title" placeholder="제목" required></p>
	<p><input type="hidden" name="writer" value="${login.userid }" ></p>
	<p>
		<textarea name="content" placeholder="내용" required></textarea>
	</p>	
	<p><input type="file" name="image" accept="image/*"></p>
	<p><input type="submit"></p>
</form> 

</body>
</html>