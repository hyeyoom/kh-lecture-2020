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
	String userId = request.getParameter("userid");
	String password = request.getParameter("password");
	
	if("abcd".equals(userId) && "1234".equals(password)) {
		session.setAttribute("username", userId);
	}
	response.sendRedirect("index.jsp");
%>
</body>
</html>