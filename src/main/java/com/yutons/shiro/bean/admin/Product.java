package com.yutons.shiro.bean.admin;

import com.yutons.shiro.bean.PageBean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

import java.io.Serializable;
/**
 * 商品类
 * @author Administrator
 * @date: 2020年11月22日 上午10:28:18
 */
@Data
@Log4j
@NoArgsConstructor
@AllArgsConstructor
public class Product extends PageBean implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 商品ID
     */
    protected Integer pid;
    /**
     * 商品名称
     */
    protected String productName;
    /**
     * 商品种类ID
     */
    protected Integer productTypeID;
    /**
     * 商品种类Name
     */
    protected String productTypeName;
    /**
     * 商品描述
     */
    protected String productDes;
}
