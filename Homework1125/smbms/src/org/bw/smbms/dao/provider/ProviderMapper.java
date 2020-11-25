package org.bw.smbms.dao.provider;

import org.apache.ibatis.annotations.Param;
import org.bw.smbms.entity.Provider;

import java.util.List;
import java.util.Map;

public interface ProviderMapper {

    public List<Provider> findProviderList() throws Exception;

    //根据供应商名字及供应商联系人名字查供应商编号，名字，联系方式，电话，住址，传真
    public List<Provider> findProviderByProNameAndProContact(Provider provider) throws Exception;

    //根据供应商名字及供应商联系人名字查供应商编号，名字，联系方式，电话，住址，传真 通过Map
    public List<Provider> findProviderByProNameAndProContactMap(Map providerMap) throws Exception;

    //新增供应商
    public int insertProvider(Provider provider) throws Exception;

    //修改供应商信息
    public int updateProvider(Provider provider) throws  Exception;

    //删除供应商
    public int deleteProvider(@Param("providerId") int id) throws Exception;

    //联合查询供应商和订单
    public List<Provider> findProviderAndBill() throws Exception;

    //通过供应商编码和名称 动态查询供应商
    public List<Provider> findProviderByProCodeAndProName() throws Exception;

    //新增供应商
    public int insertProvider() throws Exception;
}
