package com.yutons.shiro.bean.admin;

import java.io.Serializable;
import java.util.Date;

import com.yutons.shiro.bean.PageBean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;
/**
 * 供货订单表
 * @author Administrator
 * @date: 2020年11月22日 上午10:28:18
 */
@Data
@Log4j
@NoArgsConstructor
@AllArgsConstructor
public class ProOrder extends PageBean implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 订单ID
     */
    protected Integer oid;
    /**
     * 订单时间
     */
    protected Date proDate;
    /**
     * 生产基地id
     */
    protected Integer phomeID;
    /**
     * 生产基地负责人id
     */
    protected Integer userID;
    /**
     * 生产基地name
     */
    protected String phomeName;
    /**
     * 生产农户
     */
    protected String profarmer;
    /**
     * 商品id
     */
    protected Integer pid;
    /**
     * 商品名称
     */
    protected String proName;
    /**
     * 已销数量
     */
    protected Integer sellNum;
    /**
     * 供货数量
     */
    protected Integer proNum;
    /**
     * 订单状态
     */
    protected Integer ordStatus;
    /**
     * 需要排除的订单id
     */
    protected Integer excludeId;
}
