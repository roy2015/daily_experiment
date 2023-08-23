package com.guo.roy.research.misc.juc.multiThread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 面试题目 两个线程A,B  A负责12,34,56  B负责ABC..Z
 *  *  * 交替输出 12A34B56C78D910E....5152Z
 *
 * @author guojun
 * @date 2023/8/18 22:21
 * 
 * 
 */
@Slf4j
public class TestPrint12A5152z_2 {
    private ReentrantLock lock;
    private StringBuffer sb;
    private volatile int onOff = 1;//奇偶开关


    public TestPrint12A5152z_2() {
        this.lock = new ReentrantLock();
        this.sb = new StringBuffer();
    }
    
    
    public void main() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            int i = 0;
            while (i < 26) {//12  34  ...  5152  2n+1 2n+2
                while (onOff ==0) {

                }
                lock.lock(); // block until condition holds
                try {
                    sb.append(2*i+1).append(2*i+2);
                    i ++;
                } finally {
                    onOff =0;
                    lock.unlock();
                }
            }
        });



        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (i < 26) {//12  34  ...  5152  2n+1 2n+2
                    while (onOff ==1) {
                    }
                    lock.lock(); // block until condition holds
                    try {
                        sb.append(((char)('A'+ i)));
                        i ++;
                    } finally {
                        lock.unlock();
                        onOff =1;
                    }
                }
            }
        });
        thread1.start();
        thread2.start();

        TimeUnit.SECONDS.sleep(1);
        log.debug("{}", sb.toString());
    }

    public static void main(String[] args) throws InterruptedException {
        new TestPrint12A5152z_2().main();
    }
    
}
