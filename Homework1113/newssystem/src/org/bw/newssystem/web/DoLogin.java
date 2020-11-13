package org.bw.newssystem.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.bw.newssystem.service.user.UserService;
import org.bw.newssystem.service.user.impl.UserServiceImpl;

@WebServlet("/util/do_login")
public class DoLogin extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		String opr = request.getParameter("opr");

		switch(opr){
		case "index":
			String uname=request.getParameter("uname").trim();
			String upwd=request.getParameter("upwd").trim();

			if(uname==null || uname.equals("")){
				request.setAttribute("err", "用户名不能为空");
				request.getRequestDispatcher("../index.jsp").forward(request, response); 
			}else if(upwd==null || upwd.equals("")){
				request.setAttribute("err", "密码不能为空");
				request.getRequestDispatcher("../index.jsp").forward(request, response); 
			}else{
				UserService userService=new UserServiceImpl();
				boolean isLogin= userService.login(uname, upwd);
				if(isLogin){
					session.setAttribute("uname", uname);

					//cookie登陆
					Cookie userNameCookie1 = new Cookie("uname",uname);
					Cookie userPasswordCookie1 = new Cookie("upwd",upwd);

					userNameCookie1.setMaxAge(3600);//1h
					userPasswordCookie1.setMaxAge(3600);
					userNameCookie1.setPath("/");
					userPasswordCookie1.setPath("/");

					response.addCookie(userNameCookie1);
					response.addCookie(userPasswordCookie1);

					response.sendRedirect("news_control?opr=showAdmin");
//					response.sendRedirect("../newspages/admin.jsp");
				}else{
					session.setAttribute("err2", "用户名或密码错误");
					response.sendRedirect("../index.jsp");
				}
			}

			break;
		case "newsRead":

			String uname2=request.getParameter("uname").trim();
			String upwd2=request.getParameter("upwd").trim();
			
			String nid = request.getParameter("nid");
			int nid2 = Integer.parseInt(nid);

			if(uname2==null || uname2.equals("")){
				request.setAttribute("err", "用户名不能为空");
				request.getRequestDispatcher("news_control?opr=readNews&nid="+nid2).forward(request, response);
			}else if(upwd2==null || upwd2.equals("")){
				request.setAttribute("err", "密码不能为空");
				request.getRequestDispatcher("news_control?opr=readNews&nid="+nid2).forward(request, response);
			}else{
				UserService userService=new UserServiceImpl();
				boolean isLogin= userService.login(uname2, upwd2);
				if(isLogin){
					session.setAttribute("uname", uname2);

					//cookie登陆 都用uname、upwd 阅读新闻页登陆主页也能登陆
					Cookie userNameCookie1 = new Cookie("uname",uname2);
					Cookie userPasswordCookie1 = new Cookie("upwd",upwd2);

					userNameCookie1.setMaxAge(3600);//1h
					userPasswordCookie1.setMaxAge(3600);
					userNameCookie1.setPath("/");
					userPasswordCookie1.setPath("/");

					response.addCookie(userNameCookie1);
					response.addCookie(userPasswordCookie1);


					response.sendRedirect("news_control?opr=backstageNewsList");
				}else{
				    //request.setAttribute("err", "用户名密码出错，重新输入");
					//request.getRequestDispatcher("news_control?opr=readNews&nid="+nid2).forward(request, response);
					session.setAttribute("err", "用户名或密码错误");
					response.sendRedirect("news_control?opr=readNews&nid="+nid2);
				}
			}

			break;
		case "loginout":
			
			doGet(request, response);
			
			break;
		}

	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		//销毁session：
	    session.invalidate();


		Cookie cookies[] = request.getCookies();	

			Cookie killCookie1 = new Cookie("uname",null);
			killCookie1.setMaxAge(-1);
			killCookie1.setPath("/");
			response.addCookie(killCookie1);
			Cookie killCookie2 = new Cookie("upwd",null);
			killCookie2.setMaxAge(-1);
			killCookie2.setPath("/");
			response.addCookie(killCookie2);


		  response.sendRedirect("../index.jsp");
	}

}
