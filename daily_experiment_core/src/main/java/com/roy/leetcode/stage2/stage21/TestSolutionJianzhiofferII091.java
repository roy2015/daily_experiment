package com.roy.leetcode.stage2.stage21;

import org.slf4j.LoggerFactory;

/**
 *
 *
 *
 * 剑指 Offer II 091. 粉刷房子
 * 假如有一排房子，共 n 个，每个房子可以被粉刷成红色、蓝色或者绿色这三种颜色中的一种，你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。
 *
 * 当然，因为市场上不同颜色油漆的价格不同，所以房子粉刷成不同颜色的花费成本也是不同的。每个房子粉刷成不同颜色的花费是以一个 n x 3 的正整数矩阵 costs 来表示的。
 *
 * 例如，costs[0][0] 表示第 0 号房子粉刷成红色的成本花费；costs[1][2] 表示第 1 号房子粉刷成绿色的花费，以此类推。
 *
 * 请计算出粉刷完所有房子最少的花费成本。
 *
 *
 *
 * 示例 1：
 *
 * 输入: costs = [[17,2,17],[16,16,5],[14,3,19]]
 * 输出: 10
 * 解释: 将 0 号房子粉刷成蓝色，1 号房子粉刷成绿色，2 号房子粉刷成蓝色。
 *      最少花费: 2 + 5 + 3 = 10。
 * 示例 2：
 *
 * 输入: costs = [[7,6,2]]
 * 输出: 2
 *
 *
 * 提示:
 *
 * costs.length == n
 * costs[i].length == 3
 * 1 <= n <= 100
 * 1 <= costs[i][j] <= 20
 *
 *
 * @author guojun
 * @date 2021/9/29
 */
public class TestSolutionJianzhiofferII091 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolutionJianzhiofferII091.class);


    static class Solution {

        /**
         *
         * 思路清晰的动态规划，^_^
         *
         * 执行结果：通过
         * 显示详情
         * 添加备注
         *
         * 执行用时：1 ms, 在所有 Java 提交中击败了88.22%的用户
         * 内存消耗：37.8 MB, 在所有 Java 提交中击败了61.23%的用户
         * 通过测试用例：
         * 100 / 100
         *
         * @param costs
         * @return
         */
        public int minCost(int[][] costs) {
            int n = costs.length;
            int[][] dp = new int[n +1][3];
            dp[0] = new int[]{0, 0, 0};
            for (int i = 1; i <= n; i++) {
                //red
                dp[i][0] = Math.min(dp[i -1][1], dp[i-1][2]) + costs[i -1][0];
                //bule
                dp[i][1] = Math.min(dp[i -1][0], dp[i-1][2]) + costs[i -1][1];
                //green
                dp[i][2] = Math.min(dp[i -1][0], dp[i-1][1]) + costs[i -1][2];
            }
            //dp到最后才知道三种那种最优
            return Math.min(Math.min(dp[n][0], dp[n][1]),dp[n][2]);
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().minCost(new int[][]{
            {17,2,17},{16,16,5},{14,3,19}
        }));//10

        logger.info("{}", new Solution().minCost(new int[][]{
            {7,6,2}
        }));//2
    }
}
