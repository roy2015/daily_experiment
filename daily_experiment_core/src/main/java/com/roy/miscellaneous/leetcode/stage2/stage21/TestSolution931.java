package com.roy.miscellaneous.leetcode.stage2.stage21;

import java.util.Arrays;

import org.slf4j.LoggerFactory;

/**
 *
 * 931. 下降路径最小和
 * 给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。
 *
 * 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第一个元素）。具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1) 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：matrix = [[2,1,3],[6,5,4],[7,8,9]]
 * 输出：13
 * 解释：如图所示，为和最小的两条下降路径
 * 示例 2：
 *
 *
 *
 * 输入：matrix = [[-19,57],[-40,-5]]
 * 输出：-59
 * 解释：如图所示，为和最小的下降路径
 *
 *
 * 提示：
 *
 * n == matrix.length == matrix[i].length
 * 1 <= n <= 100
 * -100 <= matrix[i][j] <= 100
 * 通过次数32,973提交次数49,174
 *
 * @author guojun
 * @date 2021/6/11
 */
public class TestSolution931 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution931.class);


    static class Solution {

        /**
         * 执行结果：通过
         * 显示详情
         * 添加备注
         *
         * 执行用时：4 ms, 在所有 Java 提交中击败了74.04%的用户
         * 内存消耗：42.2 MB, 在所有 Java 提交中击败了5.09%的用户
         * 通过测试用例：49 / 49
         * @param matrix
         * @return
         */
        public int minFallingPathSum(int[][] matrix) {
            int n = matrix.length;
            for (int i = 1; i < n; i++) {
                int[] preRow = matrix[i - 1];
                int[] currentRow = matrix[i];
                for (int j = 0; j < n; j++) {
                    int preVal ;
                    if (j == 0) {
                        preVal = Math.min(preRow[j], preRow[j+1]);
                    } else if (j == n -1) {
                        preVal = Math.min(preRow[j-1], preRow[j]);
                    } else {
                        int temp = Math.min(preRow[j-1], preRow[j]);
                        preVal = Math.min(temp, preRow[j+1]);
                    }
                    currentRow[j] += preVal;
                }
            }
            int[] lastRow = matrix[n-1];
            int minVal = lastRow[0];
            for (int i = 1; i < n; i++) {
                if (lastRow[i] < minVal) {
                    minVal = lastRow[i];
                }
            }
            return minVal;
        }

    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().minFallingPathSum(new int[][]{
            new int[]{-19,57},
            new int[]{-40,-5}
        }));//-59

        logger.info("{}", new Solution().minFallingPathSum(new int[][]{
            new int[]{2,1,3},
            new int[]{6,5,4},
            new int[]{7,8,9},
        }));//13
    }
}
