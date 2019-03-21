<%@page import="com.jl.member.MemberDto" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정</title>
</head>
<body>
<jsp:include page="/Header.jsp"/>

	

	<h1>${member.name}님 회원정보 수정</h1>

	<form action="./update" method="post">
		번호 : <input type ="text" name="no" value="${member.no}" readonly="readonly"></br>
		이름 : <input type= "text" name="name" value="${member.name}"></br>
		이메일 : <input type="text" name="email" value="${member.email}" readonly="readonly"></br>
		</br><input type="submit" value="수정">
		<input type="button" value="메인화면" onclick="location='../'">
		<input type="button" value="탈퇴" onclick="location='./delete?email=${member.email}'">
	</form><!-- location="../"' -->
</body><!-- location="./delete?email=${member.email} -->
</html>