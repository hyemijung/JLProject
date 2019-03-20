package com.jl.member;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/member/add")
public class MemberAdd extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.sendRedirect("./memberForm.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		 Connection conn = null;
	      PreparedStatement pstmt = null;

	      String url = "jdbc:oracle:thin:@localhost:1521:xe";
	      String user = "jsp";
	      String password = "jsp";
	      
	      req.setCharacterEncoding("UTF-8");
	      
	      //위에잇는것들다 나중에 숨길거임
	      //정보보호차원에서나 귀차니즘(?)차원에서나...
	      //프레임워크는 다 만들어져있긴 합니당 ㅎ
	      
	      String emailStr = req.getParameter("email");
	      String pwdStr = req.getParameter("password");
	      String nameStr = req.getParameter("name");

	      String sql = "";

	      try {
	         Class.forName("oracle.jdbc.driver.OracleDriver");
	         conn = DriverManager.getConnection(url, user, password);
	         
	         sql = "INSERT INTO MEMBER";
	         sql += " (NO, EMAIL, PWD, NAME, CREDATE)";
	         sql += " VALUES(MEMBERS_MNO_SEQ.NEXTVAL, ?, ?, ?, SYSDATE)";

	         pstmt = conn.prepareStatement(sql);
	         
	         pstmt.setString(1,  emailStr);
	         pstmt.setString(2,  pwdStr);
	         pstmt.setString(3,  nameStr);
	         
	         
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
