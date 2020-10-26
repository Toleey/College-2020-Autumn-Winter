<%@page import="org.bw.newssystem.service.topic.impl.TopicServiceImpl"%>
<%@page import="org.bw.newssystem.service.topic.TopicService"%>
<%@page import="org.bw.newssystem.pojo.Topic"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加主题--管理后台</title>
<link href="../css/admin.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function check() {
		var tname = document.getElementById("tname");

		if (tname.value == "") {
			alert("请输入主题名称！！");
			tname.focus();
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<%@include file="console_element/top.jsp"%>
	<%
		String upd = request.getParameter("upd");
	%>
	<div id="main">
		<%@include file="console_element/left.html"%>
		<div id="opt_area">
			<%
				if ("1".equals(upd)) {
			%>
			<h1 id="opt_type">修改主题：</h1>
			<%
				} else {
			%>
			<h1 id="opt_type">添加主题：</h1>
			<%
				}
			%>
			<form action="../util/topic_control" method="post"
				onsubmit="return check()">
				<%
					Topic topic=(Topic)request.getAttribute("topic");
					if("1".equals(upd)){
				%>
				<input type="hidden" name="opr" value="updtopic"/>
				<%}else{%>
				<input type="hidden" name="opr" value="addtopic" />
				<%} %>
				
				<input type="hidden" 
						<%if(topic!=null){ %>
							value="<%=topic.getTid()%>"
						<%} %> name="tid"/>
				<p>
					<label> 主题名称 </label> <input name="tname" type="text"
						class="opt_input" id="tname" 
						<%if(topic!=null){ %>
						value="<%=topic.getTname()%>"
						<%} %>
						/>
						
					<% //操作完成后的提示信息
						String err = (String) request.getAttribute("err");
						if (err != null) {
							out.print(err);
							request.removeAttribute("err");
						}
					%>
					
				</p>
				<input type="submit" value="提交" class="opt_sub" /> 
					<input type="reset" value="重置" class="opt_sub" />
			</form>
		</div>
	</div>
	<div id="footer">
		<%@include file="console_element/bottom.html"%>
	</div>
</body>
</html>
