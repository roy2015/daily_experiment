package com.roy.miscellaneous.juc.multiThread;

import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by apple on 2019/10/31.
 *建立三个线程A、B、C，A线程打印10次字母A，B线程打印10次字母B,C线程打印10次字母C，
 * 但是要求三个线程同时运行，并且实现交替打印，即按照ABCABCABC的顺序打印。
 *
 */
public class TestPrintABC {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestPrintABC.class);

    /**
     */
    static class Solution {
        private volatile String expect;//相当于黑板，期待输出值

        private ReentrantLock lock = new ReentrantLock();
        private Condition conditionA = lock.newCondition();
        private Condition conditionB = lock.newCondition();
        private Condition conditionC = lock.newCondition();

        public Solution() {
            this.expect = "A";
        }

        public void printA(String threadName) throws Exception {
            lock.lockInterruptibly();
            try {
                while (! expect.equals("A")) {
                    conditionC.await();
                }
                logger.info("trheadName: {}, print: {}", threadName, "A");
                expect = "B";
                conditionA.signal();
            } finally {
                lock.unlock();
            }
        }

        public void printB(String threadName) throws Exception {
            lock.lockInterruptibly();
            try {
                while (! expect.equals("B")) {
                    conditionA.await();
                }
                logger.info("trheadName: {}, print: {}", threadName, "B");
                expect = "C";
                conditionB.signal();
            } finally {
                lock.unlock();
            }
        }

        public void printC(String threadName) throws Exception {
            lock.lockInterruptibly();
            try {
                while (! expect.equals("C")) {
                    conditionB.await();
                }
                logger.info("trheadName: {}, print: {}", threadName, "C");
                logger.info("=================================");
                expect = "A";
                conditionC.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        int count = 10;

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < count; i++) {
                        solution.printA("T_A");
                    }
                } catch (Exception e) {
                    logger.info(e.getMessage(), e);
                }
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < count; i++) {
                        solution.printB("T_B");
                    }
                } catch (Exception e) {
                    logger.info(e.getMessage(), e);
                }
            }
        });
        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < count; i++) {
                        solution.printC("T_C");
                    }
                } catch (Exception e) {
                    logger.info(e.getMessage(), e);
                }
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();

        System.in.read();

    }

}
