<%@page import="org.bw.newssystem.pojo.Topic"%>
<%@ page language="java"  pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加主题--管理后台</title>
<link href="../css/admin.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@include file="console_element/top.jsp" %>
<div id="main">
  <%@include file="console_element/left.html" %>
  <div id="opt_area">
    <ul class="classlist">
    <%
    	List<Topic> topicList = (List<Topic>) request.getAttribute("topicList");
    %>
    <%//不能直接访问这个网页
	if(topicList == null){ %>
	
		<jsp:forward page="../util/topic_control.jsp?opr=edittitle"/>
	
	<%}  %>
    
    <% 	for(int i = 0; i < topicList.size();i++){
    		Topic topic = topicList.get(i);
    	
    %>
    
    
      
     <li><%=topic.getTname() %>
				&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;
				<a href='../util/topic_control.jsp?opr=showupd&tid=<%=topic.getTid()%>'>修改</a>
				&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;
				<a href='../util/topic_control.jsp?opr=deltopic&tid=<%=topic.getTid()%>'>删除</a>
				</li>
     <%} %>
    </ul>
  </div>
</div>
<div id="footer">
  <%@include file="console_element/bottom.html" %>
</div>
</body>
</html>
