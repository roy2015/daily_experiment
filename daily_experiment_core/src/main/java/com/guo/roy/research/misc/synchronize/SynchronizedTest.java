package com.guo.roy.research.misc.synchronize;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedTest {
    /*private SynchronizedTest(){}
    private static SynchronizedTest st;           //懒汉式单例模式，线程不安全，需要加synchronized同步
    public static SynchronizedTest getInstance(){
    	if(st == null){
    		st = new SynchronizedTest();
    	}
    	return st;
    }*/
    /*private SynchronizedTest(){}
    private static final SynchronizedTest st = new SynchronizedTest();  //饿汉式单利模式，天生线程安全
    public static SynchronizedTest getInstance(){
    	return st;
    }*/

    public static SynchronizedTest staticIn = new SynchronizedTest(); // 静态对象

    public synchronized void method1() { // 非静态方法1
        for (int i = 0; i < 10; i++) {
            System.out.println("synchronized method1 is running!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public synchronized void method2() { // 非静态方法2
        for (int i = 0; i < 10; i++) {
            System.out.println("synchronized method2 is running!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public synchronized static void staticMethod1() { // 静态方法1
        for (int i = 0; i < 10; i++) {
            System.out.println("synchronized static method1 is running!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public synchronized static void staticMethod2() { // 静态方法2
        for (int i = 0; i < 10; i++) {
            System.out.println("synchronized static method2 is running!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
//		    SynchronizedTest s = SynchronizedTest.getInstance();
//		    s.method1();
//		    SynchronizedTest s1 = new SynchronizedTest();
//		    s1.method1();
//		    SynchronizedTest.staticIn.method1();
            SynchronizedTest.staticMethod1();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
//		SynchronizedTest s = SynchronizedTest.getInstance();
        SynchronizedTest s2 = new SynchronizedTest();
//        s2.staticMethod2();
//		s2.method1();
		s2.method2();
//		SynchronizedTest.staticMethod2();
//      SynchronizedTest.staticIn.staticMethod2();
//		SynchronizedTest.staticIn.method2();
            }
        });
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(t1);
        exec.execute(t2);
        exec.shutdown();
    }
}