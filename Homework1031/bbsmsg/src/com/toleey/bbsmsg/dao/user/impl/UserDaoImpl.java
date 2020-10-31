package com.toleey.bbsmsg.dao.user.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.toleey.bbsmsg.dao.BaseDao;
import com.toleey.bbsmsg.dao.user.UserDao;
import com.toleey.bbsmsg.pojo.User;

public class UserDaoImpl extends BaseDao implements UserDao {	

	@Override
	public User findUserByUserName(Connection conn, String userName) throws Exception {
		String sql = "SELECT  * FROM msg_userinfo WHERE username = ? ";
		ResultSet rst = execQuery(sql, userName);
		User user = null;
		if (rst.next()) {
			user = new User();
			user.setUsername(rst.getString("username"));
			user.setPassword(rst.getString("password"));
			user.setEmail(rst.getString("email"));		
		}
		closeDB(rst, null, null);
		return user;
	}

	@Override
	public int insertUser(Connection conn, User user) throws Exception {
		String sql = "INSERT INTO msg_userinfo (username,password,email) VALUES(?,?,?)";
		int line = 0;
		line = execUpdate(sql,user.getUsername(),user.getPassword(),user.getEmail());
		return line;
	}

	@Override
	public List<User> findAllUser(Connection conn) throws Exception {
		String sql = "SELECT * FROM msg_userinfo";
		ResultSet rst = execQuery(sql);
		List<User> userList = new ArrayList<User>();
		while (rst.next()) {
			User user = new User();
			user.setUsername(rst.getString("username"));
			user.setPassword(rst.getString("password"));
			user.setEmail(rst.getString("email"));
			userList.add(user);
		}
		closeDB(rst, null, null);
		return userList;
	}
	
	

}
