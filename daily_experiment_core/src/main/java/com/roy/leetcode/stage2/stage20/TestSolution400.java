package com.roy.leetcode.stage2.stage20;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2021/2/1 14:51
 *
 * 400. 第 N 位数字
 * 在无限的整数序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中找到第 n 位数字。
 *
 *
 *
 * 注意：n 是正数且在 32 位整数范围内（n < 231）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：3
 * 输出：3
 * 示例 2：
 *
 * 输入：11
 * 输出：0
 * 解释：第 11 位数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是 0 ，它是 10 的一部分。
 *
 *
 *
 */
public class TestSolution400 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution400.class);


    static class Solution {
        /**
         *
         * 100%？？
         *
         * 执行结果：通过
         * 显示详情
         * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：35.1 MB, 在所有 Java 提交中击败了79.04%的用户
         *
         *
         * @param n
         * @return
         */
        public int findNthDigit(int n) {
            int last = 0 ;
            int current = 9;
            int level = 1;

            //求落在第几层 start
            while (current < n) {
                level ++;
                last = current;
                current = (int) (last + (Math.pow(10, level) - Math.pow(10, level-1) ) * level);
            }
            //找出目标数字
            int overflow = n - last;
            int offset = (overflow) / level;
            int pos = (overflow) % level;
            if (pos != 0) {
                offset ++;
            } else {
                pos = level;
            }
            int target = (int) Math.pow(10, level -1) -1 + offset;
            return Integer.parseInt(String.valueOf(target).substring(pos -1, pos));
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().findNthDigit(11));//0
        logger.info("{}", new Solution().findNthDigit(3));//3
        logger.info("{}", new Solution().findNthDigit(15));//2
        logger.info("{}", new Solution().findNthDigit(1000));//3
    }
}
