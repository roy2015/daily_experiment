package com.roy.miscellaneous.juc;

import com.roy.miscellaneous.pattern.decorator.Test;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class TestCasAqs{
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(TestCasAqs.class);


    public static Thread testCasAqs(String tName) {
        Thread thread = new Thread(new Runnable() {
            private String threadName = tName;
            @Override
            public void run() {
                LOGGER.debug("{}", threadName);
                LockSupport.park(this);
                LOGGER.debug("{}: i am awake", threadName);

            }
        });
        return thread;


    }


    public static void main(String[] args) throws IOException, InterruptedException {
        Thread thread1 = TestCasAqs.testCasAqs("thread-1");
        Thread thread2 = TestCasAqs.testCasAqs("thread-2");
        thread1.start();

        LOGGER.debug("main thread sleep.....");
        TimeUnit.SECONDS.sleep(3);
        LockSupport.unpark(thread1);
        LOGGER.debug("going done.....");
        System.in.read();
    }
}
