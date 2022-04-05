package com.yutons.shiro.bean.vo;

import com.yutons.shiro.bean.quota.BaseQuota;
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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @title: ScreeningVO
 * @Author fq
 * @Date: 2022/3/20 14:35
 * @Version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScreeningVO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    /**
     * 复查单ID
     */
    private Integer check_id;
    /**
     * 总蛋白
     */
    private TotalProtein total_protein;
    /**
     * 白蛋白
     */
    private WhiteProtein white_protein;
    /**
     * 球蛋白
     */
    private CircleProtein circle_protein;
    /**
     * 白球蛋白比例
     */
    private WhilteCirclePer whilte_circle_per;
    /**
     * 谷丙转氨酶
     */
    private Aminotransferase aminotransferase;
    /**
     * 总胆红素
     */
    private AllBilirubin all_bilirubin;
    /**
     * 直接胆红素
     */
    private DirBilirubin dir_bilirubin;
    /**
     * 间接胆红素
     */
    private NoBilirubin no_bilirubin;
    /**
     * 肾小球滤过率-cr
     */
    private GlomerulusPer glomerulus_per;
    /**
     * 肌酐
     */
    private Jigan jigan;
    /**
     * 尿素
     */
    private Niaosu niaosu;
    /**
     * 尿酸
     */
    private Niaoshuan niaoshuan;
    /**
     * 甘油三醇
     */
    private Glycerol glycerol;
    /**
     * 总胆固醇
     */
    private AllCholesterol all_cholesterol;
    /**
     * 高密度脂蛋白-C
     */
    private HighProtein high_protein;
    /**
     * 空腹血糖
     */
    private NoGlucose no_glucose;
    /**
     * 钾
     */
    private Jia jia;
    /**
     * 钠
     */
    private Na na;
    /**
     * 氯
     */
    private Lv lv;

    private List<BaseQuota> quotas;
    private String hospital;
    private String dateTime;
}
