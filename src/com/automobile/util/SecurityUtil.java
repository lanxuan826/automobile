package com.automobile.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;

/**
 * 处理系统安全的工具类
 * @author ly-wangweiqiang
 *
 */
public class SecurityUtil {
	// 用户密码 KEY
		public final static String USER_PASSWORD_KEY = "1234567890abcdef";
		public final static String PASSWORD_HEADER = "{MD5}";
		
		

		/**
	     * 对字符串进行MD5加密
	     *
	     * @param text 明文
	     *
	     * @return 密文
	     */
	    public static String md5(String text) {
	        MessageDigest msgDigest = null;

	        try {
	            msgDigest = MessageDigest.getInstance("MD5");
	        } catch (NoSuchAlgorithmException e) {
	            throw new IllegalStateException("System doesn't support MD5 algorithm.");
	        }

	        msgDigest.update(text.getBytes());

	        byte[] bytes = msgDigest.digest();
	        
	        byte [] base64Byte = Base64.encodeBase64( bytes);
	        String b64Str = new String(base64Byte);
	        String md5Str = PASSWORD_HEADER.concat( b64Str);
	        
	        return md5Str;
	    }
}
