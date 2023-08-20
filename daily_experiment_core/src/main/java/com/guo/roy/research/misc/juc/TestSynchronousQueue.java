package com.guo.roy.research.misc.juc;

import lombok.SneakyThrows;
import org.slf4j.LoggerFactory;

import java.util.concurrent.SynchronousQueue;

/**
 * @author guojun
 * @date 2021/6/11
 */
public class TestSynchronousQueue {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSynchronousQueue.class);


    static class Solution {

        public void main() {
            SynchronousQueue<String> synchronousQueue = new SynchronousQueue<>();

            Thread producer = new Thread(() -> {
                try {
                    synchronousQueue.put("a");
                } catch (InterruptedException e) {
                    logger.error(e.getMessage(), e);
                }
            });

            Thread counsumer = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        String el = synchronousQueue.take();
                        logger.debug("收到数据: {}", el);
                    } catch (InterruptedException e) {
                        logger.error(e.getMessage(), e);

                    }
                }
            });

            producer.start();
            counsumer.start();
        }

    }

    public static void main(String[] args) {
        new Solution().main();
    }
}
