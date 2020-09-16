package org.bw.newssystem.dao.news_users.impl;

import org.bw.newssystem.dao.BaseDao;
import org.bw.newssystem.dao.news_users.News_UsersDao;
import org.bw.newssystem.pojo.News_Users;

import java.sql.Connection;
import java.sql.ResultSet;

public class News_UsersDaoImpl extends BaseDao implements News_UsersDao {

    @Override
    public News_Users findUserByUName(String uname) throws Exception {
        //建立数据库连接
        Connection conn = this.getConnection();
        String sql = "SELECT * FROM NEWS_USERS WHERE uname = ? ";
        ResultSet rst = execQuery(sql,uname);
        //把数据库查出来的数据转换成java对象 一般都查一个，所以不用循环了
        News_Users user = null;
        if(rst.next()) {
        	user = new News_Users();
        	user.setUid(rst.getInt("uid"));
        	user.setUname(rst.getString("uname"));
        	user.setUpwd(rst.getString("upwd"));
        }
        close(rst, null, conn);
        return user;
    }

    @Override
    public int insertUser(News_Users user) throws Exception {
    	 Connection conn = getConnection();
    	String sql = "INSERT INTO NEWS_USERS (uname,upwd) VALUES (?,?)";
    	//String sql = "INSERT INTO NEWS_USERS (uname,upwd)" + "VALUES (?,?)";
    	int line = execUpdate(sql, user.getUname(),user.getUpwd());
    	close(null, null, conn);
        return line;
    }
}
