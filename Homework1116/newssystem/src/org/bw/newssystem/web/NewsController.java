package org.bw.newssystem.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.bw.newssystem.pojo.News;
import org.bw.newssystem.pojo.Topic;
import org.bw.newssystem.service.news.NewsService;
import org.bw.newssystem.service.news.impl.NewsServiceImpl;
import org.bw.newssystem.service.topic.TopicService;
import org.bw.newssystem.service.topic.impl.TopicServiceImpl;
import org.bw.newssystem.util.Page;

@WebServlet("/util/news_control")
public class NewsController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();


		NewsService newsService = new NewsServiceImpl();
		TopicService topicService = new TopicServiceImpl();	
		
		//获得操作参数值
		String opr = request.getParameter("opr");

		switch(opr){
		 case "list":
			//主题
//			List<Topic> topicList = topicService.getAllTopics();
//			request.setAttribute("topicList", topicList);
			
			//新闻 侧边
			Map<String, List<News>> sideNewsMap = newsService.getNewsMap();
			request.setAttribute("sideNewsMap", sideNewsMap);

			 String url = request.getContextPath();
			 request.getRequestDispatcher("../index.jsp").forward(request, response);

//			//默认所有新闻分页
//			Page page1 = new Page();
//			//(1)获得默认的页码 getPatameter获得的都是String类型的
//			//int pageIndex = 1; 或者
//			String pageIndexStr = request.getParameter("pageIndex");
//			int pageIndex = 1;
//			if(pageIndexStr!=null){
//			pageIndex = Integer.parseInt(pageIndexStr);
//			}
//
//			//(2)设置每一页显示的行数
//			page1.setPageSize(10);//手动默认设置为10
//			//(3)获得总页数
//			//a.要获得总页数先获得总行数
//			int rows = newsService.getPageNewsCount();
//			//b.在page对象中设置总行数，自动算出总的页数
//			page1.setTotalCount(rows);
//
//			//																				开始页   ， 每页显示的数量(行数)
//			List<News> newsListPage =  newsService.getPageNewsList((pageIndex-1)*page1.getPageSize(), page1.getPageSize());
//			request.setAttribute("newsListPage", newsListPage);
//			request.setAttribute("pageIndex", pageIndex);
//			request.setAttribute("pageCount",page1.getPageCount());
//
//			String jsonNewsListPage = JSON.toJSONString(newsListPage);
//			out.print(jsonNewsListPage);
//			out.flush();
//			out.close();


			 break;
		case "getDisplayNews":

			//默认所有新闻分页
			Page page1 = new Page();
			//(1)获得默认的页码 getPatameter获得的都是String类型的
			//int pageIndex = 1; 或者
			String pageIndexStr = request.getParameter("pageIndex");
			int pageIndex = 1;
			if(pageIndexStr!=null){
				pageIndex = Integer.parseInt(pageIndexStr);
			}

			//(2)设置每一页显示的行数
			page1.setPageSize(10);//手动默认设置为10
			//(3)获得总页数
			//a.要获得总页数先获得总行数
			int rows = newsService.getPageNewsCount();
			//b.在page对象中设置总行数，自动算出总的页数
			page1.setTotalCount(rows);

			//																				开始页   ， 每页显示的数量(行数)
			List<News> newsListPage =  newsService.getPageNewsList((pageIndex-1)*page1.getPageSize(), page1.getPageSize());
			request.setAttribute("newsListPage", newsListPage);
			request.setAttribute("pageIndex", pageIndex);
			request.setAttribute("pageCount",page1.getPageCount());

			String displayNewsChoose = request.getParameter("displayNewsChoose");
			if ("newsList".equals(displayNewsChoose)){
				String jsonNewsListPage = JSON.toJSONString(newsListPage);
				out.print(jsonNewsListPage);
			}else if ("pageCount".equals(displayNewsChoose)){
				out.print(page1.getPageCount());
			}
			out.flush();
			out.close();

			break;

		case"getDisplayTopic":
			List<Topic> topicList = topicService.getAllTopics();
			String topicJsonArray = JSON.toJSONString(topicList);
			out.print(topicJsonArray);
			out.flush();
			out.close();

			break;

		 case "backstageNewsList":
			//获得所有新闻列表给后台管理层页面admin.jsp
				//使用新闻业务类型，把所有新闻获得过来转给admin
				List<News> newsList = newsService.getAllNews();
				//用Alibaba提供的fastjson把java对象转化成json数组对象
			 	String aliNewsJsonArray = JSON.toJSONString(newsList, SerializerFeature.WriteNullStringAsEmpty);



				//把newsList转换成HTML字符串
//			 	StringBuffer htmlstr= new StringBuffer();
//			 	for (int i = 0;i<newsList.size();i++){
//			 		News news = newsList.get(i);
//					htmlstr.append("<li>"+news.getNtitle().trim().replace("\"","&quot;")
//									+"<span> 作者： &#160;&#160;&#160;&#160;"+(news.getNauthor()==null||news.getNauthor()==""?"NO Author":news.getNauthor().trim())
//									+"<a href='../util/news_control?opr=updateNews&nid="+news.getNid()
//									+"'>修改</a> &#160;&#160;&#160;&#160; <a href='../util/news_control?opr=deleteNews&nid="+news.getNid()
//									+"' onclick='return clickdel()'>删除</a> </span> </li>");
//				}

				//把newsList转化成json对象数组字符串
//				StringBuffer newsJsonArray= new StringBuffer("[");//拼接不用字符串常量，用字符串变量
//				int i = 0 ;
//					for (  ; i < newsList.size()-1 ; i++){
//						newsJsonArray.append(
//								"{\"nid\":\""+newsList.get(i).getNid()
//								+"\",\"ntitle\":\""+newsList.get(i).getNtitle().trim().replace("\"", "&quot;")//把双引号替换成html的双引号
//								+"\",\"nauthor\":\""+newsList.get(i).getNauthor().trim().replace("\"", "&quot;")
//								+"\"},"
//						);
//					}
//
//					newsJsonArray.append("{\"nid\":"+newsList.get(i).getNid()
//							+",\"ntitle\":"+"\""+newsList.get(i).getNtitle().trim().replace("\"", "&quot;")+"\""
//							+",\"nauthor\":"+"\""+(newsList.get(i).getNauthor()==null||newsList.get(i).getNauthor()==""?"noauthor":	newsList.get(i).getNauthor().trim().replace("\"", "&quot;"))+"\""
//							+",\"nmodifyDate\":"+"\""+newsList.get(i).getNmodifyDate()+"\""+"}]");
//

//				StringBuffer newsJsonArray=new StringBuffer("[");
//		    	int i=0;
//		    	for(;i<newsList.size()-1;i++){
//		    		newsJsonArray.append("{\"nid\":"+newsList.get(i).getNid()
//		    				+",\"ntitle\":"+"\""+newsList.get(i).getNtitle().trim().replace("\"", "&quot;")+"\""
//		    				+",\"nauthor\":"+"\""+(newsList.get(i).getNauthor()==null||newsList.get(i).getNauthor()==""?"noauthor":newsList.get(i).getNauthor().trim().replace("\"", "&quot;"))	+"\""
//		    				+",\"nmodifyDate\":"+"\""+newsList.get(i).getNmodifyDate()+"\""+"},");
//		    	}
//		    	newsJsonArray.append("{\"nid\":"+newsList.get(i).getNid()
//						+",\"ntitle\":"+"\""+newsList.get(i).getNtitle().trim().replace("\"", "&quot;")+"\""
//						+",\"nauthor\":"+"\""+(newsList.get(i).getNauthor()==null||newsList.get(i).getNauthor()==""?"noauthor":	newsList.get(i).getNauthor().trim().replace("\"", "&quot;"))+"\""
//						+",\"nmodifyDate\":"+"\""+newsList.get(i).getNmodifyDate()+"\""+"}]");
		    	
				//把newsList拼成JSON形式的对象数组，以Java的字符串形式发给admin.jsp页面
			 	//然后用今天所学内容，在jsp表格中把json对象数组显示出来

					out.print(aliNewsJsonArray);
					//out.print(htmlstr);
					out.flush();
					out.close();
					
		 	break;

		 case "topicNews":

			//获得主题编号
			 String tid = request.getParameter("ntid");
			 int ntid = 1;
			 if(tid!=null ||! tid.equals("")){
				 ntid = Integer.parseInt(tid);
			 }
			//默认所有新闻分页
			Page page2 = new Page();
			//(1)获得默认的页码 getPatameter获得的都是String类型的

			String pageIndexStr2 = request.getParameter("pageIndex2");
			int pageIndex2 = 1;
			if(pageIndexStr2!=null){
			pageIndex2 = Integer.parseInt(pageIndexStr2);
			}

			//(2)设置每一页显示的行数
			page2.setPageSize(10);//手动默认设置为10

			//(3)获得总页数
			//a.要获得总页数先获得总行数
			int rows2 = newsService.getPageNewsCountByTid(ntid);
			//b.在page对象中设置总行数，自动算出总的页数
			page2.setTotalCount(rows2);
			//																				开始页   ， 每页显示的数量(行数)
			List<News> newsListPage2 =  newsService.getPageNewsListByTid(ntid,(pageIndex2-1)*page2.getPageSize(), page2.getPageSize());

			String topicNewsChoose = request.getParameter("topicNewsChoose");
			if ("topicNews".equals(topicNewsChoose)){
				String topicNews = JSON.toJSONString(newsListPage2);
				out.print(topicNews);
			}else if("pageCount".equals(topicNewsChoose)){
				out.print(page2.getPageCount());
			}


			out.flush();
			out.close();

//			request.setAttribute("pageIndex2", pageIndex2);
//			request.setAttribute("pageCount2",page2.getPageCount());
//			request.setAttribute("topicNewsList",newsListPage2);
//			request.setAttribute("ntid", ntid);
//
//			request.getRequestDispatcher("news_control?opr=list").forward(request, response);

			 break;
		 case "readNews":
			 String tid2 = request.getParameter("nid");
			 int ntid2 = 1;
			 if(tid2!=null ||! tid2.equals("")){
				 ntid2 = Integer.parseInt(tid2);
			 }
			 //获得该编号的新闻
			 News news =  newsService.getNewsListById(ntid2);
			 request.setAttribute("news", news);


			 //屏幕左侧新闻
			 Map<String, List<News>> sideNewsMap2 = newsService.getNewsMap();
			 request.setAttribute("sideNewsMap2", sideNewsMap2);
			 request.getRequestDispatcher("comments_control?opr=showComments&tid="+tid2).forward(request, response);

			 break;
		 case "deleteNews":
			 String nid = request.getParameter("nid");
			 int nid2 = Integer.parseInt(nid);
		     newsService.deleteNews(nid2);
		     response.sendRedirect("../newspages/admin.jsp");

			 break;
		 case "addNewsByTopic":
			 List <Topic> topicList2 = topicService.getAllTopics();
			 request.setAttribute("topicList2", topicList2);
			 request.getRequestDispatcher("../newspages/news_add.jsp").forward(request, response);
			 break;
		 case "addNews":
			 
			 doPost(request, response);

			 break;
		 case "updateNews":

			 List <Topic> topicList3 = topicService.getAllTopics();
			 request.setAttribute("topicList2", topicList3);

			 String nid3 = request.getParameter("nid");
			 int nid4 = Integer.parseInt(nid3);
			 News updateNews = newsService.getNewsListById(nid4);
			 request.setAttribute("news", updateNews);
			 request.getRequestDispatcher("../newspages/news_add.jsp?opr=update&nid="+nid4).forward(request, response);

			 break;
		 case "showAdmin":
			 response.sendRedirect("../newspages/admin.jsp");
			 break;

		}
		//session.invalidate();


	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		NewsService newsService = new NewsServiceImpl(); 
		News news2 = new News();
		
		 String ntid3 = "";
		 int ntid4 = 0 ;
		 String ntitle = "";
		 String nauthor = "";
		 String nsummary = "";
		 String ncontent = "";
		 String uploadFileName = "";

		
		
		String uploadFilePath = request.getSession().getServletContext().getRealPath("/upload/"); 
		//检查请求类型
		 boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		 //当enctype="multipart/form-data"并且method是post时，isMultipart为真
		 if(isMultipart) {
			 FileItemFactory factory = new DiskFileItemFactory();
			 ServletFileUpload upload = new ServletFileUpload(factory);
			 upload.setHeaderEncoding("UTF-8");
			 List<FileItem> items = null;
			 try {
				items = upload.parseRequest(request);
				Iterator<FileItem> iterator = items.iterator();
				while (iterator.hasNext()) {
					FileItem item = (FileItem) iterator.next();
					
	     			//保存上传文件
					if (item.isFormField()) {//处理普通文本字段
						String fieldName = item.getFieldName();
						if (fieldName.equals("ntid")) {
							 ntid3 = item.getString("UTF-8");
							 ntid4 = Integer.parseInt(ntid3);
						}else if (fieldName.equals("ntitle")) {
							 ntitle = item.getString("UTF-8");
						}else if (fieldName.equals("nauthor")) {							 
							 nauthor = item.getString("UTF-8");
						}else if (fieldName.equals("nsummary")) {
							 nsummary = item.getString("UTF-8");	 
						}else if (fieldName.equals("ncontent")) {
							 ncontent = item.getString("UTF-8");
						}
					}else {//处理图片
						String fileName = item.getName();
						if (fileName != null && !fileName.equals("")) {
							File fullFile = new File(fileName);
							//把上传的路径和文件名拼到一起
							File saveFile = new File(uploadFilePath, fullFile.getName());
							item.write(saveFile);
							//图片名字
							uploadFileName = fullFile.getName();
						}
					}
					
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		 //处理时间
		 DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.getDefault());
	     Date date = new Date();
	 	 String date2 = simpleDateFormat.format(date);
		 Date date3 = new Date();
		 try {
			date3 = simpleDateFormat.parse(date2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		 news2.setNtid(ntid4);
		 news2.setNtitle(ntitle);
		 news2.setNauthor(nauthor);
		 news2.setNsummary(nsummary);
		 news2.setNcontent(ncontent);
		 news2.setNpicPath(uploadFileName);

		 
		 String newsChoose = request.getParameter("news");
		 if("update".equals(newsChoose)){ //更新新闻

			 String nid3 = request.getParameter("nid");
			 int nid4 = Integer.parseInt(nid3);

			 news2.setNid(nid4);
			 news2.setNmodifyDate(date3);

			 newsService.updateNews(news2);

		 }else{
			 
			 news2.setNcreateDate(date3);
			 news2.setNmodifyDate(date3);

 			 newsService.addNews(news2);
		 }

		 response.sendRedirect("news_control?opr=showAdmin");
	}

	}
}
