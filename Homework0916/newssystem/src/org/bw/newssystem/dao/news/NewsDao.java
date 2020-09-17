package org.bw.newssystem.dao.news;
import org.bw.newssystem.pojo.News;

public interface NewsDao {
	
	//新建新闻
	public News createNews (int ntid , String nauthor , String nsummary , String ncontent , String npicPath ) throws Exception;
	//查询新闻
	public News findNews() throws Exception;
	
	
}
