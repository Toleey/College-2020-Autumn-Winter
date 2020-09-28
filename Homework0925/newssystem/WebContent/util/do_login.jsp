<%@page import="org.bw.newssystem.service.user.impl.UserServiceImpl"%>
<%@page import="org.bw.newssystem.service.user.UserService"%>
<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8"%>

<%
	request.setCharacterEncoding("UTF-8");
	String uname=request.getParameter("uname").trim();
	String upwd=request.getParameter("upwd").trim();
	
	if(uname==null || uname.equals("")){
		/* request.setAttribute("err", "用户名不能为空");
		request.getRequestDispatcher("../index.jsp")
		.forward(request, response); */
		session.setAttribute("err", "用户名不能为空");
		response.sendRedirect("../index.jsp");
	}else if(upwd==null || upwd.equals("")){
		/* request.setAttribute("err", "密码不能为空");
		request.getRequestDispatcher("../index.jsp")
		.forward(request, response); */
		session.setAttribute("err", "密码不能为空");
		response.sendRedirect("../index.jsp");
	}else{
		UserService userService=new UserServiceImpl();
		boolean isLogin= userService.login(uname, upwd);
		if(isLogin){
			session.setAttribute("uname", uname);
			response.sendRedirect("news_control.jsp?opr=servershownews");
		}else{
			/* request.setAttribute("err", "用户名密码出错，重新输入");
			request.getRequestDispatcher("../index.jsp")
			.forward(request, response); */
			session.setAttribute("err", "用户名或密码错误");
			response.sendRedirect("../index.jsp");
		}
	}
	
%>
