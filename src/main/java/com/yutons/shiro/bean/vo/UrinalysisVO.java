package com.yutons.shiro.bean.vo;

import com.yutons.shiro.bean.quota.BaseQuota;
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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @title: UrinalysisVO
 * @Author fq
 * @Date: 2022/3/20 14:22
 * @Version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UrinalysisVO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    /**
     * 复查单ID
     */
    private Integer check_id;
    /**
     * 隐血
     */
    private OccultBlood occult_blood;
    /**
     * 白细胞酯酶
     */
    private LeucocyteEsterase leucocyte_esterase;
    /**
     * 蛋白质
     */
    private Protein protein;
    /**
     * 胆红素
     */
    private Bilirubin bilirubin;
    /**
     * 酮体
     */
    private Ketone ketone;
    /**
     * 尿胆原
     */
    private Urobilinogen urobilinogen;
    /**
     * 亚硝酸盐
     */
    private Nitrite nitrite;
    /**
     * 葡萄糖
     */
    private Glucose glucose;
    /**
     * pH值
     */
    private PH pH;
    /**
     * 比重
     */
    private Levhigh levhigh;
    /**
     * 浊度
     */
    private HunLev hun_lev;
    /**
     * 颜色
     */
    private Color color;
    /**
     * 红细胞
     */
    private RedCell red_cell;
    /**
     * 白细胞
     */
    private WhiteCell white_cell;
    /**
     * 管型
     */
    private Tube tube;
    /**
     * 上皮细胞
     */
    private UpCell up_cell;
    /**
     * 细菌
     */
    private Bacteria bacteria;
    /**
     * 结晶
     */
    private Crystal crystal;
    /**
     * 粘液丝
     */
    private Filament filament;
    /**
     * 类酵母菌
     */
    private ClassBact class_bact;

    private List<BaseQuota> quotas;

    private String dateTime;
    private String hospital;
}
