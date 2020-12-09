package com.yutons.shiro.service.admin;

import java.util.List;

import com.yutons.shiro.bean.admin.CosOrder;
import com.yutons.shiro.bean.admin.ModulePage;
import com.yutons.shiro.bean.admin.OrdItem;

public interface CosOrderService {
    /**
     * 订单列表（分页）
     *
     */
    ModulePage<CosOrder> selectCosOrdersByPage(CosOrder cosOrder);
    /**
     * 订单详情
     *
     */
    List<OrdItem> selectCosOrdersById(int cid);

    
    /**
     * 添加订单
     *
     * @param CosOrder
     * @return
     */
    Integer addCosOrder(CosOrder cosOrder);
    
    /**
     * 删除订单
     *
     * @param CosOrder
     * @return
     */
    Integer delCosOrder(CosOrder cosOrder);
    
    /**
     * 撤销订单
     *
     * @param status
     * @return
     */
    int cancelById(CosOrder cosOrder);
    /**
     * 配送订单
     *
     * @param status
     * @return
     */
    int deliveryOrder(CosOrder cosOrder);

}
