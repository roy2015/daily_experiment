package com.roy.miscellaneous.leetcode.stage2.stage20;

import org.slf4j.LoggerFactory;

/**
 *
 * 1689. 十-二进制数的最少数目
 * 如果一个十进制数字不含任何前导零，且每一位上的数字不是 0 就是 1 ，那么该数字就是一个 十-二进制数 。例如，101 和 1100 都是 十-二进制数，而 112 和 3001 不是。
 *
 * 给你一个表示十进制整数的字符串 n ，返回和为 n 的 十-二进制数 的最少数目。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = "32"
 * 输出：3
 * 解释：10 + 11 + 11 = 32
 * 示例 2：
 *
 * 输入：n = "82734"
 * 输出：8
 * 示例 3：
 *
 * 输入：n = "27346209830709182346"
 * 输出：9
 *
 *
 * 提示：
 *
 * 1 <= n.length <= 105
 * n 仅由数字组成
 * n 不含任何前导零并总是表示正整数
 *
 *
 * @author guojun
 * @date 2021/11/9
 */
public class TestSolution1689 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1689.class);


    static class Solution {
        /**
         * 好easy的题
         *
         * 执行结果：通过
         * 执行用时：4 ms, 在所有 Java 提交中击败了97.61%的用户
         * 内存消耗：39.2 MB, 在所有 Java 提交中击败了14.10%的用户
         *
         * @param n
         * @return
         */
        public int minPartitions(String n) {
            char[] chars = n.toCharArray();
            char max = '0';
            for(int i = 0; i< chars.length; i ++) {
                if (chars[i] > max) {
                    max = chars[i];
                }

            }
            return max - '0';
        }

    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().minPartitions("5525"));//5
    }
}
