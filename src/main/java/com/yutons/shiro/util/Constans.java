package com.yutons.shiro.util;

public class Constans {
	/**
	 * 基地角色
	 */
	public static final Integer homeRole = 5;
	/**
	 * 商店角色
	 */
	public static final Integer storeRole = 6;
	/**
	 * 库存量不足标识
	 */
	public static final Integer HOME_LESS = 2;
	/**
	 * 未持有基地标识
	 */
	public static final Integer NONE_HOME = 111;
	/**
	 * 未持有商店标识
	 */
	public static final Integer NONE_STORE = 333;
	
	
	/**
	 * 订单状态
	 */
	public static class State{
		/**
		 * 待配送
		 */
		public static final Integer STATE_WAIT_DELIEVE = 1;
		/**
		 * 配送
		 */
		public static final Integer STATE_DELIEVE = 2;
		/**
		 * 撤销
		 */
		public static final Integer STATE_CANCEL = 0;
	}

}
