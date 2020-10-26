package org.bw.newssystem.service.topic;

import java.util.List;

import org.bw.newssystem.pojo.Topic;

public interface TopicService {
	//查询
	public List<Topic> getAllTopics ();
	//删除 大于0就等于删除成功了 也可以
	public int removeTopicByTid(int tid);
	//新增
	public int addTopic(Topic topic);
	//查找 根据编号查找主题
	public Topic geTopicByTid(int tid);
	//修改 按主题编号修改主题
	public int  modifyTopicByTid(Topic topic);

}
