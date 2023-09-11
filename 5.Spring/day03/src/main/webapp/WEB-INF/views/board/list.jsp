<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<div class="layout">
	<table>
		<thead>
			<tr>
				<th>글 번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="dto" items="${list }">
			<tr>
				<td>${dto.idx }</td>
				<td>
					<a href="${cpath}/board/view/${dto.idx}">${dto.title }</a>
					<span>
					<c:if test="${dto.fileName!=null }">
					💾
					</c:if>
					</span>
				</td>
				<td>${dto.writer}</td>
				<td><fmt:formatDate value="${dto.rdate}" pattern="yyyy년 MM월 dd일 a hh시 mm분" /></td>
			</tr>
		</c:forEach>	
		</tbody>
	</table>
	<form>
		<input type="text" name="query" value="${param.query }" placeholder="검색어를 입력하세요"><button type="submit">검색</button>
	</form>
	
	
	<c:if test="${paging.prev }">
		<a href="${cpath }/board/list/${paging.begin-10}"><button>이전</button></a>
	</c:if>
	<c:forEach begin="${paging.begin }" end="${paging.end }" var="page">
	<c:if test="${param.query!='' and param.query!=null }">	
		<a href="${cpath }/board/list/${page }?query=${param.query}">${page }</a>
	</c:if>
	<c:if test="${param.query==null or param.query=='' }">	
		<a href="${cpath }/board/list/${page }">${page }</a>
	</c:if>
	</c:forEach>
		<c:if test="${paging.next }">
		<a href="${cpath }/board/list/${paging.end+1}"><button>다음</button></a>
	</c:if>
	
</div>

</body>
</html>