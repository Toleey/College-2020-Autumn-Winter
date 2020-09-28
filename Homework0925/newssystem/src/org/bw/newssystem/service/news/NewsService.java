package org.bw.newssystem.service.news;
/**
 * 新闻的业务操作类接口
 * */

import java.sql.Connection;
import java.util.List;
import org.bw.newssystem.pojo.News;

public interface NewsService {
	//获得新闻信息
	public List<News> getAllNews ();
	
}
