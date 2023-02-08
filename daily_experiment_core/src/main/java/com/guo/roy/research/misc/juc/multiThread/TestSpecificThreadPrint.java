package com.guo.roy.research.misc.juc.multiThread;

import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 交替输出12, t1 1， t2 2 t1 1 t2 2
 *
 */
public class TestSpecificThreadPrint {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSpecificThreadPrint.class);

    private   BlockingQueue<Integer> queue;

    public TestSpecificThreadPrint() {
    }

    public TestSpecificThreadPrint(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    /**
     * * @param threadName
     * @throws InterruptedException
     */
    public void thread1Print(String threadName) throws InterruptedException {
        logger.info("{}进入",threadName);

        for (int i = 0; i < 10; i++) {
            logger.debug("{}：{}", threadName, "1");
            queue.take();
            TimeUnit.SECONDS.sleep(3);

        }
    }

    public void thread2Print(String threadName) throws InterruptedException {
        logger.info("{}进入",threadName);
        for (int i = 0; i < 10; i++) {
            queue.put(1);
            logger.debug("{}：{}", threadName, "2");

        }
    }

    public static void testThreadPrin() throws IOException, InterruptedException {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue(1);
        TestSpecificThreadPrint oddEvenPrint = new TestSpecificThreadPrint(queue);
        queue.put(1);

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    oddEvenPrint.thread1Print("thread-1");
                } catch (InterruptedException e) {
                    logger.debug(e.getMessage(), e);
                }
            }
        }, "thread-1");


        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    oddEvenPrint.thread2Print("thread-2");
                } catch (InterruptedException e) {
                    logger.debug(e.getMessage(), e);
                }
            }
        }, "thread-2");

        thread2.start();
        thread1.start();

        System.in.read();
    }

    public static void main(String[] args) throws Exception {
        TestSpecificThreadPrint.testThreadPrin();
    }

}
