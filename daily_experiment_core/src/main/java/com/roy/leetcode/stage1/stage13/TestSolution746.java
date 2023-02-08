package com.roy.leetcode.stage1.stage13;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/8/6
 *
 * 746. 使用最小花费爬楼梯
 * 数组的每个索引作为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
 *
 * 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
 *
 * 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
 *
 * 示例 1:
 *
 * 输入: cost = [10, 15, 20]
 * 输出: 15
 * 解释: 最低花费是从cost[1]开始，然后走两步即可到阶梯顶，一共花费15。
 *  示例 2:
 *
 * 输入: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * 输出: 6
 * 解释: 最低花费方式是从cost[0]开始，逐个经过那些1，跳过cost[3]，一共花费6。
 * 注意：
 *
 * cost 的长度将会在 [2, 1000]。
 * 每一个 cost[i] 将会是一个Integer类型，范围为 [0, 999]。
 *
 *
 */
public class TestSolution746 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution746.class);


    static class Solution {
        /**
         *
         * 上每个一台阶的体力花费值只与他前两个台阶有关 DP
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：1 ms, 在所有 Java 提交中击败了99.93%的用户
         * 内存消耗：39.6 MB, 在所有 Java 提交中击败了29.30%的用户
         *
         * @param cost
         * @return
         */
        public int minCostClimbingStairs(int[] cost) {
            int len = cost.length;
            int[] retInts = new int[len + 1];
            int newLen = len + 1;
            retInts[0] = 0;
            retInts[0] = 0;
            for (int i = 2; i < newLen; i++) {
                retInts[i] = Math.min(retInts[i -2] + cost[i - 2], retInts[i -1] + cost[i - 1]);
            }
            return retInts[len];
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().minCostClimbingStairs(new int[]{10, 15, 20}));
        logger.info("{}", new Solution().minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
}
