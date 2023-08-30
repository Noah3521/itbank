<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<c:if test="${empty login }">
	<script>alert('로그인 후 작성해주세요')</script>
	<c:redirect url="/member/login.jsp" />
</c:if>

<style>

</style>

<div class="frame">
	<form method="POST" action="wirte-action.jsp" enctype="multipart/form-data" accept="image/*" class="writeForm">
		<p><input type="text" name="title" placeholder="제목" required></p>
		<p><input type="hidden" name="writer" value="${login.userid }"></p>
		<p><textarea name="content" required placeholder="본문"></textarea></p>
		<p><input type="file" name="uploadFile"></p>
		<p><input type="submit" value="업로드" class="uploadBtn"></p>
	</form>
</div>

</body>
</html>