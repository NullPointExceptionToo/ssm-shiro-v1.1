package com.yutons.shiro.service.admin;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yutons.shiro.bean.admin.Home;
import com.yutons.shiro.bean.admin.ModulePage;
import com.yutons.shiro.bean.admin.ProOrder;
import com.yutons.shiro.bean.admin.ProductCount;
import com.yutons.shiro.bean.admin.User;
import com.yutons.shiro.dao.admin.HomeDao;
import com.yutons.shiro.dao.admin.ProOrderDao;
import com.yutons.shiro.util.Constans;
import com.yutons.shiro.util.TokenUtil;

@Service
public class ProOrderServiceImpl implements ProOrderService {
    private static final Logger logger = LoggerFactory.getLogger(ProOrderServiceImpl.class);
    @Resource
    private ProOrderDao proOrderDao;
    @Resource
    private HomeDao homeDao;
	@Override
	public ModulePage<ProOrder> selectProOrdersByPage(ProOrder proOrder) {
		ModulePage<ProOrder> mode = new ModulePage<ProOrder>();
		User user = TokenUtil.getUser();
		if (user.getRoleId() == Constans.homeRole) {
			proOrder.setUserID(user.getUserId());
		}
		List<ProOrder> list = proOrderDao.selectProOrdeByCondition(proOrder);
		int count = proOrderDao.selectProOrdeCountByCondition(proOrder);
		mode.setCount(count);
		mode.setData(list);
		return mode;
	}
	@Override
	public ModulePage<ProductCount> selectGroupCount(ProOrder proOrder) {
		ModulePage<ProductCount> count = new ModulePage<ProductCount>();
		User user = TokenUtil.getUser();
		if (user.getRoleId() == Constans.homeRole) {
			proOrder.setUserID(user.getUserId());
		}
		List<ProductCount> countArray = proOrderDao.selectGroupCount(proOrder);
		int pagecount = proOrderDao.selectGroupPageCount(proOrder);
		count.setCount(pagecount);
		count.setData(countArray);
		return count;
	}
	@Override
	public List<ProductCount> selectGroupCountNoPage(ProOrder proOrder) {
		return proOrderDao.selectGroupCountNoPage(proOrder);
	}
	@Override
	public Integer addProOrder(ProOrder proOrder) {
		User user = TokenUtil.getUser();
		Home home = new Home();
		home.setHomeUserId(user.getUserId());
		List<Home> homeArray = homeDao.selectHomeByConditionNoPage(home);
		if (homeArray != null && homeArray.size() != 0) {
			proOrder.setPhomeID(homeArray.get(0).getHomeId());
		}else{
			return Constans.NONE_HOME;
		}
		proOrder.setSellNum(0);
		proOrder.setProDate(new Date());
		return proOrderDao.insert(proOrder);
	}
	@Override
	public int updateStatusById(ProOrder proOrder) {
		return proOrderDao.updateStatusById(proOrder);
	}
	@Override
	public int updateSellNumById(ProOrder proOrder) {
		return proOrderDao.updateSellNumById(proOrder);
	}
	
	@Override
	@Transactional
	public Integer deleteProOrderById(ProOrder proOrder) {
		proOrder = proOrderDao.selectProOrdeById(proOrder);
		int result = 0;
		if (proOrder != null && proOrder.getSellNum() != 0) {
			ProOrder search = new ProOrder();
			search.setPid(proOrder.getPid());
			search.setExcludeId(proOrder.getOid());
			Integer rest = proOrderDao.selectCountByType(search);
			int restCount = rest == null?0:rest;
			if (restCount < proOrder.getSellNum()) {
				return Constans.HOME_LESS; //标记2表示库存数量不足已将转移被删除订单的的已销售数量,暂时不允许删除
			}
			Integer need = proOrder.getSellNum();
			List<ProOrder> array = proOrderDao.selectVailProOrdeByCondition(proOrder);
			for (ProOrder p: array) {
				if (p.getProNum() - p.getSellNum() < need) {
					p.setSellNum(p.getProNum());
				}else{
					p.setSellNum(p.getSellNum()+need);
				}
				proOrderDao.updateSellNumById(p);
				need -= p.getProNum() - p.getSellNum();
				if (need <= 0)
					break;
			}
		}
		result = proOrderDao.deleteProOrderById(proOrder);
		return result;
	}
    
}
