<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8"%>
<%
        request.setCharacterEncoding("UTF-8");
        //获得输入的用户名和密码
        String uname = request.getParameter("uname");
        String upwd = request.getParameter("upwd");
        //加入用户名密码输入正确，登陆成功
        if("admin".equals(uname) && "admin".equals(upwd)){
        	//session里加一个登陆标记
        	session.setAttribute("login", uname);
        	//session的有效时间,以分钟为单位计时，10s不行，最少1min，1.5min也不行，默认30min
        	session.setMaxInactiveInterval(10*60);
        	//重定向到 newspages/admin.jsp
        	response.sendRedirect("../newspages/admin.jsp");
        }else{
        	response.sendRedirect("../index.jsp");
        }
    %>
    

