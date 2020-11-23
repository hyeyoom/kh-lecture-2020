<%@page import="com.github.hyeyoom.domain.Todo"%>
<%@page import="com.github.hyeyoom.repository.TodoRepository"%>
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
request.setCharacterEncoding("utf-8");
String whatTodo = request.getParameter("whattodo"); // do something
String myName = request.getParameter("myname"); // Chiho Won

final Todo todo = new Todo(whatTodo, myName);
TodoRepository.getInstance().saveTodo(todo);
response.sendRedirect("index.jsp");
%>
</body>
</html>