package com.yutons.shiro.service.admin;

import java.util.List;

import com.yutons.shiro.bean.admin.ModulePage;
import com.yutons.shiro.bean.admin.ProOrder;
import com.yutons.shiro.bean.admin.ProductCount;

public interface ProOrderService {
    /**
     * 订单列表（分页）
     *
     */
    ModulePage<ProOrder> selectProOrdersByPage(ProOrder proOrder);

    /**
     * 分组统计商品库存
     *
     */
    ModulePage<ProductCount> selectGroupCount(ProOrder proOrder);
    /**
     * 分组统计商品库存(不分页)
     *
     */
    List<ProductCount> selectGroupCountNoPage(ProOrder proOrder);
    
    /**
     * 添加订单
     *
     * @param ProOrder
     * @return
     */
    Integer addProOrder(ProOrder proOrder);
    
    /**
     * 修改订单当前状态
     *
     * @param status
     * @return
     */
    int updateStatusById(ProOrder proOrder);
    /**
     * 修改订单当前已售
     *
     * @param status
     * @return
     */
    int updateSellNumById(ProOrder proOrder);

    /**
     * 删除订单（如订单的已售数量不为零，需要将已售转移到其他订单，如无可用库存则禁止删除订单）
     *
     * @param proOrder
     * @return
     */
    Integer deleteProOrderById(ProOrder proOrder);
}
