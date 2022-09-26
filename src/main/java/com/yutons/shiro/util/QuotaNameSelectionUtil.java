package com.yutons.shiro.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @title: QuotaNameSelectionUtil
 * @Author fq
 * @Date: 2022/4/8 14:57
 * @Version 1.0
 */
public class QuotaNameSelectionUtil {
    public static final Map<String, Map<String, String>> typeMap;
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
                put("尿蛋白","urine_protein");
                put("24小时尿蛋白","urine_protein24");
            }
        };
        tesrMap = new HashMap<String,String>(){
            {
                put("血沉","esr");
            }
        };
        routineMap = new HashMap<String,String>(){
            {
                put("白细胞计数","white_count");
                put("中性粒细胞","mid_cell");
                put("淋巴细胞","lb_cell");
                put("单核细胞","singo_cell");
                put("红细胞计数","red_count");
                put("血红蛋白","hemoglobin");
                put("红细胞积压","red_cell_jy");
                put("血小板计数","platelet_count");
                put("血小板积压","platelet_jy");
            }
        };
        screeningMap = new HashMap<String,String>(){
            {
                put("总蛋白","total_protein");
                put("白蛋白","white_protein");
                put("球蛋白","circle_protein");
                put("肌酐","jigan");
                put("甘油三醇","glycerol");
                put("尿酸","niaoshuan");
            }
        };
        urinalysisMap = new HashMap<String,String>(){
            {
                put("红细胞","red_cell");
                put("白细胞","white_cell");

            }
        };
        typeMap = new HashMap<String,Map<String, String>>(){
            {
                put("esr",tesrMap);
                put("immunoglobulin",immunoglobulinMap);
                put("protein",proteinMap);
                put("routine",routineMap);
                put("screening",screeningMap);
                put("urinalysis",urinalysisMap);
            }
        };
    }
}
