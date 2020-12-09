package com.yutons.shiro.service.admin;

import java.util.List;

import com.yutons.shiro.bean.admin.ModulePage;
import com.yutons.shiro.bean.admin.Product;

public interface ProductService {
	 /**
     * 根据pid获得商品
     *
     */
    Product findByProductId(Integer pid);

    /**
     * 根据商品种类ID查询商品
     *
     */
    List<Product> selectProductByTypeId(Integer productTypeID);
    /**
     * 根据商品ID查询商品
     *
     */
    List<Product> selectProductById(Integer pid);
    /**
     * 根据商品名字查询商品
     *
     */
    List<Product> selectProductByName(String productName);
    /**
     * 根据商品列表（不分页）
     *
     */
    List<Product> selectProducts();
    /**
     * 根据商品列表（分页）
     *
     */
    ModulePage<Product> selectProductsByPage(Product product);
    /**
     * 添加商品
     *
     * @param product
     * @return
     */
    Integer addProduct(Product product);
    /**
     * 提交用户修改数据
     *
     * @param user
     * @return
     */
    Integer updateProduct(Product product);

    /**
     * 删除商品
     *
     * @param product
     * @return
     */
    Integer deleteProductById(Product product);
}
