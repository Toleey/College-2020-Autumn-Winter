package org.bw.smbms.dao.role.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class TestRoleMapper {
    @Test
    public void testFindRolerCount() {

        try {
            //1.读取核心配置文件mybatis-config.xml
            InputStream in = Resources.getResourceAsStream("mybatis-config.xml");//读这个配置文件建立io流，这个配置对象到io流中了
            //2.创建SqlSessionFactory对象，读取配置文件
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
            //3.创建一个和数据库会话
            SqlSession session =  sessionFactory.openSession();
            int line = session.selectOne("org.bw.smbms.dao.role.findRoleCount");
            System.out.println("角色数:"+line);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
