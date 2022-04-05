package com.yutons.shiro.bean.admin.quota;

import com.yutons.shiro.bean.PageBean;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 红细胞沉降率测定实体
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tesr extends PageBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    /**
     * 复查单ID
     */
    private Integer check_id;
    /**
     * 血沉
     */
    private Integer esr;
}
