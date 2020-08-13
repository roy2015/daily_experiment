package com.roy.miscellaneous.leetcode.stage1.stage12;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/5/22
 *
 *面试题 08.01. 三步问题
 * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
 *
 * 示例1:
 *
 *  输入：n = 3
 *  输出：4
 *  说明: 有四种走法
 * 示例2:
 *
 *  输入：n = 5
 *  输出：13
 * 提示:
 *
 * n范围在[1, 1000000]之间
 *
 */
public class TestSolutionInterview0801 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolutionInterview0801.class);

    static class Solution {

        /**
         * 递归
         * @param n
         * @return
         */
        public int waysToStep(int n) {
            if (n == 0 || n == 1) {
                return 1;
            } else if (n == 2) {
                return 2;
            } else {
                return waysToStep(n -1) + waysToStep(n -2) + waysToStep(n -3);
            }
        }

        /**
         * 直接dp
         *
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 42 ms, 在所有 Java 提交中击败了20.82%的用户
         * 内存消耗：
         * 43.8 MB, 在所有 Java 提交中击败了44.56%的用户
         * @param n
         * @return
         */
        public int waysToStep1(int n) {
            if (n == 0 || n == 1) {
                return 1;
            } else if (n == 2) {
                return 2;
            } else {
                int[] dp = new int[n +1];
                dp[0] = dp[1] = 1;
                dp[2] = 2;
                for (int i = 3; i <= n; i++) {
                    dp[i] = (dp[i -1] + dp[i -2]) % 1000000007;
                    dp[i] = (dp[i] +  + dp[i -3]) % 1000000007;
                }
                return (dp[n]);
            }
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().waysToStep1(76));
    }
}
