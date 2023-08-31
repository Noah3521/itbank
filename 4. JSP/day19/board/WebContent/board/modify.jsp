<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>


<c:set var="dto" value="${boardDAO.selectOne(param.idx) }" />
<c:if test="${empty login or dto.writer != login.userid }">
	<script>
		alert('본인의 게시글만 수정할 수 있습니다.');
		history.go(-1)
	</script>
</c:if>

<div class="frame">
	<form method="POST" action="modify-action.jsp" enctype="multipart/form-data" accept="image/*" class="modifyForm">
		<p><input type="hidden" name="writer" value="${login.userid }"></p>
		<p><input type="hidden" name="idx" value="${dto.idx }"></p>
		<p><input type="text" name="title" value="${dto.title }" placeholder="제목" required></p>
		<p><textarea name="content" required placeholder="본문">${dto.content }</textarea></p>
		
		<p>
			현재 첨부파일 : <span id="fileState">${dto.uploadFile!=null ? dto.uploadFile : '없음' }</span>
			<span id="deleteBtn">${dto.uploadFile!=null ? '❌': '' }</span>
		</p>
		
		<p><input type="file" name="uploadFile"></p>
		
		<p><input type="submit" value="수정" class="modifyBtn"></p>
	</form>
</div>

<script>
	const deleteBtn = document.getElementById('deleteBtn')
	const fileState = document.getElementById('fileState')
	deleteBtn.onclick = function(event) {
		if(confirm('정말 삭제하시겠습니까?')) {
			location.href = '${cpath}/board/delFile.jsp?idx=${dto.idx}'
		}
	}
</script>

</body>
</html>