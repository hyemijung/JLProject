<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
	body{
		background-color: lightyellow;
	}
</style>
<title>회원가입</title>
</head>
<body>
<jsp:include page="/Header.jsp"/>
	<h1>회원 가입</h1>
	<form action="./add" method="post">
	<table>
		<tr>
			<td>이름</td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type="text" name="email"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="password"></td>
		</tr>
	</table>
	<input onclick='location="/TeamProjectDemo/MainPage.jsp"' type="button" value="메인 화면으로">
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
	<input type="submit" value="가입">
	<input type="reset" value="취소">
	</form>
</body>
</html>