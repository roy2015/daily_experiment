package com.guo.roy.research.testing;

import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author guojun
 * @date 2021/6/11
 *
 * 测试aba问题  AtomicStampedReference
 *
 */
public class TestSolutionABA {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolutionABA.class);


    static class Solution {

        public void testABA() {
            AtomicReference<TestVO> atomicReference = new AtomicReference<>();
            TestVO testVO1 = new TestVO();
            testVO1.setField1("1");
            atomicReference.set(testVO1);

            new Thread(() -> {
                try {
                    TimeUnit.SECONDS.sleep(3);
                    logger.info("{}", atomicReference.compareAndSet(testVO1, new TestVO().setField1("2")));


                } catch (InterruptedException e) {
                    logger.error(e.getMessage(), e);
                }

            }).start();

            new Thread(() -> {
                try {
                    atomicReference.set(new TestVO().setField1("2"));
                    TimeUnit.SECONDS.sleep(1);
                    atomicReference.set(testVO1);
                    logger.info("{}", atomicReference.get());
                } catch (InterruptedException e) {
                    logger.error(e.getMessage(), e);
                }
            }).start();
        }

        public void testResolveABA() {
            TestVO testVO1 = new TestVO();
            AtomicStampedReference<TestVO> atomicReference = new AtomicStampedReference<TestVO>(testVO1, 100);

            new Thread(() -> {
                try {
                    TimeUnit.SECONDS.sleep(3);
                    logger.info("版本号：{}， cas是否成功：{}, 值：{}", atomicReference.getStamp(), atomicReference
                            .compareAndSet(
                                    testVO1, new TestVO(), atomicReference.getStamp(), atomicReference.getStamp() +1)
                    , atomicReference.getReference());


                } catch (InterruptedException e) {
                    logger.error(e.getMessage(), e);
                }

            }).start();

            new Thread(() -> {

                TestVO testVOTemp1 = new TestVO().setField1("21");
                logger.info("第一次修改   版本号：{}， cas是否成功：{}, 值：{}", atomicReference.getStamp(), atomicReference
                                    .compareAndSet(
                                            testVO1, testVOTemp1, atomicReference.getStamp(), atomicReference.getStamp() +1)
                            , atomicReference.getReference());

                    logger.info("第二次修改  版本号：{}， cas是否成功：{}, 值：{}", atomicReference.getStamp(), atomicReference
                                    .compareAndSet(
                                            testVOTemp1, new TestVO().setField1("22"), atomicReference.getStamp(), atomicReference.getStamp() +1)
                            , atomicReference.getReference());



            }).start();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Solution so = new Solution();
//        so.testABA();
        so.testResolveABA();
        TimeUnit.SECONDS.sleep(5);
    }
}
