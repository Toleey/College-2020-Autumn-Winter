package cn.easybuy.dao.product;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper {

    Integer updateStock(@Param("id") Integer id,@Param("quantity") Integer quantity) throws Exception;

    public Integer add(cn.easybuy.entity.Product product) throws Exception;

    public Integer update(cn.easybuy.entity.Product product) throws Exception;

    public Integer deleteProductById(Integer id) throws Exception;

    public cn.easybuy.entity.Product getProductById(Integer id)throws Exception;

    public List<cn.easybuy.entity.Product> getProductList(
            @Param("currentPageNo") Integer currentPageNo,
            @Param("pageSize") Integer pageSize,
            @Param("proName") String proName,
            @Param("categoryId") Integer categoryId,
            @Param("level") Integer level)throws Exception;

    public Integer queryProductCount(
            @Param("proName") String proName,
            @Param("categoryId") Integer categoryId,
            @Param("level") Integer level)throws Exception;

}
