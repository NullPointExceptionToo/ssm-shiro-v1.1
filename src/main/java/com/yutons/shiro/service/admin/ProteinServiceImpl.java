package com.yutons.shiro.service.admin;

import com.yutons.shiro.bean.admin.CheckOrder;
import com.yutons.shiro.bean.admin.ModulePage;
import com.yutons.shiro.bean.admin.quota.Protein;
import com.yutons.shiro.bean.admin.quota.Tesr;
import com.yutons.shiro.bean.quota.BaseQuota;
import com.yutons.shiro.bean.quota.esr.Esr;
import com.yutons.shiro.bean.quota.protein.Urine;
import com.yutons.shiro.bean.quota.protein.UrineProtein;
import com.yutons.shiro.bean.quota.protein.UrineProtein24;
import com.yutons.shiro.bean.vo.ProteinVO;
import com.yutons.shiro.bean.vo.TesrVO;
import com.yutons.shiro.dao.admin.CheckOrderDao;
import com.yutons.shiro.dao.admin.ProteinDao;
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
public class ProteinServiceImpl implements ProteinService {
    private static final Logger logger = LoggerFactory.getLogger(ProteinServiceImpl.class);
    @Resource
    private ProteinDao proteinDao;
    @Resource
    private CheckOrderDao checkOrderDao;

	@Override
	public ModulePage<ProteinVO> selecProteinsByPage(Protein protein) {
		ModulePage<ProteinVO> mode = new ModulePage<>();
		List<Protein> list = proteinDao.selectProteinByCondition(protein);
		int count = proteinDao.selectProteinCountByCondition(protein);
		List<ProteinVO> res = new ArrayList<>();
		if(!CollectionUtils.isEmpty(list)) {
			for(Protein pro: list) {
				res.add(boCoverVo(pro));
			}
		}
		mode.setCount(count);
		mode.setData(res);
		return mode;
	}
	
	
    public ProteinVO selectProteinsById(int id){
		Protein protein = proteinDao.selectProteinById(Protein.builder().id(id).build());
    	return boCoverVo(protein);
    }
    
    @Override
	public Integer addProtein(Protein protein) {
		return proteinDao.insert(protein);
	}
	
	@Override
	public Integer delProtein(Protein protein) {
		return proteinDao.deleteProteinById(protein);
	}

	@Override
	public Integer updateProtein(Protein protein) {
		return proteinDao.update(protein);
	}

	/**
	 * bo & vo 转换方法
	 * @return
	 */
	private ProteinVO boCoverVo(Protein protein) {
		CheckOrder checkOrder = checkOrderDao.selectCheckOrderById(
				CheckOrder.builder().id(protein.getCheck_id()).build());
		ProteinVO build = ProteinVO.builder().
				dateTime(DateUtils.formatDate(checkOrder.getDate(), "yyyy-MM-dd")).
				hospital(checkOrder.getHospital()).
				check_id(protein.getCheck_id()).
				urine(new Urine(protein.getUrine())).
				urine_protein(new UrineProtein(protein.getUrine_protein())).
				urine_protein24(new UrineProtein24(protein.getUrine_protein24())).
				id(protein.getId()).
				build();
		List<BaseQuota> array = new ArrayList<>();
		array.add(build.getUrine());
		array.add(build.getUrine_protein());
		array.add(build.getUrine_protein24());
		build.setQuotas(array);
		return build;
	}

    
}
