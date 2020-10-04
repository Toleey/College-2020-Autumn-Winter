package org.bw.newssystem.service.comments;

import java.util.List;

import org.bw.newssystem.pojo.Comments;

public interface CommentsService {
	
	//根据新闻编号查找评论
	public List<Comments> getCommentsByNid(int cnid);
}
