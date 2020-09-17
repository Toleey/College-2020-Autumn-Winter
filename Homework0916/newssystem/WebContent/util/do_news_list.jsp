<%@page import="org.bw.newssystem.dao.news.impl.NewsDaoImpl"%>
<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8"%>

<%
	request.setCharacterEncoding("UTF-8");

	NewsDaoImpl news = new NewsDaoImpl();
	
	out.println(news.findNews());
		
%>
