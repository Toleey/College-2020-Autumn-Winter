<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>显示时间日期</title>
</head>
<body>

	<%
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentDateTime = sdf.format(date);
	%>
	
	<%="现在的时间是："+currentDateTime %>


</body>
</html>