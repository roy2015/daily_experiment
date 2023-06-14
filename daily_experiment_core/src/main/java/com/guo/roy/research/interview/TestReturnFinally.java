package com.guo.roy.research.interview;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2021/6/11
 */
public class TestReturnFinally {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestReturnFinally.class);


    static class Solution {
        public int   test() {
            try {
                int k =1;
                logger.info("try");
                return k;
            } catch (Exception e) {
                logger.info("catch");
                return 1;
            } finally {
                logger.info("finally");
            }

        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().test());
    }
}
