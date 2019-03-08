package com.liu.domain.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolUserStatistics {
    private final static Log logger = LogFactory.getLog(ThreadPoolUserStatistics.class);
    private  static ThreadPoolExecutor ftpPool = null;
    public static synchronized ThreadPoolExecutor userStatisticsThreadPool(){
        if(ftpPool==null){
            logger.debug("线程池启动》》》》》》》");
            ftpPool = new ThreadPoolExecutor(2, 4, 200, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(10));
        }
        return ftpPool;
    }
}
