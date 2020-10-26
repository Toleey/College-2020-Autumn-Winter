package org.bw.newssystem.pojo;

/**
 * 保存或获得主题信息的实体bean
 * **/

public class Topic {
	
	
	private int tid;
	private String tname;
	
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	
	@Override
	public String toString() { //重写为了测试用
		return "Topic [tid=" + tid + ", tname=" + tname + "]";
	}
	
	
	

}
