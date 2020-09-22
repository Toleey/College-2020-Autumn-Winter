
<%@page import="org.bw.newssystem.pojo.Topic"%>
<%@page import="org.bw.newssystem.service.topic.impl.TopicServiceImpl"%>
<%@page import="org.bw.newssystem.service.topic.TopicService"%>
<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8"%>

<%
	request.setCharacterEncoding("UTF-8");

	TopicService topicService = new TopicServiceImpl();		//都要用到，所以在前面建一个对象
	//获得操作标记
	String opr = request.getParameter("opr");
	//根据操作标记，决定做什么业务  用switch case更好，更清晰
	if("showadd".equals(opr)){
		//显示新增主题页面
		response.sendRedirect("../newspages/topic_add.jsp");
	}else if("edittitle".equals(opr)){
		//根据需求调用业务中的方法
		List<Topic> topicList =  topicService.getAllTopics();
		//放到request转发给topic_list.jsp
		request.setAttribute("topicList", topicList);
		request.getRequestDispatcher("../newspages/topic_list.jsp").forward(request, response);
		/* //显示编辑新闻主题页面（删除，显示所有新闻主题）
		response.sendRedirect("../newspages/topic_list.jsp"); */
	}else if("deltopic".equals(opr)){
		//删除操作
		String tidString = request.getParameter("tid");
		int tid = 0;
		try {
		    tid = Integer.parseInt(tidString);
		} catch (NumberFormatException e) {
		    e.printStackTrace();
		}
		/* out.println(tid); */
		topicService.removeTopicByTid(tid);
		response.sendRedirect("topic_control.jsp?opr=edittitle"); 
		
		
	}else if("addtopic".equals(opr)){
		//新增操作
		String tName = request.getParameter("tname");
		Topic topic =  new Topic();
		topic.setTname(tName);
		int line = topicService.addTopic(topic);
		if(line == 0){
			request.setAttribute("info", "主题已经存在");
			request.getRequestDispatcher("../newspages/topic_add.jsp").forward(request,response);
		}else{
			/* response.sendRedirect("../newspages/topic_add.jsp"); */
			request.setAttribute("info", "主题添加成功");
			request.getRequestDispatcher("../newspages/topic_add.jsp").forward(request,response);
		}
		
		
	}
%>

