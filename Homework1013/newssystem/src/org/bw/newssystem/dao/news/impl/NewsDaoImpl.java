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

	@Override
	public List<News> findNewsListByNtid(Connection conn, int ntid, int start, int count) throws Exception {
		String sql = "SELECT * FROM NEWS WHERE ntid=? ORDER BY ncreateDate LIMIT ?,?";
		ResultSet rst = this.execQuery(sql,ntid,start,count);
		List<News> newsList = new ArrayList<News>();
		while(rst.next()) {
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

	@Override
	public News findNewsListByNid(Connection conn, int nid) throws Exception {
		String sql = "SELECT * FROM NEWS WHERE nid = ?";
		ResultSet rst = this.execQuery(sql,nid);
		News news = new News();
		if (rst.next()) {
			news.setNid(rst.getInt("nid"));
			news.setNtid(rst.getInt("ntid"));
			news.setNtitle(rst.getString("ntitle"));
			news.setNauthor(rst.getString("nauthor"));
			news.setNcreateDate(rst.getDate("ncreatedate"));
			news.setNpicPath(rst.getString("npicpath"));
			news.setNcontent(rst.getString("ncontent"));
			news.setNmodifyDate(rst.getDate("nmodifydate"));
			news.setNsummary(rst.getString("nsummary"));
		}
		
		close(rst, null, null);
		return news;
	}

	@Override
	public int deleteNews(Connection conn, int nid) throws Exception {
		String sql = "DELETE FROM News WHERE nid = ?";
		int line = this.execUpdate(sql,nid);
		return line;
	}

	@Override
	public int insertNews(Connection conn, News news) throws Exception {
		String sql = "INSERT INTO News (ntid,ntitle,nauthor,ncreateDate,npicPath,ncontent,nmodifyDate,nsummary) VALUES (?,?,?,?,?,?,?,?)";
		int line = this.execUpdate(sql,news.getNtid(),news.getNtitle(),news.getNauthor(),news.getNcreateDate(),news.getNpicPath(),news.getNcontent(),news.getNmodifyDate(),news.getNsummary());
		return line;
	}

	@Override
	public int UpdateNews(Connection conn, News news) throws Exception {
		String sql = "UPDATE News SET ntid = ?,ntitle = ?,nauthor = ?,npicPath = ?,ncontent = ?,nmodifyDate = ?,nsummary = ? WHERE nid = ?";
		int line = this.execUpdate(sql,news.getNtid(),news.getNtitle(),news.getNauthor(),news.getNpicPath(),news.getNcontent(),news.getNmodifyDate(),news.getNsummary(),news.getNid() );
		return line;
	}

	@Override
	public List<News> findNewsListByNtidAll(Connection conn, int ntid) throws Exception {
		String sql = "SELECT * FROM NEWS WHERE ntid=?";
		ResultSet rst = this.execQuery(sql,ntid);
		List<News> newsList = new ArrayList<News>();
		while(rst.next()) {
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

	@Override
	public List<News> findPageAllNews(Connection conn, int start, int count) throws Exception {
		String sql = "SELECT * FROM NEWS ORDER BY ncreateDate LIMIT ?,?";
		ResultSet rst = this.execQuery(sql,start,count);
		List<News> newsList = new ArrayList<News>();
		while(rst.next()) {
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

	@Override
	public int findAllNewsCount(Connection conn) throws Exception {
		String sql = "SELECT COUNT(nid) AS rows  FROM NEWS";
		ResultSet rst = execQuery(sql);//返回的都是结果集 只不过结果集的数字是int类型 就1条记录
		int line = 0;
		if (rst.next()) {
			line = rst.getInt("rows");//列名 rows
		}
		return line;
	}

	@Override
	public List<News> findPageNewsByTid(Connection conn, int ntid, int start, int count) throws Exception {
		String sql = "SELECT * FROM NEWS WHERE Ntid = ? ORDER BY ncreateDate LIMIT ?,?";
		ResultSet rst = this.execQuery(sql,ntid,start,count);
		List<News> newsList = new ArrayList<News>();
		while(rst.next()) {
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

	@Override
	public int findNewsCountByTid(Connection conn, int ntid) throws Exception {
		String sql = "SELECT COUNT(nid) AS rows  FROM NEWS WHERE Ntid = ?";
		ResultSet rst = execQuery(sql,ntid);
		int line = 0;
		if (rst.next()) {
			line = rst.getInt("rows");//列名 rows
		}
		return line;
	}

}
