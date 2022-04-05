package com.yutons.shiro.service.admin;

import com.yutons.shiro.bean.admin.CheckOrder;
import com.yutons.shiro.bean.admin.ModulePage;
import com.yutons.shiro.bean.admin.quota.Tesr;
import com.yutons.shiro.bean.admin.quota.Urinalysis;
import com.yutons.shiro.bean.quota.BaseQuota;
import com.yutons.shiro.bean.quota.esr.Esr;
import com.yutons.shiro.bean.quota.urinalysis.Bacteria;
import com.yutons.shiro.bean.quota.urinalysis.Bilirubin;
import com.yutons.shiro.bean.quota.urinalysis.ClassBact;
import com.yutons.shiro.bean.quota.urinalysis.Color;
import com.yutons.shiro.bean.quota.urinalysis.Crystal;
import com.yutons.shiro.bean.quota.urinalysis.Filament;
import com.yutons.shiro.bean.quota.urinalysis.Glucose;
import com.yutons.shiro.bean.quota.urinalysis.HunLev;
import com.yutons.shiro.bean.quota.urinalysis.Ketone;
import com.yutons.shiro.bean.quota.urinalysis.LeucocyteEsterase;
import com.yutons.shiro.bean.quota.urinalysis.Levhigh;
import com.yutons.shiro.bean.quota.urinalysis.Nitrite;
import com.yutons.shiro.bean.quota.urinalysis.OccultBlood;
import com.yutons.shiro.bean.quota.urinalysis.PH;
import com.yutons.shiro.bean.quota.urinalysis.Protein;
import com.yutons.shiro.bean.quota.urinalysis.RedCell;
import com.yutons.shiro.bean.quota.urinalysis.Tube;
import com.yutons.shiro.bean.quota.urinalysis.UpCell;
import com.yutons.shiro.bean.quota.urinalysis.Urobilinogen;
import com.yutons.shiro.bean.quota.urinalysis.WhiteCell;
import com.yutons.shiro.bean.vo.TesrVO;
import com.yutons.shiro.bean.vo.UrinalysisVO;
import com.yutons.shiro.dao.admin.CheckOrderDao;
import com.yutons.shiro.dao.admin.TesrDao;
import com.yutons.shiro.dao.admin.UrinalysisDao;
import org.apache.http.client.utils.DateUtils;
import org.apache.shiro.util.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UrinalysisServiceImpl implements UrinalysisService {
    private static final Logger logger = LoggerFactory.getLogger(UrinalysisServiceImpl.class);
    @Resource
    private UrinalysisDao urinalysisDao;
    @Resource
    private CheckOrderDao checkOrderDao;

	@Override
	public ModulePage<UrinalysisVO> selecUrinalysisByPage(Urinalysis urinalysis) {
		ModulePage<UrinalysisVO> mode = new ModulePage<>();
		List<Urinalysis> list = urinalysisDao.selectUrinalysisByCondition(urinalysis);
		int count = urinalysisDao.selectUrinalysisCountByCondition(urinalysis);
		List<UrinalysisVO> res = new ArrayList<>();
		if(!CollectionUtils.isEmpty(list)) {
			for(Urinalysis urina: list) {
				res.add(boCoverVo(urina));
			}
		}
		mode.setCount(count);
		mode.setData(res);
		return mode;
	}
	
	
    public UrinalysisVO selectUrinalysisById(int id){
		Urinalysis urinalysis = urinalysisDao.selectUrinalysisById(Urinalysis.builder().id(id).build());
    	return boCoverVo(urinalysis);
    }
    
    @Override
	public Integer addUrinalysis(Urinalysis urinalysis) {
		return urinalysisDao.insert(urinalysis);
	}
	
	@Override
	public Integer delUrinalysis(Urinalysis urinalysis) {
		return urinalysisDao.deleteUrinalysisById(urinalysis);
	}

	@Override
	public Integer updateUrinalysis(Urinalysis urinalysis) {
		return urinalysisDao.update(urinalysis);
	}

    /**
	 * bo & vo 转换方法
	 * @return
	 */
	private UrinalysisVO boCoverVo(Urinalysis urinalysis) {
		CheckOrder checkOrder = checkOrderDao.selectCheckOrderById(
				CheckOrder.builder().id(urinalysis.getCheck_id()).build());
		UrinalysisVO build = UrinalysisVO.builder().
				dateTime(DateUtils.formatDate(checkOrder.getDate(), "yyyy-MM-dd")).
				hospital(checkOrder.getHospital()).
				check_id(urinalysis.getCheck_id()).
				bacteria(new Bacteria(urinalysis.getBacteria())).
				bilirubin(new Bilirubin(urinalysis.getBilirubin())).
				class_bact(new ClassBact(urinalysis.getClass_bact())).
				color(new Color(urinalysis.getColor())).
				crystal(new Crystal(urinalysis.getCrystal())).
				filament(new Filament(urinalysis.getFilament())).
				glucose(new Glucose(urinalysis.getGlucose())).
				hun_lev(new HunLev(urinalysis.getHun_lev())).
				ketone(new Ketone(urinalysis.getKetone())).
				leucocyte_esterase(new LeucocyteEsterase(urinalysis.getLeucocyte_esterase())).
				levhigh(new Levhigh(urinalysis.getLevhigh())).
				nitrite(new Nitrite(urinalysis.getNitrite())).
				occult_blood(new OccultBlood(urinalysis.getOccult_blood())).
				pH(new PH(urinalysis.getPH())).
				protein(new Protein(urinalysis.getProtein())).
				red_cell(new RedCell(urinalysis.getRed_cell())).
				tube(new Tube(urinalysis.getTube())).
				up_cell(new UpCell(urinalysis.getUp_cell())).
				urobilinogen(new Urobilinogen(urinalysis.getUrobilinogen())).
				white_cell(new WhiteCell(urinalysis.getWhite_cell())).
				id(urinalysis.getId()).
				build();
		List<BaseQuota> array = new ArrayList<>();
		array.add(build.getBacteria());
		array.add(build.getBilirubin());
		array.add(build.getClass_bact());
		array.add(build.getColor());
		array.add(build.getCrystal());
		array.add(build.getFilament());
		array.add(build.getGlucose());
		array.add(build.getHun_lev());
		array.add(build.getKetone());
		array.add(build.getLeucocyte_esterase());
		array.add(build.getLevhigh());
		array.add(build.getNitrite());
		array.add(build.getOccult_blood());
		array.add(build.getPH());
		array.add(build.getProtein());
		array.add(build.getRed_cell());
		array.add(build.getTube());
		array.add(build.getUp_cell());
		array.add(build.getUrobilinogen());
		array.add(build.getWhite_cell());
		build.setQuotas(array);
		return build;
	}

    
}
