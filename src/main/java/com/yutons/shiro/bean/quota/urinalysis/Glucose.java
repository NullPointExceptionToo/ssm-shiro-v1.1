package com.yutons.shiro.bean.quota.urinalysis;

import com.yutons.shiro.bean.quota.BaseQuota;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @title: 葡萄糖
 * @Author fq
 * @Date: 2022/3/19 16:09
 * @Version 1.0
 */
@Data
@NoArgsConstructor
public class Glucose extends BaseQuota {

    {
        name = "葡萄糖";
        unit = "mmol/L";
    }

    public Glucose(String value) {
        super.value = value;
    }

}
