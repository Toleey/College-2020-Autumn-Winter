<%@page import="org.bw.newssystem.service.topic.impl.TopicServiceImpl"%>
<%@page import="org.bw.newssystem.pojo.Topic"%>
<%@page import="org.bw.newssystem.dao.topic.impl.TopicDaoImpl"%>
<%@page import="org.bw.newssystem.service.topic.TopicService"%>
<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	TopicService topicService = new TopicServiceImpl();
	List<Topic> topicList = topicService.getAllTopic();
	request.setAttribute("topicList", topicList);
	request.getRequestDispatcher("../newspages/topic_list.jsp").forward(request, response);

%> 

