package com.toleey.bbsmsg.service.msg.impl;

import java.sql.Connection;
import java.util.List;

import com.toleey.bbsmsg.dao.msg.impl.MsgDaoImpl;
import com.toleey.bbsmsg.pojo.Message;
import com.toleey.bbsmsg.service.msg.MsgService;

public class MsgServiceImpl implements MsgService{
	MsgDaoImpl msgDao = new MsgDaoImpl();
	

	@Override
	public int insertMessage(Message message) {
		Connection conn = msgDao.getConnection();
		int line = 0;
		try {
			
			line = msgDao.insertMessage(conn, message);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			msgDao.closeDB(null, null, conn);
		}
		
		return line;
	}

	@Override
	public List<Message> showMessage(String sendto) {
		Connection conn = msgDao.getConnection();
		List<Message> messageList = null;
		
		try {
			messageList = msgDao.findAllMessage(conn,sendto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			msgDao.closeDB(null, null, conn);
		}
		
		return messageList;
	}

	@Override
	public int delMessage(int msgid) {
		Connection conn = msgDao.getConnection();
		int line = 0;
		try {
			line = msgDao.delMessage(conn, msgid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			msgDao.closeDB(null, null, conn);
		}
		return line;
	}

	@Override
	public int updateState(int msgid) {
		Connection conn = msgDao.getConnection();
		int line = 0;
		try {
			line = msgDao.updateState(conn, msgid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			msgDao.closeDB(null, null, conn);
		}
		return line;
	}

}
