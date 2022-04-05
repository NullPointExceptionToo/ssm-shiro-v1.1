package com.yutons.shiro.bean.vo;

import com.yutons.shiro.bean.quota.BaseQuota;
import com.yutons.shiro.bean.quota.esr.Esr;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @title: TesrVO
 * @Author fq
 * @Date: 2022/3/20 14:17
 * @Version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TesrVO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    /**
     * 复查单ID
     */
    private Integer check_id;
    /**
     * 血沉
     */
    private Esr esr;
    private List<BaseQuota> quotas;
    private String dateTime;
    private String hospital;
}
