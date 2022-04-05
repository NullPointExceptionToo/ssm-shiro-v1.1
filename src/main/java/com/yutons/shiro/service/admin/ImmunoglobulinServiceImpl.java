package com.yutons.shiro.service.admin;

import com.yutons.shiro.bean.admin.CheckOrder;
import com.yutons.shiro.bean.admin.ModulePage;
import com.yutons.shiro.bean.admin.quota.Immunoglobulin;
import com.yutons.shiro.bean.admin.quota.Tesr;
import com.yutons.shiro.bean.quota.BaseQuota;
import com.yutons.shiro.bean.quota.esr.Esr;
import com.yutons.shiro.bean.quota.immunoglobulin.AProtein;
import com.yutons.shiro.bean.quota.immunoglobulin.BtC3;
import com.yutons.shiro.bean.quota.immunoglobulin.BtC4;
import com.yutons.shiro.bean.quota.immunoglobulin.GProtein;
import com.yutons.shiro.bean.quota.immunoglobulin.MProtein;
import com.yutons.shiro.bean.vo.ImmunoglobulinVO;
import com.yutons.shiro.bean.vo.TesrVO;
import com.yutons.shiro.dao.admin.CheckOrderDao;
import com.yutons.shiro.dao.admin.ImmunoglobulinDao;
import com.yutons.shiro.dao.admin.TesrDao;
import org.apache.http.client.utils.DateUtils;
import org.apache.shiro.util.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ImmunoglobulinServiceImpl implements ImmunoglobulinService {
    private static final Logger logger = LoggerFactory.getLogger(ImmunoglobulinServiceImpl.class);
    @Resource
    private ImmunoglobulinDao immunoglobulinDao;
    @Resource
    private CheckOrderDao checkOrderDao;

	@Override
	public ModulePage<ImmunoglobulinVO> selecImmunoglobulinsByPage(Immunoglobulin immunoglobulin) {
		ModulePage<ImmunoglobulinVO> mode = new ModulePage<>();
		List<Immunoglobulin> list = immunoglobulinDao.selectImmunoglobulinByCondition(immunoglobulin);
		int count = immunoglobulinDao.selectImmunoglobulinCountByCondition(immunoglobulin);
		List<ImmunoglobulinVO> res = new ArrayList<>();
		if(!CollectionUtils.isEmpty(list)) {
			for(Immunoglobulin immu: list) {
				res.add(boCoverVo(immu));
			}
		}
		mode.setCount(count);
		mode.setData(res);
		return mode;
	}
	
	
    public ImmunoglobulinVO selectImmunoglobulinsById(int id){
		Immunoglobulin immunoglobulin = immunoglobulinDao.selectImmunoglobulinById(Immunoglobulin.builder().id(id).build());
    	return boCoverVo(immunoglobulin);
    }
    
    @Override
	public Integer addImmunoglobulin(Immunoglobulin immunoglobulin) {
		return immunoglobulinDao.insert(immunoglobulin);
	}
	
	@Override
	public Integer delImmunoglobulin(Immunoglobulin immunoglobulin) {
		return immunoglobulinDao.deleteImmunoglobulinById(immunoglobulin);
	}

	@Override
	public Integer updateImmunoglobulin(Immunoglobulin immunoglobulin) {
		return immunoglobulinDao.update(immunoglobulin);
	}

	/**
	 * bo & vo 转换方法
	 * @return
	 */
	private ImmunoglobulinVO boCoverVo(Immunoglobulin immunoglobulin) {
		CheckOrder checkOrder = checkOrderDao.selectCheckOrderById(
				CheckOrder.builder().id(immunoglobulin.getCheck_id()).build());
		ImmunoglobulinVO build = ImmunoglobulinVO.builder().
				dateTime(DateUtils.formatDate(checkOrder.getDate(), "yyyy-MM-dd")).
				hospital(checkOrder.getHospital()).
				check_id(immunoglobulin.getCheck_id()).
				a_protein(new AProtein(immunoglobulin.getA_protein())).
				g_protein(new GProtein(immunoglobulin.getG_protein())).
				m_protein(new MProtein(immunoglobulin.getM_protein())).
				bt_c3(new BtC3(immunoglobulin.getBt_c3())).
				bt_c4(new BtC4(immunoglobulin.getBt_c4())).
				id(immunoglobulin.getId()).
				build();
		List<BaseQuota> array = new ArrayList<>();
		array.add(build.getA_protein());
		array.add(build.getG_protein());
		array.add(build.getM_protein());
		array.add(build.getBt_c3());
		array.add(build.getBt_c4());
		build.setQuotas(array);
		return build;
	}

    
}
