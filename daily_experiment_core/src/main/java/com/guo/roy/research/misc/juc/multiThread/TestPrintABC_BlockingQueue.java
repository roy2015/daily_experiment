package com.guo.roy.research.misc.juc.multiThread;

import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/10/31.
 *建立三个线程A、B、C，A线程打印10次字母A，B线程打印10次字母B,C线程打印10次字母C，
 * 但是要求三个线程同时运行，并且实现交替打印，即按照ABCABCABC的顺序打印。
 *
 * 自己想的BlockingQueue实现，思路来源于golang的chan
 *
 */
public class TestPrintABC_BlockingQueue {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestPrintABC_BlockingQueue.class);

    /**
     */
    static class Solution {
        private BlockingQueue<Integer> q1 = new LinkedBlockingQueue(1);
        private BlockingQueue<Integer> q2= new LinkedBlockingQueue(1);
        private BlockingQueue<Integer> q3= new LinkedBlockingQueue(1);
        private volatile StringBuffer output = new StringBuffer();
        private int looptimes = 10;


        public void main() throws InterruptedException {
            Thread threadA = new Thread(() -> {

                for (int i = 0; i < looptimes; i++) {
                    try {
                        Integer val = q1.take();
                        if (val.equals(1)) {
                            logger.info("start...");
                        } else {
                        }
                        output.append("A");
                        logger.info("{}： {}", "threadA", "A");
                        q2.put(0);
                    } catch (InterruptedException e) {
                        logger.error(e.getMessage(), e);
                    }
                }
            });

            Thread threadB = new Thread(() -> {
                for (int i = 0; i < looptimes; i++) {
                    try {
                        q2.take();
                        logger.info("{}： {}", "threadB", "B");
                        output.append("B");
                        q3.put(0);
                    } catch (InterruptedException e) {
                        logger.error(e.getMessage(), e);
                    }
                }
            });

            Thread threadC = new Thread(() -> {
                for (int i = 0; i < looptimes; i++) {
                    try {
                        q3.take();
                        logger.info("{}： {}", "threadC", "C");
                        output.append("C");
                        q1.put(0);
                    } catch (InterruptedException e) {
                        logger.error(e.getMessage(), e);
                    }
                }
            });

            threadC.start();
            TimeUnit.MILLISECONDS.sleep(100);//制造极端场景 ，C先执行
            threadB.start();
            TimeUnit.MILLISECONDS.sleep(100);//制造极端场景 ，B先执行
            threadA.start();

            q1.put(1);//给一个开始信号

            threadA.join();
            threadB.join();
            threadC.join();

            logger.info("output: {}",output);
        }

    }

    public static void main(String[] args) throws InterruptedException {
        new Solution().main();
    }

}
