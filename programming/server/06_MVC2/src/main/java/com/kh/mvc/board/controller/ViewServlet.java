package com.kh.mvc.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mvc.board.model.service.BoardService;
import com.kh.mvc.board.model.vo.Board;

@WebServlet("/board/view")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BoardService service = new BoardService();
       
    public ViewServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		
		System.out.println("No : " + no);
		
		Board board = service.findBoardByNo(no);
		
		System.out.println(board);
		
		request.setAttribute("board", board);
		
		request.getRequestDispatcher("/views/board/view.jsp").forward(request, response);
	}

}
