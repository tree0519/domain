package com.liu.domain.utils;

import org.apache.commons.lang.StringUtils;

public enum PayTypeCode {
    Ali("ALI_PAY","支付宝"),
    WeiXin("TENCENT_PAY","微信"),
    Union("UNION","银联"),
    RONCOO("RONCOO","龙果"),
    POLY("POLY_PAY","聚合支付");

    private String key;

    public void setKey(String key) {
        this.key = key;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private  String  code;

    public String getKey() {
        return key;
    }

    public String getCode() {
        return code;
    }
    PayTypeCode(String key, String code) {
        this.key = key;
        this.code = code;
    }

    /**
     * 根据key 获取  value
     * @param key
     * @return
     */
    public static String get(String key){
        if(StringUtils.isNotBlank(key)){
            PayTypeCode[] types= values ();
            for(PayTypeCode type:types){
                if(type.getKey().equals(key)){
                    return type.getCode();
                }
            }
        }
        return null;
    }
}

