package com.yutons.shiro.service.admin;

import com.yutons.shiro.bean.admin.CheckOrder;
import com.yutons.shiro.bean.admin.ModulePage;
import com.yutons.shiro.bean.admin.quota.Screening;
import com.yutons.shiro.bean.admin.quota.Tesr;
import com.yutons.shiro.bean.quota.BaseQuota;
import com.yutons.shiro.bean.quota.esr.Esr;
import com.yutons.shiro.bean.quota.screening.AllBilirubin;
import com.yutons.shiro.bean.quota.screening.AllCholesterol;
import com.yutons.shiro.bean.quota.screening.Aminotransferase;
import com.yutons.shiro.bean.quota.screening.CircleProtein;
import com.yutons.shiro.bean.quota.screening.DirBilirubin;
import com.yutons.shiro.bean.quota.screening.GlomerulusPer;
import com.yutons.shiro.bean.quota.screening.Glycerol;
import com.yutons.shiro.bean.quota.screening.HighProtein;
import com.yutons.shiro.bean.quota.screening.Jia;
import com.yutons.shiro.bean.quota.screening.Jigan;
import com.yutons.shiro.bean.quota.screening.Lv;
import com.yutons.shiro.bean.quota.screening.Na;
import com.yutons.shiro.bean.quota.screening.Niaoshuan;
import com.yutons.shiro.bean.quota.screening.Niaosu;
import com.yutons.shiro.bean.quota.screening.NoBilirubin;
import com.yutons.shiro.bean.quota.screening.NoGlucose;
import com.yutons.shiro.bean.quota.screening.TotalProtein;
import com.yutons.shiro.bean.quota.screening.WhilteCirclePer;
import com.yutons.shiro.bean.quota.screening.WhiteProtein;
import com.yutons.shiro.bean.vo.ScreeningVO;
import com.yutons.shiro.bean.vo.TesrVO;
import com.yutons.shiro.dao.admin.CheckOrderDao;
import com.yutons.shiro.dao.admin.ScreeningDao;
import com.yutons.shiro.dao.admin.TesrDao;
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
public class ScreeningServiceImpl implements ScreeningService {
    private static final Logger logger = LoggerFactory.getLogger(ScreeningServiceImpl.class);
    @Resource
    private ScreeningDao screeningDao;
    @Resource
    private CheckOrderDao checkOrderDao;

	@Override
	public ModulePage<ScreeningVO> selecScreeningsByPage(Screening screening) {
		ModulePage<ScreeningVO> mode = new ModulePage<>();
		List<Screening> list = screeningDao.selectScreeningByCondition(screening);
		int count = screeningDao.selectScreeningCountByCondition(screening);
		List<ScreeningVO> res = new ArrayList<>();
		if(!CollectionUtils.isEmpty(list)) {
			for(Screening screen: list) {
				res.add(boCoverVo(screen));
			}
		}
		mode.setCount(count);
		mode.setData(res);
		return mode;
	}
	
	
    public ScreeningVO selectScreeningsById(int id){
		Screening screening = screeningDao.selectScreeningById(Screening.builder().id(id).build());
    	return boCoverVo(screening);
    }
    
    @Override
	public Integer addScreening(Screening screening) {
		return screeningDao.insert(screening);
	}
	
	@Override
	public Integer delScreening(Screening screening) {
		return screeningDao.deleteScreeningById(screening);
	}

	@Override
	public Integer updateScreening(Screening screening) {
		return screeningDao.update(screening);
	}

	/**
	 * bo & vo 转换方法
	 * @return
	 */
	private ScreeningVO boCoverVo(Screening screening) {
		CheckOrder checkOrder = checkOrderDao.selectCheckOrderById(
				CheckOrder.builder().id(screening.getCheck_id()).build());
		ScreeningVO build = ScreeningVO.builder().
				dateTime(DateUtils.formatDate(checkOrder.getDate(), "yyyy-MM-dd")).
				hospital(checkOrder.getHospital()).
				check_id(screening.getCheck_id()).
				all_bilirubin(new AllBilirubin(screening.getAll_bilirubin())).
				all_cholesterol(new AllCholesterol(screening.getAll_cholesterol())).
				aminotransferase(new Aminotransferase(screening.getAminotransferase())).
				circle_protein(new CircleProtein(screening.getCircle_protein())).
				dir_bilirubin(new DirBilirubin(screening.getDir_bilirubin())).
				glomerulus_per(new GlomerulusPer(screening.getGlomerulus_per())).
				glycerol(new Glycerol(screening.getGlycerol())).
				high_protein(new HighProtein(screening.getHigh_protein())).
				jia(new Jia(screening.getJia())).
				jigan(new Jigan(screening.getJigan())).
				lv(new Lv(screening.getLv())).
				na(new Na(screening.getNa())).
				niaoshuan(new Niaoshuan(screening.getNiaoshuan())).
				niaosu(new Niaosu(screening.getNiaosu())).
				no_bilirubin(new NoBilirubin(screening.getNo_bilirubin())).
				no_glucose(new NoGlucose(screening.getNo_glucose())).
				total_protein(new TotalProtein(screening.getTotal_protein())).
				whilte_circle_per(new WhilteCirclePer(screening.getWhilte_circle_per())).
				white_protein(new WhiteProtein(screening.getWhite_protein())).
				id(screening.getId()).
				build();
		List<BaseQuota> array = new ArrayList<>();
		array.add(build.getAll_bilirubin());
		array.add(build.getAll_cholesterol());
		array.add(build.getAminotransferase());
		array.add(build.getCircle_protein());
		array.add(build.getDir_bilirubin());
		array.add(build.getGlomerulus_per());
		array.add(build.getGlycerol());
		array.add(build.getHigh_protein());
		array.add(build.getJia());
		array.add(build.getJigan());
		array.add(build.getLv());
		array.add(build.getNa());
		array.add(build.getNiaoshuan());
		array.add(build.getNiaosu());
		array.add(build.getNo_bilirubin());
		array.add(build.getNo_glucose());
		array.add(build.getTotal_protein());
		array.add(build.getWhilte_circle_per());
		array.add(build.getWhite_protein());
		build.setQuotas(array);
		return build;
	}

    
}
