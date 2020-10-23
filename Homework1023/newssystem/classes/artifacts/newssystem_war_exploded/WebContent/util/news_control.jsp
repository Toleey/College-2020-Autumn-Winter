<%@page import="org.bw.newssystem.util.Page"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
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
		//新闻 侧边
		Map<String, List<News>> sideNewsMap = newsService.getNewsMap();
		session.setAttribute("sideNewsMap", sideNewsMap);
		
		
		//默认所有新闻分页
		Page page1 = new Page();
		//(1)获得默认的页码 getPatameter获得的都是String类型的
		//int pageIndex = 1; 或者
		String pageIndexStr = request.getParameter("pageIndex");
		int pageIndex = 1;
		if(pageIndexStr!=null){
		pageIndex = Integer.parseInt(pageIndexStr);
		}
		
		//(2)设置每一页显示的行数
		page1.setPageSize(10);//手动默认设置为10
		//(3)获得总页数
		//a.要获得总页数先获得总行数
		int rows = newsService.getPageNewsCount();
		//b.在page对象中设置总行数，自动算出总的页数
		page1.setTotalCount(rows);
		
		//																				开始页   ， 每页显示的数量(行数)
		List<News> newsListPage =  newsService.getPageNewsList((pageIndex-1)*page1.getPageSize(), page1.getPageSize());
		session.setAttribute("newsListPage", newsListPage);
		session.setAttribute("pageIndex", pageIndex);
		session.setAttribute("pageCount",page1.getPageCount());
		
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
		/*  //获得主题编号
		 String tid = request.getParameter("ntid");
		 int ntid = 1;
		 if(tid!=null ||! tid.equals("")){
			 ntid = Integer.parseInt(tid);
		 } 
		 //获得主题下的新闻
	     List<News> topicNewsList = newsService.getNewsListByTid(ntid, 0, 20);
		 session.setAttribute("topicNewsList",topicNewsList);
		 //response.sendRedirect("../index.jsp");避免session的arrtribute remove后无法获得信息
		 response.sendRedirect("news_control.jsp?opr=list"); */
		 
		//获得主题编号
		 String tid = request.getParameter("ntid");
		 int ntid = 1;
		 if(tid!=null ||! tid.equals("")){
			 ntid = Integer.parseInt(tid);
		 } 
		 
		//默认所有新闻分页
		Page page2 = new Page();
		//(1)获得默认的页码 getPatameter获得的都是String类型的

		String pageIndexStr2 = request.getParameter("pageIndex2");
		int pageIndex2 = 1;
		if(pageIndexStr2!=null){
		pageIndex2 = Integer.parseInt(pageIndexStr2);
		}
		
		//(2)设置每一页显示的行数
		page2.setPageSize(10);//手动默认设置为10
		
		//(3)获得总页数
		//a.要获得总页数先获得总行数
		int rows2 = newsService.getPageNewsCountByTid(ntid);
		//b.在page对象中设置总行数，自动算出总的页数
		page2.setTotalCount(rows2);
		//																				开始页   ， 每页显示的数量(行数)
		List<News> newsListPage2 =  newsService.getPageNewsListByTid(ntid,(pageIndex2-1)*page2.getPageSize(), page2.getPageSize());
		//session.setAttribute("newsListPage", newsListPage2);
		session.setAttribute("pageIndex2", pageIndex2);
		session.setAttribute("pageCount2",page2.getPageCount());
		
		session.setAttribute("topicNewsList",newsListPage2);
		
		session.setAttribute("ntid", ntid);
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
	     newsService.deleteNews(nid2);
	     response.sendRedirect("news_control.jsp?opr=backstageNewsList");
		 
		 break;
	 case "addNewsByTopic":
		 List <Topic> topicList2 = topicService.getAllTopics();
		 session.setAttribute("topicList2", topicList2);
		 response.sendRedirect("../newspages/news_add.jsp");
		 break;
	 case "addNews":
		 News news2 = new News();
		 
		 String ntid3 = request.getParameter("ntid");
		 int ntid4 = Integer.parseInt(ntid3);
		 String ntitle = request.getParameter("ntitle");
		 String nauthor = request.getParameter("nauthor");
		 String nsummary = request.getParameter("nsummary").trim();
		 String ncontent = request.getParameter("ncontent").trim();
		 String file = request.getParameter("file");

		 DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.getDefault());
	     Date date = new Date();
	 	 String date2 = simpleDateFormat.format(date);
		 Date date3 = new Date();
		 date3 = simpleDateFormat.parse(date2);
		
		 news2.setNtid(ntid4);
		 news2.setNtitle(ntitle);
		 news2.setNauthor(nauthor);
		 news2.setNsummary(nsummary);
		 news2.setNcontent(ncontent);
		 news2.setNpicPath(file);
		 
		 
		 String newsChoose = request.getParameter("news");
		 if("update".equals(newsChoose)){
			 
			 String nid3 = request.getParameter("nid");
			 int nid4 = Integer.parseInt(nid3);
			 
			 news2.setNid(nid4);
			 news2.setNmodifyDate(date3);
			 
			newsService.updateNews(news2);
			
			//out.print(news2);
			 
		 }else{
			 news2.setNcreateDate(date3);
			 news2.setNmodifyDate(date3);
			 
 			 newsService.addNews(news2);
		 }
		 
		 response.sendRedirect("news_control.jsp?opr=backstageNewsList");
		 
		 break;
	 case "updateNews":
		 
		 List <Topic> topicList3 = topicService.getAllTopics();
		 session.setAttribute("topicList2", topicList3);
		 
		 String nid3 = request.getParameter("nid");
		 int nid4 = Integer.parseInt(nid3);
		 News updateNews = newsService.getNewsListById(nid4);
		 session.setAttribute("news", updateNews);
		 response.sendRedirect("../newspages/news_add.jsp?opr=update&nid="+nid4);
		 
		 break;
		 
	}
	//session.invalidate();
	
%>
