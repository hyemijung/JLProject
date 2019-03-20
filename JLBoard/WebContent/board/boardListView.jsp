<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
	table{
		border-collapse: collapse;
		 
	}

	table, tr, td{
		border: 1px solid black;
	}
</style>
<title>게시판</title>
</head>
<body>

	<jsp:include page="/Header.jsp" />
	
	<h1>글 목록</h1>
	<div>
		<a href="./add">글쓰기</a>
	</div>
	<br>
	
<table>
	<c:forEach var="boardDto" items="${boardList}">
		<tr>
			<td>번호</td>	
			<td>제목</td>	
			<td>내용</td>	
			<td>작성자</td>
			<td>작성일</td>	
			<td></td>	
		</tr>
		<tr>
			<td>${boardDto.no}</td>	
			<td>
				${boardDto.title}</a>
			</td>	
			<td>${boardDto.content}</td>	
			<td>
				<a href='./update?writer=${boardDto.writer}'>${boardDto.writer}</a>
			</td>	
			<td>${boardDto.creDate}</td>	
			<td>
				<a href='./delete?writer=${boardDto.writer}'>[삭제]</a>
			</td>	
		</tr>
	</c:forEach>
</table>
	
	



<%-- 	<jsp:include page="/Tail.jsp" /> --%>

</body>
</html>