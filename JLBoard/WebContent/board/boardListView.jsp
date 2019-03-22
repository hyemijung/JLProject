<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
table {
	border-collapse: collapse;
	margin: auto;
}

table, tr, td {
	border: 2px solid black;
}

body {
	background: #FFE8FF;
}

.no {
	width: 40px;
	text-align: center;
}

.title {
	width: 500px;
	text-align: center;
}

.writer {
	width: 200px;
	text-align: center;
}

.creDate {
	width: 150px;
	text-align: center;
}
/*  div{ */
/*  	width: 890px; */
/*  	text-align: right; */
/*  } */
 
 #divTag{
 	width: 890px;
 	margin: auto;
 	text-align: right;
 }
</style>
<title>게시판</title>
</head>
<body>

	<jsp:include page="/Header.jsp" />

	<h1 style="text-align: center;">자유게시판</h1>

	<br>
	<table>
		<tr>
			<td class="no">번호</td>
			<td class="title">제목</td>
			<td class="writer">작성자</td>
			<td class="creDate">작성일</td>

		</tr>
		<c:forEach var="boardDto" items="${boardList}">

			<tr>
				<td class="no">${boardDto.no}</td>
				<td class="title"><a href="./myContentView?no=${boardDto.no}">${boardDto.title}</a>
				</td>
				<td class="writer">${boardDto.writer}</a>
				</td>
				<td class="creDate">${boardDto.creDate}</td>

			</tr>
		</c:forEach>
		<tr style="border-color: transparent;">
			
			<td style="text-align:right; border-color:transparent;">
			
			<input type="button" value="글쓰기" onclick="location='./add'" style="vertical-align: sub;">
	
			</td>
			
		</tr>
	</table>






	<%--    <jsp:include page="/Tail.jsp" /> --%>

</body>
</html>