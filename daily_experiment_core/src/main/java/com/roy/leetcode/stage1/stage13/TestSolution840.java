package com.roy.leetcode.stage1.stage13;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/7/24
 *
 *
 * 840. 矩阵中的幻方
 * 3 x 3 的幻方是一个填充有从 1 到 9 的不同数字的 3 x 3 矩阵，其中每行，每列以及两条对角线上的各数之和都相等。
 *
 * 给定一个由整数组成的 grid，其中有多少个 3 × 3 的 “幻方” 子矩阵？（每个子矩阵都是连续的）。
 *
 *
 *
 * 示例：
 *
 * 输入: [[4,3,8,4],
 *       [9,5,1,9],
 *       [2,7,6,2]]
 * 输出: 1
 * 解释:
 * 下面的子矩阵是一个 3 x 3 的幻方：
 * 438
 * 951
 * 276
 *
 * 而这一个不是：
 * 384
 * 519
 * 762
 *
 * 总的来说，在本示例所给定的矩阵中只有一个 3 x 3 的幻方子矩阵。
 * 提示:
 *
 * 1 <= grid.length <= 10
 * 1 <= grid[0].length <= 10
 * 0 <= grid[i][j] <= 15
 *
 *
 *
 */
public class TestSolution840 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution840.class);


    static class Solution {
        /**
         * 幻方有两种，正反两面 再加旋转90度
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：
         * 37.7 MB, 在所有 Java 提交中击败了100.00%的用户
         *
         * @param grid
         * @return
         */
        public int numMagicSquaresInside(int[][] grid) {
            int row = grid.length;
            int col = grid[0].length;
            if (row < 3 || col < 3) {
                return 0;
            }

            int numMagicSquares = 0;
            int rowLimit = row -3;
            int colLimit = col -3;

            int[] vertexArr11 = {3,8,1,6,7,2,9};//4
            int[] vertexArr12 = {1,6,7,2,9,4,3};//8
            int[] vertexArr13 = {7,2,9,4,3,8,1};//6
            int[] vertexArr14 = {9,4,3,8,1,6,7};//2

            int[] vertexArr21 = {9,2,7,6,1,8,3};//4
            int[] vertexArr22 = {3,4,9,2,7,6,1};//8
            int[] vertexArr23 = {1,8,3,4,9,2,7};//6
            int[] vertexArr24 = {7,6,1,8,3,4,9};//2


            for (int i = 0; i <= rowLimit; i++) {
                for (int j = 0; j <= colLimit; j++) {
                    if (grid[i +1][j+1] != 5) {
                        continue;
                    }
                    int k = 0;
                    int[] toCheckArr = new int[7];
                    toCheckArr[k++] = grid[i][j+1];
                    toCheckArr[k++] = grid[i][j+2];
                    toCheckArr[k++] = grid[i+1][j+2];
                    toCheckArr[k++] = grid[i+2][j+2];
                    toCheckArr[k++] = grid[i+2][j+1];
                    toCheckArr[k++] = grid[i+2][j];
                    toCheckArr[k++] = grid[i+1][j];

                    switch (grid[i][j]) {
                        case 4:
                            if (checkMagicSquares(toCheckArr, vertexArr11)) {
                                numMagicSquares++;
                            } else if (checkMagicSquares(toCheckArr, vertexArr21)) {
                                numMagicSquares++;
                            }
                            break;
                        case 8:
                            if (checkMagicSquares(toCheckArr, vertexArr12)) {
                                numMagicSquares++;
                            } else if (checkMagicSquares(toCheckArr, vertexArr22)) {
                                numMagicSquares++;
                            }
                            break;
                        case 6:
                            if (checkMagicSquares(toCheckArr, vertexArr13)) {
                                numMagicSquares++;
                            } else if (checkMagicSquares(toCheckArr, vertexArr23)) {
                                numMagicSquares++;
                            }
                            break;
                        case 2:
                            if (checkMagicSquares(toCheckArr, vertexArr14)) {
                                numMagicSquares++;
                            } else if (checkMagicSquares(toCheckArr, vertexArr24)) {
                                numMagicSquares++;
                            }
                            break;
                        default:break;
                    }
                }
            }
            return numMagicSquares;
        }

        public boolean checkMagicSquares(int[] arr, int[] template) {
            for (int i = 0; i < template.length; i++) {
                if (arr[i] != template[i]) {
                    return false;
                }
            }
            return true;
        }

    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().numMagicSquaresInside(new int[][]{
                {8,3,4},{1,5,9},{6,7,2}
        }));//1

        logger.info("{}", new Solution().numMagicSquaresInside(new int[][]{
                {8,1,6},{3,5,7},{4,9,2}
        }));//1


        logger.info("{}", new Solution().numMagicSquaresInside(new int[][]{
                {4,3,8,4},
                {9,5,1,9},
                {2,7,6,2}
        }));//1
    }
}
