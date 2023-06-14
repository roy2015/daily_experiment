package com.guo.roy.research.misc.juc;

import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;


/**
 * 测试下信号量
 *
 *  理解：和抢令牌比较相似
 *  10个线程6块令牌
 */
public class TestSemaphore implements Runnable {
//    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(TestSemaphore.class);
    private Semaphore semaphore;
    private String threadName;

    public TestSemaphore(Semaphore semaphore, String threadName) {
        this.semaphore = semaphore;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println(String.format("%s 获取到信号量", threadName));
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
//            LOGGER.error(e.getMessage(), e);
        } finally {
            semaphore.release();
        }
    }

    public static void main(String[] args) throws IOException {
        Semaphore semaphore = new Semaphore(2);

        for (int i = 0; i < 3; i++) {
            TestSemaphore testSemaphore = new TestSemaphore(semaphore, String.format("thread-%s", (i+1)));
            new Thread(testSemaphore).start();
        }
        System.in.read();
    }
}
