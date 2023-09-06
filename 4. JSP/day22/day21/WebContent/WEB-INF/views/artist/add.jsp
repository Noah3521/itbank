<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<!-- insert into artist (name, company, country, member, debut, type, profileimg)  -->
<!-- values('NewJeans', '주식회사 어도어', '대한민국', '민지(MINJI) , 하니(HANNI) , 다니엘(DANIELLE) , 해린(HAERIN) , 혜인(HYEIN)', '2022-07-22', '그룹', 'temp'); -->

<form method="POST" enctype="multipart/form-data">
	<table>
		<tr><th><input type="text" name="name" placeholder="이름" required autofocus autocomplete="off"></th></tr>
		<tr><th><input type="text" name="company" placeholder="회사" autocomplete="off"></th></tr>
		<tr><th><input type="text" name="country" placeholder="국적" autocomplete="off"></th></tr>
		<tr><th><input type="text" name="member" placeholder="멤버" required autocomplete="off"></th></tr>
		<tr><th><input type="date" name="debut" placeholder="데뷔일"></th></tr>
		<tr><th><input type="text" name="type" placeholder="유형" required autocomplete="off"></th></tr>
		<tr><th><input type="file" name="profileimg" placeholder="프로필이미지" accept="image/*"></th></tr>
		<tr><th><input type="submit"></th></tr>
	</table>
</form>

</body>
</html>