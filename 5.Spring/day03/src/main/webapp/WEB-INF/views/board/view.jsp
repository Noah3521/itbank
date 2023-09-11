<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<div class="layout">
	<table>
		<tr>
			<th colspan="3"><h3>${dto.title }</h3></th>
		</tr>
		<tr>
			<td>${dto.writer }</td>
			<th> | </th>
			<td><fmt:formatDate value="${dto.rdate}" pattern="yy년 MM월 dd일 a hh시 mm분" /></td>
		</tr>
		<tr>
			<td colspan="3">
				<pre>
					${dto.content }
				</pre>
			</td>
		</tr>
		<tr>
			<c:if test="${dto.fileName!=null }">
			<td><img src="${cpath }/upload/${dto.fileName }"></td>
			</c:if>
		</tr>
	</table>
	<button id="deleteBtn">삭제</button>
	<button id="modifyBtn">수정</button>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	const deleteBtn = document.getElementById('deleteBtn');
	const modifyBtn = document.getElementById('modifyBtn');

	deleteBtn.onclick = function() {
		const input = prompt('비밀번호를 입력하세요');
		$.ajax({
			type : "POST",
			url : "${cpath}/board/checkPwd", //요청 할 URL
			data : JSON.stringify ({ 
				idx : '${dto.idx}',
				input : input
				}), //넘길 파라미터
			contentType: "application/json; charset=utf-8",
			jsonp : "callback",
			dataType : "text",
			withCredentials: true,
			success : function(data) {
				//통신이 정상적으로 되었을때 실행 할 내용
				flag = data;
				if(flag=='true') {
					location.href='${cpath}/board/delete/${dto.idx}';
				} else {
					alert('비밀번호가 일치하지 않습니다');
				}
			},
			error : function(data) {
				console.log("접속 도중 오류가 발생했습니다."); //에러시 실행 할 내용
			}
		});
	}
	
	modifyBtn.onclick = function() {
		const input = prompt('비밀번호를 입력하세요');
		$.ajax({
			type : "POST",
			url : "${cpath}/board/checkPwd", //요청 할 URL
			data : JSON.stringify ({ 
				idx : '${dto.idx}',
				input : input
				}), //넘길 파라미터
			contentType: "application/json; charset=utf-8",
			jsonp : "callback",
			dataType : "text",
			withCredentials: true,
			success : function(data) {
				//통신이 정상적으로 되었을때 실행 할 내용
				flag = data;
				if(flag=='true') {
					location.href='${cpath}/board/modify/${dto.idx}';
				} else {
					alert('비밀번호가 일치하지 않습니다');
				}
			},
			error : function(data) {
				console.log("접속 도중 오류가 발생했습니다."); //에러시 실행 할 내용
			}
		});
	}
</script>

</body>
</html>