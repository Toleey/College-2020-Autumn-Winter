package org.bw.newssystem.pojo;

public class News_Users {
	
		private int uid;
		private String uname;
		private String upwd;
		
		
		
		
		public News_Users() {
			
			
		}
		public News_Users(int uid, String uname, String upwd) {
			
			this.uid = uid;
			this.uname = uname;
			this.upwd = upwd;
		}
		
		public int getUid() {
			return uid;
		}
		public void setUid(int uid) {
			this.uid = uid;
		}
		public String getUname() {
			return uname;
		}
		public void setUname(String uname) {
			this.uname = uname;
		}
		public String getUpwd() {
			return upwd;
		}
		public void setUpwd(String upwd) {
			this.upwd = upwd;
		}
		
		@Override
		public String toString() {
			return "News_Users [uid=" + uid + ", uname=" + uname + ", upwd=" + upwd + "]";
		}
		
		
		
		
	
	
}
