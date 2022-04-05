package com.yutons.shiro.bean.quota.screening;

import com.yutons.shiro.bean.quota.BaseQuota;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @title: 白球蛋白比例
 * @Author fq
 * @Date: 2022/3/19 16:09
 * @Version 1.0
 */
@Data
@NoArgsConstructor
public class WhilteCirclePer extends BaseQuota {
    {
        upLimit = 2.4;
        downLimit = 1.2;
        name = "白球蛋白比例";
        unit = "";
    }

    public WhilteCirclePer(double value) {
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
