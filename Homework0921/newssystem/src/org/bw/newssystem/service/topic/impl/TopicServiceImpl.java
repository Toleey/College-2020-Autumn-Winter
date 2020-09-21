package org.bw.newssystem.service.topic.impl;

import java.sql.Connection;
import java.util.List;

import org.bw.newssystem.dao.topic.impl.TopicDaoImpl;
import org.bw.newssystem.pojo.Topic;
import org.bw.newssystem.service.topic.TopicService;

public class TopicServiceImpl implements TopicService {
	
	TopicDaoImpl tdi = new TopicDaoImpl();

	@Override
	public List<Topic> getAllTopic() {
		Connection conn = tdi.getConnection();
		List<Topic> topicList = null;
		
		try {
			
			topicList = tdi.findAllTopic(conn);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			tdi.close(null, null, conn);
		}
		
		
		return  topicList;
	}

	@Override
	public boolean addTopic() {
		boolean boo = false;
		Connection conn = tdi.getConnection();
		
		
		
		return boo;
	}

}
