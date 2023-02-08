package com.roy.leetcode.stage2.stage22;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/8/12
 *
 *
 * 剑指 Offer 47. 礼物的最大价值
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 *
 *
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 *
 *
 * 提示：
 *
 * 0 < grid.length <= 200
 * 0 < grid[0].length <= 200
 *
 *
 *
 */
public class TestSolutionJianzhiOffer47 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolutionJianzhiOffer47.class);


    static class Solution {
        /**
         *
         * 每一步能达到礼物最大值只与上面和左边有关系
         *
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 2 ms, 在所有 Java 提交中击败了98.70%的用户
         * 内存消耗：
         * 42.4 MB, 在所有 Java 提交中击败了61.31%的用户
         *
         * @param grid
         * @return
         */
        public int maxValue(int[][] grid) {
            int row = grid.length;
            int col = grid[0].length;

            //先填充第一行和第一列，因为只有一条路可走
            for (int i = 1; i < col; i++) {
                grid[0][i] += grid[0][i - 1];
            }
            for (int i = 1; i < row; i++) {
                grid[i][0] += grid[i - 1][0];
            }
            //dp方程
            for (int i = 1; i < row; i++) {
                for (int j = 1; j < col; j++) {
                    grid[i][j] += Math.max(grid[i -1][j], grid[i][j - 1]);
                }
            }
            return grid[row -1][col -1];
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().maxValue(new int[][]{
                {1,3,1},
                {1,5,1},
                {4,2,1}
        }));
    }
}
