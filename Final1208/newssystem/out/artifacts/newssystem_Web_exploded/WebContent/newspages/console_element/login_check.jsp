<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userinsession = (String)session.getAttribute("uname");
	request.setCharacterEncoding("UTF-8");
	if(userinsession == null){
%>
<script>
	alert("您没有登录或者已经退出，请重新登录!");
	open("../index.jsp","_self");	
</script>
<%
	}
%>
