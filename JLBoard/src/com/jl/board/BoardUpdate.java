package com.jl.board;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/board/update")

public class BoardUpdate extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub


		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "jsp";
		String password = "jsp";
		
		String writerStr = req.getParameter("writer");
				
		String sql = "";
		
		try {
			Class.forName(driver);
			System.out.println("오라클 드라이버 로드");
			
			conn = DriverManager.getConnection(url, user, password);
			
			// 수정을 위한 자신이 쓴글만을 조회하기위해 유일한 이메일주소(writer)를 사용한다		
			sql = "SELECT B.NO, B.TITLE, B.WRITER, B.CREDATE";
			sql += " FROM BOARD B, MEMBER M";
			sql += " WHERE B.WRITER = M.EMAIL";
			sql += " AND B.WRITER = ?";
			sql += " ORDER BY B.NO DESC";
			
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, writerStr);
			
			rs = pstmt.executeQuery();
			
			int no = 0;
			String title = "";
			String writer = "";
			String content = "";
			Date creDate = null;
//			ArrayList<MemberDto> memberList = new ArrayList<MemberDto>(); //기본키를 통해 한명을 조회하므로 ArrayList를 쓸 이유가 없다
			
			BoardDto boardDto = null;
			
			if (rs.next()) {  // 한명만 조회하므로 while문 대신 if문을 사용해도 된다(조금 더 빠름)
				no = rs.getInt("NO");
				title = rs.getString("TITLE");   // 대소문자 구분안함을 보이기위해
				writer = rs.getString("WIRTER");
				content = rs.getString("CONTENT");
				creDate = rs.getDate("CREDATE");
				
				boardDto = new BoardDto();
				
				boardDto.setNo(no);
				boardDto.setTitle(title);
				boardDto.setWriter(writer);;
				boardDto.setContent(content);
				boardDto.setCreDate(creDate);
			}

				
				req.setAttribute("boardDto", boardDto);
				
				res.setCharacterEncoding("UTF-8");
				
				RequestDispatcher dispatcher = 
						req.getRequestDispatcher("./boardUpdateForm.jsp");
				
				dispatcher.include(req, res);
			
//			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// 나중에 예외 처리
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
		} // finally 종료
		
	}
		
		

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("BoardUpdateServlet의 doPost를 한다");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		// 결과값을 받아서 하는것이 아니므로 필요없어서, rs= reSuelt 없어도 됨

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "jsp";
		String password = " jsp";
		
		req.setCharacterEncoding("UTF-8"); // 한글이 깨지지않도록 셋팅하는 것!!!
		

		String titleStr = req.getParameter("title"); // 한글깨지지 않는 셋팅하고 한글 넣고싶으면 넣어라
		String contentStr = req.getParameter("content");
		int bNo = Integer.parseInt(req.getParameter("no"));
				
		String sql = "";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);

			sql = "UPDATE BOARD";
			sql += " SET TITLE = ?, CONTENT= ?,";
			sql += " WHERE NO = ?";
			
			
			
			
			
			pstmt = conn.prepareStatement(sql); //문장을 준비만 한것-+sql을 전체를 넣어서
			
			pstmt.setString(1,  titleStr); // 물음표에 대한 설정(물음표도 순서가 있다)
			pstmt.setString(2,  contentStr);	// 동적으로 입력
			pstmt.setInt(3, bNo);
					
			pstmt.executeUpdate(); // 수행 // insert, delete 같은 수정을 한다
			
//			추가 - 새로고침할때마다 다시 남아있는 이전 양식의 수행을 막으려면?
			res.sendRedirect("./list"); // 새 정보를 추가하고나서 ./list 경로를 던져서 - 상대경로를 찾아간다 
										// 새로고침해도 양식이 다시 입력되지않고 상대경로로 찾아간다
					
			
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