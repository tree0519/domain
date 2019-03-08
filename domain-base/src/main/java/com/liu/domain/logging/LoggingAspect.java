//package com.liu.domain.logging;
//
//import com.google.common.collect.Maps;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//
//import java.util.Map;
//
///**
// * @author zyw
// * @date 2018/2/6
// */
//@Aspect
//@Component
//public class LoggingAspect extends AbstractLogAspect {
//
//    private static Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
//
//    @Around("@annotation(com.mydao.mab.logging.Logging)")
//    public Object methodCacheHold(ProceedingJoinPoint joinPoint)
//            throws Throwable {
//        Logging simpleLog = AspectUtils.getAnnotation(joinPoint, Logging.class);
//        Map<String, Object> params = AspectUtils.getMethodParams(joinPoint);
//
//        Map<String,Object> log = Maps.newHashMap();
//        log.put("desc",getMessage(simpleLog.code(), simpleLog.vars(), params));//对应 日志数据
//        log.put("remark",getMessage(simpleLog.code() + ".message",simpleLog.vars(),params));//操作详情
//        log.put("type",simpleLog.type().getType());//操作类型
//        Object result = null;
//        try {
//            result = joinPoint.proceed();
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw e;
//
//        }finally{
//            saveLog(log);
//            logger.info(log.toString());
//        }
//        return result;
//    }
//}
