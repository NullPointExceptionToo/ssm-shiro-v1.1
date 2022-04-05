package com.yutons.shiro.bean.quota.urinalysis;

import com.yutons.shiro.bean.quota.BaseQuota;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @title: 类酵母菌
 * @Author fq
 * @Date: 2022/3/19 16:09
 * @Version 1.0
 */
@Data
@NoArgsConstructor
public class ClassBact extends BaseQuota {

    {
        name = "类酵母菌";
        unit = "/ul";
    }
    public ClassBact(double value) {
        super.value = String.valueOf(value);
    }
}
