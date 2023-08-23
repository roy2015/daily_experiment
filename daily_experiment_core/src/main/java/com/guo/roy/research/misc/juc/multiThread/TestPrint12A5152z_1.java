package com.guo.roy.research.misc.juc.multiThread;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * 面试题目 两个线程A,B  A负责12,34,56  B负责ABC..Z
 *  * 交替输出 12A34B56C78D910E....5152Z
 *
 *  采用ReentrantLock 和两个Condition
 *
 *
 * @author guojun
 * @date 2023/7/15 11:03
 */
public class TestPrint12A5152z_1 {
    private ReentrantLock lock = new ReentrantLock();
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();


     class Worker1  implements Runnable{
        private StringBuffer output;



        public Worker1( StringBuffer output) {
            this.output = output;
        }

        @SneakyThrows
        @Override
        public void run() {
            int targetLoop = 26;
            int loop = 1;
            boolean firstRun = true;
//            TimeUnit.SECONDS.sleep(1);
            while (loop <=targetLoop ) {
                try {
                    lock.lock();
                    if (!firstRun) {
                        conditionB.await();
                    } else {
                        firstRun = false;
                    }
                    output.append(2*loop-1);
                    output.append(2*loop);
                    loop++;
                    conditionA.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

     class Worker2  implements Runnable{
        private StringBuffer output;


        public Worker2( StringBuffer output) {
            this.output = output;
        }

        @Override
        public void run() {
            int targetLoop = 26;
            int loop =1;
            while (loop <=targetLoop ) {
                try {
                    lock.lock();
                    conditionA.await();
                    output.append((char)('A' + (loop -1)));
                    loop++;
                    conditionB.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public  void main() throws InterruptedException {

        StringBuffer stringBuffer = new StringBuffer();
        new Thread(new Worker1(  stringBuffer)).start();
        new Thread(new Worker2(  stringBuffer)).start();
        TimeUnit.SECONDS.sleep(3);
        System.out.println(stringBuffer.toString());
    }


    public static void main(String[] args) throws InterruptedException {
        new TestPrint12A5152z_1().main();
    }
}
