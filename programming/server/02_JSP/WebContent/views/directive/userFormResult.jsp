<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%
  //post니까 인코딩 설정
  	request.setCharacterEncoding("utf-8");
  	String name = request.getParameter("userName");
  	String age = request.getParameter("age");
	String gender = request.getParameter("gender");
	String height = request.getParameter("height");
	String[] foods = request.getParameterValues("food");
	
  	System.out.println(name);
  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h2>개인 정보 출력 확인</h2>
		
		<%=name %>님은 <%= age%>세 이고 키가 <%=height %>cm인 <%=gender %>입니다.
		좋아하는 음식은
		<%
			for(int i=0; i<foods.length; i++){
		%>
			<span style="color:red"><%=foods[i] + " "%></span>
		<%
			}
		%>
</body>
</html>