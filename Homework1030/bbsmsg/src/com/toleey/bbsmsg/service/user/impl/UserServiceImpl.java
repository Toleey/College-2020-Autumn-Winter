package com.toleey.bbsmsg.service.user.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.toleey.bbsmsg.dao.user.impl.UserDaoImpl;
import com.toleey.bbsmsg.pojo.User;
import com.toleey.bbsmsg.service.user.UserService;

public class UserServiceImpl implements UserService  {
	UserDaoImpl userdao = new UserDaoImpl();
	

	@Override //0登陆失败 1登陆成功 temUser,临时User
	public int login(User user) {
		Connection conn = userdao.getConnection();
		int islogin = 0;	
		User temUser = null;
		try {
			temUser = userdao.findUserByUserName(conn, user.getUsername());
			if (temUser != null) {
				if (user.getPassword().equals(temUser.getPassword())) {
					islogin = 1;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			userdao.closeDB(null, null, conn);
		}
		return islogin;
	}

	@Override
	public int signup(User user) {
		Connection conn = userdao.getConnection();
		int isSignup = 0;
		try {
			conn.setAutoCommit(false);
			User temUser = userdao.findUserByUserName(conn, user.getUsername());
			if (temUser == null) {
				isSignup = userdao.insertUser(conn, user);
			}
			conn.commit(); 
			conn.setAutoCommit(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			try {
				
				conn.rollback();
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}finally {
			userdao.closeDB(null, null, conn);
		}
		
		return isSignup;
	}

	@Override
	public List<User> getAllUser() {
		Connection conn = userdao.getConnection();
		List<User> userList = null;
		try {
			
			userList = userdao.findAllUser(conn);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			userdao.closeDB(null, null, conn);
		}
		
		return userList;
	}



}
