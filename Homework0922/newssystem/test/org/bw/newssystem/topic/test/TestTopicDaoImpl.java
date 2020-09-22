package org.bw.newssystem.topic.test;

import java.sql.Connection;

import org.bw.newssystem.dao.topic.TopicDao;
import org.bw.newssystem.dao.topic.impl.TopicDaoImpl;

public class TestTopicDaoImpl {
	
	TopicDaoImpl td = new TopicDaoImpl();
	
	public void testTDI() {
		Connection conn = td.getConnection();
		int tid = 0;
		try {
			td.delTopicByTid(conn, tid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
