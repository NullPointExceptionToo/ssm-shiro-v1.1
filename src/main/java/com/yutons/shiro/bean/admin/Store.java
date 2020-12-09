package com.yutons.shiro.bean.admin;

import java.io.Serializable;
import java.util.Date;

import com.yutons.shiro.bean.PageBean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;
/**
 * 商店表
 * @author Administrator
 * @date: 2020年11月22日 上午10:28:18
 */
@Data
@Log4j
@NoArgsConstructor
@AllArgsConstructor
public class Store extends PageBean implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 商店ID
     */
    protected Integer sid;
    /**
     * 商店名称
     */
    protected String storeName;
    /**
     * 商店负责人id
     */
    protected Integer storeUserId;
    /**
     * 商店负责人名
     */
    protected String storeUserName;
    /**
     * 商店地址
     */
    protected String storeAdds;
    /**
     * 商店状态
     */
    protected Integer status;
    /**
     * 商店状态描述
     */
    protected String statusDsc;
    /**
     * 排除商店ID（用于商店修改时验证商店和角色的一对一关系）
     */
    protected Integer excludeStoreId;
}
