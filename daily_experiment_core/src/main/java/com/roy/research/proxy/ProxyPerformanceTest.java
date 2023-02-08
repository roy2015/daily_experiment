package com.roy.research.proxy;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *  代理性能测试  jdk vs cglib
 * @author: BG244210
 * Date:    22/10/2018
 * Description:
 */
public class ProxyPerformanceTest {

    private static void runTest(int repeatCount, int runCount, Map<String , Target> tests) {
        System.out.println(
            String.format("\n==== run test : [repeatCount=%s] [runCount=%s] [java.version=%s]====",
                    repeatCount, runCount, System.getProperty("java.version")));

        for (int i = 0; i < repeatCount; i++) {
            System.out.println(String.format("\n-----------------------test : [%s]", (i+1)));
            for ( String key : tests.keySet() ) {
                runWithMonitor(tests.get(key), runCount, key);
            }
        }
    }


    private static void runWithoutMonitor(Target target, int runCount) {
        for (int i = 0; i < runCount; i++) {
            target.test(i);
        }
    }

    private static void runWithMonitor(Target target, int runCount, String tag) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < runCount; i++) {
            target.test(i);
        }
        long end = System.currentTimeMillis();

        System.out.println(String.format(" [%s ] Total Time: [%s] ms", tag, (end - start)));
    }




    public static void main(String[] args) {
        //创建测试对象
        Target nativeTest = new TargetImpl();
//        Warship jdkDynamicProxy = JdkDynamicProxyTest.newProxyInstance(new AircraftCarrier("辽宁舰"));
        Target cglibProxy = CglibProxyTest.newProxyInstance(TargetImpl.class, nativeTest);

        //预热一下
        int preRunCount = 10000;
        runWithoutMonitor(nativeTest, preRunCount);
//        runWithoutMonitor(jdkDynamicProxy, preRunCount);
        runWithoutMonitor(cglibProxy, preRunCount);

        //开始测试
        LinkedHashMap<String, Target> tests = new LinkedHashMap<>();
        tests.put("Native  ", nativeTest);
//        tests.put("JdkProxy ", jdkDynamicProxy);
        tests.put("CglibProxy", cglibProxy);

        int repeatCount =3;
        int runCount = 1000000;
        runTest(repeatCount, runCount, tests);
        runCount = 5000000;
        runTest(repeatCount, runCount, tests);



    }
}