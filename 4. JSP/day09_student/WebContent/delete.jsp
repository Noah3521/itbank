<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<div id="main">
	<h3>${dao.delete(param.name) }행이 삭제되었습니다</h3>
	<a href="${cpath }/list.jsp"><button>돌아가기</button></a>
</div>

</body>
</html>