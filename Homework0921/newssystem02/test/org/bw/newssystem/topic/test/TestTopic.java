package org.bw.newssystem.topic.test;

import org.bw.newssystem.dao.topic.impl.TopicDaoImpl;
import org.bw.newssystem.service.topic.TopicService;
import org.bw.newssystem.service.topic.impl.TopicServiceImpl;
import org.junit.jupiter.api.Test;

public class TestTopic {
	
	TopicService ts = new TopicServiceImpl();
	
	@Test
	public void testFindAllTopic() {
		System.out.println(ts.getAllTopic());
	}

}
