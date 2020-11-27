package com.yutons.shiro.dao.admin;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yutons.shiro.bean.admin.ProOrder;
import com.yutons.shiro.bean.admin.ProductCount;


public interface ProOrderDao {
    /**
     * 根据条件查询订单
     *
     */
    List<ProOrder> selectProOrdeByCondition(@Param("proOrder") ProOrder proOrder);
    /**
     * 根据订单id查询订单
     *
     */
    ProOrder selectProOrdeById(@Param("proOrder") ProOrder proOrder);
    
    /**
     * 搜索某一类商品的可用供货订单列表 
     *
     */
    List<ProOrder> selectVailProOrdeByCondition(@Param("proOrder") ProOrder proOrder);

    /**
     * 分组统计商品库存
     *
     */
    List<ProductCount> selectGroupCount(@Param("proOrder") ProOrder proOrder);
    
    /**
     * 根据商品id统计某种商品的库存
     *
     */
    Integer selectCountByType(@Param("proOrder") ProOrder proOrder);
    /**
     * 添加订单
     *
     * @param product
     * @return
     */
    int insert(@Param("proOrder") ProOrder proOrder);
//    /**
//     * 提交用户修改数据
//     *
//     * @param user
//     * @return
//     */
//    int update(@Param("product") Product product);
    /**
     * 修改订单当前状态
     *
     * @param status
     * @return
     */
    int updateStatusById(@Param("proOrder") ProOrder proOrder);
    /**
     * 修改订单的已售数量
     *
     * @param status
     * @return
     */
    int updateSellNumById(@Param("proOrder") ProOrder proOrder);

    /**
     * 删除订单（如订单的已售数量不为零，需要将已售转移到其他订单）
     *
     * @param proOrder
     * @return
     */
    Integer deleteProOrderById(@Param("proOrder") ProOrder proOrdert);

}
