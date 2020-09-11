<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登陆逻辑并创建Cookie</title>
</head>
<body>
	
	<%
		request.setCharacterEncoding("UTF-8");	
	
		//获得用户名和密码
		String userName = request.getParameter("userName");
		String pwd = request.getParameter("pwd");
		//简单登陆逻辑
		if("admin".equals(userName) && "admin".equals(pwd) ){
			//说明登陆成功了，把用户名密码放到cookie里发到客户端
			Cookie nameCookie = new Cookie("uName",userName);
			Cookie pwdCookie = new Cookie("pwd",pwd);
			//发之前设置一下有效期
			nameCookie.setMaxAge(60*5);
			pwdCookie.setMaxAge(60*5);
			response.addCookie(nameCookie);
			response.addCookie(pwdCookie);
			session.setAttribute("login", "userName");
			response.sendRedirect("welcome.jsp");
							
		}else{
			response.sendRedirect("login.jsp");
		}
		
		
	%>


</body>
</html>