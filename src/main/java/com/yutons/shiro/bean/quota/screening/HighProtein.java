package com.yutons.shiro.bean.quota.screening;

import com.yutons.shiro.bean.quota.BaseQuota;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @title: 高密度脂蛋白-C
 * @Author fq
 * @Date: 2022/3/19 16:09
 * @Version 1.0
 */
@Data
@NoArgsConstructor
public class HighProtein extends BaseQuota {
    {
        upLimit = 2.04;
        downLimit = 0.88;
        name = "高密度脂蛋白-C";
        unit = "mmol/L";
    }

    public HighProtein(double value) {
        super.value = String.valueOf(value);
    }

    @Override
    public int getUpOrDown() {
        if(upLimit < 0 || downLimit < 0) {
            return upOrDown;
        }
        if(Double.valueOf(value) < downLimit) {
            return -1;
        }
        if(Double.valueOf(value) > upLimit) {
            return 1;
        }
        return upOrDown;
    }
}
