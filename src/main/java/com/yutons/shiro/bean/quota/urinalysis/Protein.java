package com.yutons.shiro.bean.quota.urinalysis;

import com.yutons.shiro.bean.quota.BaseQuota;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @title: 蛋白质
 * @Author fq
 * @Date: 2022/3/19 16:09
 * @Version 1.0
 */
@Data
@NoArgsConstructor
public class Protein extends BaseQuota {

    {
        name = "蛋白质";
        unit = "g/L";
    }

    public Protein(String value) {
        super.value = value;
    }
}
