package org.bw.newssystem.dao.news.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.bw.newssystem.dao.BaseDao;
import org.bw.newssystem.dao.news.NewsDao;
import org.bw.newssystem.pojo.News;


public class NewsDaoImpl extends BaseDao implements NewsDao {

	@Override
	public News findNews() throws Exception {
		
		Connection conn = this.getConnection();
		String sql = "SELECT * FROM NEWS";
		ResultSet rst = execQuery(sql);
		News news = null;
		if (rst.next()) {
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
			
			
		}
		close(rst, null, conn);
		return news;
	}

	
	@Override
	public News createNews(int ntid, String nauthor, String nsummary, String ncontent, String npicPath)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
