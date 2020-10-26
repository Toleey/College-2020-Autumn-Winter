package org.bw.newssystem.service.topic.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.bw.newssystem.dao.topic.TopicDao;
import org.bw.newssystem.dao.topic.impl.TopicDaoImpl;
import org.bw.newssystem.pojo.News;
import org.bw.newssystem.pojo.Topic;
import org.bw.newssystem.service.news.NewsService;
import org.bw.newssystem.service.news.impl.NewsServiceImpl;
import org.bw.newssystem.service.topic.TopicService;

public class TopicServiceImpl implements TopicService{

	TopicDaoImpl topicDao = new TopicDaoImpl();
	
	@Override
	public List<Topic> getAllTopics() {
		//业务里建立连接
	  Connection conn = topicDao.getConnection();
	  List<Topic> topicList = null;
	  try {
		  
		  topicList = topicDao.findAllTopics(conn);
		  
	} catch (Exception e) {
		// TODO: handle exception
	}finally {
	     topicDao.close(null, null, conn);
	}
		return topicList;
	}

	
	public int removeTopicByTid2(int tid) {
		Connection conn = topicDao.getConnection();
		int line = 0;
		
		try {
			line = topicDao.delTopicByTid(conn, tid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			topicDao.close(null, null, conn);
		}	
		return line;
	}
	@Override
	public int removeTopicByTid(int tid) {
		NewsService newsService = new NewsServiceImpl();
		Connection conn = topicDao.getConnection();
		int line = 0;
		try {
			conn.setAutoCommit(false);
			
			//1.查询主题下的新闻编号(依据tid查询nid)
			
			List<News> newsList = newsService.getNewsListByTidAll(tid) ;
			
			//2.查询新闻下是否有评论
			if(newsList.size()!=0) {
				
				for (int i = 0; i < newsList.size(); i++) {
					
					newsService.deleteNews(newsList.get(i).getNid());
					
				}		
			}
			
			try {
				line = topicDao.delTopicByTid(conn, tid);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//3.删除评论
			//4.删除新闻
			//5.删除主题
			
			conn.commit();
			conn.setAutoCommit(true);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}finally {
			topicDao.close(null, null, conn);
		}
		return line;
	}

	@Override
	/**
	 * 新增主题，在新增主题之前，要查找主题名字存在否吗，存在则返回
	 * 0，不存在返回1表示新增成功
	 * **/
	public int addTopic(Topic topic) {
		Connection conn  = topicDao.getConnection();
		int line = 0 ;
		try {
			//添加事物
			conn.setAutoCommit(false);
			//如果添加主题名字不存在的话，才能添加
			Topic topic2 = topicDao.findTopicByTname(conn, topic.getTname());
			if (topic2 == null) {
				line = topicDao.insertTopic(conn, topic);
			}
			conn.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			topicDao.close(null, null, conn);
		}
		return line;
	}

	@Override
	public Topic geTopicByTid(int tid) {
		Connection conn = topicDao.getConnection();
		Topic topic = null;
		try {
			topic = topicDao.findTopicByTid(conn, tid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			topicDao.close(null, null, conn);
		}
		return topic;
	}

	@Override
	public int modifyTopicByTid(Topic topic) {
		Connection conn = topicDao.getConnection();
//		Topic topic = null;
		int line = 0; //放到里面，返回不了
			try {
				topicDao.updateTopicByTid(conn, topic);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				topicDao.close(null, null, conn);
			}
		
		return line;
	}

}
