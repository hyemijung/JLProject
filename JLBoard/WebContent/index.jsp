<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
	body{
		background-color: #FFE8FF;
	}

</style>
<title>홈페이지</title>
</head>
<body>
	<jsp:include page="/Header.jsp"></jsp:include>
	<h1>메인페이지</h1>
	<h1><img src="image/Unexpected.jpg" alt="상상도못한정체" /></h1>
	
	<input type="button" value="게시판 목록" onclick="location='./board/list'">
</body>
</html>