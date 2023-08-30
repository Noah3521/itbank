<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<table class="frame">
<thead>
  <tr>
    <th>idx</th>
    <th>title</th>
    <th>writer</th>
    <th>wdate</th>
  </tr>
</thead>
<tbody>

<c:if test="${empty param.query }">
<c:forEach var="dto" items="${boardDAO.selectList() }">
  <tr style="border: 1px solid red">
    <td>${dto.idx }</td>
    <td class="title">
    	<a href="${cpath}/board/view.jsp?idx=${dto.idx}">${dto.title }</a>
       	<c:if test="${not empty dto.uploadFile }">
    	<span>💾</span>
    	</c:if>	
    </td>
    <td>${dto.writer }</td>
    <td>${dto.wdate }</td>
  </tr>
</c:forEach>
</c:if>

<c:if test="${not empty param.query }">
<c:forEach var="dto" items="${boardDAO.selectQueryList(param.query) }">
  <tr style="border: 1px solid red">
    <td>${dto.idx }</td>
    <td class="title">
    	<a href="${cpath}/board/view.jsp?idx=${dto.idx}">${dto.title }</a>
       	<c:if test="${not empty dto.uploadFile }">
    	<span>💾</span>
    	</c:if>	
    </td>
    <td>${dto.writer }</td>
    <td>${dto.wdate }</td>
  </tr>
</c:forEach>
</c:if>

</tbody>
</table>
<div class="writeBtn frame">
<a href="${cpath }/board/write.jsp"><button>글쓰기</button></a>

<form class="searchBox">
	<input type="text" name="query" placeholder="검색어를 입력하세요">
	<button>검색</button>
</form>

</div>


</body>
</html>