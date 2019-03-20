package com.jl.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet(value="/member/logout")
public class LogoutServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doPost(req,res); //doGet의 정보유출 방지를 위해 두겟 메서드 안을 비워놓음 라잌디스
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//세션 객체 호출
		HttpSession session = req.getSession();
		//세션 객체 파기
//		일정 시간이 지나면 자동적으로 파기한다 예)공인인증서
		session.setMaxInactiveInterval(1000); //초단위인가?분단위인가?
		session.invalidate();//null과는 다름. setAttribute 했던것들을 다 제거해줌(안의 데이터 파기)
		
		res.sendRedirect("./login");
		
	}
	
}
