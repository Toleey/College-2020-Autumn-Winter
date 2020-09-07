<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登陆成功</title>
</head>
<body>
	
	<% request.setCharacterEncoding("utf-8");%>
	<h1> 你好：
	<%= request.getParameter("userid") %>
		！
	</h1>


</body>
</html>