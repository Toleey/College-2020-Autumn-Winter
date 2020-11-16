<%@page import="org.bw.newssystem.service.news.impl.NewsServiceImpl"%>
<%@page import="org.bw.newssystem.service.news.NewsService"%>
<%@page import="org.bw.newssystem.pojo.News"%>
<%@page import="org.bw.newssystem.util.Page"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		Page<News> page2 = new Page<News>();
	//当前页码
	out.println("当前页码" + page2.getCurPage());
	//每页显示的行数
	out.println("每页现实的行数" + page2.getPageSize());
	//总的记录数
	NewsService newsService = new NewsServiceImpl();
	int totalCount = newsService.getPageNewsCount();
	page2.setTotalCount(totalCount);
	out.println("总的记录数" + page2.getTotalCount());
	//总的页数
	out.println("总的页数" + page2.getPageCount());
	//记录
	out.println("记录" + newsService.getPageNewsList((1 - 1) * page2.getPageSize(), page2.getPageSize()));
	%>

</body>
</html>