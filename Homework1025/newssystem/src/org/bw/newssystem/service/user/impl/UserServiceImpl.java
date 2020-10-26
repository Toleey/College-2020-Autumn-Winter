package org.bw.newssystem.service.user.impl;

import java.sql.Connection;
/**
 * 实现业务操作的bean
 * **/
import java.sql.SQLException;

import org.bw.newssystem.dao.BaseDao;
import org.bw.newssystem.dao.news_users.News_UsersDao;
import org.bw.newssystem.dao.news_users.impl.News_UsersDaoImpl;
import org.bw.newssystem.pojo.News_Users;
import org.bw.newssystem.service.user.UserService;

public class UserServiceImpl extends BaseDao implements UserService {
	
	private News_UsersDaoImpl userDao = new News_UsersDaoImpl();

	@Override
	public boolean regist(String uname, String upwd) {
		
		boolean boo = false;
		
		//建立连接
		Connection conn = userDao.getConnection();
		//先判断输入的用户名是否存在
		try {
			//事物处理 （避免数据库出BUG，导致程序混乱） 建立在连接一个数据库上面的，两个就没意义了，处理不了事物
			//1.先把自动提交事物改成非自动，
			//自动提交事物，就是把数据库中每个操作都看作一个事物，自动提交
			//（提交两个数据，第一个int 提交的string，出错，第二个也无法提交）（提交-->更新和回滚）
			
			conn.setAutoCommit(false);//不要自动提交 先放到内存里
			News_Users users =  userDao.findUserByUName(conn,uname);
			//用户名不存在
			if(users==null) {
				News_Users user = new News_Users();
				user.setUname(uname);
				user.setUpwd(upwd);
				
				int line = userDao.insertUser(conn,user);
				if (line>0) {
					boo = true;
				}
			}
			conn.setAutoCommit(true);//针对这个连接，不该也行，自动提交了
			//成功提交 正常里提交
			conn.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			try {
				//回滚 错误里回滚 执行到第一步未成功会返回错误，所以回滚
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			userDao.close(null, null, conn);
		}
		return boo;
	}

	@Override
	public boolean login(String uName, String upwd) {
		boolean isLogin = false;
		//建立连接
		Connection connection = userDao.getConnection();
		//根据姓名查询，当前用户名的用户是否存在
		try {
			News_Users user = userDao.findUserByUName(connection, uName);
			//假如数据库里有这个用户 查到这个用户
			if (user!=null) { 
				//比较密码，数据库用户密码在user里，而用户输入密码在upwd参数传过来
				if(upwd.equals(user.getUpwd())) {
					isLogin = true;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			userDao.close(null, null, connection);
		}
		return isLogin;
	}

}
