package com.yutons.shiro.bean.vo;

import com.yutons.shiro.bean.quota.BaseQuota;
import com.yutons.shiro.bean.quota.immunoglobulin.AProtein;
import com.yutons.shiro.bean.quota.immunoglobulin.BtC3;
import com.yutons.shiro.bean.quota.immunoglobulin.BtC4;
import com.yutons.shiro.bean.quota.immunoglobulin.GProtein;
import com.yutons.shiro.bean.quota.immunoglobulin.MProtein;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @title: ImmunoglobulinVO
 * @Author fq
 * @Date: 2022/3/20 14:47
 * @Version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImmunoglobulinVO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    /**
     * 复查单ID
     */
    private Integer check_id;
    /**
     * 补体C3
     */
    private BtC3 bt_c3;
    /**
     * 补体C4
     */
    private BtC4 bt_c4;
    /**
     * 免疫球蛋白M
     */
    private MProtein m_protein;
    /**
     * 免疫球蛋白A
     */
    private AProtein a_protein;
    /**
     * 免疫球蛋白G
     */
    private GProtein g_protein;
    private List<BaseQuota> quotas;

    private String hospital;
    private String dateTime;
}
