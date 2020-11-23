<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지 같은거</title>
</head>
<body>
<%
String username = (String) session.getAttribute("username");
%>
<a href="logout.jsp">로그아웃</a>
<% if (username == null) { %>
<form action="login.jsp" method="POST">
	<label for="userid">아이디</label>
	<input id="userid" name="userid" type="text"/>
	<label for="password">비밀번호</label>
	<input id="password" name="password" type="password"/>
	<input type="submit" value="로그인!"/>
</form>
<% } else { %>
<h1><%= username %>님, 환영함.</h1>
<% } %>
</body>
</html>