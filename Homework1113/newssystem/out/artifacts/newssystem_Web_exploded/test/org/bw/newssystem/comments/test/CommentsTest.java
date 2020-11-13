package org.bw.newssystem.comments.test;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.bw.newssystem.dao.comments.impl.CommentsImpl;
import org.bw.newssystem.pojo.Comments;
import org.junit.Test;


public class CommentsTest {

	@Test
	public void commentsTest() {
		CommentsImpl commentsImpl = new CommentsImpl();
		Connection conn = commentsImpl.getConnection();
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.getDefault());
		Date cdate = new Date(System.currentTimeMillis());
		
		Comments comments = new Comments();
		
		comments.setCauthor("哈哈");
		comments.setCip("2.2.2.2");
		comments.setCcontent("挥洒的护发素");
		comments.setCnid(73);
		//comments.setCdate(System.currentTimeMillis());
		
		//commentsImpl.insertComment(conn, comments);
		
	}
}
