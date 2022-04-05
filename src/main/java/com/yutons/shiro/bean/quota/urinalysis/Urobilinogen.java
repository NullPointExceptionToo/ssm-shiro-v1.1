package com.yutons.shiro.bean.quota.urinalysis;

import com.yutons.shiro.bean.quota.BaseQuota;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @title: 尿胆原
 * @Author fq
 * @Date: 2022/3/19 16:09
 * @Version 1.0
 */
@Data
@NoArgsConstructor
public class Urobilinogen extends BaseQuota {

    {
        name = "尿胆原";
        unit = "u mol/L";
    }

    public Urobilinogen(String value) {
        super.value = value;
    }
}
