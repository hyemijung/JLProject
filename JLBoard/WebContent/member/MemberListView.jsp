<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
	body{
		background-color: lightyellow;
	}
</style>
<title>JLBoard의 회원목록</title>
</head>
<body>

<jsp:include page="/Header.jsp"/>
	<h1>회원목록 전체조회</h1>
	<div>
		<a href="./add">신규회원</a>
	</div>
	</br>
	
	<table>
	<c:forEach var="memberDto" items="${memberList}">
		<tr>
			<td>회원번호</td>
			<td>회원이름</td>
			<td>&nbsp;&nbsp;&nbsp; 이메일</td>
			<td>&nbsp;&nbsp;가입일</td>
		</tr>
		<tr>
			<td>${memberDto.no}</td>
			<td>${memberDto.name}</td>
			<td>&nbsp;&nbsp;${memberDto.email}&nbsp;&nbsp;</td>
			<td>${memberDto.createDate}</td>
		</tr>
		</c:forEach>
	</table>
	
</body>
</html>