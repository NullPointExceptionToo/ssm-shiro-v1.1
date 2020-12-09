package com.yutons.shiro.dao.admin;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yutons.shiro.bean.admin.CosOrder;


public interface CosOrderDao {
    /**
     * 根据条件查询订单
     *
     */
    List<CosOrder> selectCosOrdeByCondition(@Param("cosOrder") CosOrder cosOrder);
    /**
     * 根据条件查询订单count
     *
     */
    int selectCosOrdeCountByCondition(@Param("cosOrder") CosOrder cosOrder);
    /**
     * 根据订单id查询订单
     *
     */
    CosOrder selectCosOrdeById(@Param("cosOrder") CosOrder cosOrder);
    
    /**
     * 添加订单
     *
     * @param cosduct
     * @return
     */
    int insert(@Param("cosOrder") CosOrder cosOrder);
    /**
     * 修改订单当前状态
     *
     * @param status
     * @return
     */
    int updateStatusById(@Param("cosOrder") CosOrder cosOrder);
    
    /**
     * 删除订单
     *
     * @param status
     * @return
     */
    int deleteCosOrderById(@Param("cosOrder") CosOrder cosOrder);

}
