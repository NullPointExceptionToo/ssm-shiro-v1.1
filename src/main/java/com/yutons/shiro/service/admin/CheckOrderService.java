package com.yutons.shiro.service.admin;

import com.yutons.shiro.bean.admin.CheckOrder;
import com.yutons.shiro.bean.admin.ModulePage;
import com.yutons.shiro.bean.admin.quota.Tesr;
import com.yutons.shiro.bean.vo.CheckOrderVO;
import com.yutons.shiro.bean.vo.TesrVO;

import java.util.List;

public interface CheckOrderService {
    /**
     * checkOrder 列表（分页）
     *
     */
    ModulePage<CheckOrder> selecCheckOrdersByPage(CheckOrder checkOrder);
    /**
     * checkOrder 详情
     *
     */
    CheckOrderVO selectCheckOrdersById(int id);

    
    /**
     * 添加 checkOrder
     *
     * @return
     */
    Integer addCheckOrder(CheckOrder checkOrder);

    /**
     * 修改 checkOrder
     *
     * @return
     */
    Integer updateCheckOrder(CheckOrder checkOrder);
    
    /**
     * 删除 checkOrder
     *
     * @return
     */
    Integer delCheckOrder(CheckOrder checkOrder);

    List<CheckOrder> selectUnBindCheckOrder(String table);

}
