package org.bw.newssystem.service.news;
/**
 * 新闻的业务操作类接口
 * */

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import org.bw.newssystem.pojo.News;

public interface NewsService {
	//获得新闻信息
	public List<News> getAllNews ();
	//获得前几条国际、国内还有娱乐新闻
	public Map<String, List<News>> getNewsMap();
	//根据主题编号获得新闻
	public List<News> getNewsListByTid(int ntid,int start,int count);
	//根据新闻编号获得新闻
	public News getNewsListById(int nid);
	//删除新闻
	public int deleteNEws(int nid);
	
}
