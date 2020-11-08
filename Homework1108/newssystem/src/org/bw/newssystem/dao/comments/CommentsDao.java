package org.bw.newssystem.dao.comments;

import java.sql.Connection;
import java.util.List;

import org.bw.newssystem.pojo.Comments;

public interface CommentsDao {
	
	// 根据新闻编号查找评论
	public List<Comments> findCommentByNid(Connection conn,int nid) throws Exception;
	// 新增评论
	public int insertComment (Connection conn ,Comments comments) throws Exception;
	//根据新闻编号删除评论
	public int deleteComment(Connection conn , int cnid) throws Exception;

}
