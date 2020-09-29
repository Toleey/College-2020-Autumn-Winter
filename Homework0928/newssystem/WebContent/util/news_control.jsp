<%@page import="org.bw.newssystem.pojo.Topic"%>
<%@page import="org.bw.newssystem.service.topic.TopicService"%>
<%@page import="org.bw.newssystem.service.topic.impl.TopicServiceImpl"%>
<%@page import="org.bw.newssystem.pojo.News"%>
<%@page import="org.bw.newssystem.service.news.impl.NewsServiceImpl"%>
<%@page import="org.bw.newssystem.service.news.NewsService"%>
<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	
	NewsService newsService = new NewsServiceImpl();
	//获得操作参数值
	String opr = request.getParameter("opr");
	switch(opr){
	 case "list":
		 Map<String, List<News>> sideNewsMap = newsService.getNewsMap();
		session.setAttribute("sideNewsMap", sideNewsMap);
		//request.getRequestDispatcher("../index.jsp").forward(request, response);
		
		
		TopicService topicService = new TopicServiceImpl();
		List<Topic> topicList = topicService.getAllTopics();
		session.setAttribute("topicList", topicList);
		
		response.sendRedirect("../index.jsp");
		 break;
	 case "backstageNewsList":	
		 	//获得所有新闻列表给后台管理层页面admin.jsp
			//使用新闻业务类型，把所有新闻获得过来转给admin	

			List<News> newsList = newsService.getAllNews();
			request.setAttribute("newsList", newsList);
			request.getRequestDispatcher("../newspages/admin.jsp").forward(request, response);
	 	break;
	 
	
	}

	
	
	
%>
