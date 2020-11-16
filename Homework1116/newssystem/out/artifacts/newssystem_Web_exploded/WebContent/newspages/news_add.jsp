<%@page import="org.bw.newssystem.pojo.News"%>
<%@page import="org.bw.newssystem.pojo.Topic"%>
<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <%@include file="console_element/login_check.jsp"  %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加新闻--管理后台</title>
<link href="../css/admin.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@include file="console_element/top.jsp" %>
<div id="main">
  <%@include file="console_element/left.html" %>
 
  <div id="opt_area">
    <h1 id="opt_type">
    	<c:choose>
    		<c:when test="${param.opr eq 'update' }">
    			<c:out value = "修改新闻" />
    		</c:when>
    		<c:otherwise>
    			<c:out value = "添加新闻"/>
    		</c:otherwise>
    	</c:choose>
     </h1>

     <c:choose>
     	<c:when test="${param.opr eq 'update' }"> <!-- 编辑新闻 -->
     		
		     <form action="../util/news_control?opr=addNews&news=update&nid=${news.nid}" enctype="multipart/form-data" method="post">
			      <p>
			        <label> 主题 </label>
			        
			        <select name="ntid">
			        	
			        	<option value="${news.ntid}" >			        	
				        	<c:forEach items="${topicList2}" var = "i">
					           		<c:if test="${i.tid == news.ntid}">				           			
					           			<c:out value="${i.tname}" />
					           		 </c:if>
				           	 </c:forEach>			        
			        	</option>
			        	
			        	<c:forEach items="${topicList2}" var = "i">		        	
					        	<c:if test="${news.ntid != i.tid}">	
					        		<option value="${i.tid }">			           			
					           			<c:out value="${i.tname}" />
					           		</option>			       
					           	</c:if>								    
			        	</c:forEach>
			        	
			    	 </select>
			   						        				           
			      </p>
			      <p>
			        <label> 标题 </label>
			        <input name="ntitle" type="text" class="opt_input" value="${news.ntitle}"
			         />
			      </p>
			      <p>
			        <label> 作者 </label>
			        <input name="nauthor" type="text" class="opt_input" value="${news.nauthor}" />
			      </p>
			      <p>
			        <label> 摘要 </label>
			        <textarea name="nsummary" cols="40" rows="3" valiue="1">
			        ${news.nsummary}
			        </textarea>
			      </p>
			      <p>
			        <label> 内容 </label>
			        <textarea name="ncontent" cols="70" rows="10">
			        ${news.ncontent}
			        </textarea>
			      </p>
			      <p>
			        <label> 上传图片 </label>
			        <input name="file" type="file" class="opt_input" value="${news.npicPath}" />
			      </p>
			      <input name="action" type="hidden" value="addnews"/>
			      <input type="submit" value="提交" class="opt_sub" />
			      <input type="reset" value="重置" class="opt_sub" />
			      
		      </form>
     	
     	
     	</c:when>
     	<c:otherwise><!-- 添加新闻 -->
    	  
       <form action="../util/news_control?opr=addNews&news=add" enctype="multipart/form-data" method="post">
      <p>
        <label> 主题 </label>
        
        <select name="ntid">
          <option value="1">选择</option>
          	<c:forEach items="${topicList2}" var = "i">
          		<option value='${i.tid}'>${i.tname}</option>
          	</c:forEach>
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
      </form>
     	  	
     	</c:otherwise>
     </c:choose>
   
  </div>
</div>
<div id="footer">
  <%@include file="console_element/bottom.html" %>
</div>
</body>
</html>
