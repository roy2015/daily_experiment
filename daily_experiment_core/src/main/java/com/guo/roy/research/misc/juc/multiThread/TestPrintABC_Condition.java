package com.guo.roy.research.misc.juc.multiThread;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * 手写的 另外一个版本的顺序打印abc
 *
 * 用了三个线程可见状态变量
 *
 * @author guojun
 * @date 2023/3/27
 */
public class TestPrintABC_Condition {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestPrintABC_Condition.class);


    public Lock lock = new ReentrantLock();
    //a,b,c 线程是否完成
    public volatile boolean aDone = false;
    public volatile boolean bDone = false;
    public volatile boolean cDone = true;
    //condition
    public  Condition conditionAB = lock.newCondition();
    public  Condition conditionBC = lock.newCondition();
    public  Condition conditionCA = lock.newCondition();
    //需要打印的次数
    public int times=10;

    public void test() {
        Thread work1 = new Thread(new WorkerA("threadA", "A--------"));
        Thread work2 = new Thread(new WorkerB("threadB", "---B-----"));
        Thread work3 = new Thread(new WorkerC("threadC", "--------C"));
        work3.start();
        work1.start();
        work2.start();
    }

    @Data
    @AllArgsConstructor
    class WorkerA implements Runnable {
        private String name;
        private String outputStr;

        @Override
        public void run() {
            int run = 0;
            while (run != times) {
                try {
                    lock.lock();
                    while (!cDone) {
                        conditionCA.await();
                    }

                    logger.info("{}: {}", name, outputStr);
                    run ++;
                    aDone = true;
                    cDone = false;
                    bDone = false;
                    conditionAB.signal();
                } catch (InterruptedException e) {
                    logger.error(e.getMessage(), e);
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    @Data
    @AllArgsConstructor
    class WorkerB implements Runnable {
        private String name;
        private String outputStr;

        @Override
        public void run() {
            int run = 0;
            while (run != times) {
                try {
                    lock.lock();
                    while (!aDone) {
                        conditionAB.await();
                    }

                    logger.info("{}: {}", name, outputStr);
                    run ++;
                    aDone = false;
                    bDone = true;
                    cDone = false;
                    conditionBC.signal();
                } catch (InterruptedException e) {
                    logger.error(e.getMessage(), e);
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    @Data
    @AllArgsConstructor
    class WorkerC implements Runnable {
        private String name;
        private String outputStr;

        @Override
        public void run() {
            int run = 0;
            while (run != times) {
                try {
                    lock.lock();
                    while (!bDone) {
                        conditionBC.await();
                    }

                    logger.info("{}: {}", name, outputStr);
                    logger.info("\n\n");
                    run ++;
                    aDone = false;
                    bDone = false;
                    cDone = true;
                    conditionCA.signal();
                } catch (InterruptedException e) {
                    logger.error(e.getMessage(), e);
                } finally {
                    lock.unlock();
                }
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        new TestPrintABC_Condition().test();
        TimeUnit.SECONDS.sleep(10);
    }
}
