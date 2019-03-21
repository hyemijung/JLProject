<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    

    
    
    <div style="background-color:#896AB7; color: #ffffff;
    	height: 20px; padding: 5px;">
    	
    	
    	TPD(Team Project Demo)
    	<span style="float:right">
    	
    	<!-- email값이 없을 때 -->
    	<c:if test="${sessionScope.member == null}">
    	환영합니다 ${sessionScope.member.email}
    		<a href="<%=request.getContextPath() %>/auth/LoginForm.jsp">로그인</a>
    		<a href="<%=request.getContextPath() %>/member/memberForm.jsp">회원가입</a>
    	</c:if>
		<!-- email값이 있을 때 -->
    	<c:if test="${sessionScope.member != null}">	<!-- sessionScope.member.email 을 비교하면 안된다고 합니다 -->
    	${sessionScope.member.email}					<!-- sessionScope.member 즉 객체 자체를 비교해야 한다고 합니다 -->
    	<a href="<%=request.getContextPath() %>/member/update?no="${sessionScope.member.no}">회원정보 수정</a>
    		<a href=" <%=request.getContextPath() %>/member/logout"
    		style="color:white;">로그아웃
    		</a>
    		</c:if>
    	</span>
    	</div>
