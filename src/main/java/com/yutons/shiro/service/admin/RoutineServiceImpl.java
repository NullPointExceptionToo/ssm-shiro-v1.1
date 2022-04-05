package com.yutons.shiro.service.admin;

import com.yutons.shiro.bean.admin.CheckOrder;
import com.yutons.shiro.bean.admin.ModulePage;
import com.yutons.shiro.bean.admin.quota.Routine;
import com.yutons.shiro.bean.admin.quota.Tesr;
import com.yutons.shiro.bean.quota.BaseQuota;
import com.yutons.shiro.bean.quota.esr.Esr;
import com.yutons.shiro.bean.quota.routine.AveHemoglobinLev;
import com.yutons.shiro.bean.quota.routine.AveHemoglobinPer;
import com.yutons.shiro.bean.quota.routine.AvePlateletLv;
import com.yutons.shiro.bean.quota.routine.AveRedCellLv;
import com.yutons.shiro.bean.quota.routine.Hemoglobin;
import com.yutons.shiro.bean.quota.routine.JianCell;
import com.yutons.shiro.bean.quota.routine.JianCellPercent;
import com.yutons.shiro.bean.quota.routine.LbCell;
import com.yutons.shiro.bean.quota.routine.LbCellPercent;
import com.yutons.shiro.bean.quota.routine.MidCell;
import com.yutons.shiro.bean.quota.routine.MidCellPercent;
import com.yutons.shiro.bean.quota.routine.PlateletCount;
import com.yutons.shiro.bean.quota.routine.PlateletJy;
import com.yutons.shiro.bean.quota.routine.RedCellJy;
import com.yutons.shiro.bean.quota.routine.RedCellWidth;
import com.yutons.shiro.bean.quota.routine.RedCount;
import com.yutons.shiro.bean.quota.routine.ShuanCell;
import com.yutons.shiro.bean.quota.routine.ShuanCellPercent;
import com.yutons.shiro.bean.quota.routine.SingoCell;
import com.yutons.shiro.bean.quota.routine.SingoCellPercent;
import com.yutons.shiro.bean.quota.routine.WhiteCount;
import com.yutons.shiro.bean.vo.RoutineVO;
import com.yutons.shiro.bean.vo.TesrVO;
import com.yutons.shiro.dao.admin.CheckOrderDao;
import com.yutons.shiro.dao.admin.RoutineDao;
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
public class RoutineServiceImpl implements RoutineService {
    private static final Logger logger = LoggerFactory.getLogger(RoutineServiceImpl.class);
    @Resource
    private RoutineDao routineDao;
    @Resource
    private CheckOrderDao checkOrderDao;

	@Override
	public ModulePage<RoutineVO> selecRoutinesByPage(Routine routine) {
		ModulePage<RoutineVO> mode = new ModulePage<>();
		List<Routine> list = routineDao.selectRoutineByCondition(routine);
		int count = routineDao.selectRoutineCountByCondition(routine);
		List<RoutineVO> res = new ArrayList<>();
		if(!CollectionUtils.isEmpty(list)) {
			for(Routine rou: list) {
				res.add(boCoverVo(rou));
			}
		}
		mode.setCount(count);
		mode.setData(res);
		return mode;
	}
	
	
    public RoutineVO selectRoutinesById(int id){
		Routine routine = routineDao.selectRoutineById(Routine.builder().id(id).build());
    	return boCoverVo(routine);
    }
    
    @Override
	public Integer addRoutine(Routine routine) {
		return routineDao.insert(routine);
	}
	
	@Override
	public Integer delRoutine(Routine routine) {
		return routineDao.deleteRoutineById(routine);
	}

	@Override
	public Integer updateRoutine(Routine routine) {
		return routineDao.update(routine);
	}

	/**
	 * bo & vo 转换方法
	 * @return
	 */
	private RoutineVO boCoverVo(Routine routine) {
		CheckOrder checkOrder = checkOrderDao.selectCheckOrderById(
				CheckOrder.builder().id(routine.getCheck_id()).build());
		RoutineVO build = RoutineVO.builder().
				dateTime(DateUtils.formatDate(checkOrder.getDate(), "yyyy-MM-dd")).
				hospital(checkOrder.getHospital()).
				check_id(routine.getCheck_id()).
				ave_hemoglobin_lev(new AveHemoglobinLev(routine.getAve_hemoglobin_lev())).
				ave_hemoglobin_per(new AveHemoglobinPer(routine.getAve_hemoglobin_per())).
				ave_platelet_lv(new AvePlateletLv(routine.getAve_platelet_lv())).
				ave_red_cell_lv(new AveRedCellLv(routine.getAve_red_cell_lv())).
				hemoglobin(new Hemoglobin(routine.getHemoglobin())).
				jian_cell(new JianCell(routine.getJian_cell())).
				jian_cell_percent(new JianCellPercent(routine.getJian_cell_percent())).
				lb_cell(new LbCell(routine.getLb_cell())).
				lb_cell_percent(new LbCellPercent(routine.getLb_cell_percent())).
				mid_cell(new MidCell(routine.getMid_cell())).
				mid_cell_percent(new MidCellPercent(routine.getMid_cell_percent())).
				platelet_count(new PlateletCount(routine.getPlatelet_count())).
				platelet_jy(new PlateletJy(routine.getPlatelet_jy())).
				red_cell_jy(new RedCellJy(routine.getRed_cell_jy())).
				red_cell_width(new RedCellWidth(routine.getRed_cell_width())).
				red_count(new RedCount(routine.getRed_count())).
				shuan_cell(new ShuanCell(routine.getShuan_cell())).
				singo_cell_percent(new SingoCellPercent(routine.getSingo_cell_percent())).
				white_count(new WhiteCount(routine.getWhite_count())).
				singo_cell(new SingoCell(routine.getSingo_cell())).
				shuan_cell_percent(new ShuanCellPercent(routine.getShuan_cell_percent())).
				id(routine.getId()).
				build();
		List<BaseQuota> array = new ArrayList<>();
		array.add(build.getAve_hemoglobin_lev());
		array.add(build.getAve_hemoglobin_per());
		array.add(build.getAve_platelet_lv());
		array.add(build.getAve_red_cell_lv());
		array.add(build.getHemoglobin());
		array.add(build.getJian_cell());
		array.add(build.getJian_cell_percent());
		array.add(build.getLb_cell());
		array.add(build.getLb_cell_percent());
		array.add(build.getMid_cell());
		array.add(build.getMid_cell_percent());
		array.add(build.getPlatelet_count());
		array.add(build.getPlatelet_jy());
		array.add(build.getRed_cell_jy());
		array.add(build.getRed_cell_width());
		array.add(build.getRed_count());
		array.add(build.getShuan_cell());
		array.add(build.getSingo_cell_percent());
		array.add(build.getWhite_count());
		array.add(build.getSingo_cell());
		array.add(build.getShuan_cell_percent());
		build.setQuotas(array);
		return build;
	}

    
}
