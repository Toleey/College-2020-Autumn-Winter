<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		
		//访问Cookie
		Cookie cookies [] = request.getCookies();
		//保存cookie里用户名和密码的变量
		String userName = "";
		String pwd = "";
		
		//out.print(cookies.length);
		//out.print(cookies[0].getValue());
		//out.print(cookies[1].getValue());
		//out.print(cookies[2].getValue());
		
		if(cookies!=null){
			for(int i = 0;i<cookies.length ; i++){
				//out.println(cookies[i].getValue()+"换行");
				//根据cookie的键对应它的值
				if("uname".equals(cookies[i].getName())){
					userName = cookies[i].getValue();
					out.println("用户名"+userName);
				}
				if("upwd".equals(cookies[i].getName())){
					pwd = cookies[i].getValue();
					out.println("密码"+pwd);
				}
			}
		}
	
	%>

</body>
</html>