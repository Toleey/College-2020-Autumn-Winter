package com.toleey.bbsmsg.service.user;

import java.util.List;

import com.toleey.bbsmsg.pojo.User;

public interface UserService {

	//登陆
	public int login (User user) ;
	//注册
	public int signup (User user) ;
	//查询用户名
	public List<User> getAllUser();
}
