package com.toleey.bbsmsg.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MsgServlet")
public class MsgServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String action = req.getParameter("action");
		
		switch (action) {
		case "send":
			
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			
			System.out.println(title+content);
			
			break;

		
		}
		
	}

}
