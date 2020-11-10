<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
		//访问Cookie
		Cookie cookies [] = request.getCookies();
		//保存cookie里用户名和密码的变量
		String userName = "";
		String pwd = "";
		
		if(cookies!=null){
			for(int i = 0;i<cookies.length ; i++){
				//out.println(cookies[i].getValue()+"换行");
				//根据cookie的键对应它的值
				if("uname".equals(cookies[i].getName())){
					userName = cookies[i].getValue();
					//out.println("用户名"+userName);
				}
				if("upwd".equals(cookies[i].getName())){
					pwd = cookies[i].getValue();
					//out.println("密码"+pwd);
				}
			}
		}
	
	%>
