package com.guo.roy.research.testing;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2021/6/11
 */
public class TestReturnCatchFinally {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestReturnCatchFinally.class);


    static class Solution {
        /**
         * 测试 try, catch, finally全部return, finally会覆盖前面两个return
         * @return
         */
        public int test1() {
            try {
                return 1;
            } catch (Exception e) {
                return 2;
            } finally {
                return 3;
            }

        }

        /**
         *  finally会在return之前执行
         * @return
         */
        public TestVO test2() {
            TestVO testVO = new TestVO();
            testVO.setField1("1").setField2("2");
            try {
                int k = 1/0;
                return testVO;
            } catch (Exception e) {
                logger.error(e.getMessage(),e);
                testVO.setField1("error");
                return testVO;
            } finally {
                testVO.setField1("11");
            }

        }


    }

    public static void main(String[] args) {
        Solution so = new Solution();
//        logger.info("{}", so.test1());
        logger.info("{}", so.test2());
    }
}
