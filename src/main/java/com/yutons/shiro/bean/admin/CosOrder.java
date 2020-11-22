package com.yutons.shiro.bean.admin;

import java.io.Serializable;
import java.util.Date;

import com.yutons.shiro.bean.PageBean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;
/**
 * 订货订单表
 * @author Administrator
 * @date: 2020年11月22日 上午10:28:18
 */
@Data
@Log4j
@NoArgsConstructor
@AllArgsConstructor
public class CosOrder extends PageBean implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 订单ID
     */
    protected Integer cid;
    /**
     * 订单时间
     */
    protected Date cosDate;
    /**
     * 商店id
     */
    protected Integer storeID;
    /**
     * 商店名称
     */
    protected String storeName;
    /**
     * 订单详情
     */
    protected String cosDetail;
    /**
     * 订单状态
     */
    protected Integer ordStatus;
}
