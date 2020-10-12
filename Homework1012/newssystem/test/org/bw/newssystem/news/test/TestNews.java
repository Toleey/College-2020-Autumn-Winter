package org.bw.newssystem.news.test;

import java.sql.Connection;
import java.util.List;

import org.bw.newssystem.dao.BaseDao;
import org.bw.newssystem.dao.news.impl.NewsDaoImpl;
import org.bw.newssystem.pojo.News;
import org.bw.newssystem.service.news.NewsService;
import org.bw.newssystem.service.news.impl.NewsServiceImpl;
import org.bw.newssystem.util.Page;
import org.junit.jupiter.api.Test;

public class TestNews {

	
	@Test
	public void testGetAllNews() {
		
		NewsDaoImpl newsDaoImpl = new NewsDaoImpl();
		Connection conn = newsDaoImpl.getConnection();
		
		try {
			
			News news = newsDaoImpl.findNewsListByNid(conn, 1);
			
			System.out.println(news);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	@Test
	//测试所有新闻的分页数据 现在是用tomcat连接池jndi连接的，不启动tomcat连接不上数据库
	public void testPage() {
		Page<News> page = new Page<News>();
		//当前页码
		System.out.println(page.getCurPage());
		//每页显示的行数 
		System.out.print(page.getPageSize());
	}

}
