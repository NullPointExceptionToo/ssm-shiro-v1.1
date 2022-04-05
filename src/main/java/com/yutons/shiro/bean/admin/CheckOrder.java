package com.yutons.shiro.bean.admin;

import com.yutons.shiro.bean.PageBean;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @title: CheckOrder
 * @Author fq
 * @Date: 2022/3/20 14:49
 * @Version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CheckOrder extends PageBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String hospital;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date date;
    private String medicial;
    private Double fd_gov;
    private Double fd_self;
}
