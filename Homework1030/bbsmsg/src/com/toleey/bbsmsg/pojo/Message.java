package com.toleey.bbsmsg.pojo;

import java.sql.Date;
import java.sql.Timestamp;

public class Message {
	
	private int msgid;
	private String username;
	private String title;
	private String content;
	private int state;
	private String sendto;
	private Timestamp datetime;
	
	
	
	public Message() {
		
	}
	public Message(int msgid, String username, String title, String content, int state, String sendto,
			Timestamp datetime) {
		super();
		this.msgid = msgid;
		this.username = username;
		this.title = title;
		this.content = content;
		this.state = state;
		this.sendto = sendto;
		this.datetime = datetime;
	}
	public int getMsgid() {
		return msgid;
	}
	public void setMsgid(int msgid) {
		this.msgid = msgid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getSendto() {
		return sendto;
	}
	public void setSendto(String sendto) {
		this.sendto = sendto;
	}
	public Timestamp getDatetime() {
		return datetime;
	}
	public void setDatetime(Timestamp datetime) {
		this.datetime = datetime;
	}
	
	
	

}
