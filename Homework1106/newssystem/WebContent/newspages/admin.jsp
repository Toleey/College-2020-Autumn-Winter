<%@page import="org.bw.newssystem.pojo.News"%>
<%@page language="java"  pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <%@include file="console_element/login_check.jsp"  %> --%>

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
    	  <!-- 不能直接访问这个网页-->
	      <c:if test="${requestScope.newsList == null}"> <!-- 等于空null -->
	      	<jsp:forward page="../util/news_control?opr=list"/>
	      </c:if> 
	      
	      <c:forEach items="${requestScope.newsList}" var="news">
	      <li>${news.ntitle}<span> 作者： &#160;&#160;&#160;&#160;${news.nauthor}<a href='../util/news_control?opr=updateNews&nid=${news.nid}'>修改</a> &#160;&#160;&#160;&#160; <a href='../util/news_control?opr=deleteNews&nid=${news.nid}' onclick='return clickdel()'>删除</a> </span> </li>
	     </c:forEach>
    </ul>
  </div>
</div>
<div id="footer">
  <%@include file="console_element/bottom.html" %>
</div>
</body>
</html>
