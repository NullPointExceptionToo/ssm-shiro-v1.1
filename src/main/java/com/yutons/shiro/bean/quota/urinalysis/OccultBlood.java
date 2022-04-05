package com.yutons.shiro.bean.quota.urinalysis;

import com.yutons.shiro.bean.quota.BaseQuota;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @title: 隐血
 * @Author fq
 * @Date: 2022/3/19 16:09
 * @Version 1.0
 */
@Data
@NoArgsConstructor
public class OccultBlood extends BaseQuota {

    {
        name = "隐血";
        unit = "mg/L";
    }

    public OccultBlood(String value) {
        super.value = value;
    }
}
