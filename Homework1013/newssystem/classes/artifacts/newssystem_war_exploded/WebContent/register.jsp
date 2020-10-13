<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<title>用户注册</title>
</head>
<body>
	<div style="color:red">
	<%=request.getAttribute("err") %>
	</div>
	<form name="form1" method="post" action="control.jsp">
		<table>
			<tr>
				<td>用户名:</td>
				<td><input type="text" name="userName">
				</td>
			</tr>
			<tr>
				<td>输入登录密码:</td>
				<td><input type="password" name="pwd"></td>
			</tr>
			<tr>
				<td>再次输入密码:</td>
				<td><input type="password" name="validatepwd"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="注册"></td>
			</tr>
		</table>
	</form>
<body>
</html>
