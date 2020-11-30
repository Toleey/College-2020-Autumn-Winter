package org.bw.smbms.dao.bill;

import org.apache.ibatis.annotations.Param;
import org.bw.smbms.entity.Bill;

import java.util.List;
import java.util.Map;

public interface BillMapper {

    public List<Bill> findBillList() throws  Exception;

    //通过订单表查询很多东西
    public List<Bill> findBillManyInfoByProductNameAndProName(
            @Param("productName") String productName,
            @Param("proID") int proID
    ) throws  Exception;

    //联合查询 订单和供应商
    public List<Bill> findBillAndProvider() throws Exception;

    //通过订单表查询商品
    public List<Bill> findBillByDimProductNameAndProID(Bill bill) throws Exception;

    //新增订单
    public int insertBill(Bill bill) throws Exception;

    //查询供应商下的订单 Array
    public List<Bill> findBillByProviderId_Array(Integer []billArray) throws Exception;

    //查询供应商下的订单 List
    public List<Bill> findBillByProviderId_List(List<Integer> billList) throws Exception;

    //查询订单 根据 产品名称 供应商列表
    public List<Bill> findBillByBillCodeAndProviderId(Map<String,Object> billMap) throws Exception;

    //查询所有供应商名称为‘北京三木’，‘石家庄帅益’，‘深圳泰香米’（模糊查询）订单信息
    public List<Bill> findBillByProName(Map<String,Object> billMap) throws Exception;

    //查询产品带‘油’字的，供应商名称为‘北京三木’，‘石家庄帅益’，‘深圳泰香米’（模糊查询）订单信息
    public List<Bill> findBillByProNameAndProductName(Map<String,Object> billMap) throws Exception;

}
