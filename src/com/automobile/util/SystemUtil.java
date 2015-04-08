package com.automobile.util;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 系统工具
 * @author Administrator
 *
 */
public class SystemUtil {

		/**
		 * 获得当前时间
		 * @return
		 * @throws Exception
		 */
	public final static Date getSysCurentTime() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.parse(sdf.format(new Date()));
	}
	
	public final static String formatDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}
}
