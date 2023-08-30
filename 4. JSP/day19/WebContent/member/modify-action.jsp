<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<jsp:useBean id="user" class="member.MemberDTO" />
<jsp:setProperty property="*" name="user"/>

<c:set var="row" value="${memberDAO.update(user) }" />

<c:if test="${row!=0 }">
	<%
		session.invalidate();
	%>
	<script>
		alert('수정 성공')
		location.href='${cpath}/member/login.jsp'
	</script>
</c:if>

</body>
</html>