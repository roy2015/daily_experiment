package com.guo.roy.research.testing;

import org.slf4j.LoggerFactory;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * @author guojun
 * @date 2021/6/11
 */
public class TestWaitThread {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestWaitThread.class);


    static class Solution {
        public  void main() throws InterruptedException {
            Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        for (int i = 0; ; i++) {

                            TimeUnit.SECONDS.sleep(1);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "1");
            thread1.start();

            Thread thread2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        for (int i = 0; ; i++) {
                            int sum =0;
                            TimeUnit.SECONDS.sleep(1);
                            for (int j = 0; j < 10000000; j++) {
                                sum += j;
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "2");
            thread2.start();


        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Solution().main();
        TimeUnit.MINUTES.sleep(1);
    }
}
