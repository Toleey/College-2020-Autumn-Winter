package org.bw.newssystem.service.topic.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.bw.newssystem.dao.topic.TopicDao;
import org.bw.newssystem.dao.topic.impl.TopicDaoImpl;
import org.bw.newssystem.pojo.Topic;
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

	@Override
	public int removeTopicByTid(int tid) {
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
	public int addTopic(Topic topic) {
		Connection conn  = topicDao.getConnection();
		int line = 0 ;
		try {
			conn.setAutoCommit(false);
			Topic topic2 =  topicDao.findTopicByTName(conn, topic.getTname());
			if (topic2 == null) {
				topic.setTname(topic.getTname());
				
				line = topicDao.insertTopic(conn, topic);
				
			}
//			conn.setAutoCommit(true);
			conn.commit();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			try {
				//回滚 错误里回滚 执行到第一步未成功会返回错误，所以回滚
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

}
