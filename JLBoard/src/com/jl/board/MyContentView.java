package com.jl.board;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyContentView extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doPost(req,res);
		
		
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "jsp";
		String password = "jsp";
		
		String writerStr = req.getParameter("writer");
		
		String sql = "";
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
						
			sql = "SELECT NO, TITLE, WRITER, CONTENT, CREDATE";
			sql += " FROM BOARD";
			sql += " WHERE WRITER = ?";
			sql += " ORDER BY NO DESC";
					
									
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, writerStr);
			
			rs = pstmt.executeQuery();
			System.out.println("쿼리 수행 성공");
			
			res.setContentType("text/html");
			res.setCharacterEncoding("UTF-8");
			
			int no = 0;
			String title = "";
			String writer = "";
			String content = "";
			Date creDate = null;
	
			BoardDto myContentDto = null;
			
			if (rs.next()) {  // 한명만 조회하므로 while문 대신 if문을 사용해도 된다(조금 더 빠름)
				no = rs.getInt("NO");
				title = rs.getString("TITLE");   // 대소문자 구분안함을 보이기위해
				writer = rs.getString("WIRTER");
				content = rs.getString("CONTENT");
				creDate = rs.getDate("CREDATE");
				
				myContentDto = new BoardDto();
				
				myContentDto.setNo(no);
				myContentDto.setTitle(title);
				myContentDto.setWriter(writer);;
				myContentDto.setContent(content);
				myContentDto.setCreDate(creDate);
			}

				
				req.setAttribute("myContentDto", myContentDto);
				
				res.setCharacterEncoding("UTF-8");
				
				RequestDispatcher dispatcher = 
						req.getRequestDispatcher("./myContentView.jsp");
				
				dispatcher.include(req, res);
			
//			}

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			
			// 예외처리 페이지로 위엄
			req.setAttribute("error", e);
			RequestDispatcher dispatcher =
					req.getRequestDispatcher("/error.jsp");
			
			dispatcher.forward(req, res); //forwarding 방식(다른페이지로 위임하는 방식)
			
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
