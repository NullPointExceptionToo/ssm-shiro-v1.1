package com.yutons.shiro.dao.admin;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yutons.shiro.bean.admin.Store;


public interface StoreDao {
    /**
     * 根据sid获得商店
     *
     */
    Store findByStoreId(@Param("sid") Integer sid);

    /**
     * 根据条件查询商店列表
     *
     */
    List<Store> selectStoreByCondition(@Param("store") Store store);
    /**
     * 添加商店
     *
     * @param Store
     * @return
     */
    int insert(@Param("store") Store store);
    /**
     * 提交用户修改数据
     *
     * @param user
     * @return
     */
    int update(@Param("store") Store store);
    /**
     * 修改商店当前状态
     *
     * @param status
     * @return
     */
    int updateStatusById(@Param("store") Store store);

    /**
     * 删除商店
     *
     * @param store
     * @return
     */
    Integer deleteStoreById(@Param("store") Store store);

}
