<%@page import="org.bw.newssystem.pojo.News"%>
<%@page import="org.bw.newssystem.service.news.impl.NewsServiceImpl"%>
<%@page import="org.bw.newssystem.service.news.NewsService"%>
<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	//使用新闻业务类型，把所有新闻获得过来转给admin
	NewsService newsService = new NewsServiceImpl();
	List<News> newsList = newsService.getAllNews();
	request.setAttribute("newsList", newsList);
	request.getRequestDispatcher("../newspages/admin.jsp").forward(request, response); 
	String opr = request.getParameter("opr");
	/* switch(opr){
	case "worldNewsList":
		out.println("wnl");
		break;
	case "domesticNewsList":
		out.println("inl");
		break;
	case "entertainmentNewsList":
		out.println("ln");
		break;
	case "topicList":
		out.println("tl");
		break;
	case "mainNewsList":
		out.println("mn");
		break;
	
	default:
		break;
		
	} */
	
%>
