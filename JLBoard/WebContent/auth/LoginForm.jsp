<%@page import="com.jl.member.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>

<script type="text/javascript">

	function loginSubmitFnc() {
		var formObj = document.getElementById('loginForm');

		formObj.submit();
	}
</script>

</head>

<%
	MemberDto memberDto = (MemberDto) session.getAttribute("member");
	if (memberDto == null) {
		System.out.println("세션에 회원 정보가 없습니다");
	}else{
		System.out.println(memberDto.getEmail());
		System.out.println("님의 정보가 존재합니다");
		

	}
%>

<body>
<jsp:include page="/Header.jsp"/>
	<h2>사용자 로그인</h2>
	<form action="/JLBoard/member/login" id="loginForm" method="post">
	<table>
	<tr>
		<td>이메일</td>
		<td><input type="text" name="email"></td>
	</tr>
	<tr>
		<td>암호</td>
		<td><input type="password" name="password"></td>
	</tr>
	</table>
		<input type="button" value="로그인" onclick="loginSubmitFnc()">
		<input type="button" value="메인 페이지로" onclick='location="/JLBoard"'>
	</form>


</body>
</html>