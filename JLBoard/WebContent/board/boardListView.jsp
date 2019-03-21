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
    margin: 20px;
   }
    
	
   table, tr, td{
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
   }
   
   .writer {
   	width: 200px;
   	text-align: center;
   }
   
   .creDate{
   	width: 150px;
   	text-align: center;
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
         <td class="no">번호</td>   
         <td class="title">제목</td>   
         <td class="writer">작성자</td>
         <td class="creDate">작성일</td>   
          
      </tr>
      <tr>
         <td class="no">${boardDto.no}</td>   
         <td class="title">
        <a href="./myContentView?no=${boardDto.no}">${boardDto.title}</a>
         </td>   
         <td class="writer">${boardDto.writer}</a>
         </td>   
         <td class="creDate">${boardDto.creDate}</td>   
           
      </tr>
   </c:forEach>
</table>
   
   



<%--    <jsp:include page="/Tail.jsp" /> --%>

</body>
</html>