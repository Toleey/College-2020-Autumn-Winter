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
	Map<String, List<News>> sideNewsMap = (Map<String, List<News>>) session.getAttribute("sideNewsMap2");
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
 	News news = (News) session.getAttribute("news");
	
 	//评论操作
 	List<Comments> commentsList = (List<Comments>) session.getAttribute("commentsList");
%>
<%//不能直接访问这个网页
	if(news == null){ %>
	
		<jsp:forward page="../util/news_control.jsp?opr=list"/>
	
<%}  %>

<body>
<div id="header">
  <div id="top_login">
   <form action="../util/do_login.jsp?opr=newsRead&nid=<%=news.getNid() %>" method="post" onsubmit="return check2()">
      <label> 登录名 </label>
      <input type="text" name="uname" id="uname" value="<%=userName %>" class="login_input" />
      <label> 密&#160;&#160;码 </label>
      <input type="password" name="upwd" id="upwd" value="<%=pwd %>" class="login_input" />
      <input type="submit" class="login_sub" value="登录" />
      <label id="error">
      	<%
      		//获得错误信息  设置的时候是Object(对象)类型的，需要强转String
      		String err = (String)session.getAttribute("err");
      		if(err!=null){ 								//为null(空)时不显示
      			out.print(err);
      			session.removeAttribute("err");			//输出完了，就没用了，移除掉
      		}
      	%>
      	<a href="../util/news_control.jsp?opr=list" class="login_link">返回首页</a>
      </label>
      </form>
  <!-- <form action="../util/do_login.jsp" method="post" onsubmit="return check()">
    <label> 登录名 </label>
    <input type="text" id="uname" value="" class="login_input" />
    <label> 密&#160;&#160;码 </label>
    <input type="password" id="upwd" value="" class="login_input" />
    <input type="button" class="login_sub" value="登录" onclick="login()"/>
    <label id="error"> </label> -->
       
   <!--  <a href="../util/news_control.jsp?opr=list" class="login_link">返回首页</a>  -->
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
    	  
    	  <li> <a href='../util/news_control.jsp?opr=readNews&nid=<%=internalNewsList.get(i).getNid()%>'><b><%=internalNewsList.get(i).getNtitle()%> </b></a> </li>
    	  
      <% } }%>
      
       <!--  <li> <a href='#'><b> 重庆涉黑富豪黎强夫妇庭审答辩言辞相互矛盾 </b></a> </li>
        <li> <a href='#'><b> 发改委：4万亿投资计划不会挤占民间投资空间 </b></a> </li>
        <li> <a href='#'><b> 河南2个乡镇政绩报告内容完全一致引关注 </b></a> </li> -->
      </ul>
    </div>
    <h1> <img src="../images/title_2.gif" alt="国际新闻" /> </h1>
    <div class="side_list">
      <ul>
       <% //国际新闻
       	if(internationalNewsList!=null) {
    	   
       	for(int i = 0; i<internationalNewsList.size(); i++){
    	  %>
    	  
    	  <li> <a href='../util/news_control.jsp?opr=readNews&nid=<%= internationalNewsList.get(i).getNid() %>'><b><%=internationalNewsList.get(i).getNtitle() %> </b></a> </li>
    	  
      <%  }} %>
        <!-- <li> <a href='#'><b> 日本首相鸠山首次全面阐述新政府外交政策 </b></a> </li>
        <li> <a href='#'><b> 黎巴嫩以色列再次交火互射炮弹 </b></a> </li>
        <li> <a href='#'><b> 伊朗将于30日前就核燃料供应方案作出答复 </b></a> </li>
        <li> <a href='#'><b> 与基地有关组织宣称对巴格达连环爆炸负责 </b></a> </li> -->
      </ul>
    </div>
    <h1> <img src="../images/title_3.gif" alt="娱乐新闻" /> </h1>
    <div class="side_list">
      <ul>
        <% //娱乐新闻
       	if(entertainmentNewsList!=null) {
    	   
       	for(int i = 0; i<entertainmentNewsList.size(); i++){
    	  %>
    	  
    	  <li> <a href='../util/news_control.jsp?opr=readNews&nid=<%= entertainmentNewsList.get(i).getNid() %>'><b><%=entertainmentNewsList.get(i).getNtitle() %> </b></a> </li>
    	  
      <%  }} %>
       <!--  <li> <a href='#'><b> 施瓦辛格启动影视业回迁计划 推进加州经济复苏 </b></a> </li>
        <li> <a href='#'><b> 《沧海》导演回应观众质疑 自信能超越《亮剑》 </b></a> </li>
        <li> <a href='#'><b> 《海角七号》导演新片开机 吴宇森等出席 </b></a> </li>
        <li> <a href='#'><b> 《四大名捕》敦煌热拍 八主演飙戏火花四溅 </b></a> </li> -->
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
            <!-- <td colspan="2"> 　对于几近保级成功的深足来说，自从撞衫事件被足协扣罚三分之后，在最近的9轮比赛中，可以说奇迹般地取得了5胜4平的骄人战绩。但是质疑也随之 而来，这其中，有人说深足用钱收买了对手，也有人讲是私下进行了“人情交易”，特别是在上轮客场战胜成都谢菲联队后，“怀疑论”更是甚嚣尘上。
              昨天下午，深足主教练谢峰以及助理教练刘文斌、黄庆良集体接受了晶报记者的独家专访，详细介绍了他们接手深足以来的12轮联赛一些鲜为人知的“故事”。
              买通对手？我们没钱！
              晶报：有媒体做过统计，单从咱们新的教练组接手球队后12轮联赛的积分看，可以排在全部16支中超球队的前两名，于是有人会很自然地联想到，我们获得的这些分数，是不是来得不干净？
              谢峰：别的球队怎么样，我不清楚，但是要是说深圳队用钱收买过对手，这是对我们全队的侮辱！让对手送分必须具备两种可能吧，一是我们给人家钱， 但是我可以说，深足没钱，即使有这个心，我们也没这个能力；二是对手给我们个人情，但是你知道吗，不知道多少人都希望我们深圳队“死”呢！
              刘文斌：有一些报道，我们看了非常气愤，这是对我们全队的侮辱。我们队是一穷二白，拿什么去跟人家进行交易？
              黄庆良：就说上轮我们打成都吧。从我这个教练的角度看，成都跟我们的心态不一样。他们是已经保级，而我们则必须要拿三分，所以他们在场上踢得不 紧是好理解的。我做过运动员，知道这股“气”对比赛的影响程度。而且你知道吗，当年王宝山(现成都队主帅)在深圳的时候，与谢峰根本就“尿”不到一个壶 里，在成都见面，两个人也只是礼节性地握一下手，一句话没有。所以，王宝山怎么可能送分给谢峰呢？ </td>
          </tr> -->
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
         <form action="../util/comments_control.jsp?opr=addComments&nid=<%=news.getNid() %>" method="post" onsubmit="return check()">
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
	session.removeAttribute("sideNewsMap");
	session.removeAttribute("news");
	session.removeAttribute("commentsList");
%>
</body>
</html>
