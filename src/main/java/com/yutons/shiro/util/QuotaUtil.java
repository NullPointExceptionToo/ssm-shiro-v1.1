package com.yutons.shiro.util;

import java.util.HashMap;
import java.util.Map;

public class QuotaUtil {
	public static final Map<String,Map<String, String>> typeMap;
	public static final Map<String,String> immunoglobulinMap;
	public static final Map<String,String> proteinMap;
	public static final Map<String,String> tesrMap;
	public static final Map<String,String> routineMap;
	public static final Map<String,String> screeningMap;
	public static final Map<String,String> urinalysisMap;
	static{
		immunoglobulinMap = new HashMap<String,String>(){
			{
				put("补体C3","bt_c3");
				put("补体C4","bt_c4");
				put("免疫球蛋白M","m_protein");
				put("免疫球蛋白A","a_protein");
				put("免疫球蛋白G","g_protein");
		    }
		};
		proteinMap = new HashMap<String,String>(){
			{
				put("尿量","urine");
				put("尿蛋白","urine_protein");
				put("24小时尿蛋白","m_protein");
			}
		};
		tesrMap = new HashMap<String,String>(){
			{
				put("血沉","esr");
			}
		};
		routineMap = new HashMap<String,String>(){
			{
				put("白细胞计","white_count");
				put("中性粒细胞(%)","mid_cell_percent");
				put("淋巴细胞(%)","lb_cell_percent");
				put("单核细胞(%)","singo_cell_percent");
				put("嗜酸性粒细胞(%)","shuan_cell_percent");
				put("嗜碱性粒细胞(%)","jian_cell_percent");
				put("中性粒细胞","mid_cell");
				put("淋巴细胞","lb_cell");
				put("单核细胞","singo_cell");
				put("嗜酸性粒细胞","shuan_cell");
				put("嗜碱性粒细胞","jian_cell");
				put("红细胞计数","red_count");
				put("血红蛋白","hemoglobin");
				put("红细胞积压","red_cell_jy");
				put("平均红细胞体积","ave_red_cell_lv");
				put("平均血红蛋白含量","ave_hemoglobin_per");
				put("平均血红蛋白浓度","ave_hemoglobin_lev");
				put("红细胞分布宽度","red_cell_width");
				put("血小板计数","platelet_count");
				put("血小板积压","platelet_jy");
				put("平均血小板体积","ave_platelet_lv");
			}
		};
		screeningMap = new HashMap<String,String>(){
			{
				put("总蛋白","total_protein");
				put("白蛋白","white_protein");
				put("球蛋白","circle_protein");
				put("白球蛋白比例","whilte_circle_per");
				put("谷丙转氨酶","aminotransferase");
				put("总胆红素","all_bilirubin");
				put("直接胆红素","dir_bilirubin");
				put("间接胆红素","no_bilirubin");
				put("肾小球滤过率-cr","glomerulus_per");
				put("肌酐","jigan");
				put("尿素","niaosu");
				put("尿酸","niaoshuan");
				put("甘油三醇","glycerol");
				put("总胆固醇","all_cholesterol");
				put("高密度脂蛋白-C","high_protein");
				put("空腹血糖","no_glucose");
				put("钾","jia");
				put("钠","na");
				put("氯","lv");
			}
		};
		urinalysisMap = new HashMap<String,String>(){
			{
				put("隐血","occult_blood");
				put("白细胞酯酶","leucocyte_esterase");
				put("蛋白质","protein");
				put("胆红素","bilirubin");
				put("酮体","ketone");
				put("尿胆原","urobilinogen");
				put("亚硝酸盐","nitrite");
				put("葡萄糖","glucose");
				put("pH值","pH");
				put("比重","levhigh");
				put("浊度","hun_lev");
				put("颜色","color");
				put("红细胞","red_cell");
				put("白细胞","white_cell");
				put("管型","tube");
				put("上皮细胞","up_cell");
				put("细菌","bacteria");
				put("结晶","crystal");
				put("粘液丝","filament");
				put("类酵母菌","class_bact");
			}
		};
		typeMap = new HashMap<String,Map<String, String>>(){
			{
				put("tesr",tesrMap);
				put("immunoglobulin",immunoglobulinMap);
				put("protein",proteinMap);
				put("routine",routineMap);
				put("screening",screeningMap);
				put("urinalysis",urinalysisMap);
			}
		};
	}

}
