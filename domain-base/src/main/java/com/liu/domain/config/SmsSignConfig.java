package com.liu.domain.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author ZYW
 * @date 2018/5/28
 */
@Configuration
@ConfigurationProperties(prefix = "sms")
public class SmsSignConfig {
    private String sign;

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

}
