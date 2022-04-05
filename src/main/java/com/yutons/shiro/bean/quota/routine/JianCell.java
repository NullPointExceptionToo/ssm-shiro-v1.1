package com.yutons.shiro.bean.quota.routine;

import com.yutons.shiro.bean.quota.BaseQuota;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @title: 嗜碱性粒细胞
 * @Author fq
 * @Date: 2022/3/19 16:09
 * @Version 1.0
 */
@Data
@NoArgsConstructor
public class JianCell extends BaseQuota {
    {
        upLimit = 0.1;
        downLimit = 0.0;
        name = "嗜碱性粒细胞";
        unit = "10E9/L";
    }

    public JianCell(double value) {
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
