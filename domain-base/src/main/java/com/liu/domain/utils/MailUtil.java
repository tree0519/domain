package com.liu.domain.utils;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public  class MailUtil {

    private static Logger log= LoggerFactory.getLogger(MailUtil.class);

    //邮箱服务器配置
    static class MailConfig {
        public static String host = "smtp.exmail.qq.com";
        public static Integer port = 465;
        public static String username = "tester@dsle.net";
        public static String password = "Abcd4321";
        public static boolean ssl_connect = true;

    }


    public static String sendHtmlEmail(String email,String title,String htmlMsg)  {

        try {
            HtmlEmail htmlEmail = new HtmlEmail();
            htmlEmail.setHostName(MailConfig.host);
            htmlEmail.setSmtpPort(MailConfig.port);
            htmlEmail.setCharset("UTF-8");
            if(MailConfig.ssl_connect){
                htmlEmail.setSSLOnConnect(true);
            }
            htmlEmail.setAuthentication(MailConfig.username, MailConfig.password);
            htmlEmail.setFrom(MailConfig.username);
            htmlEmail.addTo(email);
            htmlEmail.setSubject(title);
            htmlEmail.setHtmlMsg(htmlMsg);
            String result =  htmlEmail.send();
            return result;
        }catch (EmailException e){
            log.info("邮件服务系统调用错误！请相关人员查看！邮件地址：{1}", MailConfig.host);
            return "500";
        }



    }





}
