<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录处理页面</title>
</head>
<body>
	
	<%@ include file="doLoginControl.jsp" %>
	
    <%-- <%
        request.setCharacterEncoding("UTF-8");
        //获得输入的用户名和密码
        String userName = request.getParameter("username");
        String pwd = request.getParameter("upwd");
        //加入用户名密码输入正确，登陆成功
        if("admin".equals(userName) && "admin".equals(pwd)){
        	//session里加一个登陆标记
        	session.setAttribute("login", userName);
        	//session的有效时间,以分钟为单位计时，10s不行，最少1min，1.5min也不行，默认30min
        	session.setMaxInactiveInterval(10*60);
        	//重定向到 newspages/admin.jsp
        	response.sendRedirect("newspages/admin.jsp");
        }else{
        	response.sendRedirect("index.jsp");
        }
    %> --%>
    </body>
</html>
