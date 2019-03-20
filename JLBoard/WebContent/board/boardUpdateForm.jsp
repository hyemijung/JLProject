<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글 목록 조회</title>

<script type="text/javascript">
	function backPageFnc() {
		location.href = './list';
	}
	
	function deleteContentFnc() {
		var obj = document.getElementById('no');
		
		var boardNo = obj.value;
		
		location.href = './delete?no=' + boardNo;
	}
	
</script>

</head>
<body>

<jsp:include page="/Header.jsp"/>
		<h1>${boardDto.email} 회원 게시글 수정</h1>
		
	
		<form action="./update" method="post">
		
			<table>
				<tr>
					<td>글 번호:</td>
					<td><input type="text" id='no' name="no" value="${boardDto.no}" readonly="readonly"><br></td>
				</tr>
				<tr>
					<td>제목:</td>
					<td><input type="text" name="title" value="${boardDto.title}"><br></td>
				</tr>
				<tr>
					<td>내용:</td>
					<td><textarea name="content" rows="10" cols="100">${boardDto.content}</textarea> <br></td>
				</tr>
				<tr>
					<td>글쓴이:</td>
					<td><input type="text" name="writer" value="${boardDto.writer}"><br></td>
				</tr>
				<tr>
					<td>작성일:</td>
					<td><input type="text" name="creDate" value="${requestScope.boardDto.creDate}" readonly="readonly"> <br></td>
				</tr>
		
			</table>
		
		
		<input type="submit" value="수정" > 
		<input type="button" value="삭제" onclick="deleteContentFnc();"> 
		<input type="button" value="뒤로가기" onclick="backPageFnc();">
			
	</form>

<%-- 		글 번호: <input type="text" id='no' name="no" value="${boardDto.no}" readonly="readonly"><br> --%>
<%-- 		제목: <input type="text" name="title" value="${boardDto.title}"><br> --%>
<%-- 		내용: <textarea name="content" rows="10" cols="100">${boardDto.content}</textarea> <br> --%>
<%-- 		글쓴이: <input type="text" name="writer" value="${boardDto.writer}"><br> --%>
<%-- 		가입일: <input type="text" name="creDate" value="${requestScope.boardDto.creDate}" readonly="readonly"> <br> --%>



<%-- <jsp:include page="/Tail.jsp"/> --%>
</body>
</html>