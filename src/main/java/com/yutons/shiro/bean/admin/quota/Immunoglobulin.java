package com.yutons.shiro.bean.admin.quota;

import com.yutons.shiro.bean.PageBean;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @title: 免疫球蛋白C3C4测定实体
 * @Author fq
 * @Date: 2022/3/20 14:12
 * @Version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Immunoglobulin extends PageBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    /**
     * 复查单ID
     */
    private Integer check_id;
    /**
     * 补体C3
     */
    private Double bt_c3;
    /**
     * 补体C4
     */
    private Double bt_c4;
    /**
     * 免疫球蛋白M
     */
    private Double m_protein;
    /**
     * 免疫球蛋白A
     */
    private Double a_protein;
    /**
     * 免疫球蛋白G
     */
    private Double g_protein;
}
