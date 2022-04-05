package com.yutons.shiro.bean.quota.urinalysis;

import com.yutons.shiro.bean.quota.BaseQuota;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @title: 粘液丝
 * @Author fq
 * @Date: 2022/3/19 16:09
 * @Version 1.0
 */
@Data
@NoArgsConstructor
public class Filament extends BaseQuota {

    {
        name = "粘液丝";
        unit = "/ul";
    }

    public Filament(double value) {
        super.value = String.valueOf(value);
    }

}