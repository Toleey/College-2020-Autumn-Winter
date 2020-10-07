<%@page import="com.mysql.fabric.Response"%>
<%@page import="java.util.Locale"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Date"%>
<%@page import="org.bw.newssystem.pojo.Comments"%>
<%@page import="java.util.List"%>
<%@page import="org.bw.newssystem.service.comments.impl.CommentsServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	
	CommentsServiceImpl commentsServiceImpl = new CommentsServiceImpl();
	
	String opr = request.getParameter("opr");
	
	switch(opr){
		case "showComments":
			String cnid1 = request.getParameter("tid");
			int cnid = 1;
			 if(cnid1!=null ||! cnid1.equals("")){
				 cnid = Integer.parseInt(cnid1);
			 } 
			
			List<Comments> commentsList = commentsServiceImpl.getCommentsByNid(cnid);
			session.setAttribute("commentsList",commentsList);
			
			response.sendRedirect("../newspages/news_read.jsp");
			
		break;
		
		case "addComments":
			
			
			
			String cauthor = request.getParameter("cauthor");
			String cip = request.getParameter("cip");
			String ccontent = request.getParameter("ccontent");
			
			String cnid2 = request.getParameter("nid");
			int cnid3 = Integer.parseInt(cnid2);
			
			
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.getDefault());
			Date cdate = new Date(System.currentTimeMillis());
			
						
			Comments comments = new Comments();
			
			comments.setCauthor(cauthor);
			comments.setCip(cip);
			comments.setCcontent(ccontent);
			comments.setCnid(cnid3);
			comments.setCdate(cdate);
		
			commentsServiceImpl.addComments(comments);
			
			response.sendRedirect("news_control.jsp?opr=readNews&nid="+cnid3);
		break;
	
	}
	
	
	
	

%>