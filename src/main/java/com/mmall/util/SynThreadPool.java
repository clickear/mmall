package com.mmall.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by Administrator on 2017/8/19.
 */
public class SynThreadPool {

    private static ThreadPoolExecutor pools = (ThreadPoolExecutor) Executors.newCachedThreadPool();

    private static Logger logger = LoggerFactory.getLogger(SynThreadPool.class);

    public static void execute(Runnable runThread) {
        try {
            if (runThread != null) {
                logger.info("SynThreadPool execute -> start execute thread success - > ");
                pools.execute(runThread);
            } else {
                logger.info(" SynThreadPool execute ->thread is nul ");
            }
        } catch (Exception e) {
            logger.error("", e);
        }
    }
}