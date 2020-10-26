
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    th{
        color: red;
    }
 
</style>
<head>
    <title>练习</title>
</head>
<body>
<table border="1px" style="border-collapse: collapse ">
    <tr>
        <th>request.getServletContext():</th>
        <td><%=request.getServletContext()%></td>
    </tr>
    <tr>
        <th>request.getServletContext().getRealPath("/"):</th>
        <td><%=request.getServletContext().getRealPath("/")%></td>
    </tr>
    <tr>
        <th>request.getServletContext().getRealPath("helloworld"):</th>
        <td><%=request.getServletContext().getRealPath("helloworld")%></td>
    </tr>
    <tr>
        <th>request.getContextPath()</th>
        <td><%=request.getContextPath()%></td>
    </tr>
    <tr>
        <th>request.getServletPath()</th>
        <td><%=request.getServletPath()%></td>
    </tr>
    <tr>
        <th>request.getRequestURL()</th>
        <td><%=request.getRequestURL()%></td>
    </tr>
    <tr>
        <th>request.getRequestURI()</th>
        <td><%=request.getRequestURI()%></td>
    </tr>
</table>
 
 
</body>
</html>