package org.bw.newssystem.dao.news;
/**
 * 新闻数据操作接口
 * **/

import java.sql.Connection;
import java.util.List;

import org.bw.newssystem.pojo.News;

public interface NewsDao {
	//查找所有新闻
	public List<News> findAllNews(Connection conn) throws Exception;
	//查找国际新闻
	public List<News> findWorldNews(Connection conn) throws Exception;
	//查找国内新闻
	
}
