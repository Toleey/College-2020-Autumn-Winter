package org.bw.newssystem.service.comments.impl;

import java.sql.Connection;
import java.util.List;

import org.bw.newssystem.dao.comments.impl.CommentsImpl;
import org.bw.newssystem.pojo.Comments;
import org.bw.newssystem.service.comments.CommentsService;

public class CommentsServiceImpl implements CommentsService {
	CommentsImpl commentsDao = new CommentsImpl();

	@Override
	public List<Comments> getCommentsByNid(int cnid) {
		Connection conn = commentsDao.getConnection();
		List<Comments> commentsList = null;
		try {
			commentsList = commentsDao.findCommentByNid(conn, cnid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			commentsDao.close(null, null, conn);
		}
		return commentsList;
	}

	@Override
	public int addComments(Comments comments) {
		Connection conn = commentsDao.getConnection();
		int line = 0;
		
		try {
			line = commentsDao.insertComment(conn, comments);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			commentsDao.close(null, null, conn);
		}
		
		return line;
	}

	@Override
	public int delComments(int cnid) {
		Connection conn = commentsDao.getConnection();
		int line = 0;
		
		try {
			line = commentsDao.deleteComment(conn, cnid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			commentsDao.close(null, null, conn);
		}
		
		return line;
	}

}
