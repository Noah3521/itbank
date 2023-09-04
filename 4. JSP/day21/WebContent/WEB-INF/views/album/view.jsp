<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<h3>${dto.name }</h3>
<table>
	<tr>
		<th rowspan="3">
		<div>
			<c:if test="${not empty dto.coverimg }">
			<img src="${cpath }/album_img/${dto.coverimg }" width="200">
			</c:if>
		</div>
		</th>
	</tr>
</table>

<button id="albumDelBtn">삭제</button>

<script>
	const albumDelBtn = document.getElementById('albumDelBtn');
	albumDelBtn.onclick = function() {
//		if('${login.name != dto.name}') {
//			alert('본인의 정보가 아닙니다');
//			history.go(-1);
//		}
//		else 
		if(confirm('삭제할거임?')) {
		location.href='${cpath}/album/delete?id=${dto.id}';
		} 
	}
</script>

</body>
</html>