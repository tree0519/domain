package com.liu.domain.config;//package com.mydao.nsop.config;
//
//import com.mydao.nsop.commons.Constants;
//import com.qcloud.cmq.Account;
//import com.qcloud.cmq.Topic;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @author ZYW
// * @date 2018/5/8
// */
//@Configuration
//@ConfigurationProperties(prefix = "nsop.cmq")
//public class CMQConfig {
//
//    private String secretId;
//    private String secretKey;
//    private String endpointTopic;
//    private String endpointQueue;
//    private String delayedQueueName;
//
//    public String getSecretId() {
//        return secretId;
//    }
//
//    public void setSecretId(String secretId) {
//        this.secretId = secretId;
//    }
//
//    public String getSecretKey() {
//        return secretKey;
//    }
//
//    public void setSecretKey(String secretKey) {
//        this.secretKey = secretKey;
//    }
//
//    public String getEndpointTopic() {
//        return endpointTopic;
//    }
//
//    public void setEndpointTopic(String endpointTopic) {
//        this.endpointTopic = endpointTopic;
//    }
//
//    public String getEndpointQueue() {
//        return endpointQueue;
//    }
//
//    public void setEndpointQueue(String endpointQueue) {
//        this.endpointQueue = endpointQueue;
//    }
//
//    public String getDelayedQueueName() {
//        return delayedQueueName;
//    }
//
//    public void setDelayedQueueName(String delayedQueueName) {
//        this.delayedQueueName = delayedQueueName;
//    }
//
//    private Account accountTopic() {
//        return new Account(endpointTopic,secretId, secretKey);
//    }
//
//    public Topic vehicleWhiteTopic() {
//        return accountTopic().getTopic(Constants.VEHICLE_WHITE_TOPIC);
//    }
//
//    public Topic vehicleBlackTopic() {
//        return accountTopic().getTopic(Constants.VEHICLE_BLACK_TOPIC);
//    }
//
//    public Account accountQueue() {
//        return new Account(endpointQueue,secretId, secretKey);
//    }
//}
