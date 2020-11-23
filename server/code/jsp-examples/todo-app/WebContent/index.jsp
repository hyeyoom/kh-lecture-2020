<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>할 일을 적어주세요!</title>
</head>
<body>
<form action="todocontroller.jsp" method="POST">
	<label for="whattodo">할 일:</label>
	<input id="whattodo" name="whattodo" type="text"/>
	<label for="myname">이름:</label>
	<input id="myname" name="myname" type="text"/>
	<input type="submit" value="할 일 등록"/>
</form>
<a href="todolist.jsp">할 일 목록 보기</a>
</body>
</html>