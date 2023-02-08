package com.guo.roy.research.interview;

import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 *
 * 生产者消费者
 * 使用BlockingQueue
 *
 * @author guojun
 * @date 2021/6/11
 */
public class TestProducerComsumerWithBlockingQueue {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestProducerComsumerWithBlockingQueue.class);


    static class Solution {
        private BlockingQueue<String> queue = new ArrayBlockingQueue<> (5, true);

        public void test () throws IOException, InterruptedException {
            queue.put("A1");
            queue.put("A2");
            queue.put("A3");

            new Thread(new Producer()).start();
            new Thread(new Consumer()).start();

            System.in.read();

        }

        public class Producer implements Runnable {

            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    String toAdd = "B" + i;
                    try {
                        queue.put(toAdd);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    logger.info("       add {}" , toAdd);
                }
            }
        }

        public class Consumer implements Runnable {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        logger.info("get {}", queue.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

    public static void main(String[] args) throws Exception {
        new Solution().test();
    }
}
