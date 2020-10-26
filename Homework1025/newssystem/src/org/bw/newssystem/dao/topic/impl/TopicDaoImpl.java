package org.bw.newssystem.dao.topic.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.bw.newssystem.dao.BaseDao;
import org.bw.newssystem.dao.topic.TopicDao;
import org.bw.newssystem.pojo.Topic;

public class TopicDaoImpl extends BaseDao implements TopicDao {

	@Override //找全部的topic
	public List<Topic> findAllTopics(Connection conn) throws Exception {
		String sql = "SELECT * FROM TOPIC";
		ResultSet rst = execQuery(sql);//用的可变参数，有也行，没有也也行
		List<Topic> topicList = new ArrayList<Topic>();
		while (rst.next()) {
			Topic topic = new Topic();
			topic.setTid(rst.getInt("tid"));
			topic.setTname(rst.getString("tname"));
			topicList.add(topic);
		}
		return topicList;
	}

	@Override //依据tid删除topic
	public int delTopicByTid(Connection conn, int tid) throws Exception {
		String sql="DELETE From Topic WHERE tid=?";
		int line= execUpdate(sql, tid);
		return line;
	}

	@Override //插入topic
	public int insertTopic(Connection conn, Topic topic) throws Exception {
		String sql = "INSERT INTO TOPIC (tname) VALUES (?)";
		int line = execUpdate(sql, topic.getTname());
		return line;//返回影响的行数
	}

	@Override //依据tname查topic
	public Topic findTopicByTname(Connection con, String tname) throws Exception {
		String sql="SELECT * FROM TOPIC WHERE tname=?";
		ResultSet rst= this.execQuery(sql, tname);
		Topic topic=null;
		//结果集如果有记录的话
		if(rst.next()) {
			topic=new Topic();
			topic.setTid(rst.getInt("tid"));
			topic.setTname(rst.getString("tname"));
		}
		return topic;
	}

	@Override //依据tid查topic
	public Topic findTopicByTid(Connection conn, int tid) throws Exception {
		String sql="SELECT * FROM TOPIC WHERE tid=?";
		ResultSet rst= this.execQuery(sql, tid);
		Topic topic=null;
		//结果集如果有记录的话
		if(rst.next()) {
			topic=new Topic();
			topic.setTid(rst.getInt("tid"));
			topic.setTname(rst.getString("tname"));
		}
		return topic;
	}

	@Override
	public int updateTopicByTid(Connection conn, Topic topic) throws Exception {
		String sql = "UPDATE TOPIC SET tname = ? where tid = ?";
		int line = this.execUpdate(sql, topic.getTname(),topic.getTid());//有先后顺序
		return line;
	}
	

}
