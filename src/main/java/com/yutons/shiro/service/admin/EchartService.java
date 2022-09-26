package com.yutons.shiro.service.admin;

import com.yutons.shiro.bean.vo.req.QuotaEchartLoadRequest;
import com.yutons.shiro.bean.vo.resp.QuotaEchartLoadResponse;

public interface EchartService {
    /**
     * 查询指标的echart数据
     */
    QuotaEchartLoadResponse selectQuotaEchartData(QuotaEchartLoadRequest request);

}
