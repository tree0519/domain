//package com.liu.domain.logging;
//
//import com.alibaba.fastjson.JSONObject;
//import com.liu.domain.utils.SecurityUtils;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Map;
//import java.util.Optional;
//
///**
// * @author liuxinghong
// * @Description: 插入日志获取用户名和人员姓名
// * @date 2018/2/28/02811:21
// */
//@Service("LogService")
//public class LogService {
//    @Autowired
//    private SysUserService sysUserService;
//
//    org.slf4j.Logger log = LoggerFactory.getLogger(LogService.class);
//    /**
//     * 通过登录用户名来获取user的姓名
//     * @return user姓名
//     */
//    public String getName() {
//        String name = this.getUserName();
//        log.info("从认证系统获取用户名为：[{}]",name);
//        //根据userName查询人员姓名,封装查询参数
//        //获取人员和用户信息
//        Map<String, Object> result = sysUserService.logUserandPer(name);
//        //返回登录用户的所有user信息和人员信息
//        if (null!=result&&!"".equals(result)){
//            Map map1 = JSONObject.parseObject(JSONObject.toJSONString(result), Map.class);
//            Object per = map1.get("per");
//            Per per1 = JSONObject.parseObject(JSONObject.toJSONString(per), Per.class);
//            return per1.getName();
//        }
//        return null;
//    }
//    //通过认证系统获取登录用户名
//    public String getUserName(){
//        Optional<String> op = Optional.ofNullable(SecurityUtils.getCurrentUserUsername());
//        if (op.isPresent()) {
//            String name = op.get();
//            return name;
//        }
//        log.error("从认证系统获取用户名失败！");
//        return null;
//    }
//}
