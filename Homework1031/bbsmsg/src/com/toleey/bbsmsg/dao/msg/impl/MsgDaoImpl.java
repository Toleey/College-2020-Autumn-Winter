package com.toleey.bbsmsg.dao.msg.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.toleey.bbsmsg.dao.BaseDao;
import com.toleey.bbsmsg.dao.msg.MsgDao;
import com.toleey.bbsmsg.pojo.Message;

public class MsgDaoImpl extends BaseDao implements MsgDao {

	@Override
	public int insertMessage(Connection conn, Message message) throws Exception {
		String sql = "INSERT INTO msg(username,title,msgcontent,state,sendto,msg_create_date) VALUES (?,?,?,?,?,?)";
		int line = execUpdate(sql, message.getUsername(),message.getTitle(),message.getContent(),message.getState(),message.getSendto(),message.getDatetime());
		return line;
	}

	@Override
	public List<Message> findAllMessage(Connection conn,String sendto) throws Exception {
		String sql = "SELECT * FROM msg WHERE sendto = ? ";
		ResultSet rst = execQuery(sql,sendto);
		List<Message> messageList = new ArrayList<Message>();
		while (rst.next()) {
			Message temMessage = new Message();
			temMessage.setMsgid(rst.getInt("msgid"));
			temMessage.setUsername(rst.getString("username"));
			temMessage.setTitle(rst.getString("title"));
			temMessage.setContent(rst.getString("msgcontent"));
			temMessage.setState(rst.getInt("state"));
			temMessage.setSendto(rst.getString("sendto"));
			temMessage.setDatetime(rst.getTimestamp("msg_create_date"));
			messageList.add(temMessage);
			
		}
		return messageList;
	}

	@Override
	public int delMessage(Connection conn, int msgid) throws Exception {
		String sql = "DELETE FROM msg WHERE msgid = ?";
		int line = execUpdate(sql,msgid) ;
		return line;
	}

	@Override
	public int updateState(Connection conn, int msgid) throws Exception {
		String sql ="UPDATE msg SET state = 1 WHERE msgid = ?";
		int line = execUpdate(sql, msgid);
		return line;
	}

}
