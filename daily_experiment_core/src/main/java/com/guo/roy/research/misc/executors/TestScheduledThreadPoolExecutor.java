package com.guo.roy.research.misc.executors;

import org.slf4j.LoggerFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestScheduledThreadPoolExecutor {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestScheduledThreadPoolExecutor.class);

    /**
     * 延迟执行任务
     * @throws InterruptedException
     */
    public void testScheduledThreadPoolExecutor_1() throws InterruptedException {
//        ScheduledExecutorService delayExecutorService = Executors.newSingleThreadScheduledExecutor(new NamedThreadFactory());
        ScheduledExecutorService delayExecutorService = Executors.newSingleThreadScheduledExecutor(new NamedThreadFactory("roypool" ,true));

        delayExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                logger.info("111111111111111111");
            }
        }, 5, TimeUnit.SECONDS);

        TimeUnit.SECONDS.sleep(10);
    }

    /**
     * 延迟周期执行任务
     * @throws InterruptedException
     */
    public void testScheduledThreadPoolExecutor_2() throws InterruptedException {
        ScheduledThreadPoolExecutor poolExecutor = new ScheduledThreadPoolExecutor(2, new NamedThreadFactory("roypool", true));
        poolExecutor.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                logger.info("22222222222222222");
            }
        }, 5, 3, TimeUnit.SECONDS);

        TimeUnit.SECONDS.sleep(10);
    }

}
