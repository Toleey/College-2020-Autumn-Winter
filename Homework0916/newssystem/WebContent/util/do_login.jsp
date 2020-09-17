<%@page import="org.bw.newssystem.pojo.News_Users"%>
<%@page import="org.bw.newssystem.dao.news_users.impl.News_UsersDaoImpl"%>
<%@page import="org.bw.newssystem.dao.news_users.News_UsersDao"%>
<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8"%>

<%
        request.setCharacterEncoding("UTF-8");
        //获得输入的用户名和密码
        String uname = request.getParameter("uname").trim();
        String upwd = request.getParameter("upwd").trim();
        
        News_UsersDaoImpl users = new News_UsersDaoImpl();  
        
      	if(users.findUserByUName(uname) != null){		//非空说明有账户查到
      		
      		if(users.findUserByUName(uname).getUpwd().trim().equals(upwd)){
      			response.sendRedirect("../newspages/admin.jsp");
      		}else{
      			 response.sendRedirect("../index.jsp"); 
      		}
      	
      	}else{
      		response.sendRedirect("../index.jsp");
      	}
            			
    %>

    

