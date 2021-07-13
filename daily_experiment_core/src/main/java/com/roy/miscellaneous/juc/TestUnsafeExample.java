package com.roy.miscellaneous.juc;

import org.slf4j.LoggerFactory;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.concurrent.TimeUnit;

/**
 * 写一个线程安全的计数器
 */
public class TestUnsafeExample {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(TestUnsafeExample.class);
    private static final Unsafe unsafe;
    private volatile int counter;
    private static final long counterOffset;

    static{
        try {
            //获取unSafe
            unsafe = AccessController.doPrivileged((PrivilegedExceptionAction<Unsafe>) () -> {
                Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
                theUnsafe.setAccessible(true);
                return (Unsafe) theUnsafe.get(null);
            });
            counterOffset = unsafe.objectFieldOffset(TestUnsafeExample.class.getDeclaredField("counter"));
        }
        catch (Exception e){
            throw new RuntimeException("Unable to load unsafe", e);
        }
    }

    private int getAndIncrement() {
        return unsafe.getAndAddInt(this, counterOffset, 1);
    }

    public int getCounter() {
        return counter;
    }

    /**
     * 直接对 volitile变量自增
     * @throws InterruptedException
     */
    public static void testWithoutUnsafe() throws InterruptedException {
        TestUnsafeExample testUnsafeCas = new TestUnsafeExample();
        for (int i=1; i<=50000; i++) {
            final String tName = i + "";
            new Thread(new Runnable() {
                private String threadName = tName;
                @Override
                public void run() {
                    testUnsafeCas.counter ++;
                    LOGGER.info("{}，count=[{}] ", threadName, testUnsafeCas.getCounter());
                }
            }).start();
        }

        TimeUnit.SECONDS.sleep(30);
        LOGGER.info("counter=[{}]", testUnsafeCas.getCounter());
    }

    /**
     * unsafe 的getAndIncrement
     * @throws InterruptedException
     */
    public static void testUnsafe() throws InterruptedException {
        TestUnsafeExample testUnsafeCas = new TestUnsafeExample();
        for (int i=1; i<=50000; i++) {
            final String tName = i + "";
            new Thread(new Runnable() {
                private String threadName = tName;
                @Override
                public void run() {
                    testUnsafeCas.getAndIncrement();
                    LOGGER.info("{}，count=[{}] ", threadName, testUnsafeCas.getCounter());
                }
            }).start();
        }

        TimeUnit.SECONDS.sleep(3);
        LOGGER.info("counter=[{}]", testUnsafeCas.getCounter());
    }
}
