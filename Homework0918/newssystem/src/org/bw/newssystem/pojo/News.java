package org.bw.newssystem.pojo;

public class News {
	
	private int nid;
	private int ntid;
	private String ntitle;
	private String nauthor;
	private String ncreateDate;
	private String npicPath;
	private String ncontent;
	private String nmodifyDate;
	private String nsummary;
	
	
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
	public String getNcreateDate() {
		return ncreateDate;
	}
	public void setNcreateDate(String ncreateDate) {
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
	public String getNmodifyDate() {
		return nmodifyDate;
	}
	public void setNmodifyDate(String nmodifyDate) {
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
