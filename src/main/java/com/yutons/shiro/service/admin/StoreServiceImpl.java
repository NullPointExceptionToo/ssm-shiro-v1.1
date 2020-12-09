package com.yutons.shiro.service.admin;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.yutons.shiro.bean.admin.ModulePage;
import com.yutons.shiro.bean.admin.Store;
import com.yutons.shiro.bean.admin.User;
import com.yutons.shiro.dao.admin.StoreDao;
import com.yutons.shiro.util.TokenUtil;

@Service
public class StoreServiceImpl implements StoreService {
    private static final Logger logger = LoggerFactory.getLogger(StoreServiceImpl.class);
    @Resource
    private StoreDao storeDao;
    
    @Override
	public Store findByStoreId(Integer sid) {
		return storeDao.findByStoreId(sid);
	}
	@Override
	public List<Store> selectStoreById(Integer sid) {
		Store store = new Store();
		store.setSid(sid);
		return storeDao.selectStoreByConditionNoPage(store);
	}
	@Override
	public List<Store> selectStoreByName(String storeName) {
		Store store = new Store();
		store.setStoreName(storeName);
		return storeDao.selectStoreByConditionNoPage(store);
	}
	@Override
	public ModulePage<Store> selectStoresByPage(Store store) {
		User user = TokenUtil.getUser();
		if (user.getRoleId() == 6) {
			store.setStoreUserId(user.getUserId());
		}
		List<Store> data = storeDao.selectStoreByCondition(store);
		int count = storeDao.selectStoreCountByCondition(store);
		ModulePage<Store> storePage = new ModulePage<>();
		storePage.setCount(count);
		storePage.setData(data);
        return storePage;
	}
	
	
	@Override
	public List<Store> selectStoreByUserIdAndExcludeId(Store store) {
		return storeDao.selectStoreByConditionNoPage(store);
	}
	
	@Override
	public Integer addStore(Store store) {
		return storeDao.insert(store);
	}
	@Override
	public Integer updateStore(Store store) {
		return storeDao.update(store);
	}
	@Override
	public Integer deleteStoreById(Store store) {
		return storeDao.deleteStoreById(store);
	}
	@Override
	public int updateStatusById(Store store) {
		return storeDao.updateStatusById(store);
	}
	
}
