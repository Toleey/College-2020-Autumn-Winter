<%@page import="org.bw.newssystem.pojo.Topic"%>
<%@page language="java"  pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
      
     <c:if test="!${requestScope.topicList}"> <!-- 等于空 -->
	      	<jsp:forward page="../util/topic_control?opr=edittitle"/>
	 </c:if>
      
     <c:forEach items="${requestScope.topicList}" var="topic">
     	<li>${topic.tname}
				&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;
				<a href='../util/topic_control?opr=showupd&tid=${topic.tid }'>修改</a>
				&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;
				<a href='../util/topic_control?opr=deltopic&tid=${topic.tid }'>删除</a>
		</li>
     </c:forEach>
     
    </ul>
  </div>
</div>
<div id="footer">
  <%@include file="console_element/bottom.html" %>
</div>
</body>
</html>
