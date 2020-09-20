package org.bw.newssystem.dao.news.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.bw.newssystem.dao.BaseDao;
import org.bw.newssystem.dao.news.NewsDao;
import org.bw.newssystem.pojo.News;
import org.bw.newssystem.pojo.News_Users;


public class NewsDaoImpl extends BaseDao implements NewsDao{

	@Override
	public List getNewsList() throws Exception {
		Connection conn = this.getConnection();
		String sql = "SELECT * FROM NEWS";
		ResultSet rst = execQuery(sql);
		News news = null;
		
		List<News> list = new ArrayList<News>();
		
		while (rst.next()) {
			news = new News();
			
			news.setNid(rst.getInt("nid"));
			news.setNtid(rst.getInt("ntid"));
			news.setNtitle(rst.getString("ntitle"));
			news.setNauthor(rst.getString("nauthor"));
			news.setNcreateDate(rst.getString("ncreatedate"));
			news.setNpicPath(rst.getString("npicpath"));
			news.setNcontent(rst.getString("ncontent"));
			news.setNmodifyDate(rst.getString("nmodifydate"));
			news.setNsummary(rst.getString("nsummary"));
			
			list.add(news);
			
		}
		close(rst, null, conn);
		return list;
	}

}
