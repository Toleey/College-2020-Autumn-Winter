<%@page import="org.bw.newssystem.service.user.impl.UserServiceImpl"%>
<%@page import="org.bw.newssystem.service.user.UserService"%>
<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8"%>

<%
	request.setCharacterEncoding("UTF-8");
	String opr = request.getParameter("opr");
	
	switch(opr){
	case "index":
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
				response.sendRedirect("news_control.jsp?opr=backstageNewsList");
			}else{
				/* request.setAttribute("err", "用户名密码出错，重新输入");
				request.getRequestDispatcher("../index.jsp")
				.forward(request, response); */
				session.setAttribute("err2", "用户名或密码错误");
				response.sendRedirect("../index.jsp");
				/* String err = (String)session.getAttribute("err");
				out.print(err); */
			}
		}
		
		break;
	case "newsRead":
		
		String uname2=request.getParameter("uname").trim();
		String upwd2=request.getParameter("upwd").trim();
		
		String nid = request.getParameter("nid");
		int nid2 = Integer.parseInt(nid);
		
		if(uname2==null || uname2.equals("")){
			/* request.setAttribute("err", "用户名不能为空");
			request.getRequestDispatcher("../index.jsp")
			.forward(request, response); */
			session.setAttribute("err", "用户名不能为空");
			response.sendRedirect("news_control.jsp?opr=readNews&nid="+nid2);
		}else if(upwd2==null || upwd2.equals("")){
			/* request.setAttribute("err", "密码不能为空");
			request.getRequestDispatcher("../index.jsp")
			.forward(request, response); */
			session.setAttribute("err", "密码不能为空");
			response.sendRedirect("news_control.jsp?opr=readNews&nid="+nid2);
		}else{
			UserService userService=new UserServiceImpl();
			boolean isLogin= userService.login(uname2, upwd2);
			if(isLogin){
				session.setAttribute("uname", uname2);
				response.sendRedirect("news_control.jsp?opr=backstageNewsList");
			}else{
				/* request.setAttribute("err", "用户名密码出错，重新输入");
				request.getRequestDispatcher("../index.jsp")
				.forward(request, response); */
				session.setAttribute("err", "用户名或密码错误");
				response.sendRedirect("news_control.jsp?opr=readNews&nid="+nid2);
			}
		}
		
		break;
	case "loginout":
			response.sendRedirect("../index.jsp");
		break;
	}
	
	
	
%>
