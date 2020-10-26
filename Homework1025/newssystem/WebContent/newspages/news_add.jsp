<%@page import="org.bw.newssystem.pojo.News"%>
<%@page import="org.bw.newssystem.pojo.Topic"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加新闻--管理后台</title>
<link href="../css/admin.css" rel="stylesheet" type="text/css" />
</head>
 <%
  	List<Topic> topicList2 = (List<Topic>) request.getAttribute("topicList2");
 	String opr = request.getParameter("opr");	
  %>
<body>
<%@include file="console_element/top.jsp" %>
<div id="main">
  <%@include file="console_element/left.html" %>
 
  <div id="opt_area">
    <h1 id="opt_type">
    <% 
    	if("update".equals(opr)){
    	%>
    	修改新闻
    	<%	
    	}else{
    	%>
    	 添加新闻：
        <%	
    	}
    %>
     
     </h1>

    <%
    	//编辑新闻
	    if("update".equals(opr)){
	    News news = (News) request.getAttribute("news");
	   
    %>
        <form action="../util/news_control?opr=addNews&news=update&nid=<%=news.getNid() %>" method="post">
      <p>
        <label> 主题 </label>
        <select name="ntid">
          <!-- <option value="1">选择</option> -->
           <%-- <option value='<%=news.getNtid() %>'> <%=topicList2.get(a).getTname() %> </option> --%>
           <option value='<%=news.getNtid() %>'> 
           
           <% 
          	 int a = 0;
           	for(int i = 0;i< topicList2.size() ; i++){
           		if(topicList2.get(i).getTid()==news.getNtid()){
           			a=i;
           		}
           	}
			 %> 
			 <%= topicList2.get(a).getTname() %>
           
           </option>
          <%
          if(topicList2!=null){
        	  
          for(int i = 0; i < topicList2.size() ; i++){
        	  if(i==a){
        		  continue;
        	  }
          %>
           <option value='<%=topicList2.get(i).getTid() %>'> <%=topicList2.get(i).getTname() %> </option>
          <%
          }}else{
        	  response.sendRedirect("../util/news_control?opr=addNewsByTopic");
          }
          %>
         <!--  <option value='1'> 国内 </option> -->
        </select>
      </p>
      <p>
        <label> 标题 </label>
        <input name="ntitle" type="text" class="opt_input" value="<%=news.getNtitle() %>"
         />
      </p>
      <p>
        <label> 作者 </label>
        <input name="nauthor" type="text" class="opt_input" value="<%=news.getNauthor() %>" />
      </p>
      <p>
        <label> 摘要 </label>
        <textarea name="nsummary" cols="40" rows="3" valiue="1">
        <%=news.getNsummary() %>
        </textarea>
      </p>
      <p>
        <label> 内容 </label>
        <textarea name="ncontent" cols="70" rows="10">
        <%=news.getNcontent() %>
        </textarea>
      </p>
      <p>
        <label> 上传图片 </label>
        <input name="file" type="file" class="opt_input" value="<%=news.getNpicPath() %>" />
      </p>
      <input name="action" type="hidden" value="addnews"/>
      <input type="submit" value="提交" class="opt_sub" />
      <input type="reset" value="重置" class="opt_sub" />
      
      </form>
      
      
      
      
      <%}else{ 
    	  
    	  
    	//添加新闻
    	  
    	
      %>
       <form action="../util/news_control?opr=addNews&news=add" enctype="multipart/form-data" method="post">
      <p>
        <label> 主题 </label>
        <select name="ntid">
          <option value="1">选择</option>
          <%
          if(topicList2!=null){
          for(int i = 0 ; i < topicList2.size() ; i++){
          %>
           <option value='<%=topicList2.get(i).getTid() %>'> <%=topicList2.get(i).getTname() %> </option>
          <%
          }}else{
        	  response.sendRedirect("../util/news_control?opr=addNewsByTopic");
          }
          %>
         <!--  <option value='1'> 国内 </option> -->
        </select>
      </p>
      <p>
        <label> 标题 </label>
        <input name="ntitle" type="text" class="opt_input" />
      </p>
      <p>
        <label> 作者 </label>
        <input name="nauthor" type="text" class="opt_input" />
      </p>
      <p>
        <label> 摘要 </label>
        <textarea name="nsummary" cols="40" rows="3" ></textarea>
      </p>
      <p>
        <label> 内容 </label>
        <textarea name="ncontent" cols="70" rows="10"></textarea>
      </p>
      <p>
        <label> 上传图片 </label>
        <input name="file" type="file" class="opt_input"  />
      </p>
      <input name="action" type="hidden" value="addnews"/>
      <input type="submit" value="提交" class="opt_sub" />
      <input type="reset" value="重置" class="opt_sub" />
      
      <%}%>
    </form>
  </div>
</div>
<div id="footer">
  <%@include file="console_element/bottom.html" %>
</div>
</body>
</html>
