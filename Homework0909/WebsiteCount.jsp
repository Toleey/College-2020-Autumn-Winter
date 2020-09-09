<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	网站当前访问次数：
	<%
	
		Integer visits = (Integer)application.getAttribute("visits");
		if(visits == null){
			visits = 1;
		}else{
			visits++;
		}
		
		application.setAttribute("visits", visits);
		out.print(visits);
	%>

</body>
</html>