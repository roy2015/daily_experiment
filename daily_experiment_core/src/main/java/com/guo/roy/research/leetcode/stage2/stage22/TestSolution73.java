package com.guo.roy.research.leetcode.stage2.stage22;

import org.slf4j.LoggerFactory;

/**
 *
 * 73. 矩阵置零
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 *
 * 进阶：
 *
 * 一个直观的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个仅使用常量空间的解决方案吗？
 *
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：[[1,0,1],[0,0,0],[1,0,1]]
 * 示例 2：
 *
 *
 * 输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * 输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 *
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[0].length
 * 1 <= m, n <= 200
 * -231 <= matrix[i][j] <= 231 - 1
 *
 *
 * @author guojun
 * @date 2021/1/21 10:40
 *
 */
public class TestSolution73 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution73.class);


    static class Solution {

        /**
         *
         * 空间复杂度 O(m+n)，没达到原地的要求~~，估计还有什么骚操作
         *
         * 执行结果：通过
         * 显示详情 添加备注
         *
         * 执行用时：1 ms, 在所有 Java 提交中击败了99.62%的用户
         * 内存消耗：39.7 MB, 在所有 Java 提交中击败了83.37%的用户
         * @param matrix
         */
        public void setZeroes(int[][] matrix) {
            int row = matrix.length;
            int col = matrix[0].length;

            if (row == 0 || col == 0) {
                return;
            }

            int[] rowZeroDic = new int[row];
            int[] colZeroDic = new int[col];

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (matrix[i][j] == 0) {
                        rowZeroDic[i] = 1;
                        colZeroDic[j] = 1;
                    }
                }
            }

            for (int i = 0; i < row; i++) {
                if (rowZeroDic[i] == 1) {
                    for (int j = 0; j < col; j++) {
                        matrix[i][j] = 0;
                    }
                } else {}
            }

            for (int i = 0; i < col; i++) {
                if (colZeroDic[i] == 1) {
                    for (int j = 0; j < row; j++) {
                        matrix[j][i] = 0;
                    }
                } else {}
            }
        }

        /**
         *
         * 看了下英文的提示，说什么可以把行列是否为0记在  列记在第一行，行记在第一列，立刻想到这个
         *
         * 原地算法，只定义了两个变量用来特殊处理第一行第一列，
         * 其它行列是否为0用flag打在原数组：列记在第一行，行记在第一列
         *
         *
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 添加备注
         *
         * 执行用时：
         * 1 ms
         * , 在所有 Java 提交中击败了
         * 99.62%
         * 的用户
         * 内存消耗：
         * 39.5 MB
         * , 在所有 Java 提交中击败了
         * 95.72%
         * 的用户
         *
         * @param matrix
         */
        public void setZeroes1(int[][] matrix) {
            int row = matrix.length;
            int col = matrix[0].length;

            if (row == 0 || col == 0) {
                return;
            }

            int firsRow = 1, firstCol = 1;
            int i,j;

            //第0行和第0列单独两个变量，其它都列情况记在第一行，行情况记在第一列
            for (i = 0; i < row; i++) {
                for (j = 0; j < col; j++) {
                    if (matrix[i][j] != 0) {continue;}
                    if (i == 0) {
                        firsRow = 0;
                    } else {
                        matrix[i][0] = 0;
                    }

                    if (j == 0) {
                        firstCol = 0;
                    } else {
                        matrix[0][j] = 0;
                    }
                }
            }

            //非第一行第一列先处理
            for (i = 1; i < row; i++) {
                for (j = 1; j < col; j++) {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }

            if (firsRow == 0) {
                for (i = 0; i < col; i++) {
                    matrix[0][i] = 0;
                }
            }

            if (firstCol == 0) {
                for (i = 0; i < row; i++) {
                    matrix[i][0] = 0;
                }
            }
        }

        public static void print(int[][] matrix) {
            for (int[] ints : matrix) {
                logger.info("{}", ints);
            }
        }
    }

    public static void main(String[] args) {
        int[][] input;
        input = new int[][]{
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        new Solution().setZeroes1(input);
        Solution.print(input);//[[1,0,1],[0,0,0],[1,0,1]]
    }
}
