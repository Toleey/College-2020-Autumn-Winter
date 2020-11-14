package com.toleey.bbsmsg.dao.msg;

import java.sql.Connection;
import java.util.List;

import com.toleey.bbsmsg.pojo.Message;

public interface MsgDao {
	
	//1.添加短消息
	public int insertMessage(Connection conn,Message message) throws Exception;
	//2.根据用户名获取当前消息
	public List<Message> findAllMessage(Connection conn,String sendto) throws Exception;
	//3.删除消息
	public int delMessage(Connection conn,int msgid) throws Exception;
	//4.修改消息状态
	public int updateState(Connection conn,int msgid) throws Exception;

}
