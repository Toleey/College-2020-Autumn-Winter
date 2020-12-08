<%@page import="org.bw.newssystem.pojo.Topic"%>
<%@page import="org.bw.newssystem.pojo.News"%>
<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="newspages/console_element/cookie_check.jsp"  %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新闻中国</title>
<link href="../css/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src = "../js/jquery-3.5.1.js"></script>
<script type="text/javascript" src = "../js/index.js"></script>
</head>
	
	<c:set var = "internalNewsList" value = "${sideNewsMap['internalNewsList']}" scope="request" />
	<c:set var = "internationalNewsList" value = "${sideNewsMap['internationalNewsList']}" scope="request" />
	<c:set var = "entertainmentNewsList" value = "${sideNewsMap['entertainmentNewsList']}" scope="request" />
	
	<c:if test="${sideNewsMap == null}">
		<c:redirect url="/util/news_control?opr=list" />
	</c:if>
	
<body onload="focusOnLogin()">
<div id="header">
  <div id="top_login">
    <form action="${pageContext.request.contextPath}/util/do_login?opr=index" method="post" onsubmit="return check()">
      <label> 登录名 </label>
      <input type="text" name="uname" id="uname" value="<%=userName %>" class="login_input" />
      <label> 密&#160;&#160;码 </label>
      <input type="password" name="upwd" id="upwd" value="<%=pwd %>" class="login_input" />
      <input type="submit" class="login_sub" value="登录" />
      <label id="error">
      
      	<c:set var="err" value="${err2}"  />
      	<c:if test="${err != null}">
      		<c:out value="${err }" />
      	</c:if>
    
      
     <%--   <%
      		//获得错误信息  设置的时候是Object(对象)类型的，需要强转String
      		String err = (String)session.getAttribute("err2");
      		if(err!=null){ 								//为null(空)时不显示
      			out.print(err);
      			session.removeAttribute("err");			//输出完了，就没用了，移除掉
      		}
      	%>  --%>
      	
      </label>
      <img src="${pageContext.request.contextPath}/images/friend_logo.gif" alt="Google" id="friend_logo" />
    </form>
  </div>
  <div id="nav">
    <div id="logo"> <img src="${pageContext.request.contextPath}/images/logo.jpg" alt="新闻中国" /> </div>
    <div id="a_b01"> <img src="${pageContext.request.contextPath}/images/a_b01.gif" alt="" /> </div>
    <!--mainnav end-->
  </div>
</div>
<div id="container">
  <div class="sidebar">
    <h1> <img src="${pageContext.request.contextPath}/images/title_1.gif" alt="国内新闻" /> </h1>
    <div class="side_list">
      <ul>
			<!-- 国内新闻 -->	
     	<c:forEach items = "${internalNewsList}" var = "i"> <!-- 取不到值是空字符串，不是空值 -->   		
     		<li> <a href='${pageContext.request.contextPath}/util/news_control?opr=readNews&nid=${i.nid}'><b>${i.ntitle}</b></a> </li>  
     	</c:forEach>
      
        <!-- <li> <a href='#'><b> 景区，如何不再依靠门票收入 </b></a> </li>  -->
      </ul>
    </div>
    <h1> <img src="${pageContext.request.contextPath}/images/title_2.gif" alt="国际新闻" /> </h1>
    <div class="side_list">
      <ul>
	    	<!-- 国际新闻 -->	
	   	<c:forEach items = "${internationalNewsList}" var = "i">   		
	   		<li> <a href='${pageContext.request.contextPath}/util/news_control?opr=readNews&nid=${i.nid}'><b>${i.ntitle}</b></a> </li>  	  
	   	</c:forEach>
      
       <!--  <li> <a href='#'><b> 习近平在墨国会发表演讲:朋友要老 好酒要陈 </b></a> </li> -->
      </ul>
    </div>
    <h1> <img src="${pageContext.request.contextPath}/images/title_3.gif" alt="娱乐新闻" /> </h1>
    <div class="side_list">
      <ul>
      		<!-- 娱乐新闻 -->	
	   	<c:forEach items = "${entertainmentNewsList}" var = "i"> 
	   		<li> <a href='${pageContext.request.contextPath}/util/news_control?opr=readNews&nid=${i.nid}'><b>${i.ntitle}</b></a> </li>	  	  
	   	</c:forEach>
      
        <!-- <li> <a href='#'><b> "星跳水立方"决战临近 陈楚生被华谊要求进前三 </b></a> </li> -->
      </ul>
    </div>
  </div>
  <div class="main">
    <div class="class_type"> <img src="${pageContext.request.contextPath}/images/class_type.gif" alt="新闻中心" /> </div>
    <div class="content">
      <ul class="class_date">
       <!--  <li id='class_month'> <a href='#'><b> 国内 </b></a> <a href='#'><b> 国际 </b></a> <a href='#'><b> 军事 </b></a> <a href='#'><b> 体育 </b></a> <a href='#'><b> 娱乐 </b></a> <a href='#'><b> 社会 </b></a> <a href='#'><b> 财经 </b></a> <a href='#'><b> 科技 </b></a> <a href='#'><b> 健康 </b></a> <a href='#'><b> 汽车 </b></a> <a href='#'><b> 教育 </b></a> </li>
        <li id='class_month'> <a href='#'><b> 房产 </b></a> <a href='#'><b> 家居 </b></a> <a href='#'><b> 旅游 </b></a> <a href='#'><b> 文化 </b></a> <a href='#'><b> 其他 </b></a> </li> -->
       	<li id='class_month'> 
       	
       		<!-- 主题 -->
