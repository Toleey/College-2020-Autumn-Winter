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
			out.println("hello");
			String ccontent = request.getParameter("ccontent");
			String cip = request.getParameter("cip");
			String cauthor = request.getParameter("cauthor");
			
		break;
	
	}
	
	
	
	

%>