package com.liu.domain.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RatioUtil {

    /**
     * 获取增长率
     * @param x
     * @param n
     * @return
     * 年均增长率，小数点后保留两位，结尾以百分号表示
     */
    public static String getGrowthRatePerAnnumWithPercent(double x, double n) {
        String defaultStr = "-";
        if( n == 0){
            return  defaultStr;
        }
        try{
            BigDecimal bd = new BigDecimal((x-n)/n * 100);
            return bd.setScale(2, RoundingMode.HALF_UP) + "%";
        }catch (Exception e){
            return defaultStr;
        }
    }

    /**
     * 新老客户交易环比
     * @param x
     * @param n
     * @return
     */
    public static String getUserTransactionDataTableRate(double x, double n) {
        if(n == 0){
            return "/";
        }
        BigDecimal bd = new BigDecimal((x-n)/n * 100);
        String value = bd.setScale(2, RoundingMode.HALF_UP) + "%";
        if(value.indexOf("-")!=-1){
            return "↓"+value;
        }else{
            return "↑"+value;
        }
    }

}
