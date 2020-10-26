<%@page import="org.bw.newssystem.pojo.Topic"%>
<%@page import="org.bw.newssystem.pojo.News"%>
<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新闻中国</title>
<link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet" type="text/css" />
<script language="javascript">
	function check(){
		var login_username = document.getElementById("uname");
		var login_password = document.getElementById("upwd");
		if(login_username.value == ""){
			alert("用户名不能为空！请重新填入！");
			login_username.focus();	
			return false;
		}else if(login_password.value == ""){
			alert("密码不能为空！请重新填入！");
			login_password.focus();
			return false;
		}
		return true;
	}
	
	function focusOnLogin(){
		var login_username = document.getElementById("uname");
		login_username.focus();	
	}
</script>
</head>
	<%
		
		//访问Cookie
		Cookie cookies [] = request.getCookies();
		//保存cookie里用户名和密码的变量
		String userName = "";
		String pwd = "";

		if(cookies!=null){
			for(int i = 0;i<cookies.length ; i++){
				//根据cookie的键对应它的值
				if("uname".equals(cookies[i].getName())){
					userName = cookies[i].getValue();
					
				}
				if("upwd".equals(cookies[i].getName())){
					pwd = cookies[i].getValue();
					
				}
			}
		}
	
	%>
<%	
	
	//从控制层获得列表，在该页面显示
	//取边左边显示的最新新闻的前五条
	Map<String, List<News>> sideNewsMap = (Map<String, List<News>>) request.getAttribute("sideNewsMap");//获得两组新闻
	List<Topic> topicList = (List<Topic>) request.getAttribute("topicList"); //获得首页主题
	
	//1.获得国内新闻列表
	List<News> internalNewsList = null;
	if(sideNewsMap != null){
		internalNewsList = (List<News>) sideNewsMap.get("internalNewsList");

	}
	
	//2.获得国际新闻列表
	List<News> internationalNewsList = null;
	if(sideNewsMap != null){
		internationalNewsList = (List<News>) sideNewsMap.get("internationalNewsList");

	}

	//3.获得娱乐新闻列表
		List<News> entertainmentNewsList = null;
		if(sideNewsMap != null){
			entertainmentNewsList = (List<News>) sideNewsMap.get("entertainmentNewsList");
		}
			
	//4.获得主题下的新闻
		List<News> topicNewsList = (List<News>) request.getAttribute("topicNewsList");
	
	//6.获得分页后的所有新闻
		List<News> allPageNewsList = (List<News>) request.getAttribute("newsListPage"); 
	
	//7.获得当前页码
		Integer pageIndexInt = (Integer) request.getAttribute("pageIndex");
		int pageIndex = 1;
		if(pageIndexInt != null){
			pageIndex = pageIndexInt;
		}
	//8.获得总页数
		Integer pageCount = (Integer) request.getAttribute("pageCount");
	
	//7-2.获得当前页码
		Integer pageIndexInt2 = (Integer) request.getAttribute("pageIndex2");
		int pageIndex2 = 1;
		if(pageIndexInt2 != null){
			pageIndex2 = pageIndexInt2;
		}
	//8-2.获得总页数
		Integer pageCount2 = (Integer) request.getAttribute("pageCount2");
	
	
	//9.获得当前页面主题编号
		Integer ntidInt = (Integer)request.getAttribute("ntid");
		int ntid = 1;
		if(ntidInt != null){
			ntid = ntidInt;
		}
		
	//	internalNewsList == null || internationalNewsList == null || entertainmentNewsList == null || topicList == null
	if(internalNewsList == null || internationalNewsList == null || entertainmentNewsList == null || topicList == null || allPageNewsList == null ){
		response.sendRedirect("util/news_control?opr=list");

	}
	
