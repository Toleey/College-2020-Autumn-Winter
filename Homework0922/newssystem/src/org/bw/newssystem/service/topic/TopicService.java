package org.bw.newssystem.service.topic;

import java.sql.Connection;
import java.util.List;

import org.bw.newssystem.pojo.Topic;

public interface TopicService {
	//查询
	public List<Topic> getAllTopics ();
	//删除 大于0就等于删除成功了 也可以
	public int removeTopicByTid(int tid);
	//新增
	public int addTopic(Topic topic);


}