<%--       		<c:if test="${requestScope.topicList != null }">--%>
<%--       			<c:forEach items = "${requestScope.topicList}" var = "i">--%>
<%--       				<a id="topicNews" href='${pageContext.request.contextPath}/util/news_control?ntid=${i.tid}&opr=topicNews' ><b>${i.tname}</b></a>--%>
<%--       			</c:forEach>--%>
<%--       		</c:if>--%>
       		
        </li>
      </ul>
      <ul class="classlist">
      	<ul id="classlist">
      	</ul>
      <!-- 主题点击出现新闻 -->
<%--      	<c:if test="${requestScope.topicNewsList != null }">--%>
<%--       		<c:forEach items = "${requestScope.topicNewsList}" var = "i">--%>
<%--       				<li><a href='${pageContext.request.contextPath}/util/news_control?opr=readNews&nid=${i.nid}'>${i.ntitle}</a><span>${i.ncreateDate}</span></li>--%>
<%--       		</c:forEach>--%>
<%--       	</c:if>--%>
       	
       	<!-- 默认的分页新闻 -->
<%--      	<c:if test="${requestScope.topicNewsList == null }">--%>
<%--      		<c:if test="${requestScope.newsListPage != null }">--%>
<%--	       		<c:forEach items = "${requestScope.newsListPage}" var = "i">--%>
<%--	       				<li><a href='${pageContext.request.contextPath}/util/news_control?opr=readNews&nid=${i.nid}'> ${i.ntitle}</a><span>${i.ncreateDate}</span></li>--%>
<%--	       		</c:forEach>--%>
<%--       		</c:if>--%>
<%--       	</c:if>--%>
      
        <!-- <li><a href='newspages/news_read.jsp'> 深足教练组：说我们买球是侮辱 朱广沪常暗中支招 </a><span> 2013-06-06 01:03:51.0 </span></li> -->
        <!-- <p align="right"> 当前页数:[1/2]&nbsp; <a href="#">下一页</a> <a href="#">末页</a> </p> -->
        
         <p id="page" align="right">
         
         <!-- 显示默认新闻的上下页 -->
	        <%-- <c:choose>
	        	<c:when test="${topicNewsList == null }">     		
	        		<c:if test="${pageCount != null }">   		
	        			<c:choose>
							<c:when test="${pageIndex > 1}">
								<a href="${pageContext.request.contextPath}/util/news_control?pageIndex=1&opr=list">首页</a>
			      	   			<a href="${pageContext.request.contextPath}/util/news_control?pageIndex=${pageIndex-1}&opr=list">上一页</a>
							</c:when>
							<c:when test="${pageIndex < pageCount}" >
								<a href="${pageContext.request.contextPath}/util/news_control?pageIndex=${pageIndex+1}&opr=list">下一页</a>
		      	   	   			<a href="${pageContext.request.contextPath}/util/news_control?pageIndex=${pageCount}&opr=list">末页</a>
							</c:when>
	        			</c:choose>	
	        		</c:if>      	
	        	</c:when>
	        	<c:otherwise>
	        		<c:if test="${pageCount2 != null}">   		
	        			<c:choose>
							<c:when test="${pageIndex2 > 1}">
								<a href="${pageContext.request.contextPath}/util/news_control?pageIndex2=1&opr=topicNews&ntid=${ntid}">首页</a>
	      	   	  				<a href="${pageContext.request.contextPath}/util/news_control?pageIndex2=${pageIndex2-1}&opr=topicNews&ntid=${ntid}">上一页</a>
							</c:when>
							<c:when test="${pageIndex2 < pageCount2}" >
								<a href="${pageContext.request.contextPath}/util/news_control?pageIndex2=${pageIndex2+1}&opr=topicNews&ntid=${ntid}">下一页</a>
	      	      				 <a href="${pageContext.request.contextPath}/util/news_control?pageIndex2=${pageCount2}&opr=topicNews&ntid=${ntid}">末页</a>
							</c:when>
	        			</c:choose>	
	        		</c:if>    
	        	</c:otherwise> 
	        </c:choose> --%>
       	</p>
        
      </ul>
    </div>
    <div class="picnews">
      <ul>
        <li> <a href="#"><img src="${pageContext.request.contextPath}/images/Picture1.jpg" width="249" alt="" /> </a><a href="#">幻想中穿越时空</a> </li>
        <li> <a href="#"><img src="${pageContext.request.contextPath}/images/Picture2.jpg" width="249" alt="" /> </a><a href="#">国庆多变的发型</a> </li>
        <li> <a href="#"><img src="${pageContext.request.contextPath}/images/Picture3.jpg" width="249" alt="" /> </a><a href="#">新技术照亮都市</a> </li>
        <li> <a href="#"><img src="${pageContext.request.contextPath}/images/Picture4.jpg" width="249" alt="" /> </a><a href="#">群星闪耀红地毯</a> </li>
      </ul>
    </div>
  </div>
</div>
  <%@include file="index-elements/index_bottom.html"%>
	
</body>
</html>
