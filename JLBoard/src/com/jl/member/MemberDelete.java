package com.jl.member;

//기본
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/member/delete")
// 구우우우우웃!어노테이션으로 개꿀
//jsp3.0부터 쓸 수 있습니당

public class MemberDelete extends HttpServlet{

	 protected void doGet(HttpServletRequest req, HttpServletResponse res)
			 throws ServletException, IOException {
	      // TODO Auto-generated method stub

		 Connection conn = null;
		 PreparedStatement pstmt = null;
		 //셋이 순서 꼭 지켜야됨
		 //지울때는 반대로 지워야됨 rs 지우고 pstmt 지우고 conn 지워야됨
		 
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "jsp";
		String password ="jsp";
		 
		String email = req.getParameter("email");
		String sql = "";
		
		int no = Integer.parseInt(req.getParameter("no"));
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("오라클 드라이버 로드");
			
			
			conn = DriverManager.getConnection(url, user, password);
			
			
			sql += "DELETE FROM MEMBER";
			sql += " WHERE EMAIL = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, email);
			
			pstmt.executeUpdate();
			
			res.sendRedirect("../");
			
			
			

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
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
	 
	 //update를 업어오느라 이부분 삭제가 안된듯?
	 //일단은 놔두기(03/20 04:45 P.M.)
	 protected void doPost(HttpServletRequest req, HttpServletResponse res)
			 throws ServletException, IOException {
		 System.out.println("doPost를 탄다");
		 Connection conn = null;
	      PreparedStatement pstmt = null;
	      //결과값없어서 resultset없어도됨
	      
	      String url = "jdbc:oracle:thin:@localhost:1521:xe";
	      String user = "jsp";
	      String password = "jsp";
	      
	      req.setCharacterEncoding("UTF-8");
	      
	      String email = req.getParameter("email");
	      String name = req.getParameter("name");
	      int mNo = Integer.parseInt(req.getParameter("mNo"));
	      String sql = "";

	      try {
	         Class.forName("oracle.jdbc.driver.OracleDriver");
	         conn = DriverManager.getConnection(url, user, password);
	         
	         sql += "UPDATE MEMBERS";
	         sql += " SET EMAIL = ?, MNAME = ?,MOD_DATE = SYSDATE";
	         sql += " WHERE MNO = ?";
             
	         pstmt = conn.prepareStatement(sql);
	         
	         pstmt.setString(1,  email);
	         pstmt.setString(2,  name);
	         pstmt.setInt(3,  mNo);
	         
	         
	         pstmt.executeUpdate();
	         
	         res.sendRedirect("./list");
	      } catch (ClassNotFoundException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } finally {
	         if (pstmt != null) {
	            try {
	               pstmt.close();
	            } catch (Exception e) {
	               e.printStackTrace();
	            }
	         } // if(rs != null) end

	         if (pstmt != null) {
	            try {
	               pstmt.close();
	            } catch (Exception e) {
	               e.printStackTrace();
	            }
	         }

	         if (conn != null) {
	            try {
	               conn.close();
	            } catch (Exception e) {
	               e.printStackTrace();
	            }
	         }
	      } // finally end

		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
	 }

	
}
