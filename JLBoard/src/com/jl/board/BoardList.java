package com.jl.board;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jl.board.BoardDto;

@WebServlet(value="/board/list")
public class BoardList extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "jsp";
		String password = "jsp";
		
		String sql = "";
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
						
			sql = "SELECT NO, TITLE, WRITER, CONTENT, CREDATE";
			sql += " FROM BOARD";
			sql += " ORDER BY NO DESC";
									
			pstmt = conn.prepareStatement(sql);
					
			rs = pstmt.executeQuery();
			System.out.println("쿼리 수행 성공");
			
			res.setContentType("text/html");
			res.setCharacterEncoding("UTF-8");
			
//			게시판 - 글 목록 데이터 보관
//			왜 리스트로 만들었나? 게시판의 글이 몇개나 될지 모르는 것(여러개일것이므로 ArrayList 로 만들었다)
			ArrayList<BoardDto> boardList = new ArrayList<BoardDto>(); // 이후 boardListView.jsp 로 전달한다
			
			int no = 0;
			String title ="";
			String writer = "";
			String content ="";
			Date creDate = null;
			
//			데이터베이스에서  게시판 정보를 가져와 BoardDto에 담는다 
//			그리고 BoardDto 객체를 ArrayList에 추가한다
			while(rs.next()) {
				no = rs.getInt("NO");
				title = rs.getString("TITLE");
				writer = rs.getString("WRITER");
				content = rs.getString("CONTENT");
				creDate = rs.getDate("CREDATE");
				
				BoardDto boardDto = 
						new BoardDto(no, title, writer, content, creDate);
				boardList.add(boardDto);
				
			} // while end
			
			// request에 게시판 목록 데이터를 보관한다 // map 방식
			req.setAttribute("boardList", boardList);
			
			// jsp로 출력을 위임한다(페이지를 넘긴다) //리퀘스트를 풀다
			RequestDispatcher dispatcher = 
					req.getRequestDispatcher("./boardListView.jsp"); // 다음 경로의 위치 설정
			
			dispatcher.include(req, res); //setAttribute로 담았으니깐 가져가야 페이지의 내용이 소실되지 않는다
			
			
			
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
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		
		
		
		
		
		
	}
	
	
	
}
