package com.toleey.bbsmsg.web;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.toleey.bbsmsg.pojo.Message;
import com.toleey.bbsmsg.service.msg.impl.MsgServiceImpl;

@WebServlet("/MsgServlet")
public class MsgServlet extends HttpServlet{
	
	MsgServiceImpl MsgServiceImpl = new MsgServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String action = req.getParameter("action");
		
		switch (action) {
		case "send":
			
		  	String fromUser = (String)req.getSession().getAttribute("loginuser");
		  	String toUser = req.getParameter("toUser");
		  	String title = req.getParameter("title");
		  	String content = req.getParameter("content");
		  	int state = 0;
		  	Timestamp timestamp = new Timestamp((new Date()).getTime());
		  	
		  	Message message = new Message();
		  	message.setUsername(fromUser);
		  	message.setTitle(title);
		  	message.setContent(content);
		  	message.setState(state);
		  	message.setSendto(toUser);
		  	message.setDatetime(timestamp);
		  	
		  	
		  	MsgServiceImpl.insertMessage(message);
		  	System.out.println("hello");
			
			resp.sendRedirect("MsgServlet?action=list");
			
			break;
		case "list":
			
			doGet(req, resp);
			
			break;
		case "read":
			doGet(req, resp);
			break;
		case "del":
			doGet(req, resp);
			break;
		
		}
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String action = req.getParameter("action");
		
		switch (action) {
		case "list":
			
			List<Message> messageList = MsgServiceImpl.showMessage((String)req.getSession().getAttribute("loginuser"));
			req.setAttribute("msgs", messageList);
			req.getRequestDispatcher("main.jsp").forward(req, resp);
			
			break;
		case "read":
			String temMsgid = (String) req.getParameter("msgid");
			int msgid = Integer.parseInt(temMsgid);
			MsgServiceImpl.updateState(msgid);
			List<Message> messageList2 = MsgServiceImpl.showMessage((String)req.getSession().getAttribute("loginuser"));
			req.setAttribute("msg", messageList2);
			req.getRequestDispatcher("readMsg.jsp").forward(req, resp);
			break;
		case "del":
			String temMsgid2 = (String) req.getParameter("msgid");
			int msgid2 = Integer.parseInt(temMsgid2);
			MsgServiceImpl.delMessage(msgid2);
			
			resp.sendRedirect("MsgServlet?action=list");
			break;
		
		}
	}

}
