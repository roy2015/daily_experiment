package com.guo.roy.research.misc.juc.multiThread;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.threadpool.TtlExecutors;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author guojun
 * @date 2023/10/13 14:50
 */
public class TestTransmittableThreadLocal {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(TestTransmittableThreadLocal.class);

    static class Solution {
        TransmittableThreadLocal<String> ttl;
        private ExecutorService executorService;

        public Solution() {
            ttl = new TransmittableThreadLocal<>();
            executorService = Executors.newFixedThreadPool(1);
            executorService = TtlExecutors.getTtlExecutorService(executorService);

        }

        public void main() throws InterruptedException {
            ttl.set("traceId-main");
            Runnable task1 = () -> {
                LOGGER.debug("task1 traceId :{} ", ttl.get());
                ttl.set("traceId:-task1");
            };

            Runnable task2 = () -> {
                LOGGER.debug("task2 traceId :{} ", ttl.get());
                ttl.set("traceId:-task2");
                Runnable task2_1 = () -> {
                    LOGGER.debug("task2_1 traceId :{} ", ttl.get());
                    ttl.set("traceId:-task2_1");
                };

                executorService.submit(task2_1);
            };

            executorService.submit(task1);
            executorService.submit(task2);
            TimeUnit.SECONDS.sleep(1);
            LOGGER.debug("main thread traceId :{} ", ttl.get());
            executorService.shutdown();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        new Solution().main();
    }

}
