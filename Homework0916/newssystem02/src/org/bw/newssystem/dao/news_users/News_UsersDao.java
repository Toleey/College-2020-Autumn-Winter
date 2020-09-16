package org.bw.newssystem.dao.news_users;

import org.bw.newssystem.pojo.News_Users;

/**
 * news_users表数据库接口
 * 
 * **/

public interface News_UsersDao {
	//1.根据用户名查找用户
	public News_Users findUserByUName(String uname ) throws Exception;
	//2.新增用户 一个个参数传太麻烦，直接传对象方便
	public int insertUser(News_Users user) throws Exception;
	
}
