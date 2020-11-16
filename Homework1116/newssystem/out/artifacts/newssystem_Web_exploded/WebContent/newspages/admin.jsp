<%@page import="org.bw.newssystem.pojo.News"%>
<%@page language="java"  pageEncoding="utf-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<title>添加主题--管理后台</title>
<link href="${pageContext.request.contextPath}/css/admin.css" rel="stylesheet" type="text/css" /> <!-- 换成根目录 -->
<script type="text/javascript" src="../js/jquery-3.5.1.js"></script>
<script type="text/javascript" src="../js/admin.js"></script>
</head>
<body>
<%@include file="console_element/top.jsp" %>
<div id="main">
  <%@include file="console_element/left.html" %>
  <div id="opt_area">
    <ul class="classlist" >
	      <%-- <li>${news.ntitle}<span> 作者： &#160;&#160;&#160;&#160;${news.nauthor}<a href='../util/news_control?opr=updateNews&nid=${news.nid}'>修改</a> &#160;&#160;&#160;&#160; <a href='../util/news_control?opr=deleteNews&nid=${news.nid}' onclick='return clickdel()'>删除</a> </span> </li> --%>
    </ul>
  </div>
</div>
<div id="footer">
  <%@include file="console_element/bottom.html" %>
</div>
</body>
</html>
