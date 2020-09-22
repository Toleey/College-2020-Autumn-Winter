package org.bw.newssystem.dao.topic.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.bw.newssystem.dao.BaseDao;
import org.bw.newssystem.dao.topic.TopicDao;
import org.bw.newssystem.pojo.News_Users;
import org.bw.newssystem.pojo.Topic;

public class TopicDaoImpl extends BaseDao implements TopicDao {

	@Override
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

	@Override
	public int delTopicByTid(Connection conn, int tid) throws Exception {
		String sql = "DELETE FROM TOPIC WHERE tid = ?";
		int line = execUpdate(sql, tid);
		return line;
	}

	@Override
	public int insertTopic(Connection conn, Topic topic) throws Exception {
		String sql = "INSERT INTO TOPIC (tname) VALUES (?)";
		int line = execUpdate(sql, topic.getTname());
		return line;//返回影响的行数
	}

	@Override
	public Topic findTopicByTName(Connection conn, String tname) throws Exception {
        //建立数据库连接
        String sql = "SELECT * FROM TOPIC WHERE tname = ? ";
        ResultSet rst = execQuery(sql,tname);
        //把数据库查出来的数据转换成java对象 一般都查一个，所以不用循环了
        Topic topic = null;
        if(rst.next()) {
        	topic = new Topic();
        	
        	topic.setTid(rst.getInt("tid"));
			topic.setTname(rst.getString("tname"));
			
        }
        close(rst, null, null);
        return topic;
    }

}
