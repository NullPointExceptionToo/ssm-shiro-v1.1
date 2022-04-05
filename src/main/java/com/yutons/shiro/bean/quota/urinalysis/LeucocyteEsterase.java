package com.yutons.shiro.bean.quota.urinalysis;

import com.yutons.shiro.bean.quota.BaseQuota;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @title: 白细胞酯酶
 * @Author fq
 * @Date: 2022/3/19 16:09
 * @Version 1.0
 */
@Data
@NoArgsConstructor
public class LeucocyteEsterase extends BaseQuota {

    {
        name = "白细胞酯酶";
        unit = "leu/ul";
    }

    public LeucocyteEsterase(String value) {
        super.value = value;
    }
}
