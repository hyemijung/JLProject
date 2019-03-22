<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
	body{
		background-color: #FFE8FF;
	}
	
	table{
    border-collapse: collapse;
    margin: 20px;
   }
    
	
   table, tr, td{
    border: 2px solid black;
   }
		
	.no {
   	width: 100px; 
   	text-align: center;
   }
   
   .name{
   	width: 250px;
   	text-align: center;
   	
   	.email{
  	width: 300px;
   	text-align: center;
   	}
   	
   	.creDate{
   	width: 200px;
   	text-align: center;
   }
   	
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
		<tr>
			<td class="no">회원번호</td>
			<td class="name">회원이름</td>
			<td class="email">&nbsp;&nbsp;&nbsp; 이메일</td>
			<td class="creDate">&nbsp;&nbsp;가입일</td>
		</tr>
	<c:forEach var="memberDto" items="${memberList}">
		<tr>
			<td class="no">${memberDto.no}</td>
			<td class="name">${memberDto.name}</td>
			<td class="email">&nbsp;&nbsp;${memberDto.email}&nbsp;&nbsp;</td>
			<td class="creDate">${memberDto.createDate}</td>
		</tr>
		</c:forEach>
	</table>
	
</body>
</html>