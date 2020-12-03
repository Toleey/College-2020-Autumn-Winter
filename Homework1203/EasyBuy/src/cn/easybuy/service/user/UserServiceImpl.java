package cn.easybuy.service.user;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import cn.easybuy.dao.MyBatisUtil;
import cn.easybuy.dao.user.UserDao;
import cn.easybuy.dao.user.UserDaoImpl;
import cn.easybuy.dao.user.UserMapper;
import cn.easybuy.entity.User;
import cn.easybuy.utils.DataSourceUtil;

public class UserServiceImpl implements UserService {
	
	private Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	@Override
	public boolean add(User user){
		SqlSession session = null;
		Integer count=0;
		try {
			session = MyBatisUtil.createSession();
			count=session.getMapper(UserMapper.class).add(user);
			session.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MyBatisUtil.closeSqlSession(session);
			return  count>0;
		}
//		Connection connection = null;
//		Integer count=0;
//		try {
//			connection = DataSourceUtil.openConnection();
//			UserDao userDao = new UserDaoImpl(connection);
//			count=userDao.add(user);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			DataSourceUtil.closeConnection(connection);
//			return  count>0;
//		}
	}

	@Override
	public boolean update(User user) {
		SqlSession session = null;
		Integer count=0;
		try {
			session = MyBatisUtil.createSession();
			count=session.getMapper(UserMapper.class).update(user);
			session.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MyBatisUtil.closeSqlSession(session);
			return  count>0;
		}
//		Connection connection = null;
//		Integer count=0;
//		try {
//			connection = DataSourceUtil.openConnection();
//			UserDao userDao = new UserDaoImpl(connection);
//			count=userDao.update(user);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			DataSourceUtil.closeConnection(connection);
//			return  count>0;
//		}
	}

	@Override
	public boolean deleteUserById(Integer userId) {

		SqlSession session = null;
		Integer count=0;
		try {
			session  = MyBatisUtil.createSession();
			count= session.getMapper(UserMapper.class).deleteUserById(userId+""); //传入String类型
			session.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MyBatisUtil.closeSqlSession(session);
			return  count>0;
		}

//		Connection connection = null;
//		Integer count=0;
//		try {
//			connection = DataSourceUtil.openConnection();
//			UserDao userDao = new UserDaoImpl(connection);
//			count=userDao.deleteUserById(userId+"");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			DataSourceUtil.closeConnection(connection);
//			return  count>0;
//		}
	}

	@Override
	public User getUser(Integer userId, String loginName) {
		SqlSession session = null;
		User user=null;
		try {
			session = MyBatisUtil.createSession();
			user=session.getMapper(UserMapper.class).getUser(userId,loginName);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MyBatisUtil.closeSqlSession(session);
			return user;
		}

//		Connection connection = null;
//		User user=null;
//		try {
//			connection = DataSourceUtil.openConnection();
//			UserDao userDao = new UserDaoImpl(connection);
//			user=userDao.getUser(userId,loginName);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			DataSourceUtil.closeConnection(connection);
//			return user;
//		}
	}

	@Override
	public List<User> getUserList(Integer currentPageNo, Integer pageSize) {
		SqlSession session = null;
		List<User> userList=null;
		try {
			session = MyBatisUtil.createSession();
			userList=session.getMapper(UserMapper.class).getUserList(currentPageNo,pageSize);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MyBatisUtil.closeSqlSession(session);
			return userList;
		}
//		Connection connection = null;
//		List<User> userList=null;
//		try {
//			connection = DataSourceUtil.openConnection();
//			UserDao userDao = new UserDaoImpl(connection);
//			userList=userDao.getUserList(currentPageNo,pageSize);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			DataSourceUtil.closeConnection(connection);
//			return userList;
//		}
	}

	@Override
	public int count() {

		SqlSession session = null;
		Integer count=null;
		try {
			session = MyBatisUtil.createSession();
			count = session.getMapper(UserMapper.class).count();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			MyBatisUtil.closeSqlSession(session);
			return count;
		}
	}

//		Connection connection = null;
//		Integer count=null;
//		try {
//			connection = DataSourceUtil.openConnection();
//			UserDao userDao = new UserDaoImpl(connection);
//			count=userDao.count();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			DataSourceUtil.closeConnection(connection);
//			return count;
//		}
//	}
}
