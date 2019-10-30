package com.roy.miscellaneous.interview;

import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 交替输出奇偶
 *
 */
public class TestOddEvenPrint {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestOddEvenPrint.class);

    private static final Lock MY_LOCK = new ReentrantLock();
    private static final Condition MY_COND = MY_LOCK.newCondition();

    private  int limit;
    private volatile int printVar;

    public TestOddEvenPrint(int limit) {
        this.limit = limit;
    }

    /**
     * 第一个线程把活儿全干了
     * @param threadName
     * @throws InterruptedException
     */
    public void printOddEven_1(String threadName) throws InterruptedException {
        logger.info("{}进入",threadName);
        try {
            MY_LOCK.lock();
            while (printVar < limit) {
                logger.debug("{}：{}", threadName,  ++ printVar);
            }
        } finally {
            MY_LOCK.unlock();
        }
    }

    /**
     * 交替1234
     * * @param threadName
     * @throws InterruptedException
     */
    public void printOddEven_2(String threadName) throws InterruptedException {
        logger.info("{}进入",threadName);
        MY_LOCK.lockInterruptibly();
        try {
            while (printVar < limit) {
                logger.debug("{}：{}", threadName,  ++ printVar);
                MY_COND.signalAll();
                MY_COND.await();
            }
        } finally {
            MY_LOCK.unlock();
        }
    }

    public void testOddEvenPrin() throws IOException {
        TestOddEvenPrint oddEvenPrint = new TestOddEvenPrint(10);

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    oddEvenPrint.printOddEven_2("thread-1");
                } catch (InterruptedException e) {
                    logger.debug(e.getMessage(), e);
                }
            }
        }, "thread-1");


        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    oddEvenPrint.printOddEven_2("thread-2");
                } catch (InterruptedException e) {
                    logger.debug(e.getMessage(), e);
                }
            }
        }, "thread-2");

        thread1.start();
        thread2.start();

        System.in.read();
    }

}
