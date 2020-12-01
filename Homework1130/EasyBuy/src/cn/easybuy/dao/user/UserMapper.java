package cn.easybuy.dao.user;

import java.util.List;

import cn.easybuy.entity.User;

public interface UserMapper {
	
	int add(User user) throws Exception;//新增用户信息

	int update(User user) throws Exception;//更新用户信息

	public int deleteUserById(String id) throws Exception;
	
	public List<User> getUserList(Integer currentPageNo,Integer pageSize)throws Exception;
	
	public Integer count() throws Exception;
	
	public User getUser(Integer id,String loginName) throws Exception;

}
