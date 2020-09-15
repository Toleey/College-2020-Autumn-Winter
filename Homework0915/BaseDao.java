package newssystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import newssystem.util.DBConfigure;


public class BaseDao {
	
	protected Connection connection;
	
	private static String DBDriver = DBConfigure.getProperty("driver");
	private static String DBUrl = DBConfigure.getProperty("url");
	private static String DBUserName = DBConfigure.getProperty("username");
	private static String DBUserPwd = DBConfigure.getProperty("userpwd");
	
	static {
		
		try {
			
			Class.forName(DBDriver);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	//连接数据库
    public Connection getConnection() {
		
		try {
			connection = DriverManager.getConnection(DBUrl,DBUserName,DBUserPwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	//数据库操作
	public int execUpdate(String sql,Object ...params) {
		
		int line = 0;
		try {
			PreparedStatement prep = connection.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				prep.setObject(i+1, params[i]);
			}
			line = prep.executeUpdate();
			close(null, prep, null);
			
		} catch (SQLException e) {
			e.printStackTrace();
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
			e.printStackTrace();
		}
		
		
		return rst;
		
	}
	
	//关闭连接，释放资源
	public void close (ResultSet rst,PreparedStatement prep,Connection conn) {
		if(rst!=null) {
			try {
				rst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (prep!=null) {
			try {
				prep.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
}
