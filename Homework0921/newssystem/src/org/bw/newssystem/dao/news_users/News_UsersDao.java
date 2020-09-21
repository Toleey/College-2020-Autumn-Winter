package org.bw.newssystem.dao.news_users;

import java.sql.Connection;

import org.bw.newssystem.pojo.News_Users;

/**
 * news_users表数据库接口
 * 
 * **/

public interface News_UsersDao {
	//1.根据用户名查找用户
	/**
	 * 查找某个用户名的用户数据，返回null表示不存在
	 * **/
	//连接connectino必须在业务中做，在业务建连接，不能在数据库交互时做
	public News_Users findUserByUName(Connection conn, String uname ) throws Exception;
	//2.新增用户 一个个参数传太麻烦，直接传对象方便
	public int insertUser(Connection conn,News_Users user) throws Exception;//throws这里没必要处理异常，引发trycatch处理异常
	
}
