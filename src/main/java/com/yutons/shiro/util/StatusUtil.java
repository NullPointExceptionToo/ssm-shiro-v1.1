package com.yutons.shiro.util;

import java.util.HashMap;
import java.util.Map;

public class StatusUtil {
	public static final Map<Integer,String> statusMap;
	static{
		statusMap = new HashMap<Integer,String>(){
		{  
			put(0,"已注销");
			put(1,"已启用");
		}
		};
	}

}
