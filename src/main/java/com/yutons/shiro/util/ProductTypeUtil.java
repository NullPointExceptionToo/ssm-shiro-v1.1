package com.yutons.shiro.util;

import java.util.HashMap;
import java.util.Map;

public class ProductTypeUtil {
	public static final Map<Integer,String> typeMap;
	static{
		typeMap = new HashMap<Integer,String>(){
		{   put(0,"水果");
		    put(1,"蔬菜");
		    put(2,"五谷");
		    }
		};
	}

}
