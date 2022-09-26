package com.yutons.shiro.bean.vo.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @title: QuotaEchartLoadRequest
 * @Author fq
 * @Date: 2022/4/8 15:23
 * @Version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuotaEchartLoadRequest implements Serializable {
    private String checkType;
    private String quotaName;
    private String timeSearch;
}
