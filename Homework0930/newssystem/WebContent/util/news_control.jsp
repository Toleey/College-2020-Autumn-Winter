<%@page import="org.bw.newssystem.pojo.Topic"%>
<%@page import="org.bw.newssystem.service.topic.impl.TopicServiceImpl"%>
<%@page import="org.bw.newssystem.service.topic.TopicService"%>
<%@page import="org.bw.newssystem.pojo.News"%>
<%@page import="org.bw.newssystem.service.news.impl.NewsServiceImpl"%>
<%@page import="org.bw.newssystem.service.news.NewsService"%>
<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	
	NewsService newsService = new NewsServiceImpl();
	TopicService topicService = new TopicServiceImpl();
	
	//获得操作参数值
	String opr = request.getParameter("opr");
	
	switch(opr){
	 case "list":
		//主题
		List<Topic> topicList = topicService.getAllTopics();
		session.setAttribute("topicList", topicList);
		//新闻
		Map<String, List<News>> sideNewsMap = newsService.getNewsMap();
		session.setAttribute("sideNewsMap", sideNewsMap);
		//默认新闻
		  List<News> defaultNewsList = newsService.getNewsListByTid(1, 0, 20);
		  session.setAttribute("defaultNewsList", defaultNewsList);
		
		//request.getRequestDispatcher("../index.jsp").forward(request, response);
		response.sendRedirect("../index.jsp");
		 break;
	 case "backstageNewsList":	
		 	//获得所有新闻列表给后台管理层页面admin.jsp
			//使用新闻业务类型，把所有新闻获得过来转给admin	

			List<News> newsList = newsService.getAllNews();
			request.setAttribute("newsList", newsList);
			request.getRequestDispatcher("../newspages/admin.jsp").forward(request, response);
	 	break;
	 	
	 case "topicNews":
		 //获得主题编号
		 String tid = request.getParameter("ntid");
		 int ntid = 1;
		 if(tid!=null ||! tid.equals("")){
			 ntid = Integer.parseInt(tid);
		 } 
		 //获得主题下的新闻
	     List<News> topicNewsList = newsService.getNewsListByTid(ntid, 0, 20);
		 session.setAttribute("topicNewsList",topicNewsList);
		 //response.sendRedirect("../index.jsp");避免session的arrtribute remove后无法获得信息
		 response.sendRedirect("news_control.jsp?opr=list");
		 
		 break;
	 case "readNews":
		 String tid2 = request.getParameter("nid");
		 int ntid2 = 1;
		 if(tid2!=null ||! tid2.equals("")){
			 ntid2 = Integer.parseInt(tid2);
		 } 
		 //获得该编号的新闻
		 News news =  newsService.getNewsListById(ntid2);
		 //out.println(news);
		 session.setAttribute("news", news);
		
		 
		 //屏幕左侧新闻
		 Map<String, List<News>> sideNewsMap2 = newsService.getNewsMap();
		 session.setAttribute("sideNewsMap2", sideNewsMap2);
		 
		 response.sendRedirect("comments_control.jsp?opr=showComments&tid="+tid2);
		
		 break;
	 case "deleteNews":
		 String nid = request.getParameter("nid");
		 int nid2 = Integer.parseInt(nid);
	     newsService.deleteNEws(nid2);
	     response.sendRedirect("news_control.jsp?opr=backstageNewsList");
		 
		 break;
	 case "updateNews":
		 response.sendRedirect("../newspages/news_add.jsp");
		 break;
	}
	//session.invalidate();
	
%>
