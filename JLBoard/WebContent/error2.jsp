<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" http-equiv="Refresh" content="3;url=../member/add">
<style type="text/css">
	body{
		background-color: #FFE8FF;
	}

</style>

<title>에러페이지</title>
</head>
<body>
	<jsp:include page="/Header.jsp"></jsp:include>
	<% 
		Exception e = (Exception)request.getAttribute("error");
		String msg = "";
		msg = e.getMessage();	
	%>

		<p>회원만 글을 작성할 수 있습니다</p>
		<p>잠시 후 회원가입 페이지로 이동합니다</p>
		<p>감사합니다</p></br>
		
</body>
</html>