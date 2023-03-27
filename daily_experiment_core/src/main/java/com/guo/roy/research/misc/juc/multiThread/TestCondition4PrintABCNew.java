package com.guo.roy.research.misc.juc.multiThread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.LoggerFactory;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * 手写的 另外一个版本的顺序打印abc
 * 不用状态变量，只用condition,  附加工作就是需要启动参数，和A线程的第一次执行不走condition
 * @author guojun
 * @date 2023/3/27
 */
public class TestCondition4PrintABCNew {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestCondition4PrintABCNew.class);


    public Lock lock = new ReentrantLock();

    //condition
    public  Condition conditionAB = lock.newCondition();
    public  Condition conditionBC = lock.newCondition();
    public  Condition conditionCA = lock.newCondition();
    //需要打印的次数
    public int times=10;
    public boolean startUp = false;


    public void test() throws InterruptedException {
        Thread work1 = new Thread(new WorkerA("threadA", "A--------"), "threadA");
        Thread work2 = new Thread(new WorkerB("threadB", "---B-----"), "threadB");
        Thread work3 = new Thread(new WorkerC("threadC", "--------C"), "threadC");
        work1.start();
        work3.start();
        work2.start();
        //延迟一秒启动
        TimeUnit.SECONDS.sleep(1);
        this.startUp = true;
    }

    @Data
    @AllArgsConstructor
    class WorkerA implements Runnable {
        private String name;
        private String outputStr;

        @Override
        public void run() {
            //启动
            while (!startUp) {
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    logger.error(e.getMessage(), e);
                }
            }

            boolean firstRun = true;
            int run = 0;
            while (run != times) {
                try {
                    lock.lock();
                    if (!firstRun) {
                        conditionCA.await();
                    } else {
                        firstRun = false;
                    }

                    logger.info("{}: {}", name, outputStr);
                    run ++;
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
                        conditionAB.await();

                    logger.info("{}: {}", name, outputStr);
                    run ++;
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
                        conditionBC.await();

                    logger.info("{}: {}", name, outputStr);
                    logger.info("\n\n");
                    run ++;
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
        new TestCondition4PrintABCNew().test();
        TimeUnit.SECONDS.sleep(5);
    }
}
