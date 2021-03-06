package com.yutons.shiro.service.admin;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.yutons.shiro.bean.admin.Home;
import com.yutons.shiro.bean.admin.ModulePage;
import com.yutons.shiro.bean.admin.User;
import com.yutons.shiro.dao.admin.HomeDao;
import com.yutons.shiro.util.Constans;
import com.yutons.shiro.util.TokenUtil;

@Service
public class HomeServiceImpl implements HomeService {
    private static final Logger logger = LoggerFactory.getLogger(HomeServiceImpl.class);
    @Resource
    private HomeDao homeDao;
    
    @Override
	public Home findByHomeId(Integer homeId) {
		return homeDao.findByHomeId(homeId);
	}
	@Override
	public List<Home> selectHomeById(Integer homeId) {
		Home home = new Home();
		home.setHomeId(homeId);
		return homeDao.selectHomeByConditionNoPage(home);
	}
	@Override
	public List<Home> selectHomeByName(String homeName) {
		Home home = new Home();
		home.setHomeName(homeName);
		return homeDao.selectHomeByConditionNoPage(home);
	}
	@Override
	public ModulePage<Home> selectHomesByPage(Home home) {
		User user = TokenUtil.getUser();
		if (user.getRoleId() == Constans.homeRole) {
			home.setHomeUserId(user.getUserId());
		}
		List<Home> data = homeDao.selectHomeByCondition(home);
		int count = homeDao.selectHomeCountByCondition(home);
		ModulePage<Home> homePage = new ModulePage<>();
		homePage.setCount(count);
		homePage.setData(data);
        return homePage;
	}
	@Override
	public Integer addHome(Home home) {
		return homeDao.insert(home);
	}
	@Override
	public Integer updateHome(Home home) {
		return homeDao.update(home);
	}
	@Override
	public Integer deleteHomeById(Home home) {
		return homeDao.deleteHomeById(home);
	}
	@Override
	public int updateStatusById(Home home) {
		return homeDao.updateStatusById(home);
	}
	@Override
	public List<Home> selectHomeByUserIdAndExcludeId(Home home) {
		return homeDao.selectHomeByConditionNoPage(home);
	}
	
}
