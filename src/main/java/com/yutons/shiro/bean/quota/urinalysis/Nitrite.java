package com.yutons.shiro.bean.quota.urinalysis;

import com.yutons.shiro.bean.quota.BaseQuota;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @title: 亚硝酸盐
 * @Author fq
 * @Date: 2022/3/19 16:09
 * @Version 1.0
 */
@Data
@NoArgsConstructor
public class Nitrite extends BaseQuota {

    {
        name = "亚硝酸盐";
        unit = "";
    }

    public Nitrite(String value) {
        super.value = value;
    }

}
