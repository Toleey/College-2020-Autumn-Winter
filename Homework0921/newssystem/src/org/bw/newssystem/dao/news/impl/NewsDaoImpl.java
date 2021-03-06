package org.bw.newssystem.dao.news.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.bw.newssystem.dao.BaseDao;
import org.bw.newssystem.dao.news.NewsDao;
import org.bw.newssystem.pojo.News;

public class NewsDaoImpl extends BaseDao implements NewsDao {

	@Override
	public List<News> findAllNews(Connection conn) throws Exception {
		String sql = "SELECT * FROM NEWS";
		ResultSet rst = this.execQuery(sql);
		List<News> newsList = new ArrayList<News>();
		while (rst.next()) {
			//把数据库表里的每条数据放到对象里
			News news = new News();
			
			news.setNid(rst.getInt("nid"));
			news.setNtid(rst.getInt("ntid"));
			news.setNtitle(rst.getString("ntitle"));
			news.setNauthor(rst.getString("nauthor"));
			news.setNcreateDate(rst.getDate("ncreatedate"));
			news.setNpicPath(rst.getString("npicpath"));
			news.setNcontent(rst.getString("ncontent"));
			news.setNmodifyDate(rst.getDate("nmodifydate"));
			news.setNsummary(rst.getString("nsummary"));
			
			//把新闻添加到list中
			newsList.add(news);
		}
		
		return newsList;
	}

}
