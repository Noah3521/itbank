<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<c:forEach var="dto" items="${list }">
	<p>
		<a href="${cpath}/board/view/${dto.idx}">${dto.title }</a> 					<span>
					<c:if test="${dto.fileName!=null }">
					💾
					</c:if>
					</span> | 
		${dto.writer } | 
		${dto.rdate }
	</p>
</c:forEach>

<form>
	<input type="text" name="query" value="${param.query }" placeholder="검색어를 입력하세요"><button type="submit">검색</button>
</form>

<c:if test="${paging.prev }">
	<a href="${cpath }/board/list/${paging.begin - 10}"><button>이전</button></a>
</c:if>
<c:forEach var="i" begin="${paging.begin }" end="${paging.end }">
	<a href="${cpath }/board/list/${i}" style="${paging.page==i ? 'color: red' : ''}">${i }</a>
</c:forEach>
<c:if test="${paging.next }">
	<a href="${cpath }/board/list/${paging.end + 1}"><button>다음</button></a>
</c:if>
</body>
</html>