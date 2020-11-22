package com.yutons.shiro.dao.admin;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yutons.shiro.bean.admin.Product;


public interface ProductDao {
    /**
     * 根据pid获得商品
     *
     */
    Product findByProductId(@Param("pid") Integer pid);

    /**
     * 根据条件查询商品列表
     *
     */
    List<Product> selectProductByCondition(@Param("product") Product product);
    /**
     * 添加商品
     *
     * @param product
     * @return
     */
    int insert(@Param("product") Product product);
    /**
     * 提交用户修改数据
     *
     * @param user
     * @return
     */
    int update(@Param("product") Product product);
//    /**
//     * 修改商品当前状态
//     *
//     * @param status
//     * @return
//     */
//    int updateStatusById(@Param("product") Product product);

    /**
     * 删除商品
     *
     * @param product
     * @return
     */
    Integer deleteProductById(@Param("product") Product product);

}
