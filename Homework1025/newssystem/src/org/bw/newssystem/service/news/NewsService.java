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
	public int deleteNews(int nid);
	//新增新闻
	public int addNews(News news);
	//修改新闻
	public int updateNews(News news);
	//根据主题编号获得全部新闻
	public List<News> getNewsListByTidAll(int ntid);
	//分页查找所有新闻数据 起始行，一共长多少
	public List<News> getPageNewsList(int start,int count);
	//分页查找新闻总数
	public int getPageNewsCount();
	//分页查找所有特定主题新闻数据 起始行，一共长多少
	public List<News> getPageNewsListByTid(int ntid,int start,int count);
	//分页查找特定主题新闻总数
	public int getPageNewsCountByTid(int ntid);
	
}
