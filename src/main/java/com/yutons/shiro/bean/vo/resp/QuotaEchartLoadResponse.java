package com.yutons.shiro.bean.vo.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @title: QuotaEchartLoadResponse
 * @Author fq
 * @Date: 2022/4/8 15:25
 * @Version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuotaEchartLoadResponse implements Serializable {
    /**
     * x轴
     */
    private List<String> dateString;
    /**
     * 折线值
     */
    private List<Double> seriesData;
    /**
     * 安全范围
     */
    private Double downLimit;
    private Double upLimit;
    /**
     * y轴单位
     */
    private String unit;
}
