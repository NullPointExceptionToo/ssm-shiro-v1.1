package com.yutons.shiro.bean.admin;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

/**
 * 商店商品订单原子类
 * @author Administrator
 * @date: 2020年12月6日 下午8:23:21
 */
@Data
@Log4j
@NoArgsConstructor
@AllArgsConstructor
public class OrdItem implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 商品ID
	 */
	private Integer productId;
	/**
	 * 商品名字
	 */
	private String productName;
	/**
	 * 订购数量（斤）
	 */
	private Integer count;

}
