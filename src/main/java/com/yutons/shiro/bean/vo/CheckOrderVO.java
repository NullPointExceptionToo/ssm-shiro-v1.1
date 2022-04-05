package com.yutons.shiro.bean.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @title: CheckOrderVO
 * @Author fq
 * @Date: 2022/3/20 15:09
 * @Version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CheckOrderVO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String hospital;
    private String dateTime;
    private String medicial;
    private Double fd_gov;
    private Double fd_self;
    /**
     * 血沉
     */
    private TesrVO tesrVO;
    /**
     * 尿常规+比重测定
     */
    private UrinalysisVO urinalysisVO;
    /**
     * 生化筛查常规测定
     */
    private ScreeningVO screeningVO;

    /**
     * 血常规测定
     */
    private RoutineVO routineVO;
    /**
     * 24小时尿蛋白测定
     */
    private ProteinVO proteinVO;
    /**
     * 免疫球蛋白C3C4测定
     */
    private ImmunoglobulinVO immunoglobulinVO;
}
