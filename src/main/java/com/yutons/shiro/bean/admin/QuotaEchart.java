package com.yutons.shiro.bean.admin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

import java.util.Date;

/**
 * @title: QuotaEchartDao
 * @Author fq
 * @Date: 2022/4/8 15:39
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuotaEchart {
    private Date date;
    private String hospital;
    private Double value;
}
