package com.toleey.bbsmsg.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

public class BaseDao {

	private Connection connection;

	//连接数据库
	public Connection getConnection() {
		
		Context ctx = null;
		
		try {
			ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/bbsmsg");
			connection = ds.getConnection();
			
		}catch (NamingException e) {
			// TODO: handle exception
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
		
	}
	//数据库更新
	public int execUpdate(String sql,Object ...params) {
		int line = 0;
		PreparedStatement prep = null;
		try {
			prep = connection.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				prep.setObject(i+1, params[i]);
			}
			line = prep.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeDB(null, prep, null);
		}	
		return line;
	}
	
	//数据库查询
	public ResultSet execQuery(String sql,Object ...params) {		
		ResultSet rst = null;		
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
	
	//关闭数据库
	public void closeDB(ResultSet rst,PreparedStatement prep,Connection conn) {
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
