package org.bw.smbms.dao.address.test;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.bw.smbms.dao.address.AddressMapper;
import org.bw.smbms.entity.Address;
import org.bw.smbms.util.MyBatisUtil;
import org.junit.Test;

import java.util.List;

public class TestAddressMapper {
    //创建日志对象
    Logger logger = Logger.getLogger(TestAddressMapper.class);
    @Test
    public void testFindAddressCount() {

            //创建一个和数据库会话
            SqlSession session = MyBatisUtil.sqlSessionFactory.openSession();
            int line = session.selectOne("org.bw.smbms.dao.address.findAddressCount");
            //简单的输出到控制台上
            //System.out.println("地址数:"+line);
            //有格式的日志输出
            logger.info("地址数"+line);
            logger.error("地址数"+line);
            logger.debug("地址数"+line);

    }
    @Test
    public void testFindAddressList(){
        SqlSession session = MyBatisUtil.sqlSessionFactory.openSession();
        //第一种方法
//        List<Address> addressList = session.selectList("org.bw.smbms.dao.address.findAddressList");
//        System.out.println(addressList);
        //第二种方法
        try {
            List<Address> addressList = session.getMapper(AddressMapper.class).findAddressList();
            System.out.println(addressList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
    }

    @Test
    public void testInsertAddress(){
        SqlSession session = MyBatisUtil.sqlSessionFactory.openSession();
        try {
            Address address = new Address();
            address.setContact("哈哈哈");
            address.setAddressDesc("北京市东城区");
            int line = session.getMapper(AddressMapper.class).insertAddress(address);
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
}
