package com.roy.miscellaneous.juc;

import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author guojun
 * @date 2020/6/9 19:25
 */
public class TestInheritableThreadLocal {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(TestInheritableThreadLocal.class);


    public static void main(String[] args) throws IOException {
        InheritableThreadLocal<String> threadLocal = new InheritableThreadLocal<>();
        threadLocal.set("parent");

        new Thread(new Runnable() {
            @Override
            public void run() {
                LOGGER.debug("{}", threadLocal.get());
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                LOGGER.debug("{}", threadLocal.get());
            }
        }).start();

        System.in.read();


    }
}
