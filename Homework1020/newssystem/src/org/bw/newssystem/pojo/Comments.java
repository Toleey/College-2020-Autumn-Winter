package org.bw.newssystem.pojo;

import java.util.Date;

public class Comments {
	
	private int cid;
	private int cnid;
	private String ccontent;
	private Date cdate;
	private String cip;
	private String cauthor;
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getCnid() {
		return cnid;
	}
	public void setCnid(int cnid) {
		this.cnid = cnid;
	}
	public String getCcontent() {
		return ccontent;
	}
	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
	}
	public Date getCdate() {
		return cdate;
	}
	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}
	public String getCip() {
		return cip;
	}
	public void setCip(String cip) {
		this.cip = cip;
	}
	public String getCauthor() {
		return cauthor;
	}
	public void setCauthor(String cauthor) {
		this.cauthor = cauthor;
	}
	
	@Override
	public String toString() {
		return "Comments [cid=" + cid + ", cnid=" + cnid + ", ccontent=" + ccontent + ", cdate=" + cdate + ", cip="
				+ cip + ", cauthor=" + cauthor + "]";
	}
	
	

}
