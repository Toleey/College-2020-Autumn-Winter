<%@page import="org.bw.newssystem.pojo.News_Users"%>
<%@page import="org.bw.newssystem.dao.news_users.impl.News_UsersDaoImpl"%>
<%@page import="org.bw.newssystem.dao.news_users.News_UsersDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册表示层逻辑</title>
</head>
<body>
	<%
		//获得表单提交过来的数据
		String userName = request.getParameter("userName");
		String pwd = request.getParameter("pwd");
		String validatepwd = request.getParameter("validatepwd");
		
		//表示层逻辑： 非空验证，两次密码输入不一致
		if(userName == null || userName.equals("") ){
			request.setAttribute("err", "用户名不能为空");
			request.getRequestDispatcher("register.jsp").forward(request,response);
		}else if( pwd == null || pwd.equals("")){
			request.setAttribute("err", "密码不能为空");
			request.getRequestDispatcher("register.jsp").forward(request,response);
		}else if( validatepwd == null || validatepwd.equals("")){
			request.setAttribute("err", "验证密码不能为空");
			request.getRequestDispatcher("register.jsp").forward(request,response);
		}else if( !pwd.equals(validatepwd)){
			request.setAttribute("err", "两次密码不一致");
			request.getRequestDispatcher("register.jsp").forward(request,response);
		}else{
			// 数据库交互 
			// (1)输入用户名数据库中有没有
			//（2）把输入的合法数据录入到数据库中
			
			News_UsersDao usersDao = new News_UsersDaoImpl();
			News_Users user = usersDao.findUserByUName(userName);
			
			if (user==null) {
				News_Users user1 = new News_Users();
				user1.setUname(userName);
				user1.setUpwd(pwd);
				usersDao.insertUser(user1);
				response.sendRedirect("welcome.jsp");
			}else {
				request.setAttribute("err", "用户名已经存在");
				request.getRequestDispatcher("register.jsp").forward(request,response);
			}
			
			
		}
		
	%>

</body>
</html>