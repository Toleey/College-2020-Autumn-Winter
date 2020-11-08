<%@page import="org.bw.newssystem.service.topic.impl.TopicServiceImpl"%>
<%@page import="org.bw.newssystem.service.topic.TopicService"%>
<%@page import="org.bw.newssystem.pojo.Topic"%>
<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <%@include file="console_element/login_check.jsp"  %> --%>
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
	<div id="main">
		<%@include file="console_element/left.html"%>
		<div id="opt_area">
			 <c:choose>
				<c:when test="${param.upd eq 1}">
					<h1 id="opt_type">修改主题：</h1>
				</c:when>
				<c:otherwise>
					<h1 id="opt_type">添加主题：</h1>
				</c:otherwise>
			</c:choose> 
			<form action="../util/topic_control" method="post"
				onsubmit="return check()">
				
			<c:choose>
				<c:when test="${param.upd eq 1}">
					<input type="hidden" name="opr" value="updtopic"/>
				</c:when>
				<c:otherwise>
					<input type="hidden" name="opr" value="addtopic" />
				</c:otherwise>
			</c:choose> 
				
				<input type="hidden" value="${topic.tid }" name="tid"/>
				<p>
					<label> 主题名称 </label> 
					<input name="tname" type="text" class="opt_input" id="tname" value="${topic.tname }"/>
					
					<!-- 操作完成后的提示信息 -->
					<c:out value = "${err }"/>
					
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
