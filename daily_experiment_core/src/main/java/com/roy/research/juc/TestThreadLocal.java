package com.roy.research.juc;

import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * 测试ThreadLocal,两个线程，
 * 第二个线程改了value并不影响第一个线程的value
 *
 * 总结：
 * 1.  set(T value)最终的放到Thread的threadLocals的Entry[] 里，Entry的长度就是ThreadLocal的个数（本线程）
 * 2. Thread的属性 ThreadLocal.ThreadLocalMap threadLocals，ThreadLocalMap的key是ThreadLocal对象本身，
 *    value是你要设置的值（所以一个线程里可以用多个ThreadLocal）
 * 3. createMap(t, value); t为currentThead, 会为每个线程创建单独的ThreadLocalMap, 这就做到了线程隔离
 * 4. 看起来好像“ThreadLocal存在与多个线程”，实际上只是用了他的hashCode(第一次赋值的时候)
 * 问题：
 * 1. Entry是weakReference的内存泄漏
 */
public class TestThreadLocal {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(TestThreadLocal.class);


    public static void testThreadLocal() throws IOException {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    threadLocal.set("123");
                    LOGGER.debug("{}, before sleep threadlocal.value: {}", "thread-1", threadLocal.get());
                    LOGGER.debug("{} sleep....." , "thread-1");
                    TimeUnit.SECONDS.sleep(3);
                    LOGGER.debug("{}, awake threadlocal.value: {}", "thread-1", threadLocal.get());
                } catch (InterruptedException e) {
                    LOGGER.error(e.getMessage(), e);
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    threadLocal.set("456");
                    LOGGER.debug("{}, threadlocal.value: {}", "thread-2", threadLocal.get());
                } catch (Exception e) {
                    LOGGER.error(e.getMessage(), e);
                }
            }
        }).start();

        System.in.read();


    }
}
