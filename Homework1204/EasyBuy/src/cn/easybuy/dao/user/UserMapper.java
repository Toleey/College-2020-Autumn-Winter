package cn.easybuy.dao.user;

import java.util.List;

import cn.easybuy.dao.IBaseDao;
import cn.easybuy.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends IBaseDao {
	
	int add(User user) throws Exception;//新增用户信息

	int update(User user) throws Exception;//更新用户信息

	public int deleteUserById(String id) throws Exception;

	/**
	 *
	 * @param currentPageNo
	 * @param pageSize	当前页的记录
	 * @return
	 * @throws Exception
	 */
	public List<User> getUserList(@Param("currentPageNo") Integer currentPageNo, @Param("pageSize") Integer pageSize)throws Exception;

	/**
	 * 功能：获得用户的总数
	 * @return
	 * @throws Exception
	 */
	public Integer count() throws Exception;
	
	public User getUser(@Param("id") Integer id,@Param("loginName") String loginName) throws Exception;

}
