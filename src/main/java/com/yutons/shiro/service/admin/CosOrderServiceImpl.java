package com.yutons.shiro.service.admin;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.yutons.shiro.bean.admin.CosOrder;
import com.yutons.shiro.bean.admin.ModulePage;
import com.yutons.shiro.bean.admin.OrdItem;
import com.yutons.shiro.bean.admin.ProOrder;
import com.yutons.shiro.bean.admin.Store;
import com.yutons.shiro.bean.admin.User;
import com.yutons.shiro.dao.admin.CosOrderDao;
import com.yutons.shiro.dao.admin.ProOrderDao;
import com.yutons.shiro.dao.admin.StoreDao;
import com.yutons.shiro.util.Constans;
import com.yutons.shiro.util.TokenUtil;

@Service
public class CosOrderServiceImpl implements CosOrderService {
    private static final Logger logger = LoggerFactory.getLogger(CosOrderServiceImpl.class);
    @Resource
    private CosOrderDao cosOrderDao;
    @Resource
    private ProOrderDao proOrderDao;
    @Resource
    private StoreDao storeDao;
	@Override
	public ModulePage<CosOrder> selectCosOrdersByPage(CosOrder cosOrder) {
		ModulePage<CosOrder> mode = new ModulePage<CosOrder>();
		User user = TokenUtil.getUser();
		if (user.getRoleId() == Constans.storeRole) {
			cosOrder.setUserID(user.getUserId());
		}
		List<CosOrder> list = cosOrderDao.selectCosOrdeByCondition(cosOrder);
		int count = cosOrderDao.selectCosOrdeCountByCondition(cosOrder);
		mode.setCount(count);
		mode.setData(list);
		return mode;
	}
	
	
    public List<OrdItem> selectCosOrdersById(int cid){
    	CosOrder co = new CosOrder();
    	co.setCid(cid);
    	co = cosOrderDao.selectCosOrdeById(co);
    	if (co != null && !StringUtils.isEmpty(co.getCosDetail())) {
    		return JSON.parseArray(co.getCosDetail(), OrdItem.class);
    	}
    	return null;
    }
    
    @Override
    @Transactional
	public Integer addCosOrder(CosOrder cosOrder) {
		User user = TokenUtil.getUser();
		Store store = new Store();
		store.setStoreUserId(user.getUserId());
		List<Store> storeArray = storeDao.selectStoreByConditionNoPage(store);
		
		Map<Integer,OrdItem> map = new HashMap<>();
		for(OrdItem ordItem:cosOrder.getOrdArray()) {
			OrdItem temp = map.get(ordItem.getProductId());
			if (temp == null) {
				map.put(ordItem.getProductId(), ordItem);
			}else{
				temp.setCount(temp.getCount()+ordItem.getCount());
			}
		}
		cosOrder.setOrdArray(new ArrayList<OrdItem>(map.values()));
		
		if (storeArray != null && storeArray.size() != 0) {
			cosOrder.setStoreID(storeArray.get(0).getSid());
		}else{
			return Constans.NONE_STORE;
		}
		if (!checkAail(cosOrder)) {
			return Constans.HOME_LESS;
		}
		cosOrder.setCosDetail(JSON.toJSONString(cosOrder.getOrdArray()));
		cosOrder.setCosDate(new Date());
		cosOrder.setOrdStatus(Constans.State.STATE_WAIT_DELIEVE);
		return cosOrderDao.insert(cosOrder);
	}
	
	@Override
	public Integer delCosOrder(CosOrder cosOrder) {
		return cosOrderDao.deleteCosOrderById(cosOrder);
	}

	@Override
	public int cancelById(CosOrder cosOrder) {
		cosOrder = cosOrderDao.selectCosOrdeById(cosOrder);
		if (cosOrder.getOrdStatus() == Constans.State.STATE_DELIEVE) {
			return 999;
		}
		cosOrder.setOrdStatus(Constans.State.STATE_CANCEL);
		return cosOrderDao.updateStatusById(cosOrder);
	}
	
	
	@Override
	@Transactional
	public int deliveryOrder(CosOrder cosOrder) {
		cosOrder = cosOrderDao.selectCosOrdeById(cosOrder);
		cosOrder.setOrdArray(JSON.parseArray(cosOrder.getCosDetail(), OrdItem.class));
		//验证库存是否充足
		if (checkAail(cosOrder)) {
			//扣除库存
			dealRelOrd(cosOrder);
			//修改订单状态为配送
			cosOrder.setOrdStatus(Constans.State.STATE_DELIEVE);
			return cosOrderDao.updateStatusById(cosOrder);
		}
		return Constans.HOME_LESS;
	}


	/**
	 * 扣除库存
	 * @param cosOrder
	 */
	void dealRelOrd(CosOrder cosOrder) {
		List<OrdItem> array = cosOrder.getOrdArray();
		for (OrdItem item:array) {
			ProOrder proOrder = new ProOrder();
			proOrder.setPid(item.getProductId());
			List<ProOrder> proArray = proOrderDao.selectVailProOrdeByCondition(proOrder);
			int count = item.getCount();
			for (ProOrder pro:proArray) {
				int res = pro.getProNum()-pro.getSellNum();
				if (res < count) {
					count-=res;
					proOrder.setOid(pro.getOid());
					proOrder.setSellNum(pro.getProNum());
					proOrderDao.updateSellNumById(proOrder);
				}else{
					proOrder.setOid(pro.getOid());
					proOrder.setSellNum(pro.getSellNum()+count);
					proOrderDao.updateSellNumById(proOrder);
					break;
				}
				 
			}
			
		}
	}
	/**
	 * 检查库存是否充足
	 * @param cosOrder
	 */
	Boolean checkAail(CosOrder cosOrder) {
		List<OrdItem> array = cosOrder.getOrdArray();
		for (OrdItem item:array) {
			ProOrder po = new ProOrder();
			po.setPid(item.getProductId());
			Integer res = proOrderDao.selectCountByType(po);
			if (res < item.getCount()) {
				return false;
			}
		}
		return true;
	}
    
}
