<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<jsp:useBean id="user" class="member.MemberDTO" />
<jsp:setProperty property="*" name="user"/>


<script>
	const flag = '${memberDAO.join(user)}'
	if(flag!=0) {
		alert('회원가입성공')
		location.href='${cpath}'
	}
	else {
		alert('회원가입실패')
		history.go(-1)
	}
</script>

</body>
</html>