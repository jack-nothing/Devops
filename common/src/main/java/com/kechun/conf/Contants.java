package com.kechun.conf;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Contants {

    //token密钥
    public static final String TOKEN = "PMXSDSP";
    //超时时间
    public static final long TOKEN_TIMEOUT=1000*60*60*72;


    public static final String TEXT = "text";
    public static final String IMAGE = "image";
    public static final String LINK = "link";
    public static final String EVENT = "event";
    public static final String NEWS = "news";

    public static final String OFFICE_EXCEL_2003_POSTFIX = "xls";
    public static final String OFFICE_EXCEL_2010_POSTFIX = "xlsx";
    public static final String EMPTY = "";
    public static final String POINT = ".";

    private static ThreadLocal<DateFormat> threadLocal_SimpDate_yyyyMMdd_HHmmss = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };
    private static ThreadLocal<DateFormat> threadLocal_SimpDate_yyyyMMdd = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };
    private static ThreadLocal<DateFormat> threadLocal_SimpDate_HHmm = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("HHmm");
        }
    };

}
