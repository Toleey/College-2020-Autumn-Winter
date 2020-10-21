package org.bw.newssystem.dao.comments.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.bw.newssystem.dao.BaseDao;
import org.bw.newssystem.dao.comments.CommentsDao;
import org.bw.newssystem.pojo.Comments;


public class CommentsImpl extends BaseDao implements CommentsDao {

	@Override
	public List<Comments> findCommentByNid(Connection conn,int cnid) throws Exception {
		String sql = "SELECT * FROM COMMENTS WHERE cnid = ?";
		ResultSet rst = this.execQuery(sql, cnid);
		List<Comments> commentsList = new ArrayList<Comments>();
		Comments comment = null;
		while (rst.next()) {
			comment = new Comments();
			comment.setCid(rst.getInt("cid"));
			comment.setCnid(rst.getInt("cnid"));
			comment.setCcontent(rst.getString("ccontent"));
			comment.setCdate(rst.getDate("cdate"));
			comment.setCip(rst.getString("cip"));
			comment.setCauthor(rst.getString("cauthor"));
			
			commentsList.add(comment);
		}
		close(rst, null, null);
		return commentsList;
	}

	@Override
	public int insertComment(Connection conn ,Comments comments) throws Exception {
		String sql = "INSERT INTO COMMENTS (cid,cnid,ccontent,cdate,cip,cauthor) VALUES (?,?,?,?,?,?)";
		int line = this.execUpdate(sql, comments.getCid(),comments.getCnid(),comments.getCcontent(),comments.getCdate(),comments.getCip(),comments.getCauthor());
		return line;
	}

	@Override
	public int deleteComment(Connection conn, int cnid) throws Exception {
		String sql = "DELETE FROM COMMENTS WHERE cnid = ?";
		int line = this.execUpdate(sql, cnid);
		return line;
	}

}
