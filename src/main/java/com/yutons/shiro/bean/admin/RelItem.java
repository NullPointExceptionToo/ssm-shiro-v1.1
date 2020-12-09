package com.yutons.shiro.bean.admin;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;
/**
 * 用于撤销订单时将订单原路返回
 * @author Administrator
 * @date: 2020年12月6日 下午8:29:43
 */
@Data
@Log4j
@NoArgsConstructor
@AllArgsConstructor
public class RelItem implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 商品ID
	 */
	private Integer productId;
	/**
	 * 关联供货订单id
	 */
	private Integer relid;
	/**
	 * 关联数量
	 */
	private Integer count;

}
