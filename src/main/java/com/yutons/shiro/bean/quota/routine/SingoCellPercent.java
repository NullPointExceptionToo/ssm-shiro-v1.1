package com.yutons.shiro.bean.quota.routine;

import com.yutons.shiro.bean.quota.BaseQuota;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @title: 单核细胞(%)
 * @Author fq
 * @Date: 2022/3/19 16:09
 * @Version 1.0
 */
@Data
@NoArgsConstructor
public class SingoCellPercent extends BaseQuota {
    {
        upLimit = 10.0;
        downLimit = 3.0;
        name = "单核细胞(%)";
        unit = "%";
    }

    public SingoCellPercent(double value) {
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
