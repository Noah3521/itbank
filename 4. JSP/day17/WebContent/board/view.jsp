<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<c:set var="dto" value="${boardDAO.selectOne(param.idx) }" />

${dto.idx }
${dto.title }
${dto.writer }
${dto.content }
<c:if test="${not empty dto.uploadFile }">
<img src="${cpath }/upload/${dto.uploadFile }">
</c:if>
${dto.wdate}

<a href="${cpath }/board/modify.jsp?idx=${dto.idx}"><button>수정</button></a>
<a href="${cpath }/board/delete.jsp?idx=${dto.idx}"><button>삭제</button></a>

</body>
</html>