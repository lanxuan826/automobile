package com.automobile.util;

/**
 * String工具类
 * @author ly-wangweiqiang
 *
 */
class StringUtil{
	
	/**
	 * 判断string是否为空
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return (str == null) || str.trim().equals("") || str.trim().equals("null");
	}

}
	