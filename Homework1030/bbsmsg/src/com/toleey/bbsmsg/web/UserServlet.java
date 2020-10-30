package com.toleey.bbsmsg.web;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.toleey.bbsmsg.pojo.User;
import com.toleey.bbsmsg.service.user.impl.UserServiceImpl;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String action = req.getParameter("action"); 
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		HttpSession session = req.getSession();
		
		String username = req.getParameter("username").trim();
		String password = req.getParameter("password").trim();	
		
		switch (action) {
		case "login":
				
			if( username == null || username.equals("")){
				req.setAttribute("error", "用户名不能为空");
				req.getRequestDispatcher("index.jsp").forward(req, resp); 
			}else if(password==null || password.equals("")){
				req.setAttribute("error", "密码不能为空");
				req.getRequestDispatcher("index.jsp").forward(req, resp); 
			}else{
				User user = new User();			
				user.setUsername(username);
				user.setPassword(password);
			
				int isLogin = userServiceImpl.login(user);
				
				if(isLogin == 1){ //登陆成功				
					session.setAttribute("loginuser", user.getUsername());
					resp.sendRedirect("MsgServlet?action=list");				
				}else{
					req.setAttribute("error", "用户名或密码错误");
					req.getRequestDispatcher("index.jsp").forward(req, resp); 
				}
			}
						
		break;
		case "regist":
			String affirm = req.getParameter("affirm").trim();
			String email = req.getParameter("email").trim();
			
			if( username == null || username.equals("")){
				req.setAttribute("error", "用户名不能为空");
				req.getRequestDispatcher("register.jsp").forward(req, resp); 
			}else if(password==null || password.equals("")){
				req.setAttribute("error", "密码不能为空");
				req.getRequestDispatcher("register.jsp").forward(req, resp); 
			}else if (password.equals(affirm)) {
				User user = new User();			
				user.setUsername(username);
				user.setPassword(password);
				user.setEmail(email);
				
				int isSignup = userServiceImpl.signup(user);
				if(isSignup == 1){ //注册成功
					resp.sendRedirect("index.jsp");				
				}else {
					req.setAttribute("error", "用户名已存在,请重新选择");
					req.getRequestDispatcher("register.jsp").forward(req, resp); 
				}
			}else{				
				req.setAttribute("error", "两次密码不相同，请重新输入");
				req.getRequestDispatcher("register.jsp").forward(req, resp); 			
			}	
			break;
		case "findUsers":
			
			doGet(req, resp);
			
			break;
		case "logout":
			
			
			break;
		}
			
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String action = req.getParameter("action"); 
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		HttpSession session = req.getSession();
		
		switch (action) {
		case "findUsers":
			List<User> userList = userServiceImpl.getAllUser();
			
			req.setAttribute("users", userList);		
			req.getRequestDispatcher("newMsg.jsp").forward(req, resp);	
			break;
		case "logout":
			session.invalidate();
			resp.sendRedirect("index.jsp");	
			break;
		}
		
	}
	
}
