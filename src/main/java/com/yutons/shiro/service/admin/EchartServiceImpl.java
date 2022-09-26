package com.yutons.shiro.service.admin;

import com.alibaba.fastjson.JSON;
import com.yutons.shiro.bean.admin.CheckOrder;
import com.yutons.shiro.bean.admin.ModulePage;
import com.yutons.shiro.bean.admin.QuotaEchart;
import com.yutons.shiro.bean.admin.quota.Immunoglobulin;
import com.yutons.shiro.bean.admin.quota.Routine;
import com.yutons.shiro.bean.admin.quota.Screening;
import com.yutons.shiro.bean.admin.quota.Tesr;
import com.yutons.shiro.bean.admin.quota.Urinalysis;
import com.yutons.shiro.bean.quota.BaseQuota;
import com.yutons.shiro.bean.quota.esr.Esr;
import com.yutons.shiro.bean.quota.immunoglobulin.AProtein;
import com.yutons.shiro.bean.quota.immunoglobulin.BtC3;
import com.yutons.shiro.bean.quota.immunoglobulin.BtC4;
import com.yutons.shiro.bean.quota.immunoglobulin.GProtein;
import com.yutons.shiro.bean.quota.immunoglobulin.MProtein;
import com.yutons.shiro.bean.quota.protein.Urine;
import com.yutons.shiro.bean.quota.protein.UrineProtein;
import com.yutons.shiro.bean.quota.protein.UrineProtein24;
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
import com.yutons.shiro.bean.vo.CheckOrderVO;
import com.yutons.shiro.bean.vo.ImmunoglobulinVO;
import com.yutons.shiro.bean.vo.ProteinVO;
import com.yutons.shiro.bean.vo.RoutineVO;
import com.yutons.shiro.bean.vo.ScreeningVO;
import com.yutons.shiro.bean.vo.TesrVO;
import com.yutons.shiro.bean.vo.UrinalysisVO;
import com.yutons.shiro.bean.vo.req.QuotaEchartLoadRequest;
import com.yutons.shiro.bean.vo.resp.QuotaEchartLoadResponse;
import com.yutons.shiro.dao.admin.CheckOrderDao;
import com.yutons.shiro.dao.admin.ImmunoglobulinDao;
import com.yutons.shiro.dao.admin.ProteinDao;
import com.yutons.shiro.dao.admin.QuotaEchartDao;
import com.yutons.shiro.dao.admin.RoutineDao;
import com.yutons.shiro.dao.admin.ScreeningDao;
import com.yutons.shiro.dao.admin.TesrDao;
import com.yutons.shiro.dao.admin.UrinalysisDao;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.utils.DateUtils;
import org.apache.shiro.util.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class EchartServiceImpl implements EchartService {
	public static final char UNDERLINE = '_';
    @Resource
    private QuotaEchartDao quotaEchartDao;

	@Override
	public QuotaEchartLoadResponse selectQuotaEchartData(QuotaEchartLoadRequest request) {
		if(Objects.isNull(request)) {
			log.error("EchartServiceImpl#selectQuotaEchartData request is null");
			return null;
		}
		String table = "t_"+request.getCheckType();
		if(StringUtils.isEmpty(request.getTimeSearch())) {
			request.setTimeSearch("100");
		}
		Integer timer = Integer.parseInt(request.getTimeSearch());
		List<QuotaEchart> leastQuota = quotaEchartDao.getLeastQuota(table, request.getQuotaName(), timer);
		QuotaEchartLoadResponse response = new QuotaEchartLoadResponse();
		List<String> dateString = new ArrayList<>();
		List<Double> series = new ArrayList<>();
		if(!CollectionUtils.isEmpty(leastQuota)) {
			for(int i=leastQuota.size()-1;i>=0;i--) {
				dateString.add(DateUtils.formatDate(leastQuota.get(i).getDate(), "yyyy-MM-dd"));
				series.add(leastQuota.get(i).getValue());
			}
			response.setDateString(dateString);
			response.setSeriesData(series);
			String cName = "com.yutons.shiro.bean.quota."+request.getCheckType()+"."+underlineToCamel(request.getQuotaName());
			try {
				BaseQuota quota =  (BaseQuota)Class.forName(cName).newInstance();
				response.setDownLimit(quota.getDownLimit());
				response.setUpLimit(quota.getUpLimit());
				response.setUnit(quota.getUnit());
			} catch (Exception e) {
				log.error("EchartServiceImpl#selectQuotaEchartData error={}", JSON.toJSONString(e.getMessage()));
			}
		}
		return response;
	}

	/**
	 * 下划线格式字符串转换为驼峰格式字符串
	 *
	 * @param param
	 * @return
	 */
	public String underlineToCamel(String param) {
		if (param == null || "".equals(param.trim())) {
			return "";
		}
		int len = param.length();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++) {
			char c = param.charAt(i);
			if (c == UNDERLINE) {
				if (++i < len) {
					sb.append(Character.toUpperCase(param.charAt(i)));
				}
			} else {
				sb.append(c);
			}
		}
		sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
		return sb.toString();
	}

}
