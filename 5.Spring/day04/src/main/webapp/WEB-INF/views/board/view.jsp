<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<div class="layout">
	<h2>${dto.title }</h2>
	<p>${dto.writer } | ${dto.rdate }</p>
	<pre>${dto.content }</pre>
	<img src="${cpath }/upload/${dto.fileName }">
	<button id="btnMod">수정</button>
	<button id="btnDel">삭제</button>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>

const btnMod = document.getElementById('btnMod')
const btnDel = document.getElementById('btnDel')

btnDel.onclick = function() {
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

btnMod.onclick = function() {
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