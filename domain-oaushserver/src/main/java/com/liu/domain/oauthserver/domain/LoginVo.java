package com.liu.domain.oauthserver.domain;

import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author : liqi
 * Date: 2018-09-04
 * Time: 16:48
 */
public class LoginVo implements Serializable {
    @NotEmpty(message = "验证码不能为空")
    private String captcha;
    @NotEmpty(message = "验证码KEY不能为空")
    private String captchaKey;
    @NotEmpty(message = "用户名不能为空")
    private String username;
    @NotEmpty(message = "密码不能为空")
    private String password;

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public String getCaptchaKey() {
        return captchaKey;
    }

    public void setCaptchaKey(String captchaKey) {
        this.captchaKey = captchaKey;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
