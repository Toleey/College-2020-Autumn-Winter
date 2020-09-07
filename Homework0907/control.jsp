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
	
	 String userid = request.getParameter("userid");
	 String passwd = request.getParameter("passwd");
	 
	 if(userid==null || userid.equals("")){  							//用户名为空
		 request.setAttribute("error", "用户名不能为空");
		 request.getRequestDispatcher("mailLogin.jsp").forward(request, response);
	 }else if(passwd == null || passwd.equals("")){ 					//密码为空
		 request.setAttribute("error","密码不能为空");
		 request.getRequestDispatcher("mailLogin.jsp").forward(request,response);
	 }else{																//都不为空
		 
		 	if(userid.equals("lucky") && passwd.equals("123456")){		//登陆成功
				response.sendRedirect("welcome.jsp?userid="+userid);
			}else{														//登陆失败
				request.setAttribute("error", "用户名或密码错误");	
				request.getRequestDispatcher("mailLogin.jsp").forward(request,response);
			}
		 
	 }
	
	%>

</body>
</html>