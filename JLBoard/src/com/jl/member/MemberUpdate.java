package com.jl.member;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jl.member.MemberDto;

@WebServlet(value="/member/upadate")
public class MemberUpdate extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		 PreparedStatement pstmt = null;
		 ResultSet rs = null;
		 //셋이 순서 꼭 지켜야됨
		 //지울때는 반대로 지워야됨 rs 지우고 pstmt 지우고 conn 지워야됨
		 
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "jsp";
		String password =" jsp";
		
		int no = Integer.parseInt(req.getParameter("no"));
		String sql = "";
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("오라클 드라이버 로드");
			
			
			conn = DriverManager.getConnection(url, user, password);
			
			
			sql += "SELECT NO, EMAIL, NAME, CREDATE";
			sql += " FROM MEMBER";
			sql += " WHERE EMAIL = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, no);
			
			
			rs = pstmt.executeQuery();
			
			MemberDto memberDto = null;
			String mName = "";
			String email = "";
			Date creDate = null;
			
			while (rs.next()) {
				no = rs.getInt("NO");
				mName = rs.getString("NAME");
				email = rs.getString("email");
				creDate = rs.getDate("CREDATE");
				memberDto = new MemberDto(no, mName, email, creDate);
			}
			
			
			req.setAttribute("memberDto", memberDto);
			res.setCharacterEncoding("UTF-8");
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("./memberUpdateForm.jsp");
			
			dispatcher.include(req,res);
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			req.setAttribute("error", e);//key,value 라고 합니다
	    	  RequestDispatcher dispatcher = req.getRequestDispatcher("/error.jsp");
	    	  
	    	  dispatcher.forward(req, res);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
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
