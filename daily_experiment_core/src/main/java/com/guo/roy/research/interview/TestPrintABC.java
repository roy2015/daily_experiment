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
public class TestPrintABC {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestPrintABC.class);


    static class Solution {
        private int loopLimit;
        private volatile int currentLoop;

        private ReentrantLock lock;
        private Condition conditionA;
        private Condition conditionB;
        private Condition conditionC;
        private volatile boolean readyA;
        private volatile boolean readyB;
        private volatile boolean readyC;

        public Solution() {
            loopLimit = 10;
            currentLoop = 1;
            lock = new ReentrantLock();
            conditionA = lock.newCondition();
            conditionB = lock.newCondition();
            conditionC = lock.newCondition();
        }

        public void start() throws IOException {
            Worker workerA = new Worker();
            Worker workerB = new Worker();
            Worker workerC = new Worker();

            workerA.setWorkerName("A");
            workerB.setWorkerName("B");
            workerC.setWorkerName("C");

            new Thread(workerA).start();
            new Thread(workerB).start();
            new Thread(workerC).start();

            System.in.read();
        }

        @Data
        public class Worker implements Runnable {
            private String workerName;
            private int loopIdx = 1;//初始化1

            @Override
            public void run() {
                try {
                    for (; ; ) {
                        if (loopIdx > loopLimit) {
                            break;
                        }
                        lock.lock();  // block until condition holds
                        try {

                            if (workerName.equals("A")) {//A
                                if (loopIdx == 1) {
                                    logger.info("   {}-{}", loopIdx, workerName);
                                    loopIdx++;
                                    readyA = true;
                                    conditionA.signal();
                                } else {
                                    if (!readyC) {
                                        conditionC.await();

                                    } else {
                                        readyC = false;
                                        readyA = true;
                                        logger.info("   {}-{}", loopIdx, workerName);
                                        loopIdx++;
                                        conditionA.signal();
                                    }
                                }

                            } else if (workerName.equals("B")) {//B
                                if (!readyA) {
                                    conditionA.await();
                                } else {
                                    readyA = false;
                                    readyB = true;
                                    logger.info("   {}-{}", loopIdx, workerName);
                                    loopIdx++;
                                    conditionB.signal();
                                }

                            } else {//C
                                if (!readyB) {
                                    conditionB.await();
                                } else {
                                    readyB = false;
                                    readyC = true;
                                    logger.info("   {}-{}", loopIdx, workerName);
                                    loopIdx++;
                                    currentLoop++;
                                    conditionC.signal();

                                }

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
        new Solution().start();
    }
}
