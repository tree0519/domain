package com.liu.domain.utils;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author : liqi
 * Date: 2018-01-29
 * Time: 17:30
 */
public class DateUtils {
    /**
     * 将字符串转date
     * @param str
     * @param pattern "yyyy-MM-dd HH:mm:ss" "yyyy-MM-dd" "yyyy-MM-dd HH:mm"
     * @return
     */
    public static Date stringToDate(String str , String pattern){
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            if(StringUtils.isNotEmpty(str)&&StringUtils.isNotEmpty(pattern)){
                return sdf.parse(str);
            }else{
                return null;
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String dateToString(Date date,String format){
        if(date!=null){
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.format(date);
        }else{
            return "";
        }
    }

//    public static void main(String[] args){
//        System.out.println(stringToDate("2017-01-01","yyyy-MM-dd"));
//    }


}
