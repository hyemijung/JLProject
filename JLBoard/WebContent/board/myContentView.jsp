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

</style>
<title>회원 등록</title>
<script type="text/javascript">
	function backPageFnc() {
		location.href = './list';
	}
	
	function deleteFnc() {
		var writer = document.getElementById('writer').value;
		var email = document.getElementById('email').value;
		if (writer != email) {
			alert("삭제 권한이 없습니다");
		}
		
		if (writer == email) {
			location.href = "./delete?no=" + ${myContentDto.no};	
		}
	}
	
	function updateFnc() {
		var writer = document.getElementById('writer').value;
		var email = document.getElementById('email').value;
		if (writer != email) {
			alert("수정 권한이 없습니다");
		}
		
		if (writer == email) {
			location.href = "./update?writer="+writer;	
		}
	}
// 	onclick='location="./update?writer=${myContentDto.writer}"
</script>



</head>
<body>

<jsp:include page="/Header.jsp"/>

	<h1>게시글 보기</h1>
<!-- 	<form action="./add" method="post"> -->
		<input type="hidden" id="email" value="${member.email}">
			<table>
				<tr>
					<td>글 번호:</td>
					<td><input type="text" id='no' name="no" value="${myContentDto.no}" readonly="readonly"><br></td>
				</tr>
				<tr>
					<td>제목:</td>
					<td><input type="text" name="title" value="${myContentDto.title}" readonly="readonly"><br></td>
				</tr>
				<tr>
					<td>내용:</td>
					<td><textarea name="content" rows="10" cols="100" readonly="readonly">${myContentDto.content}</textarea> <br></td>
				</tr>
				<tr>
					<td>글쓴이:</td>
					<td><input type="text" name="writer" id="writer" value="${myContentDto.writer}" readonly="readonly"><br></td>
				</tr>
				<tr>
					<td>작성일:</td>
					<td><input type="text" name="creDate" value="${myContentDto.creDate}" readonly="readonly"> <br></td>
				</tr>
		
			</table>
		
		
		<input type="button" value="삭제" onclick="deleteFnc();">
		 <input type="button" value="수정" onclick="updateFnc();">
		<input type="button" value="뒤로가기" onclick="backPageFnc();">
			
<!-- 	</form> -->


<%-- <jsp:include page="/Tail.jsp"/>   --%>

</body>


</html>