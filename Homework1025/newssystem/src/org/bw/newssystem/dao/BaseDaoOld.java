package org.bw.newssystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.bw.newssystem.util.DBConfigure;

/**
 * 一般用文档注释，可以导出，便于别人访问
 * 数据访问基础类，提供数据库连接和数据库访问
 * 基本操作，其他数据库访问类型继承它
 * **/

public class BaseDaoOld {
	
	protected Connection connection;
	
	//获得连接的几个变量属性 这是一个基础类，不推荐用static
	private static String DBDriver = DBConfigure.getProperty("driver");
	private static String DBUrl = DBConfigure.getProperty("url");
	private static String DBUserName = DBConfigure.getProperty("username");
	private static String DBUserPwd = DBConfigure.getProperty("userpwd");
	
	
	//加载驱动
	static {
		try {
			Class.forName(DBDriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//连接数据库的方法
	
	public Connection getConnection() {
		
		try {
			connection = DriverManager.getConnection(DBUrl,DBUserName,DBUserPwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
	}
	//数据库更新操作 增删改查				  objecrt类型 参数  可变参数，用可变参数方便
	/**
	 * 数据库更新操作（报错增删改）
	 * @param sql sql语句	
	 * @param params 可变参数设置，sql语句中的？占位符值
	 * @return 影响的行数
	 * **/
	public int execUpdate(String sql,Object ...params) {
		//声明一个执行sql的对象
		//普通事物是建立在一个连接的基础上
		int line = 0;
		try {
			PreparedStatement prep = connection.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				prep.setObject(i+1, params[i]);
			}
			line = prep.executeUpdate();
			close(null, prep, null);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return line;
		
	}
	//数据库查询
	public ResultSet execQuery(String sql,Object ...params) {
		
		ResultSet rst = null;
		//数据库操作
		PreparedStatement prep = null;
	
		try {
			prep = connection.prepareStatement(sql);
			for(int i=0;i<params.length;i++) {
				prep.setObject(i+1, params[i]);
			}
			rst = prep.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return rst;
		
	}
	
	
	//数据库对象的关闭 释放数据库资源
	public void close (ResultSet rst,PreparedStatement prep,Connection conn) {
		if(rst!=null) {
			try {
				rst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (prep!=null) {
			try {
				prep.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
}
