package newssystem.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import newssystem.dao.BaseDao;
import org.junit.jupiter.api.Test;

public class TestBaseDao {
	
	
	@Test
	public void testBaseDao() throws Exception  {
		inquireNewsTopic();   			//查询所有新闻主题
		inquireID1NewsTopic();			//查询编号为1的新闻主题
		inqueireGlobalNewsInfo();		//查询所有国际新闻的编号，标题，作者，创建时间
		createTopic();					//新增一个名字为”杂问”主题
		updateTopic();					//修改杂问主题为”房产”
		deleteTopic();					//删除主题名为房产的主题
	}
	//查询所有新闻主题
	public static void inquireNewsTopic() throws SQLException {
		BaseDao bDao = new BaseDao();
		Connection conn = bDao.getConnection();
		String sql = "SELECT ntitle FROM NEWS";
		ResultSet rst = bDao.execQuery(sql);
		while(rst.next()) {
			System.out.println(rst.getString("ntitle"));
		}
		bDao.close(rst, null, conn);
	}
	//查询编号为1的新闻主题
	public static void inquireID1NewsTopic() throws SQLException {
		BaseDao bDao = new BaseDao();
		Connection conn = bDao.getConnection();
		String sql = "SELECT ntitle FROM NEWS WHERE ntid = 1";
		ResultSet rst = bDao.execQuery(sql);
		while(rst.next()) {
			System.out.println(rst.getString("ntitle"));
		}
		bDao.close(rst, null, conn);
	}
	//查询所有国际新闻的编号，标题，作者，创建时间
	public static void inqueireGlobalNewsInfo() throws SQLException {
		BaseDao bDao = new BaseDao();
		Connection conn = bDao.getConnection();
		String sql = "SELECT nid,ntitle,nauthor,ncreateDate FROM NEWS,TOPIC WHERE ntid = (SELECT tid FROM TOPIC WHERE tname = '国际')";
		ResultSet rst = bDao.execQuery(sql);
		while(rst.next()) {
			System.out.println(rst.getString("ntitle"));
		}
		bDao.close(rst, null, conn);
	}
	//新增一个名字为”杂问”主题
	public static void createTopic() throws SQLException {
		BaseDao bDao = new BaseDao();
		Connection conn = bDao.getConnection();
		conn = bDao.getConnection();
		String topicName = "杂问";
		String sql = "INSERT INTO TOPIC (tname) VALUES (?)";
		int line = bDao.execUpdate(sql,topicName);
		if(line>0) {
			System.out.println("新增"+topicName+"主题成功");
		}
		bDao.close(null, null, conn);
	}
	//修改杂问主题为”房产”
	public static void updateTopic() throws SQLException {
		BaseDao bDao = new BaseDao();
		Connection conn = bDao.getConnection();
		conn = bDao.getConnection();
		String oldTopicName = "杂问";
		String newTopicName = "房产";
		String sql = "UPDATE TOPIC SET tname = ? WHERE tname = ?";
		int line = bDao.execUpdate(sql,newTopicName,oldTopicName);
		if(line>0) {
			System.out.println("修改"+newTopicName+"成功");
		}
		bDao.close(null, null, conn);
		}
	//删除主题名为房产的主题
	public static void deleteTopic() throws SQLException {
		BaseDao bDao = new BaseDao();
		Connection conn = bDao.getConnection();
		conn = bDao.getConnection();
		String topicName = "房产";
		String sql = "DELETE FROM TOPIC WHERE tname=?";
		int line = bDao.execUpdate(sql,topicName);
		if(line>0) {
			System.out.println("删除"+topicName+"成功");
		}
		bDao.close(null, null, conn);
	}

}
