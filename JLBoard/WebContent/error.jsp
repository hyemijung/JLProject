<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/Header.jsp"></jsp:include>
	<% 
		Exception e = (Exception)request.getAttribute("error");
		String msg = "";
		msg = e.getMessage();
	%>

		<p>요청을 처리하는 중에 문제가 발생하였습니다. 잠시 후에 다시 요청해 주세요</p>
		<p>만약  계속해서 이 문제가 발생된다면 시스템 운영팀(사내번호 8282)에 연락하시기 바랍니다</p>
		<p>감사합니다</p></br>
		
		메세지 :
		
		<p> <%=msg %> </p>
</body>
</html>