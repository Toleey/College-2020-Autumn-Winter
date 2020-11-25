package org.bw.smbms.dao.user;

import org.apache.ibatis.annotations.Param;
import org.bw.smbms.entity.User;

import java.util.List;
import java.util.Map;

/**
 * 用户表操作接口
 * */
public interface UserMapper {
    //查询用户人数
    public int findUserCount() throws Exception;
    //查询所有用户信息
    public List<User> findUserList() throws Exception;//名字需要与xml里面的相同
    //根据姓名进行模糊查询
    public List<User> findUsersByDimName(String name)throws Exception;
    //根据姓名模糊查询并且根据角色编号进行查询
    public List<User> findUsersByDimNameAndUserRole(User user)throws Exception;
    //根据姓名模糊查询并且根据角色编号进行查询(参数是map集合)
    public List<User> findUsersByDimNameAndUserRoleMap(Map userMap)throws Exception;
    //根据姓名模糊查询并且根据角色编号进行查询，要求显示用户表中的用户编号，用户名称，用户性别，用户年龄，用户电话同时还要显示用户角色表中的用户的角色名称
    //public List<User> findUsersAndRoleByDimNameAndUserRole(Map userMap)throws Exception;
    public List<User> findUsersAndRoleByDimNameAndUserRole(
            @Param("userName") String name,
            @Param("userRole") int roleId
    )throws Exception; //少的话用这种，一般的话用Map，全部的话用对象
    //新增用户
    public int insertUser(User user)throws Exception;
    //根据用户编号，修改用户编码，用户名和密码
    public int updateUserById(User user)throws Exception;
    //修改某个用户的密码
    public int updateUserPassword(
            @Param("password") String password, //形参，谁调接谁的值,JAVA的变量  Param里面的是返回类型
            @Param("userId") int id
    )throws Exception;
    //删除某个用户
    public int deleterUser(@Param("userId") int id)throws Exception;
    //联合查询用户拥有一个角色的所有信息
    public List<User> findUserAndRoleOfUser()throws Exception;
    //联合查询拥有多个配送地址的用户信息及其配送地址信息
    public List<User> findUserAndSendAddressOfUser()throws Exception;

}
