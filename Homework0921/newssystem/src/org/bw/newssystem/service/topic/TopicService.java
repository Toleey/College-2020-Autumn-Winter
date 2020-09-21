package org.bw.newssystem.service.topic;

import java.util.List;

import org.bw.newssystem.pojo.Topic;

public interface TopicService {
	
	public List<Topic> getAllTopic();
	public boolean addTopic();

}
