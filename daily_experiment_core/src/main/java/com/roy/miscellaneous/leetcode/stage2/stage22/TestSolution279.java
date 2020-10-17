package com.roy.miscellaneous.leetcode.stage2.stage22;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/10/16
 *
 * 279. 完全平方数
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 * 示例 1:
 *
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 *
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 *
 */
public class TestSolution279 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution279.class);


    static class Solution {
        /**
         *
         *
         * 公式： numSquares(n)=min(numSquares(n-k) + 1)  ∀k ∈ square numbers
         *https://leetcode-cn.com/problems/perfect-squares/solution/wan-quan-ping-fang-shu-by-leetcode/
         * ，方法有五中算法，只看懂了第一种和第二种的动态规划，
         * 方法二：动态规划
         *
         * 借鉴了dp思路，算法实现是自己写的，想了半天时间~
         * 思想： 从底往上，知道得出顶层的结果，底层可上层计算提供数据支撑，动态规划的精髓
         * 、
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 34 ms
         * , 在所有 Java 提交中击败了
         * 83.47%
         * 的用户
         * 内存消耗：
         * 37.4 MB
         * , 在所有 Java 提交中击败了
         * 94.53%的用户
         *
         * @param n
         * @return
         */
        public int numSquares(int n) {
            //特殊情况直接处理掉，然后return
            if (n ==0) {
                return 0;
            }
            if (n ==1) {
                return 1;
            }
            if (n ==2) {
                return 2;
            }
            if (n == 3) {
                return 3;
            }
            int[] dp = new int[n + 1];
            dp[0] = 0;
            dp[1] = 1;//1^2
            dp[2] = 2;//1^2 + 1^2
            dp[3] = 3;//1^2 + 1^2 + 1^2

            int i;
            for (i = 4; i <= n ; i++) {
                int min = i;
                int initJ = (int) Math.sqrt(i);
                //j应该是完全平方数的根
                for (int j = initJ; j >0 ; j--) {
                    int tempMin = dp[i - j*j] + 1;
                    //完全平方数
                    if (tempMin == 1) {
                        min = 1;
                        break;
                    }
                    if (min > tempMin) {
                        min = tempMin;
                    }
                }
                dp[i] = min;
            }
            return dp[i-1];
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().numSquares(100));//1
        logger.info("{}", new Solution().numSquares(99));//3
        logger.info("{}", new Solution().numSquares(7));// 4
        logger.info("{}", new Solution().numSquares(6));// 3：1 1 2
        logger.info("{}", new Solution().numSquares(5));// 2：1 2
        logger.info("{}", new Solution().numSquares(4));// 1：2
        logger.info("{}", new Solution().numSquares(3));// 3：1 1 1
        logger.info("{}", new Solution().numSquares(2));// 2：1 1
        logger.info("{}", new Solution().numSquares(1));// 1：1
    }
}
