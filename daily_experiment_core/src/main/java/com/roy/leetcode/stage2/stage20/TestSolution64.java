package com.roy.leetcode.stage2.stage20;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/11/10
 *
 *64. 最小路径和
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 *
 *
 *
 */
public class TestSolution64 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution64.class);


    static class Solution {
        /**
         *
         * 矩阵没输过，哪怕是动态规划，
         * 有个细节，为了在for里面减少if,给矩阵加固一层数据，for里面的if才是耗时的
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：3 ms, 在所有 Java 提交中击败了87.23%的用户
         * 内存消耗：41.3 MB, 在所有 Java 提交中击败了79.05%的用户
         *
         *
         * @param grid
         * @return
         */
        public int minPathSum(int[][] grid) {
            //row col
            int row = grid.length;
            int col = grid[0].length;
            //最左和最上加固一层
            int[][] newGrid = new int[row+1][col+1];
            for (int i = 0; i <= col; i++) {
                newGrid[0][i] = Integer.MAX_VALUE;
            }
            for (int i = 2; i <= row; i++) {
                newGrid[i][0] = Integer.MAX_VALUE;
            }
            newGrid[1][0] = 0;
            for (int i = 1; i <= row; i++) {
                for (int j = 1; j <= col; j++) {
                    newGrid[i][j] = Math.min(newGrid[i -1][j], newGrid[i][j -1]) + grid[i-1][j-1];
                }
            }
            return newGrid[row][col];
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().minPathSum(new int[][]{
                {1,2},
                {1,1}
        }));//3
        logger.info("{}", new Solution().minPathSum(new int[][]{
                {1,3,1},
                {1,5,1},
                {4,2,1}
        }));//7
    }
}
