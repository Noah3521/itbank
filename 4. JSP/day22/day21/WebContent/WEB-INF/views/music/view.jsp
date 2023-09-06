<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<h2>곡 정보</h2>
<table>
	<tr>
		<th rowspan="6" class="coverImg">
			<c:if test="${not empty albumDTO.coverimg }">
			<img src="${cpath }/album_img/${albumDTO.coverimg }">
			</c:if>
		</th>
		<th colspan="2">
			<h3>${musicDTO.name }</h3>
		</th>
	</tr>
	<tr>
		<th colspan="2">
			<h3><a href="${cpath }/artist/view?id=${artistDTO.id }">${artistDTO.name }</a></h3>
		</th>
	</tr>
	<tr>
		<th>앨범</th>
		<td><a href="${cpath}/album/view?id=${albumDTO.id}">${albumDTO.name }</a></td>
	</tr>
	<tr>
		<th>발매일</th>
		<td>${albumDTO.rdate }</td>
	</tr>
	
	<tr>
		<th>장르</th>
		<td>${musicDTO.genre }</td>
	</tr>
	<tr>
		<th>기획사</th>
		<td>${artistDTO.company }</td>
	</tr>
	
</table>

<button id="musicDelBtn">삭제</button>
<a href="${cpath }/music/modify?id=${musicDTO.id}"><button>수정</button></a>

<h3>가사</h3>
<hr>
<pre>
	${musicDTO.lyrics }
</pre>

<script>
	const albumDelBtn = document.getElementById('musicDelBtn');
	albumDelBtn.onclick = function() {
		if(confirm('진짜 삭제?')) {
			location.href = '${cpath}/music/delete?id=${musicDTO.id }';
		}
	};
</script>

</body>
</html>