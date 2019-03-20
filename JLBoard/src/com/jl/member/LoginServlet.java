package com.jl.member;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet(value="/member/login")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		HttpSession session = req.getSession();
		
		MemberDto memberDto = (MemberDto)session.getAttribute("member");
		
		if (memberDto == null) {
			RequestDispatcher rd = req.getRequestDispatcher("/auth/LoginForm.jsp");
			rd.forward(req,res);
		}else {
			String contextPathStr = req.getContextPath() + "../"; //메인페이지 띄우고싶은데
			res.sendRedirect(contextPathStr);					  //이렇게해놔도되나? ->됩니다
		}
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		 Connection conn = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      
	      String url = "jdbc:oracle:thin:@localhost:1521:xe";
	      String user = "jsp";
	      String password = "jsp";
	      
	      req.setCharacterEncoding("UTF-8");
	      
	      String email = req.getParameter("email");
	      String pwd = req.getParameter("password");
	      String name = "";
	      int no = 0;
	      
	      
	      String sql = "";
	      
	      int colIndex = 1; //컬럼 위치
	      
	      try {
	         Class.forName("oracle.jdbc.driver.OracleDriver");
	         conn = DriverManager.getConnection(url, user, password);
	                 
	         sql += "SELECT NAME, EMAIL, NO";
	         sql += " FROM MEMBER";
	         sql += " WHERE EMAIL = ?";
	         sql += " AND PWD = ?";
	         pstmt = conn.prepareStatement(sql);
	               
	         pstmt.setString(colIndex++, email);
	         pstmt.setString(colIndex, pwd);
	         
	         rs = pstmt.executeQuery();
	         System.out.println("쿼리 수행 성공");
	         
	         res.setContentType("text/html");
	         res.setCharacterEncoding("UTF-8");
	         
	         
	         if (rs.next()) {
	        	
				email = rs.getString("EMAIL");
				name = rs.getString("NAME");
				no = rs.getInt("NO");
				MemberDto memberDto = new MemberDto();
				//2
				memberDto.setEmail(email);
				memberDto.setName(name);
				memberDto.setNo(no);
				HttpSession session = req.getSession();	//new 해서 session 만든것과 비슷
				session.setAttribute("member", memberDto);//세션은 리다이렉트로 안넘어가도 살아있음!
				
				
				res.sendRedirect("../");	//기존 저장된 데이터 파기(?)시키고 페이지 전환
													//req에 담긴 데이터는 못쓴다는 말???
			}else {
				RequestDispatcher dispatcher = 
						req.getRequestDispatcher("../auth/LoginFail.jsp");
				
				dispatcher.forward(req, res);
			}
	         
	      } catch (Exception e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	    	  
	    	  //굳이 오류 하나를 지우고 이것만 남겨놓은 이유는
	    	  //모든 종류의 오류를 에러페이지로 강제전환시키기 위함이겟지?
	    	  
	    	  //예외처리 페이지로 위임
	    	  req.setAttribute("error", e);//key,value 라고 합니다
	    	  RequestDispatcher dispatcher = req.getRequestDispatcher("/error.jsp");
	    	  
	    	  dispatcher.forward(req, res);
	      }finally {
	         if(rs != null) {
	            try {
	               rs.close();
	            } catch (Exception e) {
	               e.printStackTrace();
	            }
	         } // if(rs != null) end
	         
	         if(pstmt != null) {
	            try {
	               pstmt.close();
	            } catch (Exception e) {
	               e.printStackTrace();
	            }
	         }
	         
	         if(conn != null) {
	            try {
	               conn.close();
	            } catch (Exception e) {
	               e.printStackTrace();
	            }
	         }
	      } // finally end
		
	}

}
