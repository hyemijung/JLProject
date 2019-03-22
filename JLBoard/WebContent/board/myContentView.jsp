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

<style type="text/css">
	
	#content {
		border: 2px solid black;
		width: 550px;
		height: 450px;
		vertical-align: top;
		text-align: left;
	}
</style>

</head>
<body>

<jsp:include page="/Header.jsp"/>


		
		
		<table>
			<tr>
				<td> <h2> ${myContentDto.no}&nbsp;&nbsp;&nbsp; ${myContentDto.title}</h2></td>
			</tr>
		</table>
		
		<table id="table">
			<tr>
				<td style="width:70px; font-weight: bold;">작성자 &nbsp;&nbsp;&nbsp; ${myContentDto.writer}</td>
			</tr>
			<tr>
				<td style="font-weight: bold;">내용</td>
			</tr>
			
			<tr>
				<td id="content">${myContentDto.content}</td>
			</tr>
		</table>

		<input type="hidden" id="email" value="${member.email}">
			<table>
				<tr>
					<td><input type="hidden" id='no' name="no" value="${myContentDto.no}" readonly="readonly"><br></td>
				</tr>
				<tr>
					<td><input type="hidden" name="title" value="${myContentDto.title}" readonly="readonly"><br></td>
				</tr>
				<tr>
					<td><input type="hidden"  name="content" readonly="readonly" value="${myContentDto.content}"><br></td>
				</tr>
				<tr>
					<td><input type="hidden" name="writer" id="writer" value="${myContentDto.writer}" readonly="readonly"><br></td>
				</tr>
				<tr>
					<td><input type="hidden" name="creDate" value="${myContentDto.creDate}" readonly="readonly"> <br></td>
				</tr>
		
			</table>
		
		
		<input type="button" value="삭제" onclick="deleteFnc();">
		 <input type="button" value="수정" onclick="updateFnc();">
		<input type="button" value="뒤로가기" onclick="backPageFnc();">
			
<!-- 	</form> -->


<%-- <jsp:include page="/Tail.jsp"/>   --%>

</body>


</html>