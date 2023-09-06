<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<style>
	table {
		border: 2px solid #ddd; 
		width: 60%;
		border-collapse: collapse;
	}
	.coverImg {
		width: 45%;
	}
	.coverImg > img {
		height: 100%;
	}
	h3, h4 {
		margin: 0;
		padding: 0; 
	}
	.music > thead th {
		padding: 5px;
		background-color: darkgrey;
	}
	.music > tbody td {
		border: 1px solid #dadada;
		padding: 10px;
	}
</style>

<h2>앨범 정보</h2>
<table>
	<tr>
		<th rowspan="5" class="coverImg">
			<c:if test="${not empty albumDTO.coverimg }">
			<img src="${cpath }/album_img/${albumDTO.coverimg }">
			</c:if>
		</th>
		<th colspan="2">
			<h3>${albumDTO.name }</h3>
		</th>
	</tr>
	<tr>
		<th colspan="2">
			<h3><a href="${cpath }/artist/view?id=${artistDTO.id }">${artistDTO.name }</a></h3>
		</th>
	</tr>
	<tr>
		<th>발매일</th>
		<td>${albumDTO.rdate }</td>
	</tr>
	
	<tr>
		<th>발매일</th>
		<td>${albumDTO.type }</td>
	</tr>
	<tr>
		<th>기획사</th>
		<td>${artistDTO.company }</td>
	</tr>
	
</table>

<a href="${cpath }/music/add?album_id=${albumDTO.id}&artist_id=${artistDTO.id}"><button>곡 추가</button></a>
<button id="albumDelBtn">삭제</button>
<a href="${cpath}/album/modify?id=${albumDTO.id}"><button>수정</button></a>

<br>
<hr>
<br>

<c:if test="${musicList.size() == 0}">
	<h3>수록곡이 없습니다</h3>
</c:if>

<c:if test="${musicList.size() != 0}">
<h3>수록곡 (${musicList.size()})</h3>
<table class="music">
	<thead>
		<tr>
			<th>번호</th>
			<th>곡정보</th>
			<th>재생시간</th>
			<th>재생횟수</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="musicDTO" items="${musicList }">
		<tr>
			<td>${musicDTO.id }</td>
			<td><a href="${cpath}/music/view?id=${musicDTO.id}">${musicDTO.name }</a></td>
			<td>${musicDTO.playtime }</td>
			<td>${musicDTO.playCount }</td>
			<td><a href="${cpath }/music/modify?id=${musicDTO.id}"><button>수정</button></a></td>
			<td><button class="musicDelBtn ${musicDTO.id }">삭제</button></td>
		</tr>
		</c:forEach>
	</tbody>
</table>
</c:if>

<script>
	const albumDelBtn = document.getElementById('albumDelBtn');
	albumDelBtn.onclick = function() {
//		if('${login.name != dto.name}') {
//			alert('본인의 정보가 아닙니다');
//			history.go(-1);
//		}
//		else 
		if(confirm('삭제할거임?')) {
		location.href='${cpath}/album/delete?id=${albumDTO.id}';
		} 
	}
	const musicDelBtnArray = Array.from(document.querySelectorAll('.musicDelBtn'));
	musicDelBtnArray.forEach(a => a.onclick=function() {
	if(confirm('ㅇㅇㅇㅇ??????')) {
	    location.href='${cpath}/music/delete?id='+a.classList[1];			
		}
	})
		
</script>

	
</body>
</html>