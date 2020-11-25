package org.bw.smbms.dao.user.test;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.bw.smbms.dao.address.test.TestAddressMapper;
import org.bw.smbms.dao.user.UserMapper;
import org.bw.smbms.entity.User;
import org.bw.smbms.util.MyBatisUtil;
import org.junit.Test;

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

	@Test
	public void testFindUserList(){
		SqlSession session = MyBatisUtil.sqlSessionFactory.openSession();
		//第一种方法 通过SqlSession实例直接运行映射的SQL语句
//		List<User> userList =  session.selectList("org.bw.smbms.dao.user.findUserList");
//		//System.out.println(userList);
//		logger.info(userList);

		//第二种方法 基于Mapper接口方式操作数据
		try {
			List<User> userList = session.getMapper(UserMapper.class).findUserList();
			System.out.println("userList"+userList);

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

}
