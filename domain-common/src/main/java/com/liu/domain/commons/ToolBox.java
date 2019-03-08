package com.liu.domain.commons;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

/**
 * @author ZYW
 * @date 2018/5/14
 */
public class ToolBox {

    private static final Map<String,String> PAY_CHANNEL = Maps.newHashMap();

    static {
        PAY_CHANNEL.put("ALIPAY","支付宝APP支付");
        PAY_CHANNEL.put("ALIPAY_CONTRACT","支付宝免密支付");
        PAY_CHANNEL.put("ALIPAY_SCAN","支付宝条码支付");
        PAY_CHANNEL.put("WXPAY","微信APP支付");
        PAY_CHANNEL.put("WX_CONTRACT","微信免密支付");
        PAY_CHANNEL.put("WX_LITE","微信小程序支付");
        PAY_CHANNEL.put("WX_PUB","微信公众号支付");
        PAY_CHANNEL.put("WX_SCAN","微信条码支付");
    }

    /**
     * 分转元
     * @param cent 分
     * @param prefix 可以添加元的前缀例如：￥，或者空字符串
     * @return 返回有小数点后两位的元
     */
    public static String centToYuan(long cent,String prefix) {
        Money money = new Money();
        money.setCent(cent);
        return Optional.ofNullable(prefix).orElse("") + money.getAmount().toString();
    }

    /**
     * 分转元
     * @param cent 分
     * @return 返回有小数点后两位的元
     */
    public static BigDecimal centToYuan(long cent) {
        Money money = new Money();
        money.setCent(cent);
        return money.getAmount();
    }

    /**
     * 元转分
     * @param yuan 元
     * @return 返回分
     */
    public static Long yuanToCent(double yuan) {
        Money money = new Money(yuan);
        return money.getCent();
    }
    /**
     * 元转分
     * @param yuan 元
     * @return 返回分
     */
    public static Long yuanToCent(String yuan) {
        Money money = new Money(yuan);
        return money.getCent();
    }

    /**
     * 根据支付通道编码返回支付通道描述
     * @param payChannelNo 支付通道编码
     * @return 支付通道描述
     */
    public static String payChannel(String payChannelNo) {
        String result = PAY_CHANNEL.get(payChannelNo);
        if(StringUtils.isEmpty(result)) {
            return "未知";
        }
        return result;
    }

    /**
     * 根据支付状态码，返回支付状态描述
     * @param status 支付状态码
     * @return 支付状态描述
     */
    public static String payStatus(Integer status) {
        if (null==status){//现金结算
            return "支付成功";
        }
        String result;
        switch (status) {
            case 0:
                result = "支付成功";
                break;
            case 1:
                result = "连接支付网关失败";
                break;
            case 2:
                result = "账户余额不足";
                break;
            case 3:
                result = "支付失败(其他原因)";
                break;
            default:
                result = "未知";
        }
        return result;
    }

    /**
     * 0-未处理 1-退款完毕 2-退款失败 3-退款中
     * 根据退款处理状态码，返回退款处理状态描述
     * @param status 退款处理状态码
     * @return 返回退款处理状态描述
     */
    public static String refundStatus(Integer status) {
        String result;
        switch (status) {
            case 0:
                result = "未处理";
                break;
            case 1:
                result = "退款完毕";
                break;
            case 2:
                result = "退款失败";
                break;
            case 3:
                result = "退款中";
                break;
            case 4:
                result = "已拒绝";
                break;
            default:
                result = "未知";
        }
        return result;
    }

    /**
     * 转换时间为微信需要的时间
     * @param date
     * @return
     */
    public static String wxTimeCovn(Date date) {
        DateTime dateTime = new DateTime(date);
        return dateTime.toString("yyyyMMddHHmmss");
    }

    public static String dateToString(Date date) {
        DateTime dateTime = new DateTime(date);
        return dateTime.toString("yyyy-MM-dd HH:mm:ss");
    }

    public static Date wxTimeEndCovnDate(String timeEnd) {
        return DateTime.parse(timeEnd, DateTimeFormat.forPattern("yyyyMMddHHmmss")).toDate();
    }

    public static Date wxTimeEndCovnDate(Long timeEnd) {
        return new Date(timeEnd);
    }

    public static Date strToDate(String date) {
        return DateTime.parse(date,DateTimeFormat.forPattern("YYYY-MM-dd HH:mm:ss")).toDate();
    }
}
