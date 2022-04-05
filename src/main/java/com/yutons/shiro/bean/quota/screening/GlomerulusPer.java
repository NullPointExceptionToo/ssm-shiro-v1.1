package com.yutons.shiro.bean.quota.screening;

import com.yutons.shiro.bean.quota.BaseQuota;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @title: 肾小球滤过率-cr
 * @Author fq
 * @Date: 2022/3/19 16:09
 * @Version 1.0
 */
@Data
@NoArgsConstructor
public class GlomerulusPer extends BaseQuota {
    {
        name = "肾小球滤过率-cr";
        unit = "ml/min";
    }

    public GlomerulusPer(double value) {
        super.value = String.valueOf(value);
    }
}
