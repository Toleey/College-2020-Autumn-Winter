package org.bw.smbms.dao.provider.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.bw.smbms.dao.address.test.TestAddressMapper;
import org.bw.smbms.dao.provider.ProviderMapper;
import org.bw.smbms.entity.Provider;
import org.bw.smbms.util.MyBatisUtil;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestProviderMapper {
    Logger logger = Logger.getLogger(TestAddressMapper.class);

    @Test
    public void testFindProviderCount() {

        try {
            //1.读取核心配置文件mybatis-config.xml
            InputStream in = Resources.getResourceAsStream("mybatis-config.xml");//读这个配置文件建立io流，这个配置对象到io流中了
            //2.创建SqlSessionFactory对象，读取配置文件
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
            //3.创建一个和数据库会话
            SqlSession session =  sessionFactory.openSession();
            int line = session.selectOne("org.bw.smbms.dao.provider.findProviderCount");
            System.out.println("供应商数:"+line);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    @Test
    public void testFindProviderList(){
        SqlSession session = MyBatisUtil.sqlSessionFactory.openSession();
        //第一种方法
//        List<Provider> providerList = session.selectList("org.bw.smbms.dao.provider.findProviderList");
//        System.out.println(providerList);
        //第二种方法
        try {
            List<Provider> providerList = session.getMapper(ProviderMapper.class).findProviderList();
            System.out.println(providerList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
    }

    @Test
    public void testFindProviderByProNameAndProContact(){
        SqlSession session = MyBatisUtil.sqlSessionFactory.openSession();

        try {
            Provider provider = new Provider();
            //provider.setProName("北京");
            //provider.setProContact("张");
            List<Provider> providerList = session.getMapper(ProviderMapper.class).findProviderByProNameAndProContact(provider);
            for (Provider provider2:providerList) {
                logger.info(provider2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
    }

    @Test
    public void testFindProviderByProNameAndProContactMap(){
        SqlSession session = MyBatisUtil.sqlSessionFactory.openSession();
        try {
            Map<String,String> providerMap = new HashMap<String,String>();
            providerMap.put("proName","北京");
            providerMap.put("proContact","张");
            List<Provider> providerList = session.getMapper(ProviderMapper.class).findProviderByProNameAndProContactMap( providerMap);
            System.out.println(providerList);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testInsertProvider(){
        SqlSession session = MyBatisUtil.sqlSessionFactory.openSession();
        try {
            Provider provider = new Provider();
            provider.setProCode("YGDBZ");
            provider.setProName("大包子");
            provider.setProDesc("一个大包子");
            provider.setProContact("包子王");
            provider.setProPhone("1888888888");
            provider.setProAddress("北京市海淀区");
            int line = session.getMapper(ProviderMapper.class).insertProvider(provider);
            session.commit();
            logger.info("line");
            if (line>0){
                logger.info("新增成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();

    }

    @Test
    public void testUpdateProvider(){
        SqlSession session = MyBatisUtil.sqlSessionFactory.openSession();
        Provider provider = new Provider();
        provider.setId(16);
        provider.setProCode("xsz");
        provider.setProName("小水饺");
        provider.setProDesc("小小的水饺啊");
        try {
            int line = session.getMapper(ProviderMapper.class).updateProvider(provider);
            session.commit();
            logger.info("line");
            if (line>0){
                System.out.println("修改"+provider.getProName()+"成功");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
    }

    @Test
    public void testDeleteProvider(){
        SqlSession session = MyBatisUtil.sqlSessionFactory.openSession();
        try {
            int line = session.getMapper(ProviderMapper.class).deleteProvider(17);
            session.commit();
            logger.info("line");
            if (line>0){
                logger.info("删除成功");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindProviderAndBill(){
        SqlSession session = MyBatisUtil.sqlSessionFactory.openSession();
        try {
            List<Provider> providerList = session.getMapper(ProviderMapper.class).findProviderAndBill();
            for (Provider provider:providerList) {
                logger.info(provider);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
