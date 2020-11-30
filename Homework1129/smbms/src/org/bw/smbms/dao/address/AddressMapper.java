package org.bw.smbms.dao.address;

import org.bw.smbms.entity.Address;

import java.util.List;

public interface AddressMapper {

    public List<Address> findAddressList() throws  Exception;

    //地址新增
    public int insertAddress(Address address) throws Exception;
}
