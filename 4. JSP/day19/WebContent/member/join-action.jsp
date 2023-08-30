<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<jsp:useBean id="user" class="member.MemberDTO" />
<jsp:setProperty property="*" name="user"/>

<c:set var="row" value="${memberDAO.insert(user) }" />

<script>
	const row = '${row}'
	if(row!=0) {
		alert('회원가입 완료')
		location.href='${cpath}/member/login.jsp'
	} else {
		alert('회원가입 실패')
		history.go(-1)
	}
</script>

</body>
</html>