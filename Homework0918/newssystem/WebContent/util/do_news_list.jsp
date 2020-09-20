<%@page import="org.bw.newssystem.pojo.News"%>
<%@page import="org.bw.newssystem.dao.news.NewsDao"%>
<%@page import="org.bw.newssystem.dao.news.impl.NewsDaoImpl"%>
<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8"%>

<%
	NewsDao nd = new NewsDaoImpl();
	
	List<News> list =  nd.getNewsList();
	int i = 0;
	while( i < list.size()){
		out.println("<li>"+
	 	list.get(i).getNtitle()+"<span>作者:"+list.get(i).getNauthor()+
		"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a style='cursor:pointer' href='../newspages/news_read.jsp'>修改</a>"+
		"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a style='cursor:pointer' href='../newspages/news_add.jsp'>删除</a></span></li>");
		i++;
	}
	/* while( i < list.size()){
		out.println("<li><a style='text-decoration:none;cursor:pointer' href:'#''>"
		+list.get(i).getNtitle()+"<span>作者:"+list.get(i).getNauthor()+
		"</a><a style='text-decoration:none;cursor:pointer' href='../newspages/news_read.jsp'>修改</a>"+
		"<a style='text-decoration:none;cursor:pointer' href='../newspages/news_add.jsp'>删除</a></span></li>");
		i++;
	} */
	
	/*  <li> 深足教练组：说我们买球是侮辱 朱广沪常暗中支招 <span> 作者：
     sport                                             
     &#160;&#160;&#160;&#160; <a href='news_modify.html'>修改</a> &#160;&#160;&#160;&#160; <a href='#' >删除</a> </span> </li> */
	/* out.println(list.get(1).getNsummary()+"作者:"+list.get(1).getNauthor()); */
	
	
	
	/* for (News news : list) {
		out.println(list);
	} */


%>

