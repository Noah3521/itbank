<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>


<h3>${artistDTO.name }</h3> 

<table class="artist-view">
	<tr>
		<td rowspan="4">
			<div class="img size300">
				<c:if test="${not empty artistDTO.profileimg }">
				<img src="${cpath }/artist_img/${artistDTO.profileimg }" width="300">
				</c:if>
			</div>
		</td>	
		<td>유형</td>
		<td>${artistDTO.type }</td>
	</tr>
	<tr>
		<td>데뷔</td>
		<td>${artistDTO.debut }</td>
	</tr>
	<tr>
		<td>국적</td>
		<td>${artistDTO.country }</td>
	</tr>
	<tr>
		<td>소속</td>
		<td>${artistDTO.company }</td>
	</tr>
</table>

<button id="artistDelBtn">삭제</button>
<a href="${cpath }/artist/modify?id=${artistDTO.id}"><button>수정</button></a>

<h3>${not empty albumList ? '앨범' : '앨범이 존재하지 않습니다' }</h3>

<c:if test="${not empty albumList }">
<table>
	<tr>
		<th>id</th>
		<th>artistId</th>
		<th>name</th>
		<th>type</th>
		<th>rdate</th>
		<th>playtime</th>
		<td>coverImg</td>
	</tr>
	<c:forEach var="albumDTO" items="${albumList }">
	<tr>
		<td>${albumDTO.id }</td>
		<td>${albumDTO.artist_id }</td>
		<td>${albumDTO.name }</td>
		<td>${albumDTO.type }</td>
		<td>${albumDTO.rdate }</td>
		<td>${albumDTO.playtime }</td>
		<td><img src="${cpath }/album_img/${albumDTO.coverimg}" width="300"></td>
		<td>
			<button class="albumDelBtn ${albumDTO.id }">삭제</button>
			<button class="albumModBtn ${albumDTO.id }">수정</button>
		</td>
	</tr>
	</c:forEach>
</table>
</c:if>

<script>
	const artistDelBtn = document.getElementById('artistDelBtn');
	
	artistDelBtn.onclick = function() {
		if(confirm('ㅇㅇㅇㅇ?????')) {
			location.href='${cpath}/artist/delete?id=${artistDTO.id}';
		} 
	}
	
	const albumDelBtnArray = Array.from(document.querySelectorAll('.albumDelBtn'));
	albumDelBtnArray.forEach(a => a.onclick=function() {
		if(confirm('ㅇㅇㅇㅇ??????')) {
	    location.href='${cpath}/album/delete?id='+a.classList[1];			
		}
	})
	
	const albumModBtnArray = Array.from(document.querySelectorAll('.albumModBtn'));
	albumModBtnArray.forEach(a => a.onclick=function() {
	    location.href='${cpath}/album/modify?id='+a.classList[1];			
	})

	
</script>

</body>
</html>