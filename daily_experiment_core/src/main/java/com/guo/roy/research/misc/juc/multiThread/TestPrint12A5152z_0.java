package com.guo.roy.research.misc.juc.multiThread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 面试题目 两个线程A,B  A负责12,34,56  B负责ABC..Z
 * 交替输出 12A34B56C78D910E....5152Z
 *
 * @author guojun
 * @date 2023/7/15 11:03
 *
 * synchronized + wait + notify
 */
public class TestPrint12A5152z_0 {
    private ReentrantLock lock = new ReentrantLock();

    private static volatile StringBuffer output = new StringBuffer();

    private synchronized void printA() {

        int targetLoop = 26;
        int loop = 1;
        while (loop <= targetLoop) {
            output.append(2 * loop - 1);
            output.append(2 * loop);
            loop++;
            notify();
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized void printB() {
        int targetLoop = 26;
        int loop = 1;
        while (loop <= targetLoop) {
            output.append((char) ('A' + (loop - 1)));
            loop++;
            notify();
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void main() throws InterruptedException {
        TestPrint12A5152z_0 testPrint12A5152z0 = new TestPrint12A5152z_0();
        new Thread(() -> testPrint12A5152z0.printA()).start();
        TimeUnit.MILLISECONDS.sleep(10);//让第一个线程先执行
        new Thread(() -> testPrint12A5152z0.printB()).start();
        TimeUnit.SECONDS.sleep(3);//等待三秒获取输出结果
        System.out.println(TestPrint12A5152z_0.output.toString());
    }

    public static void main(String[] args) throws InterruptedException {
        new TestPrint12A5152z_0().main();

    }
}