%>
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
      
      	<%
      		//获得错误信息  设置的时候是Object(对象)类型的，需要强转String
      		String err = (String)session.getAttribute("err2");
      		if(err!=null){ 								//为null(空)时不显示
      			out.print("错误"+err);
      			session.removeAttribute("err");			//输出完了，就没用了，移除掉
      		}
      	%>
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
      <% //国内新闻
      	if(internalNewsList!=null){
      
      	for(int i = 0; i<internalNewsList.size(); i++){
    	  %>
    	  
    	  <li> <a href='${pageContext.request.contextPath}/util/news_control?opr=readNews&nid=<%=internalNewsList.get(i).getNid()%>'><b><%=internalNewsList.get(i).getNtitle()%> </b></a> </li>
    	  
      <%  } }%>
    
        <!-- <li> <a href='#'><b> 景区，如何不再依靠门票收入 </b></a> </li>  -->
      </ul>
    </div>
    <h1> <img src="${pageContext.request.contextPath}/images/title_2.gif" alt="国际新闻" /> </h1>
    <div class="side_list">
      <ul>
       <% //国际新闻
       	if(internationalNewsList!=null) {
    	   
       	for(int i = 0; i<internationalNewsList.size(); i++){
    	  %>
    	  
    	  <li> <a href='${pageContext.request.contextPath}/util/news_control?opr=readNews&nid=<%= internationalNewsList.get(i).getNid() %>'><b><%=internationalNewsList.get(i).getNtitle() %> </b></a> </li>
    	  
      <%  }} %>
       <!--  <li> <a href='#'><b> 习近平在墨国会发表演讲:朋友要老 好酒要陈 </b></a> </li> -->
      </ul>
    </div>
    <h1> <img src="${pageContext.request.contextPath}/images/title_3.gif" alt="娱乐新闻" /> </h1>
    <div class="side_list">
      <ul>
       <% //娱乐新闻
       	if(entertainmentNewsList!=null) {
    	   
       	for(int i = 0; i<entertainmentNewsList.size(); i++){
    	  %>
    	  
    	  <li> <a href='${pageContext.request.contextPath}/util/news_control?opr=readNews&nid=<%= entertainmentNewsList.get(i).getNid() %>'><b><%=entertainmentNewsList.get(i).getNtitle() %> </b></a> </li>
    	  
      <%  }} %>
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
        	<%	//主题
        		if(topicList != null){
        		for(int i = 0; i < topicList.size() ; i++){	
        	%>
        	
        	<a href='${pageContext.request.contextPath}/util/news_control?ntid=<%=topicList.get(i).getTid()%>&opr=topicNews'><b> <%=topicList.get(i).getTname() %> </b></a>
        
       		<% } }%>
        </li>
      </ul>
      <ul class="classlist">
      	<%	//主题点击出现新闻
      		if(topicNewsList != null){
      			for(int i = 0;i<topicNewsList.size() ; i++){
      				News news = topicNewsList.get(i);
      	%>
      
       	<li><a href='${pageContext.request.contextPath}/util/news_control?opr=readNews&nid=<%= news.getNid() %>'> <%=news.getNtitle() %> </a><span> <%=news.getNcreateDate() %> </span></li>

       	
       	<%
      		}}
       	%>
       	
       	<%	//默认的分页新闻
       	 if(topicNewsList == null){
      		if(allPageNewsList != null){
      			for(int i = 0;i<allPageNewsList.size() ; i++){
      				News allNewsPageList = allPageNewsList.get(i);
      	%>
      
       	<li><a href='${pageContext.request.contextPath}/util/news_control?opr=readNews&nid=<%= allNewsPageList.getNid() %> '> <%=allNewsPageList.getNtitle() %> </a><span> <%=allNewsPageList.getNcreateDate() %> </span></li>
   
       	
       	<%
      		}}}
       	%>
      
        <!-- <li><a href='newspages/news_read.jsp'> 深足教练组：说我们买球是侮辱 朱广沪常暗中支招 </a><span> 2013-06-06 01:03:51.0 </span></li>
        <!-- <p align="right"> 当前页数:[1/2]&nbsp; <a href="#">下一页</a> <a href="#">末页</a> </p> -->
        
         <p align="right">
        <%
        //显示默认新闻的上下页
       	 if(topicNewsList == null){	
       		 if(pageCount != null ){ 
       		if (pageIndex > 1) { // 控制页面显示风格
      	%>
      	  
				<a href="${pageContext.request.contextPath}/util/news_control?pageIndex=1&opr=list">首页</a>
	      	    <a href="${pageContext.request.contextPath}/util/news_control?pageIndex=<%=pageIndex - 1%>&opr=list">上一页</a>
			<%
			} if (pageIndex < pageCount) { // 控制页面显示风格
			%>
			   <a href="${pageContext.request.contextPath}/util/news_control?pageIndex=<%=pageIndex + 1%>&opr=list">下一页</a>
      	   	   <a href="${pageContext.request.contextPath}/util/news_control?pageIndex=<%=pageCount %>&opr=list">末页</a>
		      	     
       	
       	<%
			} }
			}else{
				if(pageCount2 != null ){ 
       	%>	
        
			<%
			if (pageIndex2 > 1) { // 控制页面显示风格
			%>   
			  <a href="${pageContext.request.contextPath}/util/news_control?pageIndex2=1&opr=topicNews&ntid=<%=ntid%>">首页</a>
      	   	  <a href="${pageContext.request.contextPath}/util/news_control?pageIndex2=<%=pageIndex2 - 1%>&opr=topicNews&ntid=<%=ntid%>">上一页</a>
			<%
			} if (pageIndex2 < pageCount2) { // 控制页面显示风格
			%>
			   <a href="${pageContext.request.contextPath}/util/news_control?pageIndex2=<%=pageIndex2 + 1%>&opr=topicNews&ntid=<%=ntid%>">下一页</a>
      	       <a href="${pageContext.request.contextPath}/util/news_control?pageIndex2=<%=pageCount2 %>&opr=topicNews&ntid=<%=ntid%>">末页</a>
			<%   
			} }
			%>   
          
          <%
          }
          
       	  %>
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
