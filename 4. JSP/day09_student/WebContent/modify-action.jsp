<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<jsp:useBean id="dto" class="day09_student.StudentDTO" />
<jsp:setProperty property="*" name="dto"/>

${dao.update(dto) }

<c:redirect url="/list.jsp" />

</body>
</html>