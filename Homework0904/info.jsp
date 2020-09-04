<%@ page language="java" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>注册信息</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");
    String txtUser = request.getParameter("txtUser");
    String txtPass = request.getParameter("txtPass");
    String gen = request.getParameter("gen");
    String txtEmail = request.getParameter("txtEmail");
    String year = request.getParameter("year");
    String month = request.getParameter("month");
    String day = request.getParameter("day");


%>

<div align="center">你输入的注册信息
    <table border="0" align="center">
        <tr>
            <td width="80" height="20">用户名:</td>
            <td><%=txtUser %></td>
        </tr>
        <tr>
            <td height="20">密码:</td>
            <td><%=txtPass %></td>
        </tr>
        <tr>
            <td height="20">性别:</td>
            <td><%=gen %></td>
        </tr>
        <tr>
            <td height="20">电子邮件地址:</td>
            <td><%=txtEmail %></td>
        </tr>
        <tr>
            <td height="20">出生日期:</td>
            <td><%=year %>年<%=month %>月<%=day %>日</td>
        </tr>

    </table>
</div>
</body>
</html>
