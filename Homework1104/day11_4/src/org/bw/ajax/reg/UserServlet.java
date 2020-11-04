package org.bw.ajax.reg;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/userServlet")
public class UserServlet extends HttpServlet {
    
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置请求编码
		req.setCharacterEncoding("UTF-8");
		String opr = req.getParameter("opr");

		String email = req.getParameter("email");
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		String flag = "true";
		PrintWriter out = resp.getWriter();
		switch (opr){
			case "1":
				System.out.println(email);
				if ("a@a.com".equals(email)){
					flag = "fail";
				}
				break;
			case "2":
				System.out.println(name);
				if ("a".equals(name)){
					flag = "fail";
				}
				break;
			case "3":
				System.out.println(password);
				if (password.length()<6){
					flag = "fail";
				}
				break;
		}
		resp.setContentType("text/html; charset=UTF-8");
		out.print(flag);
		out.flush();
		out.close();

	}
}
