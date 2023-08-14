package com.guo.roy.research.interview;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 面试题目 两个线程A,B  A负责12,34,56  B负责ABC..Z
 * 交替输出 12A34B56C78D910E....5152Z
 *
 * @author guojun
 * @date 2023/7/15 11:03
 */
public class ShowmeBug1 {
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
        ShowmeBug1 showmeBug1 = new ShowmeBug1();
        new Thread(() -> showmeBug1.printA()).start();
        TimeUnit.MILLISECONDS.sleep(10);//让第一个线程先执行
        new Thread(() -> showmeBug1.printB()).start();
        TimeUnit.SECONDS.sleep(3);//等待三秒获取输出结果
        System.out.println(ShowmeBug1.output.toString());
    }

    public static void main(String[] args) throws InterruptedException {
        new ShowmeBug1().main();

    }
}
