package com.guo.roy.research.leetcode.stage2.stage22;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/9/2
 *
 * 面试题 05.06. 整数转换
 * 整数转换。编写一个函数，确定需要改变几个位才能将整数A转成整数B。
 *
 * 示例1:
 *
 *  输入：A = 29 （或者0b11101）, B = 15（或者0b01111）
 *  输出：2
 * 示例2:
 *
 *  输入：A = 1，B = 2
 *  输出：2
 * 提示:
 *
 * A，B范围在[-2147483648, 2147483647]之间
 *
 */
public class TestSolutionInterview05_06 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolutionInterview05_06.class);



    static class Solution {

        /**
         *
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：36.2 MB, 在所有 Java 提交中击败了85.80%的用户
         *
         * @param A
         * @param B
         * @return
         */
        public int convertInteger(int A, int B) {
            int diff = A ^ B;
            int changeTimes = 0;
            while (diff != 0) {
                if((diff & 0x1) == 1) {
                    changeTimes ++;
                }
                diff >>>= 1;
            }
            return changeTimes;
        }
    }

    public static void main(String[] args) {



        logger.info("{}", new Solution().convertInteger(826966453
                ,-729934991));

    }
}
