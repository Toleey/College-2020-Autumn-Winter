package org.bw.newssystem.pojo;

import java.util.Date;

/**
 * 新闻实体Bean
 * **/

public class News {
	
	private int nid;    		//新闻编号
	private int ntid;			//新闻主题
	private String ntitle;		//新闻标题
	private String nauthor;		//新闻作者
	private Date ncreateDate; 	//新闻创建时间
	private String npicPath;	//新闻图片路径
	private String ncontent;	//新闻内容
	private Date nmodifyDate;	//新闻修改时间
	private String nsummary;	//新闻概要
	
	
	public int getNid() {
		return nid;
	}
	public void setNid(int nid) {
		this.nid = nid;
	}
	public int getNtid() {
		return ntid;
	}
	public void setNtid(int ntid) {
		this.ntid = ntid;
	}
	public String getNtitle() {
		return ntitle;
	}
	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}
	public String getNauthor() {
		return nauthor;
	}
	public void setNauthor(String nauthor) {
		this.nauthor = nauthor;
	}
	public Date getNcreateDate() {
		return ncreateDate;
	}
	public void setNcreateDate(Date ncreateDate) {
		this.ncreateDate = ncreateDate;
	}
	public String getNpicPath() {
		return npicPath;
	}
	public void setNpicPath(String npicPath) {
		this.npicPath = npicPath;
	}
	public String getNcontent() {
		return ncontent;
	}
	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}
	public Date getNmodifyDate() {
		return nmodifyDate;
	}
	public void setNmodifyDate(Date nmodifyDate) {
		this.nmodifyDate = nmodifyDate;
	}
	public String getNsummary() {
		return nsummary;
	}
	public void setNsummary(String nsummary) {
		this.nsummary = nsummary;
	}
	
	@Override
	public String toString() {
		return "News [nid=" + nid + ", ntid=" + ntid + ", ntitle=" + ntitle + ", nauthor=" + nauthor + ", ncreateDate="
				+ ncreateDate + ", npicPath=" + npicPath + ", ncontent=" + ncontent + ", nmodifyDate=" + nmodifyDate
				+ ", nsummary=" + nsummary + "]";
	}
	
	
	

}
