package com.yutons.shiro.dao.admin;

import com.yutons.shiro.bean.admin.CheckOrder;
import com.yutons.shiro.bean.admin.quota.Tesr;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface CheckOrderDao {
    /**
     * 根据条件查询 checkOrder
     *
     */
    List<CheckOrder> selectCheckOrderByCondition(@Param("checkOrder") CheckOrder checkOrder);
    /**
     * 根据条件查询 checkOrder count
     *
     */
    int selectCheckOrderCountByCondition(@Param("checkOrder") CheckOrder checkOrder);
    /**
     * 根据id查询 checkOrder
     *
     */
    CheckOrder selectCheckOrderById(@Param("checkOrder") CheckOrder checkOrder);

    /**
     * 添加 checkOrder
     *
     * @param checkOrder
     * @return
     */
    int insert(@Param("checkOrder") CheckOrder checkOrder);
    /**
     * 修改 checkOrder
     *
     * @param checkOrder
     * @return
     */
    int update(@Param("checkOrder") CheckOrder checkOrder);
    
    /**
     * 删除 checkOrder
     *
     * @return
     */
    int deleteCheckOrderById(@Param("checkOrder") CheckOrder checkOrder);

    List<CheckOrder> selectUnBindCheckOrder(@Param("tableName") String table);

}
