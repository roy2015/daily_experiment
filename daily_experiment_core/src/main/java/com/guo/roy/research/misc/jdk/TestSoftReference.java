package com.guo.roy.research.misc.jdk;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import com.guo.roy.research.leetcode.stage3.TestSolutionTemplate;
import com.guo.roy.research.misc.targetObject.TestVO;
import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2021/6/11
 */
public class TestSoftReference {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolutionTemplate.class);


    static class Solution {
        private SoftReference<byte[]> softReference;

        /**
         * 软引用刚好有60M空间，够gc回收
         */
        private void genSoftRefer() {
            byte[] obj = new byte[1024 * 1024 * 60];
            softReference = new SoftReference<byte[]>(obj);
        }

        public void main() {
            genSoftRefer();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            if (null == softReference.get()) {
                                logger.info("softReference is null ");
                            } else {
                                logger.info("softReference {}", softReference);
                            }

                            TimeUnit.MILLISECONDS.sleep(10);
                        }
                    } catch (InterruptedException e) {
                        logger.error(e.getMessage(), e);
                    }
                }
            }).start();


            //不停的分配60M空间
            new Thread(new Runnable() {
                @Override
                public void run() {
                    List list = new ArrayList();

                    for (int i = 0; i < 200; i++) {
                        //alloc 1G bytes
                        list.add(new byte[1024 * 1024 * 60]);
                        try {
                            TimeUnit.MILLISECONDS.sleep(300);
                        } catch (InterruptedException e) {
                            logger.error(e.getMessage(), e);
                        }
                    }
                }
            }).start();

        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.main();
    }
}
