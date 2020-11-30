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
    //public List<User> findUserList() throws Exception;//名字需要与xml里面的相同
    /**
     *
     * @param from
     * @param pageSize
     * @return
     * @throws Exception
     */
    public List<User> findUserList(
            @Param("from") Integer from,
            @Param("pageSize") Integer pageSize
    ) throws Exception;//名字需要与xml里面的相同


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
    //查询各种角色的用户详细信息(传值为数组),不使用子查询
    public List<User> findUserListByUserRole_Array(Integer []ids) throws Exception;
    //查询各种角色的用户详细信息(传值为列表),不使用子查询
    public List<User> findUserListByUserRole_List(List<Integer> idsList) throws Exception;
    //查询各种角色某个性别的用户详细信息(传值为Mao),不使用自查询
    public List<User> findUserListByUserRoleAndGender(Map<String,Object> condition) throws Exception;
    //查询角色名称为‘经理’和‘普通员工’的所有用户信息
    public List<User> findUserByRoleName(Map<String,Object> userMap) throws Exception;
    //查询角色名称为‘经理’和‘普通员工’的所有男用户信息
    public List<User> findUserByRoleNameAndGender(Map<String,Object> userMap) throws  Exception;
    //根据用户名称(模糊)、用户的注册时间范围，查询用户表中所有信息(用户类型输入的是中文也就是管理员、经理、普通员工)
    public List<User> findUserListByUname_CDate_Role(Map<String,Object> conditionMap) throws Exception;
    //根据用户名称(模糊)、用户的注册时间范围(输入项是老员工(5年以上)，中员工(3年以上),新员工(1年以内))，查询用户表中所有信息(输入橘色id)
    public List<User> findUserListByUName_CDateScope_Role(Map<String,Object> conditionMap) throws Exception;
}
