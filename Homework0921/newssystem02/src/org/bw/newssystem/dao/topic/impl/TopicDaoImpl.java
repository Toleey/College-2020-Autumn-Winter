package org.bw.newssystem.dao.topic.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.bw.newssystem.dao.BaseDao;
import org.bw.newssystem.dao.topic.TopicDao;
import org.bw.newssystem.pojo.Topic;

public class TopicDaoImpl extends BaseDao implements TopicDao {

	@Override
	public List<Topic> findAllTopic(Connection conn) throws Exception {
		String sql = "SELECT * FROM TOPIC";
		ResultSet rst =  execQuery(sql);
		List<Topic> topicList = new ArrayList<Topic>();
		while (rst.next()) {
			Topic topic = new Topic();
			
			topic.setTid(rst.getInt("tid"));
			topic.setTname(rst.getString("tname"));
			
			topicList.add(topic);
		}
		
		
		return topicList;
	}

	@Override
	public int insertTopic(Connection conn, String tname) throws Exception {
		String sql = "INSERT INTO TOPIC (tname) VALUES ('?') ";
		int line = execUpdate(sql, tname);
		return line;
	}

	@Override
	public boolean updateTopic(Connection conn, String tname) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteTopic(Connection conn, String tname) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
