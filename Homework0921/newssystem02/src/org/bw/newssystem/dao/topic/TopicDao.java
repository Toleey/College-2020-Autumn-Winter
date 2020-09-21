package org.bw.newssystem.dao.topic;

import java.sql.Connection;
import java.util.List;

import org.bw.newssystem.pojo.News_Users;
import org.bw.newssystem.pojo.Topic;

public interface TopicDao {

	//查询所有主题
	public List<Topic> findAllTopic(Connection conn) throws Exception;
	
	
	//查询单个主题
	public Topic findTopicByUName(Connection conn, String uname ) throws Exception;
	//添加主题
	public int insertTopic(Connection conn,String tname) throws Exception;
	
	//修改主题
	public boolean updateTopic(Connection conn,String tname) throws Exception;
	//删除主题
	public boolean deleteTopic(Connection conn,String tname) throws Exception;
}
