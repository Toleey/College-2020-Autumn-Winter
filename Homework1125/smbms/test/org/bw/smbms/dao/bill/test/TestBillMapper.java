package org.bw.smbms.dao.bill.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.bw.smbms.dao.bill.BillMapper;
import org.bw.smbms.entity.Bill;
import org.bw.smbms.util.MyBatisUtil;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestBillMapper {
    Logger logger = Logger.getLogger(TestBillMapper.class);
    @Test
    public void testFindBillCount() {

        try {
            //1.读取核心配置文件mybatis-config.xml
            InputStream in = Resources.getResourceAsStream("mybatis-config.xml");//读这个配置文件建立io流，这个配置对象到io流中了
            //2.创建SqlSessionFactory对象，读取配置文件
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
            //3.创建一个和数据库会话
            SqlSession session =  sessionFactory.openSession();
            int line = session.selectOne("org.bw.smbms.dao.bill.findBillCount");
            System.out.println("账单数:"+line);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Test
    public void testFindBillList(){
        SqlSession session = MyBatisUtil.sqlSessionFactory.openSession();
        //第一种方法
//        List<Bill> billList = session.selectList("org.bw.smbms.dao.bill.findBillList");
//        System.out.println(billList);
        //第二种方法
        try {
            List<Bill> billList = session.getMapper(BillMapper.class).findBillList();
            System.out.println(billList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
    }

    @Test
    public void testFindBillManyInfoByProductNameAndProName(){
        SqlSession session = MyBatisUtil.sqlSessionFactory.openSession();
        try {

            List<Bill> billList = session.getMapper(BillMapper.class).findBillManyInfoByProductNameAndProName("哈",2);
            System.out.println(billList);
//            for (Bill bill: billList){
//                logger.info(bill);
//            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
    }

    @Test
    public void testFindBillAndProvider(){
        SqlSession session = MyBatisUtil.sqlSessionFactory.openSession();
        try {
            List<Bill> billList = session.getMapper(BillMapper.class).findBillAndProvider();
            for (Bill bill:billList) {
                logger.info(bill);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
    }

    @Test
    public void testInsertBill(){
        SqlSession session = MyBatisUtil.sqlSessionFactory.openSession();
        try {
            Bill bill = new Bill();
            bill.setBillCode("BILL2020_001");
            bill.setProductName("大包子");
            int line = session.getMapper(BillMapper.class).insertBill(bill);
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
