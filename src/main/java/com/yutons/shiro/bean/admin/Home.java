package com.yutons.shiro.bean.admin;

import java.io.Serializable;
import java.util.Date;

import com.yutons.shiro.bean.PageBean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;
/**
 * 基地表
 * @author Administrator
 * @date: 2020年11月22日 上午10:28:18
 */
@Data
@Log4j
@NoArgsConstructor
@AllArgsConstructor
public class Home extends PageBean implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 基地ID
     */
    protected Integer hId;
    /**
     * 基地名称
     */
    protected String hName;
    /**
     * 基地地址
     */
    protected String hAdds;
    /**
     * 基地负责人id
     */
    protected Integer hUserId;
    /**
     * 基地负责人名
     */
    protected String hUserName;
    /**
     * 基地状态
     */
    protected Integer status;
    /**
     * 基地状态描述
     */
    protected String statusDsc;
}
