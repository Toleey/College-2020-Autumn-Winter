package org.bw.newssystem.dao.topic;

import java.sql.Connection;
import java.util.List;

import org.bw.newssystem.pojo.Topic;

/**
 * 对Topic表的数据库操作
 * 
 * */

public interface TopicDao {
	//查询所有新闻主题
	public List<Topic> findAllTopics(Connection conn) throws Exception;
	//删除某个新闻主题 先返回int(删除的行数)，业务再boolean
	public int delTopicByTid(Connection conn,int tid) throws Exception;
	//新增单个新闻主题 直接传topic如果后期字段增多就不用再修改了
	public int insertTopic(Connection conn,Topic topic) throws Exception;
	//根据主题名查主题
	public Topic findTopicByTName(Connection conn,String tname) throws Exception;
	
}
