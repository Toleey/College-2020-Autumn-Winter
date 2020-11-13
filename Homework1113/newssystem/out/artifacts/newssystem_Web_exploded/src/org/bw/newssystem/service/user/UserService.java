package org.bw.newssystem.service.user;
/**
 * 处理用户数据业务逻辑的接口
 * **/

public interface UserService {
	//注册业务
	/**
	 * 注册
	 * @param uname 用户名
	 * @param upwd 密码
	 * @return 注册是否成功
	 * **/
	public boolean regist(String uname,String upwd);
	//登陆业务
	/**
	 * @param uname 用户名
	 * @param upwd 密码
	 * @return 登陆是否成功
	 * int 1 登陆成功 2 密码错误 3 用户名错误
	 * **/
	public boolean login(String uname,String upwd);
	
	
	
}
