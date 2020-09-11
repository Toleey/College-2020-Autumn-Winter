<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <title>登录</title>

  </head>
  
  <body>
  	<%
  		//访问Cookie
  		Cookie cookies [] = request.getCookies();
  		//保存cookie里用户名和密码的变量
  		String userName = "";
  		String pwd = "";
  		
  		if(cookies!=null){
  			for(int i = 0;i<cookies.length ; i++){
  				//根据cookie的键对应它的值
  				if("uName".equals(cookies[i].getName())){
  					userName = cookies[i].getValue();
  				}
  				if("pwd".equals(cookies[i].getName())){
  					pwd = cookies[i].getValue();
  
  				}
  			}
  		}
  	%>
  		
    <form name="loginForm" method="post" action="doLogin.jsp">
			用户名：<input type="text" name="userName" value="<%=userName %>" />
			密码：<input type="password" name="pwd" value="<%=pwd %>"/>
			<input type="submit" value="登录">
		</form>

  </body>
</html>
