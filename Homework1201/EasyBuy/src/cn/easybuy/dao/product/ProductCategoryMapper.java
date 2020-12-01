package cn.easybuy.dao.product;

import cn.easybuy.entity.ProductCategory;
import cn.easybuy.param.ProductCategoryParam;

import java.util.List;

public interface ProductCategoryMapper {

    /**
     * 根据id删除商品
     * @param parseLong
     */
    void deleteById(Integer parseLong);//删除商品分类
    /**
     * 根据条件查询商品列表
     * @param param
     */
    public List<ProductCategory> queryProductCategorylist(ProductCategoryParam param);
    /**
     * 根据id查询商品分类
     * @param param
     */
    public ProductCategory queryProductCategoryById(Integer id);
    /**
     * 添加商品分类
     * @param param
     */
    public Integer add(ProductCategory productCategory) ;
    /**
     * 根据参数查询商品分类的数目
     * @param param
     */
    public Integer queryProductCategoryCount(ProductCategoryParam param);
    /**
     * 修改商品分类
     * @param param
     */
    public void update(ProductCategory productCategory) ;

}
