package com.roy.miscellaneous.guava.util.concurrent;

import com.google.common.util.concurrent.RateLimiter;
import org.apache.commons.lang3.time.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by apple on 2019/8/22.
 *
 * Guava的限流算法
 * 1. 限制线程提交速度， 这个例子是 2/sec
 */
public class TestRateLimiter {
    public static final Logger LOGGER = LoggerFactory.getLogger(TestRateLimiter.class);
    private final RateLimiter rateLimiter = RateLimiter.create(2.0);

    public void submitTasks(List<Thread> tasks, Executor executor) {
        LOGGER.info("开始{}", System.currentTimeMillis());

        for (Thread task : tasks) {
            long startTimeInMil = System.currentTimeMillis();
            LOGGER.info("线程[{}]开始提交， 提交时间【{}】", task.getName(), startTimeInMil);
            LOGGER.info("{}",rateLimiter.acquire()); // may wait
            executor.execute(task);
            LOGGER.info("线程[{}]提交 done， 提交用时【{}】", task.getName(), System.currentTimeMillis() - startTimeInMil);
        }
    }

    public static void main(String[] args) {
        List<Thread> taskList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            final int ii = i;
            taskList.add(new Thread(new Runnable() {
                @Override
                public void run() {
//                    LOGGER.info("=========== [{}] ", ii);
                }
            }, "mythread-" + i ));
        }


        ExecutorService executorService = Executors.newFixedThreadPool(10);
        TestRateLimiter testRateLimiter = new TestRateLimiter();
        testRateLimiter.submitTasks(taskList, executorService);

    }
}
