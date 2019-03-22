package com.jl.board;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/board/delete")

public class BoardDelete extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("BoardDelete의 doGet를 한다");
		Connection conn = null;
		PreparedStatement pstmt = null;
				
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "jsp";
		String password = "jsp";
		
		int bNo = Integer.parseInt(req.getParameter("no"));
		
		String sql = "";
		
		try {
			Class.forName(driver);
			System.out.println("오라클 드라이버 로드");
			
			conn = DriverManager.getConnection(url, user, password);
						
			sql = "DELETE FROM BOARD";
			sql += " WHERE NO = ?";
									
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, bNo);
			
			pstmt.executeUpdate();
			
			res.sendRedirect("./list");
					
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
		} // finally 종료
		
	}
		
		

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		

	}

}