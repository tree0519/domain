package com.liu.domain.domaingateway.filter;


import com.liu.domain.enums.HttpStatus;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.cloud.netflix.zuul.util.ZuulRuntimeException;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zyw
 * @date 2018/2/9
 */
@Component
public class CaptchaZuulFilter extends ZuulFilter {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return -2;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        return ctx.getRequest().getRequestURI().contains("/oauth/token");
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest req = ctx.getRequest();
        String clientId = req.getParameter("client_id");
//        if(StringUtils.equals(clientId,"webapp")){//管理系统图片验证码
//          String captcha = req.getParameter("captcha");
//        String captchaKey = req.getParameter("captchaKey");
//
//        if(StringUtils.isEmpty(captcha)) {
//            throw new ZuulRuntimeException(new ZuulException(HttpStatus.NSOP_CAPTCHA_NULL.msg(), HttpStatus.NSOP_CAPTCHA_NULL.value(),HttpStatus.NSOP_CAPTCHA_NULL.msg()));
//        }
//        String redisCaptcha = stringRedisTemplate.boundValueOps(captchaKey).get();
//
//        if(!StringUtils.equalsIgnoreCase(captcha,redisCaptcha)) {
//            throw new ZuulRuntimeException(new ZuulException(HttpStatus.NSOP_CAPTCHA_ERROR.msg(), HttpStatus.NSOP_CAPTCHA_ERROR.value(),HttpStatus.NSOP_CAPTCHA_ERROR.msg()));
//        }
//        }
        if(StringUtils.equals(clientId,"verification")){//app短信验证码
            String mobile = req.getParameter("username");//手机号
            String code = req.getParameter("password");//手机验证码
            if(StringUtils.isEmpty(code) ) {
                throw new ZuulRuntimeException(new ZuulException(HttpStatus.NSOP_CAPTCHA_NULL.msg(), HttpStatus.NSOP_CAPTCHA_NULL.value(),HttpStatus.NSOP_CAPTCHA_NULL.msg()));
            }
            String redisCaptcha = stringRedisTemplate.boundValueOps(mobile).get();
            if(null == redisCaptcha){
                throw new ZuulRuntimeException(new ZuulException(HttpStatus.NSOP_CAPTCHA_INVALID.msg(), HttpStatus.NSOP_CAPTCHA_INVALID.value(),HttpStatus.NSOP_CAPTCHA_INVALID.msg()));
            }
            if(!StringUtils.equals(code,redisCaptcha)) {
                throw new ZuulRuntimeException(new ZuulException(HttpStatus.NSOP_CAPTCHA_ERROR.msg(), HttpStatus.NSOP_CAPTCHA_ERROR.value(),HttpStatus.NSOP_CAPTCHA_ERROR.msg()));
            }
        }
        return null;
    }
}
