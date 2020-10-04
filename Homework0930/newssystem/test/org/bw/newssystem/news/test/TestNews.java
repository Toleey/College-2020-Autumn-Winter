package org.bw.newssystem.news.test;

import java.sql.Connection;
import java.util.List;

import org.bw.newssystem.dao.BaseDao;
import org.bw.newssystem.dao.news.impl.NewsDaoImpl;
import org.bw.newssystem.pojo.News;
import org.bw.newssystem.service.news.NewsService;
import org.bw.newssystem.service.news.impl.NewsServiceImpl;
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

}
