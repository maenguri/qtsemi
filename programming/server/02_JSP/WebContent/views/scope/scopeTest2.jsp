<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
		request.setAttribute("requestScope", "requestValue");
		pageContext.setAttribute("pageScope", "pageValue");
		
		//response.sendRedirect("scopeTest3.jsp");
		pageContext.forward("scopeTest3.jsp");
	%>
</body>
</html>