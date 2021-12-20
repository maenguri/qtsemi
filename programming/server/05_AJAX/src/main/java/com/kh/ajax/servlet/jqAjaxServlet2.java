package com.kh.ajax.servlet;

import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.kh.ajax.model.vo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/jqAjax2.do")
public class jqAjaxServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public jqAjaxServlet2() {
    }
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int userNo = Integer.parseInt(request.getParameter("userNo"));
    	
    	
    	//사용자 정보가 저장되어 있는 List 생성
    	java.util.List<User> list = new ArrayList<>();
    	
    	list.add(new User(1, "김철수", 30, '남'));
    	list.add(new User(2, "김영희", 30, '여'));
    	list.add(new User(3, "영심이", 16, '여'));
    	list.add(new User(4, "왕경태", 16, '남'));
    	list.add(new User(5, "맹세정", 20, '여'));
    	
    	User findUser = list.stream()
    						.filter(user -> user.getNo() == userNo)
    						.findFirst()
    						.orElse(null); 
  
    	response.setContentType("application/json; charset=UTF-8");
    	
    	// 라이브러리를 쓰기 전에 JSON 만들어서 테스트
//    	String result = "{\"no\":1, \"name\": \"홍길동\", \"age\": 30 \"gender\":\"남\"}";
    	
//    	response.getWriter().print(result);
    	response.getWriter().print(new Gson().toJson(findUser));
    	
    	
    }

}
