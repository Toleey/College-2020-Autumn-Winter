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
	
	//根据新闻的主题编号获得前几条新闻(连接，新闻主题编号，截取新闻的起始和结束位置)
	/**
	 * @param conn
	 * @param ntid 新闻所在的主题编号
	 * @param start 提取新闻的起始位置
	 * @param count 在某个位置提取新闻数目
	 * @return	所需要的新闻列表
	 */
	public List<News> findNewsListByNtid(Connection conn, int ntid, int start, int count) throws Exception;
	
	//根据新闻编号查找相关新闻
	public News findNewsListByNid(Connection conn, int nid) throws Exception;
	
	//删除新闻
	public int deleteNews(Connection conn , int nid) throws Exception;
	
}
