package com.toleey.bbsmsg.service.msg;

import java.sql.Connection;
import java.util.List;

import com.toleey.bbsmsg.pojo.Message;

public interface MsgService {

	//1.插入短消息，发送短消息
	public int insertMessage(Message message);
	//2.根据用户名查询显示短消息
	public List<Message> showMessage(String sendto);
	//3.删除短消息
	public int delMessage(int msgid);
	//4.更新消息状态
	public int updateState(int msgid);
}
