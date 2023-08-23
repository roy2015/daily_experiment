package com.guo.roy.research.misc.juc.multiThread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;

/**
 * 面试题目 两个线程A,B  A负责12,34,56  B负责ABC..Z
 *  *  * 交替输出 12A34B56C78D910E....5152Z
 *
 * @author guojun
 * @date 2023/8/18 22:21
 * 
 *   第三种方式，比较好理解，用两个SynchronousQueue
 */
@Slf4j
public class TestPrint12A5152z_4 {
    private BlockingQueue<String> queueA;//thread1执行的条件
    private BlockingQueue<String> queueB;//thread2执行的条件
    private StringBuffer output;//保存结果


    public TestPrint12A5152z_4() {
        this.queueA = new SynchronousQueue<>();
        this.queueB = new SynchronousQueue<>();
        output = new StringBuffer();
    }


    public void print125152(String threadName) {
        int i = 0;
        try {
            while (i < 26) {//12  34  ...  5152  2n+1 2n+2
                String takeVal = queueA.take();
                if ("start".equals(takeVal)) {
                    log.info("{}拿到开始指令, 去掉 start", threadName);
                } else {
                    //do nothing
                }
                StringBuffer sb = new StringBuffer();
                sb.append(2*i+1).append(2*i+2);
                i ++;
                log.info("{} put {}", threadName, sb.toString());
                output.append(sb.toString());
                queueB.put("1");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void printaz(String threadName) {
        int i = 0;
        try {
            while (i < 26) {//12  34  ...  5152  2n+1 2n+2
                queueB.take();
                StringBuffer sb = new StringBuffer();
                sb.append((char)('A'+ i));
                i ++;
                output.append(sb.toString());
                log.info("{} put {}", threadName, sb.toString());
                queueA.put("1");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    
    public void main() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
                print125152("thread_A");
            }
        );

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                printaz("thread_B");
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    queueA.put("start");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread2.start();
        thread1.start();
        thread3.start();
        //主线程sleep 10s
        TimeUnit.SECONDS.sleep(4);
        log.debug("{}", output.toString());
    }

    public static void main(String[] args) throws InterruptedException {
        new TestPrint12A5152z_4().main();
    }
    
}
