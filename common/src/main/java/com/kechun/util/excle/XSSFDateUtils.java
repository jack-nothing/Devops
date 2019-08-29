package com.kechun.util.excle;

import org.apache.poi.ss.usermodel.DateUtil;

import java.util.Calendar;

public class XSSFDateUtils extends DateUtil {

		/**
		 * 自定义xssf日期工具类
		 */
	    protected static int absoluteDay(Calendar cal, boolean use1904windowing) {    
	        return DateUtil.absoluteDay(cal, use1904windowing);
	    }   
}
