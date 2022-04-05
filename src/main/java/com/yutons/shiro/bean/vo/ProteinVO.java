package com.yutons.shiro.bean.vo;

import com.yutons.shiro.bean.quota.BaseQuota;
import com.yutons.shiro.bean.quota.protein.Urine;
import com.yutons.shiro.bean.quota.protein.UrineProtein;
import com.yutons.shiro.bean.quota.protein.UrineProtein24;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @title: ProteinVO
 * @Author fq
 * @Date: 2022/3/20 14:45
 * @Version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProteinVO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    /**
     * 复查单ID
     */
    private Integer check_id;
    /**
     * 尿量
     */
    private Urine urine;
    /**
     * 尿蛋白
     */
    private UrineProtein urine_protein;
    /**
     * 24小时尿蛋白
     */
    private UrineProtein24 urine_protein24;

    private List<BaseQuota> quotas;
    private String hospital;
    private String dateTime;
}
