package com.yutons.shiro.bean.admin.quota;

import com.yutons.shiro.bean.PageBean;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @title: 24小时尿蛋白测定实体
 * @Author fq
 * @Date: 2022/3/20 14:14
 * @Version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Protein extends PageBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    /**
     * 复查单ID
     */
    private Integer check_id;
    /**
     * 尿量
     */
    private Double urine;
    /**
     * 尿蛋白
     */
    private Double urine_protein;
    /**
     * 24小时尿蛋白
     */
    private Double urine_protein24;

}
