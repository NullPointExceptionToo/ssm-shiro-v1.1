package com.yutons.shiro.bean.admin.quota;

import com.yutons.shiro.bean.PageBean;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @title: 血常规测定实体
 * @Author fq
 * @Date: 2022/3/20 13:48
 * @Version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Routine extends PageBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    /**
     * 复查单ID
     */
    private Integer check_id;
    /**
     * 白细胞计数
     */
    private Double white_count;
    /**
     * 中性粒细胞%
     */
    private Double mid_cell_percent;
    /**
     * 淋巴细胞%
     */
    private Double lb_cell_percent;
    /**
     * 单核细胞%
     */
    private Double singo_cell_percent;
    /**
     * 嗜酸性粒细胞%
     */
    private Double shuan_cell_percent;
    /**
     * 嗜碱性粒细胞%
     */
    private Double jian_cell_percent;
    /**
     * 中性粒细胞
     */
    private Double mid_cell;
    /**
     * 淋巴细胞
     */
    private Double lb_cell;
    /**
     * 单核细胞
     */
    private Double singo_cell;
    /**
     * 嗜酸性粒细胞
     */
    private Double shuan_cell;
    /**
     * 嗜碱性粒细胞
     */
    private Double jian_cell;
    /**
     * 红细胞计数
     */
    private Double red_count;
    /**
     * 血红蛋白
     */
    private Double hemoglobin;
    /**
     * 红细胞积压
     */
    private Double red_cell_jy;
    /**
     * 平均红细胞体积
     */
    private Double ave_red_cell_lv;
    /**
     * 平均血红蛋白含量
     */
    private Double ave_hemoglobin_per;
    /**
     * 平均血红蛋白浓度
     */
    private Double ave_hemoglobin_lev;
    /**
     * 红细胞分布宽度
     */
    private Double red_cell_width;
    /**
     * 血小板计数
     */
    private Double platelet_count;
    /**
     * 血小板积压
     */
    private Double platelet_jy;
    /**
     * 平均血小板体积
     */
    private Double ave_platelet_lv;
}
