package com.yutons.shiro.bean.admin.quota;

/**
 * @title: 尿常规+比重测定实体
 * @Author fq
 * @Date: 2022/3/20 11:59
 * @Version 1.0
 */

import com.yutons.shiro.bean.PageBean;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Urinalysis extends PageBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    /**
     * 复查单ID
     */
    private Integer check_id;
    /**
     * 隐血
     */
    private String occult_blood;
    /**
     * 白细胞酯酶
     */
    private String leucocyte_esterase;
    /**
     * 蛋白质
     */
    private String protein;
    /**
     * 胆红素
     */
    private String bilirubin;
    /**
     * 酮体
     */
    private String ketone;
    /**
     * 尿胆原
     */
    private String urobilinogen;
    /**
     * 亚硝酸盐
     */
    private String nitrite;
    /**
     * 葡萄糖
     */
    private String glucose;
    /**
     * pH值
     */
    private Double pH;
    /**
     * 比重
     */
    private Double levhigh;
    /**
     * 浊度
     */
    private String hun_lev;
    /**
     * 颜色
     */
    private String color;
    /**
     * 红细胞
     */
    private Double red_cell;
    /**
     * 白细胞
     */
    private Double white_cell;
    /**
     * 管型
     */
    private Double tube;
    /**
     * 上皮细胞
     */
    private Double up_cell;
    /**
     * 细菌
     */
    private Double bacteria;
    /**
     * 结晶
     */
    private Double crystal;
    /**
     * 粘液丝
     */
    private Double filament;
    /**
     * 类酵母菌
     */
    private Double class_bact;
}
