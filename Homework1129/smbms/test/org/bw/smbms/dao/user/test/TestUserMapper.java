package org.bw.smbms.dao.user.test;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.bw.smbms.dao.address.test.TestAddressMapper;
import org.bw.smbms.dao.user.UserMapper;
import org.bw.smbms.entity.User;
import org.bw.smbms.util.MyBatisUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestUserMapper {

	Logger logger = Logger.getLogger(TestAddressMapper.class);
	@Test
	public void testFindUserCount() {

			//创建一个和数据库会话
			SqlSession session = MyBatisUtil.sqlSessionFactory.openSession();
			//通过SqlSession实例直接运行映射的SQL语句
			//int line = session.selectOne("org.bw.smbms.dao.user.findUserCount");
			//基于Mapper接口方式操作数据
		int line = 0;
		try {
			line = session.getMapper(UserMapper.class).findUserCount();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println("注册用户人数:"+line);
			logger.info("注册用户人数:"+line);
			logger.error("注册用户人数:"+line);
			logger.debug("注册用户人数:"+line);
		
	}

//	@Test
//	public void testFindUserList(){
//		SqlSession session = MyBatisUtil.sqlSessionFactory.openSession();
//		//第一种方法 通过SqlSession实例直接运行映射的SQL语句
////		List<User> userList =  session.selectList("org.bw.smbms.dao.user.findUserList");
////		//System.out.println(userList);
////		logger.info(userList);
//
//		//第二种方法 基于Mapper接口方式操作数据
//		try {
//			List<User> userList = session.getMapper(UserMapper.class).findUserList();
//			System.out.println("userList"+userList);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//
//		session.close();
//	}

	@Test
	public void testFindUserList(){
		SqlSession session = MyBatisUtil.sqlSessionFactory.openSession();
		//第一种方法 通过SqlSession实例直接运行映射的SQL语句
//		List<User> userList =  session.selectList("org.bw.smbms.dao.user.findUserList");
//		//System.out.println(userList);
//		logger.info(userList);

		//第二种方法 基于Mapper接口方式操作数据

		//第几页
		Integer pageCount = 2;
		//一页显示多少行
		Integer pageSize = 3;
		try {
			List<User> userList = session.getMapper(UserMapper.class).findUserList((pageCount-1)*pageSize,pageSize);
			for (User user: userList) {
				logger.info(user);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}


		session.close();
	}

	@Test
	public void testFindUsersByDimName(){
		SqlSession session = MyBatisUtil.sqlSessionFactory.openSession();
		try {
			List<User> userList = session.getMapper(UserMapper.class).findUsersByDimName("王");
			System.out.println(userList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
	}

	@Test
	public void findUsersByDimNameAndUserRole(){
		SqlSession session = MyBatisUtil.sqlSessionFactory.openSession();
		try {
			User user = new User();
			//user.setUserName("孙");
			//user.setUserRole(3);
			List<User> userList = session.getMapper(UserMapper.class).findUsersByDimNameAndUserRole(user);
			System.out.println(userList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
	}

	@Test
	public void findUsersByDimNameAndUserRoleMap(){
		SqlSession session = MyBatisUtil.sqlSessionFactory.openSession();
		try {
			Map<String,Object> userMap = new HashMap<String,Object>();
			userMap.put("userName","孙");
			userMap.put("userRole",3);
			List<User> userList = session.getMapper(UserMapper.class).findUsersByDimNameAndUserRoleMap(userMap);
			System.out.println(userList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
	}

	@Test
	public void findUsersAndRoleByDimNameAndUserRole(){
		SqlSession session = MyBatisUtil.sqlSessionFactory.openSession();
		try {
			List<User> userList = session.getMapper(UserMapper.class).findUsersAndRoleByDimNameAndUserRole("孙",3);
			//System.out.println(userList);
			//logger.info(userList);
			for(User user:userList){
				logger.info(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
	}

	@Test
	public void testInsertUser(){
		//SqlSessiong默认非自动提交事物
		SqlSession session = MyBatisUtil.sqlSessionFactory.openSession(true);//默认情况下是false，非自动提交事物
		User user = new User();
		user.setUserCode("Ty");
		user.setUserName("Toby");
		user.setUserPassword("123456");
		user.setGender(1);
		try {
			int line = session.getMapper(UserMapper.class).insertUser(user);
			//session.commit(); 不写true的时候用这个
			System.out.println(line);
			if (line>0){
				logger.info("新增"+user.getUserName()+"成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();

	}

	@Test
	public void testUpdateUserById(){
		SqlSession session = MyBatisUtil.sqlSessionFactory.openSession();
		User user = new User();
		user.setId(20);
		user.setUserName("Tim");
		user.setUserCode("TC");
		user.setUserPassword("Tc1984");

		try {
			int line = session.getMapper(UserMapper.class).updateUserById(user);
			session.commit();
			logger.info(line);
			if (line>0){
				logger.info("修改"+user.getUserName()+"成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
	}

	@Test
	public void testUpdateUserPassword(){
		SqlSession session = MyBatisUtil.sqlSessionFactory.openSession();

		try {
			int line = session.getMapper(UserMapper.class).updateUserPassword("666",18);
			session.commit();
			logger.info(line);
			if (line>0){
				logger.info("修改成功");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();

	}

	@Test
	public void testDeleteUser(){
		SqlSession session = MyBatisUtil.sqlSessionFactory.openSession();
		try {
			int line = session.getMapper(UserMapper.class).deleterUser(18);
			session.commit();
			logger.info(line);
			if (line>0){
				logger.info("删除成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();

	}
	@Test
	public void testFindUserAndRoleOfUser(){
		SqlSession session = MyBatisUtil.sqlSessionFactory.openSession();
		try {
			List<User> userRoleList = session.getMapper(UserMapper.class).findUserAndRoleOfUser();
			for (User user:userRoleList) {
				logger.info(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
	}

	@Test
	public void testFindUserAndSendAddressOfUser(){
		SqlSession session = MyBatisUtil.sqlSessionFactory.openSession();

		try {
			List<User> userList = session.getMapper(UserMapper.class).findUserAndSendAddressOfUser();
			for (User user: userList) {
				logger.info(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
	}

	@Test
	public void testFindUserListByUserRole_Array(){
		SqlSession session = MyBatisUtil.sqlSessionFactory.openSession();

		try {
			Integer ids[] ={2,3};
			List<User> userList = session.getMapper(UserMapper.class).findUserListByUserRole_Array(ids);
			for (User user:userList){
				logger.info(user);
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		session.close();
	}

	@Test
	public void testFindUserListByUserRole_List(){
		SqlSession session = MyBatisUtil.sqlSessionFactory.openSession();

		try {
			List<Integer> idsList = new ArrayList<>();
			idsList.add(2);
			idsList.add(3);


			List<User> userList = session.getMapper(UserMapper.class).findUserListByUserRole_List(idsList);
			for (User user:userList){
				logger.info(user);
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		session.close();
	}

	@Test
	public void testFindUserListByUserRoleAndGender(){
		SqlSession session = MyBatisUtil.sqlSessionFactory.openSession();

		Map<String,Object> conditionMap = new HashMap<String,Object>();
		conditionMap.put("gender",1); //性别 为1
		List<Integer> roleIdList = new ArrayList<>();
		roleIdList.add(2); //角色为2
		roleIdList.add(3); //角色为3
		conditionMap.put("roleIdList",roleIdList);

		try {
			List<User> userList = session.getMapper(UserMapper.class).findUserListByUserRoleAndGender(conditionMap);
			for (User user:userList){
				logger.info(user);
			}


		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();


	}

	@Test
	public void testFindUserByRoleName(){
		SqlSession session = MyBatisUtil.sqlSessionFactory.openSession();

		try {
			Map<String,Object> userMap = new HashMap<String,Object>();
			List<String> roleList = new ArrayList<>();
			roleList.add("经理");
			roleList.add("系统管理员");
			userMap.put("roleList",roleList);
			List<User> userList = session.getMapper(UserMapper.class).findUserByRoleName(userMap);
			for (User user:userList){
				logger.info(user);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();

	}

	@Test
	public void testFindUserByRoleNameAndGender(){
		SqlSession session = MyBatisUtil.sqlSessionFactory.openSession();

		try {
			Map<String,Object> userMap = new HashMap<String,Object>();

			List<String> roleList = new ArrayList<>();
			roleList.add("经理");
			roleList.add("系统管理员");

			userMap.put("roleList",roleList);
			userMap.put("gender",1);//男
			List<User> userList = session.getMapper(UserMapper.class).findUserByRoleName(userMap);
			for (User user:userList){
				logger.info(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();

	}

	@Test
	public  void testFindUserListByUname_CDate_Role(){
		SqlSession session = MyBatisUtil.sqlSessionFactory.openSession();
		try {

			Map<String,Object> conditionMap = new HashMap<String,Object>();
			conditionMap.put("userName","孙");
			conditionMap.put("creationDate","2016-01-01");
			conditionMap.put("userRole","普通员工");

			List<User> userList = session.getMapper(UserMapper.class).findUserListByUname_CDate_Role(conditionMap);
			for (User user:userList){
				logger.info(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();

	}


}
