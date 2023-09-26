<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<form method="POST">
	<table>
		<tr>
			<th>userid</th>
			<td>
				<input type="text" name="userid" placeholder="USERID">
			</td>
		</tr>
		<tr>
			<th>userpw</th>
			<td>
				<input type="password" name="userpw" placeholder="USERPW">
			</td>
		</tr>
		<tr>
			<th>username</th>
			<td>
				<input type="text" name="username" placeholder="USERNAME">
			</td>
		</tr>
		<tr>
			<th>email</th>
			<td>
				<input type="email" name="email" placeholder="EMAIL">
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="회원가입">
			</td>
		</tr>
	</table>
</form>

</body>
</html>