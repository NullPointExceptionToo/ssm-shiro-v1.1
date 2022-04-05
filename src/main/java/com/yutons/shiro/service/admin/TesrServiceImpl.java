package com.yutons.shiro.service.admin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.yutons.shiro.bean.admin.CheckOrder;
import com.yutons.shiro.bean.admin.quota.Tesr;
import com.yutons.shiro.bean.quota.BaseQuota;
import com.yutons.shiro.bean.quota.esr.Esr;
import com.yutons.shiro.bean.vo.TesrVO;
import com.yutons.shiro.dao.admin.CheckOrderDao;
import org.apache.http.client.utils.DateUtils;
import org.apache.shiro.util.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.yutons.shiro.bean.admin.ModulePage;
import com.yutons.shiro.bean.admin.User;
import com.yutons.shiro.dao.admin.TesrDao;
import com.yutons.shiro.util.Constans;
import com.yutons.shiro.util.TokenUtil;

@Service
public class TesrServiceImpl implements TesrService {
    private static final Logger logger = LoggerFactory.getLogger(TesrServiceImpl.class);
    @Resource
    private TesrDao tesrDao;
    @Resource
    private CheckOrderDao checkOrderDao;

	@Override
	public ModulePage<TesrVO> selecTesrsByPage(Tesr tesr) {
		ModulePage<TesrVO> mode = new ModulePage<>();
		List<Tesr> list = tesrDao.selectTesrByCondition(tesr);
		int count = tesrDao.selectTesrCountByCondition(tesr);
		List<TesrVO> res = new ArrayList<>();
		if(!CollectionUtils.isEmpty(list)) {
			for(Tesr esr: list) {
				res.add(boCoverVo(esr));
			}
		}
		mode.setCount(count);
		mode.setData(res);
		return mode;
	}
	
	
    public TesrVO selectTesrsById(int id){
		Tesr tesr = tesrDao.selectTesrById(Tesr.builder().id(id).build());
    	return boCoverVo(tesr);
    }
    
    @Override
	public Integer addTesr(Tesr tesr) {
		return tesrDao.insert(tesr);
	}
	
	@Override
	public Integer delTesr(Tesr tesr) {
		return tesrDao.deleteTesrById(tesr);
	}

	@Override
	public Integer updateTesr(Tesr tesr) {
		return tesrDao.update(tesr);
	}

	/**
	 * bo & vo 转换方法
	 * @return
	 */
	private TesrVO boCoverVo(Tesr tesr) {
		CheckOrder checkOrder = checkOrderDao.selectCheckOrderById(
				CheckOrder.builder().id(tesr.getCheck_id()).build());
		TesrVO build = TesrVO.builder().
				dateTime(DateUtils.formatDate(checkOrder.getDate(), "yyyy-MM-dd")).
				hospital(checkOrder.getHospital()).
				check_id(tesr.getCheck_id()).
				esr(new Esr(tesr.getEsr())).
				id(tesr.getId()).
				build();
		List<BaseQuota> array = new ArrayList<>();
		array.add(build.getEsr());
		build.setQuotas(array);
		return build;
	}

    
}
