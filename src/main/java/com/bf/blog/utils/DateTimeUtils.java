package com.bf.blog.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhubin on 2017/1/14.
 */
public class DateTimeUtils {

    public static final String COMMON_FORMATTER = "yyyy-MM-dd HH:mm:ss";

    public static String getCurrentTime4Str(){
        return getCurrentTime4Str(COMMON_FORMATTER);
    }

    public static String getCurrentTime4Str(String format){
        return transformTime2Str(new Date(), format);
    }

    public static String transformTime2Str(Date date){
        return transformTime2Str(date, COMMON_FORMATTER);
    }

    public static String transformTime2Str(Date date, String format){
        return new SimpleDateFormat(format).format(date);
    }

}
