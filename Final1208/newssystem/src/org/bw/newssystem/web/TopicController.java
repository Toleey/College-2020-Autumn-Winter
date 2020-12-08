package org.bw.newssystem.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import org.bw.newssystem.pojo.Topic;
import org.bw.newssystem.service.topic.TopicService;
import org.bw.newssystem.service.topic.impl.TopicServiceImpl;


@WebServlet("/util/topic_control")//定制目录，整个目录是个虚拟目录
public class TopicController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		//控制代码

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
			//1.把list转拼成json对象数组
			//2.通过out对象把数据写给客户端，由ajax请求该操作的页面接收该数据
			String aliTopicJsonArray = JSON.toJSONString(topicList);
			
//			StringBuffer topicJsonArray = new StringBuffer();
//			for (int i = 0;i<topicList.size();i++){
//				topicJsonArray.append("<li>"+topicList.get(i).getTname()
//						+"&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160; <a href='../util/topic_control?opr=showupd&tid="+topicList.get(i).getTid()
//						+"'>修改</a> &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160; <a href='../util/topic_control?opr=deltopic&tid="+topicList.get(i).getTid()
//						+"'>删除</a> </li>");
//			}
			
			
//			StringBuffer topicJsonArray = new StringBuffer("[");
//			int i = 0;
//			for (;i<topicList.size()-1;i++){
//				topicJsonArray.append("{\"tid\":\""+topicList.get(i).getTid()+"\",\"tname\":\""+topicList.get(i).getTname()+"\"},");
//			}
//			topicJsonArray.append("{\"tid\":\""+topicList.get(i).getTid()+"\",\"tname\":\""+topicList.get(i).getTname()+"\"}]");
			
			PrintWriter out = response.getWriter();
			out.print(aliTopicJsonArray);
			out.flush();
			out.close();

			//放到request转发给topic_list.jsp
//			request.setAttribute("topicList", topicList);
//			request.getRequestDispatcher("../newspages/topic_list.jsp").forward(request, response);
			/* //显示编辑新闻主题页面（删除，显示所有新闻主题）
			response.sendRedirect("../newspages/topic_list.jsp"); */
		}else if("deltopic".equals(opr)){
			//删除操作
			String tids = request.getParameter("tid");
			if(tids!=null || !tids.equals("")){
				int tid = Integer.parseInt(tids);
				topicService.removeTopicByTid(tid);//传入主题编号进行删除
				response.sendRedirect("topic_control?opr=showTopicList");
			}

		}else if("addtopic".equals(opr)){
			
			doPost(request, response);

		}else if ("showupd".equals(opr)){
			//查询要修改的主题
			String tids = request.getParameter("tid");
			if(tids!=null || !tids.equals("")){
				int tid = Integer.parseInt(tids);
				Topic topic = topicService.geTopicByTid(tid);
				request.setAttribute("topic", topic);
				request.getRequestDispatcher("../newspages/topic_add.jsp?upd=1").forward(request, response);
			}
			//显示修改主题
			//response.sendRedirect("../newspages/topic_add.jsp?upd=1");
		}else if("updtopic".equals(opr)){

			doPost(request, response);
			
		}
		else if ("showTopicList".equals(opr)) {
			response.sendRedirect("../newspages/topic_list.jsp");
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String opr = request.getParameter("opr");
		TopicService topicService = new TopicServiceImpl();	
		if("addtopic".equals(opr)){
			//新增操作
			String tName= request.getParameter("tname");
			//out.print(tName);
			Topic topic=new Topic();
			topic.setTname(tName);
			int line= topicService.addTopic(topic);
			if(line==0){
				request.setAttribute("err", "新增主题已存在");
				request.
				getRequestDispatcher("../newspages/topic_add.jsp")
				.forward(request, response);
			}else{
				//request.setAttribute("err", "操作成功");
				//request.getRequestDispatcher("../newspages/topic_add.jsp").forward(request, response);
				response.sendRedirect("topic_control?opr=showTopicList");
			}
		}else if("updtopic".equals(opr)){
			//修改操作，获得要修改的主题编号
			String tid = request.getParameter("tid");
			//把tid转换成整型，tid不等于空或者""才能转换
			int itid = 0;
			if(tid!=null&&!"".equals(tid)){
				itid = Integer.parseInt(tid);
			}
			String tname = request.getParameter("tname");
			//有了tid和topic，就能够构建topic
			Topic topic = new Topic();
			topic.setTid(itid);
			topic.setTname(tname);
			topicService.modifyTopicByTid(topic);
		 	response.sendRedirect("topic_control?opr=showTopicList");
		}
	}
}
