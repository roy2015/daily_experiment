package com.roy.miscellaneous.juc;

import org.slf4j.LoggerFactory;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.concurrent.TimeUnit;

/**
 * 写一个计数器
 */
public class TestUnsafeCas {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(TestUnsafeCas.class);

    private static final Unsafe unsafe;

    private volatile int counter;

    private static final long counterOffset;

    static{
        try {
            //获取unSafe
            final PrivilegedExceptionAction<Unsafe> action = new PrivilegedExceptionAction<Unsafe>() {
                public Unsafe run() throws Exception {
                    Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
                    theUnsafe.setAccessible(true);
                    return (Unsafe) theUnsafe.get(null);
                }
            };
            unsafe = AccessController.doPrivileged(action);
            //业务
            counterOffset = unsafe.objectFieldOffset(TestUnsafeCas.class.getDeclaredField("counter"));

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
     * 生成线程
     * @param tName
     * @return
     */
    public static Thread genUnsafeThread(String tName, TestUnsafeCas testUnsafeCas) {
        Thread thread = new Thread(new Runnable() {
            private String threadName = tName;
            @Override
            public void run() {
                testUnsafeCas.getAndIncrement();
                LOGGER.info("{}，count=[{}] ", threadName, testUnsafeCas.getCounter());
            }
        });
        return thread;
    }

    public static Thread genThread(String tName, TestUnsafeCas testUnsafeCas) {
        Thread thread = new Thread(new Runnable() {
            private String threadName = tName;
            @Override
            public void run() {
                testUnsafeCas.counter ++;
                LOGGER.info("{}，count=[{}] ", threadName, testUnsafeCas.getCounter());
            }
        });
        return thread;
    }


    public static void testWithoutUnsafe() throws InterruptedException {
        TestUnsafeCas testUnsafeCas = new TestUnsafeCas();
        for (int i=1; i<=5000; i++) {
            genThread(i + "", testUnsafeCas).start();
        }

        TimeUnit.SECONDS.sleep(3);
        LOGGER.info("counter=[{}]", testUnsafeCas.getCounter());
    }

    public static void testUnsafe() throws InterruptedException {
        TestUnsafeCas testUnsafeCas = new TestUnsafeCas();
        for (int i=1; i<=5000; i++) {
            genUnsafeThread(i + "", testUnsafeCas).start();
        }

        TimeUnit.SECONDS.sleep(3);
        LOGGER.info("counter=[{}]", testUnsafeCas.getCounter());
    }


}
