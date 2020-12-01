package cn.easybuy.dao.product;

import java.util.List;

public interface ProductMapper {

    Integer updateStock(Integer id, Integer quantity) throws Exception;

    public Integer add(cn.easybuy.entity.Product product) throws Exception;

    public Integer update(cn.easybuy.entity.Product product) throws Exception;

    public Integer deleteProductById(Integer id) throws Exception;

    public cn.easybuy.entity.Product getProductById(Integer id)throws Exception;

    public List<cn.easybuy.entity.Product> getProductList(Integer currentPageNo, Integer pageSize, String proName, Integer categoryId, Integer level)throws Exception;

    public Integer queryProductCount(String proName,Integer categoryId,Integer level)throws Exception;

}
