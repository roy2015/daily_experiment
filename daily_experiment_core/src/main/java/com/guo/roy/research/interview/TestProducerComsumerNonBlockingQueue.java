package com.guo.roy.research.interview;

import lombok.Data;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author guojun
 * @date 2021/6/11
 */
public class TestProducerComsumerNonBlockingQueue {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestProducerComsumerNonBlockingQueue.class);


    static class Solution {

        private ReentrantLock lock;
        private Condition producerCondition;
        private Condition consumerCondition;
        private volatile boolean fullFlag;
        private volatile String diamond;

        public Solution() {

        }

        public void start() throws IOException {
            lock = new ReentrantLock();
            producerCondition = lock.newCondition();
            consumerCondition = lock.newCondition();
            fullFlag = false;

            Producer producer = new Producer();
            Consumer consumer = new Consumer();


            new Thread(producer).start();
            new Thread(consumer).start();

            System.in.read();
        }

        @Data
        public class Producer implements Runnable {

            @Override
            public void run() {
                try {
                    int idx = 0;
                    for (int i =0; i< 10 ;i++ ) {

                        lock.lock();  // block until condition holds
                        try {
                            if (fullFlag) {
                                consumerCondition.await();
                            } else {//未满
                                String toAdd = "A" + (idx++);
                                logger.info("add {}", toAdd);
                                diamond = toAdd;
                                fullFlag = true;
                                producerCondition.signal();
                            }

                        } finally {
                            lock.unlock();
                        }

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        @Data
        public class Consumer implements Runnable {
            private String workerName;
            private int loopIdx = 1;//初始化1

            @Override
            public void run() {
                try {
                    for (int i =0; i< 10 ;i++ ) {
                        lock.lock();  // block until condition holds
                        try {
                            if (!fullFlag) {
                                producerCondition.await();
                            } else {
                                logger.info("      get {}", diamond);
                                diamond = "";
                                fullFlag = false;
                                consumerCondition.signal();
                            }

                        } finally {
                            lock.unlock();
                        }

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new TestProducerComsumerNonBlockingQueue.Solution().start();
    }
}
