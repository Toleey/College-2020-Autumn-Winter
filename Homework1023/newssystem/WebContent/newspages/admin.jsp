<%@page import="org.bw.newssystem.pojo.News"%>
<%@ page language="java"  pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<title>添加主题--管理后台</title>
<link href="../css/admin.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@include file="console_element/top.jsp" %>
<div id="main">
  <%@include file="console_element/left.html" %>
  <div id="opt_area">    
    <script language="javascript">
	function clickdel(){
		return confirm("删除请点击确认");
	}
	
</script>
    <ul class="classlist">
    
    	    <% 
    		List<News> newsList = (List<News>)request.getAttribute("newsList"); //获得的是一个object。需要强转一下
    		%>
    		
    		<%//不能直接访问这个网页
				if(newsList==null){ %>
	
					<jsp:forward page="../util/news_control?opr=list"/>
	
			<%}  %>
			
    		<%
    		for (int i=0 ; i<newsList.size();i++ ) {
    			News news = newsList.get(i);
    		%>
      
	      <li><%= news.getNtitle() %><span> 作者： &#160;&#160;&#160;&#160;
	      <%= news.getNauthor() %> <a href='../util/news_control?opr=updateNews&nid=
	      <%=news.getNid() %>'>修改</a> &#160;&#160;&#160;&#160; 
	      <a href='../util/news_control?opr=deleteNews&nid=<%=news.getNid() %>' 
	      onclick='return clickdel()'>删除</a> </span> </li>
	     
	      <li class='space'></li>
	      <% } %>
	    
    </ul>
  </div>
</div>
<div id="footer">
  <%@include file="console_element/bottom.html" %>
</div>
</body>
</html>
