package org.bw.newssystem.service.news.impl;

import java.sql.Connection;
import java.util.List;

import org.bw.newssystem.dao.news.impl.NewsDaoImpl;
import org.bw.newssystem.pojo.News;
import org.bw.newssystem.service.news.NewsService;

public class NewsServiceImpl implements NewsService {
	NewsDaoImpl newsdao = new NewsDaoImpl();
	
	@Override
	public List<News> getAllNews() {
		Connection conn = newsdao.getConnection();
		List<News> newsList = null;
		try {
			
			newsList =  newsdao.findAllNews(conn);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			newsdao.close(null, null, conn);
		}
		return newsList;
	}

}
