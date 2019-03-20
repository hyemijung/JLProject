<%@page import="com.jl.member.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>

<script type="text/javascript">
	// 	window.onload = {
	// 		var forObj = document.getElementById('loginForm')  // 나중에 미래에 쓸꺼다
	// 	}

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
		
// 		String contextPathStr = request.getContextPath() + "/member/list";
		
// 		response.sendRedirect(contextPathStr);
	}
%>

<body>
	<h2>사용자 로그인</h2>
	<form action="./login" id="loginForm" method="post">
		이메일: <input type="text" name="email"><br> 
		암호: <input type="password" name="password"><br> 
			<input type="button" value="로그인" onclick="loginSubmitFnc()">

	</form>

</body>
</html>