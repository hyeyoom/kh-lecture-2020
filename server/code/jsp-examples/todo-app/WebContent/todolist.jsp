<%@page import="com.github.hyeyoom.repository.TodoRepository"%>
<%@page import="com.github.hyeyoom.domain.Todo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>할 일 목록 보기</title>
</head>
<body>
<ul>
<%
List<Todo> list = TodoRepository.getInstance().getTodoList();
for (Todo todo : list) {
%>
	<li>이름:<%= todo.getMyName() %>|할일:<%= todo.getWhatToDo() %><li>
<%
}
%>
</ul>
투두목록개수
<%= list.size() %>
</body>
</html>