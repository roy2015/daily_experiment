package com.roy.leetcode.stage2.stage22;


import lombok.extern.slf4j.Slf4j;

/**
 * 1277. 统计全为 1 的正方形子矩阵
 * 给你一个 m * n 的矩阵，矩阵中的元素不是 0 就是 1，请你统计并返回其中完全由 1 组成的 正方形 子矩阵的个数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：matrix =
 * [
 *   [0,1,1,1],
 *   [1,1,1,1],
 *   [0,1,1,1]
 * ]
 * 输出：15
 * 解释：
 * 边长为 1 的正方形有 10 个。
 * 边长为 2 的正方形有 4 个。
 * 边长为 3 的正方形有 1 个。
 * 正方形的总数 = 10 + 4 + 1 = 15.
 * 示例 2：
 *
 * 输入：matrix =
 * [
 *   [1,0,1],
 *   [1,1,0],
 *   [1,1,0]
 * ]
 * 输出：7
 * 解释：
 * 边长为 1 的正方形有 6 个。
 * 边长为 2 的正方形有 1 个。
 * 正方形的总数 = 6 + 1 = 7.
 *
 *
 * 提示：
 *
 * 1 <= arr.length <= 300
 * 1 <= arr[0].length <= 300
 * 0 <= arr[i][j] <= 1
 *
 * @author guojun
 * @date 2022/2/4
 */
@Slf4j
public class TestSolution1277 {


    static class Solution {
        /**
         * 执行结果：通过
         * 执行用时：6 ms, 在所有 Java 提交中击败了95.20%的用户
         * 内存消耗：49.5 MB, 在所有 Java 提交中击败了80.33%的用户
         * 通过测试用例：32 / 32
         *
         * @param matrix
         * @return
         */
        public int countSquares(int[][] matrix) {
            int cnt = 0;
            int row = matrix.length;
            int col = matrix[0].length;

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (matrix[i][j] == 0) {
                        continue;
                    }
                    //伸缩走"反L"
                    int maxStretchLen = Math.min(row - i, col - j);
                    cnt ++;
                    for (int k = 1; k < maxStretchLen ; k++) {
                        boolean trap = false;
                        //水平
                        for (int l = 0; l <= k ; l++) {
                            if (matrix[i + k][j + l] == 0) {
                                trap = true;
                                break;
                            }
                        }
                        if (trap) {
                            break;
                        }
                        //垂直
                        for (int l = 0; l <= k ; l++) {
                            if (matrix[i + l][j + k] == 0) {
                                trap = true;
                                break;
                            }
                        }
                        if (trap) {
                            break;
                        }
                        cnt ++;
                    }
                }
            }
            return cnt;
        }
    }

    public static void main(String[] args) {
        log.info("{}", new Solution().countSquares(new int[][]{
            {0,1,1,1},{1,1,0,1},{1,1,1,1},{1,0,1,0}
            }));//13

        log.info("{}", new Solution().countSquares(new int[][]{
            {0,1,1,1},
            {1,1,1,1},
            {0,1,1,1}
        }));//15

        log.info("{}", new Solution().countSquares(new int[][]{
            {1,0,1},
            {1,1,0},
            {1,1,0}
        }));//7
    }
}
