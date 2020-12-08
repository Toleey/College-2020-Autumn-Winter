package cn.easybuy.dao.order;

import cn.easybuy.entity.UserAddress;
import cn.easybuy.param.UserAddressParam;

import java.util.List;

public interface UserAddressMapper {

    public List<UserAddress> queryUserAddressList(UserAddressParam param);

    public Integer add(UserAddress userAddress);

    public UserAddress getUserAddressById(Integer addressId);

}
