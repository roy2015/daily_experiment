package com.roy.miscellaneous.leetcode.stage2.stage21;

import org.slf4j.LoggerFactory;

/**
 *
 * 63. 不同路径 II
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * 输出：2
 * 解释：3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 * 示例 2：
 *
 *
 * 输入：obstacleGrid = [[0,1],[0,0]]
 * 输出：1
 *
 *
 * 提示：
 *
 * m == obstacleGrid.length
 * n == obstacleGrid[i].length
 * 1 <= m, n <= 100
 * obstacleGrid[i][j] 为 0 或 1
 *
 * @author guojun
 * @date 2021/6/11
 */
public class TestSolution63 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution63.class);


    static class Solution {

        /**
         *
         * 执行结果：通过
         * 显示详情
         * 添加备注
         *
         * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：39.6 MB, 在所有 Java 提交中击败了31.19%的用户
         *
         * @param obstacleGrid
         * @return
         */
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int row = obstacleGrid.length;
            int col = obstacleGrid[0].length;

            int[][] dp = new int[row][col];
            for (int i = 0; i < row; i++) {
                if (i == 0) {
                    if (obstacleGrid[i][0] == 0) {
                        dp[i][0] = 1;
                    }
                } else {
                    if (obstacleGrid[i][0] != 1) {
                        dp[i][0] = dp[i-1][0];
                    }
                }
            }
            for (int i = 0; i < col; i++) {
                if (i == 0) {
                    if (obstacleGrid[0][i] == 0) {
                        dp[0][i] = 1;
                    }
                } else {
                    if (obstacleGrid[0][i] != 1) {
                        dp[0][i] = dp[0][i-1];
                    }
                }
            }

            for (int i =1; i < row; i++) {
                for (int j=1; j < col; j++) {
                    if (obstacleGrid[i][j] == 1) {
                        dp[i][j] = 0;
                        continue;
                    }
                    dp[i][j] = dp[i][j-1] + dp[i-1][j];
                }
            }
            return dp[row-1][col-1];
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().uniquePathsWithObstacles(new int[][]{
            {0,1},{0,0}
        }));//1
    }
}
