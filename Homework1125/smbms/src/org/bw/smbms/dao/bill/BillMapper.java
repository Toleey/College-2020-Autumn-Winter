package org.bw.smbms.dao.bill;

import org.apache.ibatis.annotations.Param;
import org.bw.smbms.entity.Bill;

import java.util.List;

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
}
