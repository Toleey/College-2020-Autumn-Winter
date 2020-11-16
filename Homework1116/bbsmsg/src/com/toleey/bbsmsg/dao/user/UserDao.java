package com.toleey.bbsmsg.dao.user;

import java.sql.Connection;
import java.util.List;

import com.toleey.bbsmsg.pojo.User;

public interface UserDao {

	// 1.根据用户名查找用户
	public User findUserByUserName(Connection conn, String userName) throws Exception;

	// 2.新增用户
	public int insertUser(Connection conn, User user) throws Exception;
	
	// 3.查找所有用户
	public List<User> findAllUser(Connection conn) throws Exception;

}
