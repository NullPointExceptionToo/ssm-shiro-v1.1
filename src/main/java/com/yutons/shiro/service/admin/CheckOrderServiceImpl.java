package com.yutons.shiro.service.admin;

import com.yutons.shiro.bean.admin.CheckOrder;
import com.yutons.shiro.bean.admin.ModulePage;
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
import com.yutons.shiro.dao.admin.CheckOrderDao;
import com.yutons.shiro.dao.admin.ImmunoglobulinDao;
import com.yutons.shiro.dao.admin.ProteinDao;
import com.yutons.shiro.dao.admin.RoutineDao;
import com.yutons.shiro.dao.admin.ScreeningDao;
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
public class CheckOrderServiceImpl implements CheckOrderService {
    private static final Logger logger = LoggerFactory.getLogger(CheckOrderServiceImpl.class);
    @Resource
    private CheckOrderDao checkOrderDao;
    @Resource
    private TesrDao tesrDao;
	@Resource
    private ImmunoglobulinDao immunoglobulinDao;
	@Resource
    private ProteinDao proteinDao;
	@Resource
    private RoutineDao routineDao;
	@Resource
    private ScreeningDao screeningDao;
	@Resource
    private UrinalysisDao urinalysisDao;

	@Override
	public ModulePage<CheckOrder> selecCheckOrdersByPage(CheckOrder checkOrder) {
		ModulePage<CheckOrder> mode = new ModulePage<>();
		List<CheckOrder> list = checkOrderDao.selectCheckOrderByCondition(checkOrder);
		int count = checkOrderDao.selectCheckOrderCountByCondition(checkOrder);
		mode.setCount(count);
		mode.setData(list);
		return mode;
	}
	
	
    public CheckOrderVO selectCheckOrdersById(int id){
		CheckOrder checkOrder = checkOrderDao.selectCheckOrderById(CheckOrder.builder().id(id).build());
    	return insatllCheckOrderVO(checkOrder);
    }
    
    @Override
	public Integer addCheckOrder(CheckOrder checkOrder) {
		return checkOrderDao.insert(checkOrder);
	}

	/**
	 * 级联删除
	 * @param checkOrder
	 * @return
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public Integer delCheckOrder(CheckOrder checkOrder) {
		tesrDao.deleteTesrByCheckId(checkOrder.getId());
		immunoglobulinDao.deleteImmunoglobulinByCheckId(checkOrder.getId());
		proteinDao.deleteProteinByCheckId(checkOrder.getId());
		routineDao.deleteRoutineByCheckId(checkOrder.getId());
		screeningDao.deleteScreeningByCheckId(checkOrder.getId());
		urinalysisDao.deleteUrinalysisByCheckId(checkOrder.getId());
		return checkOrderDao.deleteCheckOrderById(CheckOrder.builder().id(checkOrder.getId()).build());
	}

	@Override
	public Integer updateCheckOrder(CheckOrder checkOrder) {
		return checkOrderDao.update(checkOrder);
	}

	@Override
	public List<CheckOrder> selectUnBindCheckOrder(String table) {
		return checkOrderDao.selectUnBindCheckOrder(table);
	}

	/**
	 * 封装检查单详情
	 * @return
	 */
	private CheckOrderVO insatllCheckOrderVO(CheckOrder checkOrder) {
		List<Tesr> tesrs = tesrDao.selectTesrByCondition(Tesr.builder().check_id(checkOrder.getId()).build());
		List<Immunoglobulin> immunoglobulins = immunoglobulinDao.selectImmunoglobulinByCondition(
				Immunoglobulin.builder().check_id(checkOrder.getId()).build());
		List<com.yutons.shiro.bean.admin.quota.Protein> proteins = proteinDao.selectProteinByCondition(
				com.yutons.shiro.bean.admin.quota.Protein.builder().check_id(checkOrder.getId()).build());
		List<Routine> routines = routineDao.selectRoutineByCondition(Routine.builder().check_id(checkOrder.getId()).build());
		List<Screening> screenings = screeningDao.selectScreeningByCondition(Screening.builder().check_id(checkOrder.getId()).build());
		List<Urinalysis> urinalyses = urinalysisDao.selectUrinalysisByCondition(Urinalysis.builder().check_id(checkOrder.getId()).build());
		return CheckOrderVO.builder().
				dateTime(DateUtils.formatDate(checkOrder.getDate(), "yyyy-MM-dd")).
				hospital(checkOrder.getHospital()).
				medicial(checkOrder.getMedicial()).
				fd_gov(checkOrder.getFd_gov()).
				fd_self(checkOrder.getFd_self()).
				immunoglobulinVO(CollectionUtils.isEmpty(immunoglobulins)?null:installImmunoglobulinVO(immunoglobulins.get(0))).
				proteinVO(CollectionUtils.isEmpty(proteins)?null:installProteinVO(proteins.get(0))).
				routineVO(CollectionUtils.isEmpty(routines)?null:installRoutineVO(routines.get(0))).
				screeningVO(CollectionUtils.isEmpty(screenings)?null:installScreeningVO(screenings.get(0))).
				urinalysisVO(CollectionUtils.isEmpty(urinalyses)?null:installUrinalysisVO(urinalyses.get(0))).
				tesrVO(CollectionUtils.isEmpty(tesrs)?null:installTesrVO(tesrs.get(0))).
				id(checkOrder.getId()).
				build();
	}

	/**
	 * 组装UrinalysisVO
	 * @param urinalysis
	 * @return
	 */
	private UrinalysisVO installUrinalysisVO(Urinalysis urinalysis) {
		UrinalysisVO build = UrinalysisVO.builder().
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

	/**
	 * 组装tesrVO
	 * @param tesr
	 * @return
	 */
	private TesrVO installTesrVO(Tesr tesr) {
		TesrVO build = TesrVO.builder().
				esr(new Esr(tesr.getEsr())).
				id(tesr.getId()).
				build();
		List<BaseQuota> array = new ArrayList<>();
		array.add(build.getEsr());
		build.setQuotas(array);
		return build;
	}

	/**
	 * 组装ScreeningVO
	 * @param screening
	 * @return
	 */
	private ScreeningVO installScreeningVO(Screening screening) {
		ScreeningVO build = ScreeningVO.builder().
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

	/**
	 * 组装RoutineVO
	 * @param routine
	 * @return
	 */
	private RoutineVO installRoutineVO(Routine routine) {
		RoutineVO build = RoutineVO.builder().
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

	/**
	 * 组装ProteinVO
	 * @param protein
	 * @return
	 */
	private ProteinVO installProteinVO(com.yutons.shiro.bean.admin.quota.Protein protein) {
		ProteinVO build = ProteinVO.builder().
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

	/**
	 * 组装ImmunoglobulinVO
	 * @param immunoglobulin
	 * @return
	 */
	private ImmunoglobulinVO installImmunoglobulinVO(Immunoglobulin immunoglobulin) {
		ImmunoglobulinVO build = ImmunoglobulinVO.builder().
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
