package com.yutons.shiro.bean.quota;

import lombok.Data;

import java.io.Serializable;

/**
 * @title: 指标base类
 * @Author fq
 * @Date: 2022/3/19 15:58
 * @Version 1.0
 */
@Data
public class BaseQuota implements Serializable{
    /**
     * 指标上升或下降
     */
    protected int upOrDown = 0;
    /**
     * 参考上界
     */
    protected double upLimit = -1.0;
    /**
     * 参考下界
     */
    protected double downLimit = -1.0;
    /**
     * 指标名称
     */
    protected String name;
    /**
     * 指标单位
     */
    protected String unit;

    protected String value;

}
