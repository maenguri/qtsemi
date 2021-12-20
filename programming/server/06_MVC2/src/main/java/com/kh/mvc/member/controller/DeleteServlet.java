package com.kh.mvc.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.mvc.member.model.service.MemberService;
import com.kh.mvc.member.model.vo.Member;


@WebServlet("/member/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberService service = new MemberService();
	
    public DeleteServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int result = 0;
		HttpSession session = request.getSession(false); //기존 세션 없애기
		Member loginMember = session != null ? (Member)session.getAttribute("loginMember") : null;
		
		if(loginMember != null) {
			result = service.delete(loginMember.getNo());
			if(result > 0) {
				request.setAttribute("msg", "정상적으로 탈퇴되었습니다.");
				request.setAttribute("location", "/logout");
			}else {
				request.setAttribute("msg", "탈퇴에 실패하였습니다.");
				request.setAttribute("location", "/member/view");
			}
		}else {
			request.setAttribute("msg", "로그인 후 탈퇴가 가능합니다.");
			request.setAttribute("location", "/");
		}
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
	}


}
