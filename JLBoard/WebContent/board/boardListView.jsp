<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
         <td>작성자</td>
         <td>작성일</td>   
          
      </tr>
      <tr>
         <td>${boardDto.no}</td>   
         <td>
            <a href="./myContentView?no=${boardDto.no}">${boardDto.title}</a>
<%--             <a href="<%=request.getContextPath() %>/member/update?no="${sessionScope.member.no}">회원정보 수정</a> --%>
         </td>   
         <td>${boardDto.writer}</a>
         </td>   
         <td>${boardDto.creDate}</td>   
           
      </tr>
   </c:forEach>
</table>
   
   



<%--    <jsp:include page="/Tail.jsp" /> --%>

</body>
</html>