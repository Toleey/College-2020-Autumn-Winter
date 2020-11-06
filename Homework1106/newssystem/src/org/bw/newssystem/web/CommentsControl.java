package org.bw.newssystem.web;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.bw.newssystem.pojo.Comments;
import org.bw.newssystem.service.comments.impl.CommentsServiceImpl;

@WebServlet("/util/comments_control")
public class CommentsControl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		

		HttpSession session = request.getSession();

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
				//session.setAttribute("commentsList",commentsList);
				request.setAttribute("commentsList",commentsList);

				//response.sendRedirect("../newspages/news_read.jsp");
				request.getRequestDispatcher("../newspages/news_read.jsp").forward(request, response);;

			break;

			case "addComments":
				
				doPost(request, response);

			break;

		}


	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		CommentsServiceImpl commentsServiceImpl = new CommentsServiceImpl();
		
		String cauthor = request.getParameter("cauthor");
		String cip = request.getParameter("cip");
		String ccontent = request.getParameter("ccontent");

		String cnid2 = request.getParameter("nid");
		int cnid3 = Integer.parseInt(cnid2);


		DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.getDefault());
		Date cdate = new Date();
		String cdate2 = simpleDateFormat.format(cdate);
		Date cdate3 = new Date();
	try {
		cdate3 = simpleDateFormat.parse(cdate2);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

		Comments comments = new Comments();

		comments.setCauthor(cauthor);
		comments.setCip(cip);
		comments.setCcontent(ccontent);
		comments.setCnid(cnid3);
		comments.setCdate(cdate3);

		commentsServiceImpl.addComments(comments);

		response.sendRedirect("news_control?opr=readNews&nid="+cnid3);
	}

}
