package org.bw.newssystem.service.news.impl;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bw.newssystem.dao.news.impl.NewsDaoImpl;
import org.bw.newssystem.dao.topic.TopicDao;
import org.bw.newssystem.dao.topic.impl.TopicDaoImpl;
import org.bw.newssystem.pojo.News;
import org.bw.newssystem.pojo.Topic;
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

	@Override
	public Map<String, List<News>> getNewsMap() {
		Connection conn = newsdao.getConnection();
		Map<String, List<News>> sideNewsListMap = new HashMap<String, List<News>>();
		try {
			//获得国内新闻
			List<News> internalNewsList = newsdao.findNewsListByNtid(conn, 1, 0, 5);	
			//获得国际新闻
			List<News> internationalNewsList = newsdao.findNewsListByNtid(conn, 2, 0, 5);
			//获得娱乐新闻
			List<News> entertainmentNewsList = newsdao.findNewsListByNtid(conn, 5, 0, 5);
			
			//把三组新闻放到Map中
			sideNewsListMap.put("internalNewsList",internalNewsList);
			sideNewsListMap.put("internationalNewsList",internationalNewsList);
			sideNewsListMap.put("entertainmentNewsList",entertainmentNewsList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			newsdao.close(null, null, conn);
		}

		return sideNewsListMap;
	}

	@Override
	public List<News> getNewsListByTid(int ntid, int start, int count) {
		Connection conn = newsdao.getConnection();
		List<News> newsList = null;
		try {
			
			newsList = newsdao.findNewsListByNtid(conn, ntid, start, count);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			newsdao.close(null, null, conn);
		}
		
		return newsList;
	}

	@Override
	public News getNewsListById(int nid) {
		Connection conn = newsdao.getConnection();
		News news = null;
		try {
			news = newsdao.findNewsListByNid(conn, nid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			newsdao.close(null, null, conn);
		}
		return news;
	}

}
