package com.yutons.shiro.service.admin;

import java.util.List;

import com.yutons.shiro.bean.admin.ModulePage;
import com.yutons.shiro.bean.admin.Store;

public interface StoreService {
	 /**
     * 根据sid获得商店
     *
     */
    Store findByStoreId(Integer sid);
    /**
     * 根据商店ID查询商店
     *
     */
    List<Store> selectStoreById(Integer sid);
    /**
     * 根据商店名字查询商店
     *
     */
    List<Store> selectStoreByName(String storeName);
    
    /**
     * 根据商店角色id和过滤商店ID查询商店
     *
     */
    List<Store> selectStoreByUserIdAndExcludeId(Store store);
    /**
     * 根据商店列表（分页）
     *
     */
    ModulePage<Store> selectStoresByPage(Store store);
    /**
     * 添加商店
     *
     * @param store
     * @return
     */
    Integer addStore(Store store);
    /**
     * 提交用户修改数据
     *
     * @param user
     * @return
     */
    Integer updateStore(Store store);
    /**
     * 修改商店当前状态
     *
     * @param status
     * @return
     */
    int updateStatusById(Store store);

    /**
     * 删除商店
     *
     * @param store
     * @return
     */
    Integer deleteStoreById(Store store);
}
