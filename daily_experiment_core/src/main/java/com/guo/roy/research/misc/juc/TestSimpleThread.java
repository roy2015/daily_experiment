package com.guo.roy.research.misc.juc;

import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by apple on 2019/8/22.
 *
 * 守护线程，  有守护的对象时不会退出， 都是守护进程是JVM退出
 * 这个demo就说明了这点
 *
 */
public class TestSimpleThread {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(TestSimpleThread.class);

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                LOGGER.info("==============");
                try {
                    TimeUnit.SECONDS.sleep(10);
                    LOGGER.info("*************");
                } catch (InterruptedException e) {
                    LOGGER.info(e.getMessage(), e);
                }
            }
        });

        thread.setDaemon(false);
        thread.start();

    }

}
