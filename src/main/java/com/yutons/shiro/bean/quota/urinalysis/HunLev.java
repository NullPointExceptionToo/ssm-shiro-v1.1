package com.yutons.shiro.bean.quota.urinalysis;

import com.yutons.shiro.bean.quota.BaseQuota;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @title: 浊度
 * @Author fq
 * @Date: 2022/3/19 16:09
 * @Version 1.0
 */
@Data
@NoArgsConstructor
public class HunLev extends BaseQuota {

    {
        name = "浊度";
        unit = "";
    }

    public HunLev(String value) {
        super.value = value;
    }
}
