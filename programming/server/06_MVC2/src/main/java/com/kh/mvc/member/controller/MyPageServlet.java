package com.kh.mvc.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.mvc.member.model.vo.Member;


@WebServlet("/member/view")
public class MyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MyPageServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false); //기존 세션 없애기
		Member loginMember = session != null ? (Member)session.getAttribute("loginMember") : null;
		
		if(loginMember != null) {
			request.getRequestDispatcher("/views/member/myPage.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "잘못된 접근입니다.");
			request.setAttribute("location", "/");
			
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
		}
		
	}

}
