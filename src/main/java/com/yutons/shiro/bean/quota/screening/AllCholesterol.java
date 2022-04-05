package com.yutons.shiro.bean.quota.screening;

import com.yutons.shiro.bean.quota.BaseQuota;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @title: 总胆固醇
 * @Author fq
 * @Date: 2022/3/19 16:09
 * @Version 1.0
 */
@Data
@NoArgsConstructor
public class AllCholesterol extends BaseQuota {
    {
        upLimit = 5.86;
        downLimit = 3.10;
        name = "总胆固醇";
        unit = "mmol/L";
    }

    public AllCholesterol(double value) {
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
