package com.roy.leetcode.stage2.stage21;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/8/6
 *
 *
 * 322. 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 *
 *
 * 示例 1:
 *
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 *
 * 输入: coins = [2], amount = 3
 * 输出: -1
 *
 *
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 *
 */
public class TestSolution322 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution322.class);


    static class Solution {
        /**
         *
         * 还是用动态规划的思维想出来了
         * 思路： 求金额N最少使用硬币次数，就必须求 N -  coins[i] , 在加1即可， 枚举是有多个答案的，所以只能DP
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 16 ms, 在所有 Java 提交中击败了52.00%的用户
         * 内存消耗：
         * 39.3 MB, 在所有 Java 提交中击败了68.42%的用户
         *
         * @param coins
         * @param amount
         * @return
         */
        public int coinChange(int[] coins, int amount) {
            int[] changeArray = new int[amount + 1];
            for (int j = 1; j <= amount; j++) {
                //计算凑足金额j的最小使用硬币次数
                int jVal = Integer.MAX_VALUE;
                for (int coin : coins) {
                    int tmepJval;
                    int preJ = j - coin;
                    if (preJ < 0) {
                        continue;
                    }
                    int preJVal = changeArray[preJ];
                    if (preJVal == -1) {
                        continue;
                    } else {
                        tmepJval = preJVal + 1;
                    }
                    if (tmepJval < jVal) {
                        jVal = tmepJval;
                    }
                }
                if (jVal == Integer.MAX_VALUE) {
                    changeArray[j] = -1;
                } else {
                    changeArray[j] = jVal;
                }
            }
            return changeArray[amount];
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().coinChange(new int[]{1,2,5}, 11));//3
        logger.info("{}", new Solution().coinChange(new int[]{2}, 3));//-1
    }
}
