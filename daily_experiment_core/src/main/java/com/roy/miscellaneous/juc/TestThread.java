package com.roy.miscellaneous.juc;

import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * 1. 测试LockSupport
 * 2. 测试各种interrupt()中断
 *
 * comments:
 *   thread的各种state见
 *    {@link java.lang.Thread.State},理解Blocked和Waiting的不通，Syncronizied是Blocked, Object.wait()
 *    是Waiting, TIMED_WAITING
 */
public class TestThread {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(TestThread.class);


    public static Thread genLockSupportThread(String tName) {
        Thread thread = new Thread(new Runnable() {
            private String threadName = tName;
            @Override
            public void run() {
                LOGGER.debug("{}", threadName);
                LOGGER.info("线程中断状态{}", Thread.currentThread().isInterrupted());
                LockSupport.park(this);
                LOGGER.info("线程中断状态{}", Thread.currentThread().isInterrupted());
                LOGGER.debug("{}: i am awake", threadName);
            }
        });
        return thread;
    }

    public static Thread genSleepThread(String tName) {
        Thread thread = new Thread(new Runnable() {
            private String threadName = tName;
            @Override
            public void run() {
                LOGGER.debug("{}", threadName);
                try {
                    LOGGER.info("线程中断状态{}", Thread.currentThread().isInterrupted());
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    LOGGER.info("线程中断状态{}", Thread.currentThread().isInterrupted());
                    LOGGER.error("{} 发生中断了...", threadName);
                }
            }
        });
        return thread;
    }

    public static Thread genLoopThread(String tName) {
        Thread thread = new Thread(new Runnable() {
            private String threadName = tName;
            @Override
            public void run() {
                LOGGER.debug("{}", threadName);
                for (;;) {
                    LOGGER.info("线程中断状态{}", Thread.currentThread().isInterrupted());
                }
            }
        });
        return thread;
    }

    public static void testLockSleepInterrupt() throws IOException, InterruptedException {
        Thread thread1 = TestThread.genSleepThread("thread-1");
        thread1.start();

        LOGGER.debug("main thread sleep.....");
        TimeUnit.SECONDS.sleep(3);
        thread1.interrupt();
        System.in.read();
    }

    public static void testLoopInterrupt() throws IOException, InterruptedException {
        Thread thread1 = TestThread.genLoopThread("thread-1");
        thread1.start();

        LOGGER.debug("main thread sleep.....");
        TimeUnit.SECONDS.sleep(3);
        thread1.interrupt();
        System.in.read();
    }

    /**
     * 测试 Locksupport的中断
     * @throws IOException
     * @throws InterruptedException
     */
    public static void testLockSupportInterrupt() throws IOException, InterruptedException {
        Thread thread1 = TestThread.genLockSupportThread("thread-1");
        thread1.start();

        LOGGER.debug("main thread sleep.....");
        TimeUnit.SECONDS.sleep(3);
        thread1.interrupt();
        System.in.read();
    }

    /**
     * 测试 LockSupport
     * @param args
     * @throws IOException
     * @throws InterruptedException
     */
    public static void testLockSupport(String[] args) throws IOException, InterruptedException {
        Thread thread1 = TestThread.genLockSupportThread("thread-1");
        thread1.start();

        LOGGER.debug("main thread sleep.....");
        TimeUnit.SECONDS.sleep(3);
        LockSupport.unpark(thread1);
        LOGGER.debug("going done.....");
        System.in.read();
    }
}
