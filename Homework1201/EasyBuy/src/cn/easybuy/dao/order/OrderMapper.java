package cn.easybuy.dao.order;

import cn.easybuy.dao.IBaseDao;
import cn.easybuy.entity.Order;

import java.util.List;

public interface OrderMapper {

    /***
     * 订单处理的dao层
     * getRowCount
     * getRowList(Params params)
     * getById(Integer id)
     * addObject(Params params)
     */
    public interface OrderDao extends IBaseDao {

        public void add(Order order) ;

        public void deleteById(Integer id);

        public Order getOrderById(Integer id) ;

        public List<Order> getOrderList(Integer userId, Integer currentPageNo, Integer pageSize) ;

        public Integer count(Integer userId);
    }

}
