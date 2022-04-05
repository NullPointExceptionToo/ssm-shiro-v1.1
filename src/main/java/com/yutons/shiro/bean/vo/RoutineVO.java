package com.yutons.shiro.bean.vo;

import com.yutons.shiro.bean.quota.BaseQuota;
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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @title: RoutineVO
 * @Author fq
 * @Date: 2022/3/20 14:40
 * @Version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoutineVO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    /**
     * 复查单ID
     */
    private Integer check_id;
    /**
     * 白细胞计数
     */
    private WhiteCount white_count;
    /**
     * 中性粒细胞%
     */
    private MidCellPercent mid_cell_percent;
    /**
     * 淋巴细胞%
     */
    private LbCellPercent lb_cell_percent;
    /**
     * 单核细胞%
     */
    private SingoCellPercent singo_cell_percent;
    /**
     * 嗜酸性粒细胞%
     */
    private ShuanCellPercent shuan_cell_percent;
    /**
     * 嗜碱性粒细胞%
     */
    private JianCellPercent jian_cell_percent;
    /**
     * 中性粒细胞
     */
    private MidCell mid_cell;
    /**
     * 淋巴细胞
     */
    private LbCell lb_cell;
    /**
     * 单核细胞
     */
    private SingoCell singo_cell;
    /**
     * 嗜酸性粒细胞
     */
    private ShuanCell shuan_cell;
    /**
     * 嗜碱性粒细胞
     */
    private JianCell jian_cell;
    /**
     * 红细胞计数
     */
    private RedCount red_count;
    /**
     * 血红蛋白
     */
    private Hemoglobin hemoglobin;
    /**
     * 红细胞积压
     */
    private RedCellJy red_cell_jy;
    /**
     * 平均红细胞体积
     */
    private AveRedCellLv ave_red_cell_lv;
    /**
     * 平均血红蛋白含量
     */
    private AveHemoglobinPer ave_hemoglobin_per;
    /**
     * 平均血红蛋白浓度
     */
    private AveHemoglobinLev ave_hemoglobin_lev;
    /**
     * 红细胞分布宽度
     */
    private RedCellWidth red_cell_width;
    /**
     * 血小板计数
     */
    private PlateletCount platelet_count;
    /**
     * 血小板积压
     */
    private PlateletJy platelet_jy;
    /**
     * 平均血小板体积
     */
    private AvePlateletLv ave_platelet_lv;

    private List<BaseQuota> quotas;
    private String hospital;
    private String dateTime;
}
