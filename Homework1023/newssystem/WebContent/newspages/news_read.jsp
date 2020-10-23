<%@page import="org.bw.newssystem.pojo.Comments"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.bw.newssystem.pojo.News"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新闻中国</title>
<link href="../css/read.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	  		function check(){
	  			var cauthor = document.getElementById("cauthor");
	  			var content = document.getElementById("ccontent");
	  			if(cauthor.value == ""){
	  				alert("用户名不能为空！！");
	  				return false;
	  			}else if(content.value == ""){
	  				alert("评论内容不能为空！！");
	  				return false;
	  			}
	  			return true;
	  		}
	  		
	  		function check2(){
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

<%
	
	
	//取边左边显示的最新新闻的前五条
	Map<String, List<News>> sideNewsMap = (Map<String, List<News>>) request.getAttribute("sideNewsMap2");
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

	//新闻页阅读内容
 	News news = (News) request.getAttribute("news");
	
 	//评论操作
 	List<Comments> commentsList = (List<Comments>) request.getAttribute("commentsList");
%>
<%//不能直接访问这个网页
	if(news == null){ %>
	
		<jsp:forward page="../util/news_control?opr=list"/>
	
<%}  %>

<body>
<div id="header">
  <div id="top_login">
   <form action="../util/do_login?opr=newsRead&nid=<%=news.getNid() %>" method="post" onsubmit="return check2()">
      <label> 登录名 </label>
      <input type="text" name="uname" id="uname" value="<%=userName %>" class="login_input" />
      <label> 密&#160;&#160;码 </label>
      <input type="password" name="upwd" id="upwd" value="<%=pwd %>" class="login_input" />
      <input type="submit" class="login_sub" value="登录" />
      <label id="error">
      	<%
      		//获得错误信息  设置的时候是Object(对象)类型的，需要强转String
      		String err = (String)request.getAttribute("err");
      		if(err!=null){ 								//为null(空)时不显示
      			out.print(err);
      			//session.removeAttribute("err");			//输出完了，就没用了，移除掉
      		}
      	%>
      	<a href="../util/news_control?opr=list" class="login_link">返回首页</a>
      </label>
      </form>
    <img src="../images/friend_logo.gif" alt="Google" id="friend_logo" /> </div>
  <div id="nav">
    <div id="logo"> <img src="../images/logo.jpg" alt="新闻中国" /> </div>
    <div id="a_b01"> <img src="../images/a_b01.gif" alt="" /> </div>
    <!--mainnav end-->
  </div>
</div>
<div id="container">
  <div class="sidebar">
    <h1> <img src="../images/title_1.gif" alt="国内新闻" /> </h1>
    <div class="side_list">
      <ul>
       <% //国内新闻
      	if(internalNewsList!=null){
      
      	for(int i = 0; i<internalNewsList.size(); i++){
    	  %>
    	  
    	  <li> <a href='../util/news_control?opr=readNews&nid=<%=internalNewsList.get(i).getNid()%>'><b><%=internalNewsList.get(i).getNtitle()%> </b></a> </li>
    	  
      <% } }%>
      
       <!--  <li> <a href='#'><b> 重庆涉黑富豪黎强夫妇庭审答辩言辞相互矛盾 </b></a> </li> -->
      </ul>
    </div>
    <h1> <img src="../images/title_2.gif" alt="国际新闻" /> </h1>
    <div class="side_list">
      <ul>
       <% //国际新闻
       	if(internationalNewsList!=null) {
    	   
       	for(int i = 0; i<internationalNewsList.size(); i++){
    	  %>
    	  
    	  <li> <a href='../util/news_control?opr=readNews&nid=<%= internationalNewsList.get(i).getNid() %>'><b><%=internationalNewsList.get(i).getNtitle() %> </b></a> </li>
    	  
      <%  }} %>
        <!-- <li> <a href='#'><b> 日本首相鸠山首次全面阐述新政府外交政策 </b></a> </li> -->
      </ul>
    </div>
    <h1> <img src="../images/title_3.gif" alt="娱乐新闻" /> </h1>
    <div class="side_list">
      <ul>
        <% //娱乐新闻
       	if(entertainmentNewsList!=null) {
    	   
       	for(int i = 0; i<entertainmentNewsList.size(); i++){
    	  %>
    	  
    	  <li> <a href='../util/news_control?opr=readNews&nid=<%= entertainmentNewsList.get(i).getNid() %>'><b><%=entertainmentNewsList.get(i).getNtitle() %> </b></a> </li>
    	  
      <%  }} %>
       <!--  <li> <a href='#'><b> 施瓦辛格启动影视业回迁计划 推进加州经济复苏 </b></a> </li> -->
      </ul>
    </div>
  </div>
  <div class="main">
    <div class="class_type"> <img src="../images/class_type.gif" alt="新闻中心" /> </div>
    <div class="content">
      <ul class="classlist">
        <table width="80%" align="center">
          <tr width="100%">
            <td colspan="2" align="center">
            	<!-- 新闻标题 -->
          		<%= news.getNtitle() %>
            </td>
            <!-- <td colspan="2" align="center">深足教练组：说我们买球是侮辱 朱广沪常暗中支招</td> -->
          </tr>
          <tr>
            <td colspan="2"><hr />
            </td>
          </tr>
          <tr>
            <td align="center">
            	<!-- 新闻发布时间 -->
          		<% 
          			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.getDefault());
          			String time = simpleDateFormat.format(news.getNcreateDate());
          		%>
          		<%= time %>
            </td>
            <!-- <td align="center">2009-10-28 01:03:51.0</td> -->
            <td align="left">
            <%= news.getNauthor() %>
            </td>
            <!-- <td align="left">sport </td> -->
          </tr>
          <tr>
            <td colspan="2" align="center"></td>
          </tr>
          <tr>
          	<td colspan="2">
          		<!-- 新闻内容 -->
          		<%= news.getNcontent() %>

          	</td>
          <tr>
            <td colspan="2"><hr />
            </td>
          </tr>
        </table>
      </ul>
      <ul class="classlist">
        <table width="80%" align="center">
        
         <td colspan="6">
           	  <%
              	if(commentsList.size()!=0){
              		for(int i = 0 ; i<commentsList.size();i++){
              %>
              	<%=commentsList.get(i).getCcontent() %>
              	<%=commentsList.get(i).getCdate() %>
              	<%=commentsList.get(i).getCauthor() %><br />
              <%
              	}}else if(commentsList.size()==0) {
              %>
            
              暂无评论！ 
              
              <%} %>
              </td>
          
          <!-- <td colspan="6"> 暂无评论！ </td> -->
          
          <tr>
            <td colspan="6"><hr /></td>
          </tr>
          
        </table>
      </ul>
      <ul class="classlist">
         <form action="../util/comments_control?opr=addComments&nid=<%=news.getNid() %>" method="post" onsubmit="return check()">
          <table width="80%" align="center">
            <tr>
              <td> 评 论 </td>
            </tr>
            <tr>
              <td> 用户名： </td>
              <td><input id="cauthor" name="cauthor" value="这家伙很懒什么也没留下"/>
                IP：
                <input name="cip" value="<%=request.getLocalAddr() %>" readonly="readonly"/>
               <!--  <input name="cip" value="127.0.0.1" readonly="readonly"/> -->
              </td>
            </tr>
            <tr>
              <td colspan="2"><textarea name="ccontent" cols="70" rows="10"></textarea>
              </td>
            </tr>
            <td><input name="submit" value="发  表" type="submit"/>
              </td>
          </table>
         </form>
      </ul>
    </div>
  </div>
</div>
<%@include file="../index-elements/index_bottom.html"%>
<%	
	//session.removeAttribute("sideNewsMap");
	//session.removeAttribute("news");
	//session.removeAttribute("commentsList");
%>
</body>
</html>
