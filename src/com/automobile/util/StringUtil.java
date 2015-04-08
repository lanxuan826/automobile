package com.automobile.util;


class StringUtil{
	
	public static boolean isEmpty(String str) {
		return (str == null) || str.trim().equals("") || str.trim().equals("null");
	}

}
	