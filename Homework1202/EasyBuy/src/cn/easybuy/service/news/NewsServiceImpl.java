package cn.easybuy.service.news;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.easybuy.dao.MyBatisUtil;
import cn.easybuy.dao.news.NewsDao;
import cn.easybuy.dao.news.NewsDaoImpl;
import cn.easybuy.dao.news.NewsMapper;
import cn.easybuy.entity.News;
import cn.easybuy.param.NewsParams;
import cn.easybuy.utils.DataSourceUtil;
import cn.easybuy.utils.Pager;
import cn.easybuy.utils.Params;
import org.apache.ibatis.session.SqlSession;

/**
 *
 */
public class NewsServiceImpl implements NewsService {

	public void deleteNews(String id) {// 删除新闻
		SqlSession session =null;
		try {
			session= MyBatisUtil.createSession();
			session.getMapper(NewsMapper.class).deleteById(Integer.parseInt(id));
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			MyBatisUtil.closeSqlSession(session);
		}
//		Connection connection=null;
//		try {
//			connection=DataSourceUtil.openConnection();
//			NewsDao newsDao = new NewsDaoImpl(connection);
//			newsDao.deleteById(Integer.parseInt(id));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally{
//			DataSourceUtil.closeConnection(connection);
//		}
	}

	public News findNewsById(String id) {// 根据ID获取新闻
		News news = null;
		SqlSession session = null;
		try {
			session = MyBatisUtil.createSession();
			news = session.getMapper(NewsMapper.class).getNewsById(Integer.parseInt(id));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MyBatisUtil.closeSqlSession(session);
		}
		return news;
//		News news = null;
//		Connection connection=null;
//		try {
//			connection=DataSourceUtil.openConnection();
//			NewsDao newsDao = new NewsDaoImpl(connection);
//			news = newsDao.getNewsById(Integer.parseInt(id));
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DataSourceUtil.closeConnection(connection);
//		}
//		return news;
	}

	public void addNews(News news) {// 保存新闻
		SqlSession session = null;
		try {
			session = MyBatisUtil.createSession();
			session.getMapper(NewsMapper.class).add(news);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MyBatisUtil.closeSqlSession(session);
		}
//		Connection connection = null;
//		try {
//			connection = DataSourceUtil.openConnection();
//			NewsDao newsDao = new NewsDaoImpl(connection);
//			newsDao.add(news);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DataSourceUtil.closeConnection(connection);
//		}
	}

	public void updateNews(News news) {// 更新留言
		SqlSession session = null;
		try {
			session = MyBatisUtil.createSession();
			session.getMapper(NewsMapper.class).update(news);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MyBatisUtil.closeSqlSession(session);
		}
//		Connection connection = null;
//		try {
//			connection = DataSourceUtil.openConnection();
//			NewsDao newsDao = new NewsDaoImpl(connection);
//			newsDao.update(news);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DataSourceUtil.closeConnection(connection);
//		}
	}

	
	public List<News> queryNewsPageList(NewsParams param) throws SQLException {

		List<News> newsList=new ArrayList<News>();
		SqlSession session = null;
		try {
			session = MyBatisUtil.createSession();
			session.getMapper(NewsMapper.class).queryNewsList(param);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MyBatisUtil.closeSqlSession(session);
		}
		return newsList;

//		List<News> newsList=new ArrayList<News>();
//		Connection connection = null;
//		NewsDao newsDao =null;
//		try {
//			connection = DataSourceUtil.openConnection();
//			newsDao= new NewsDaoImpl(connection);
//			newsList=newsDao.queryNewsList(param);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			System.out.println(connection.isClosed());
//			DataSourceUtil.closeConnection(connection);
//		}
//		return newsList;
	}
	
	@Override
	public List<News> queryNewsList(NewsParams param) {
		List<News> newsList=new ArrayList<News>();
		SqlSession session = null;
		try {
			session = MyBatisUtil.createSession();
			session.getMapper(NewsMapper.class).queryNewsList(param);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MyBatisUtil.closeSqlSession(session);
		}
		return newsList;
//		List<News> newsList=new ArrayList<News>();
//		Connection connection = null;
//		try {
//			connection = DataSourceUtil.openConnection();
//			NewsDao newsDao = new NewsDaoImpl(connection);
//			newsList=newsDao.queryNewsList(param);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DataSourceUtil.closeConnection(connection);
//		}
//		return newsList;
	}

	@Override
	public Integer queryNewsCount(NewsParams param) {
		SqlSession session = null;
		Integer count=0;
		try {
			session = MyBatisUtil.createSession();
			count = session.getMapper(NewsMapper.class).queryNewsCount(param);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MyBatisUtil.closeSqlSession(session);
			return count;
		}
//		Connection connection = null;
//		Integer count=0;
//		try {
//			connection = DataSourceUtil.openConnection();
//			NewsDao newsDao = new NewsDaoImpl(connection);
//			count=newsDao.queryNewsCount(param);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DataSourceUtil.closeConnection(connection);
//			return count;
//		}
	}

}
