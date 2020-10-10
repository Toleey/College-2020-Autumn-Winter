package org.bw.newssystem.service.comments;

import java.util.List;

import org.bw.newssystem.pojo.Comments;

public interface CommentsService {
	
	//根据新闻编号查找评论
	public List<Comments> getCommentsByNid(int cnid);
	//新增评论
	public int addComments(Comments comments);
	//根据新闻编号删除评论
	public int delComments(int cnid);
}
