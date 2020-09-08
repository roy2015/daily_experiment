package com.roy.miscellaneous.leetcode.stage1.stage13;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/9/8
 *
 *
 * 1572. 矩阵对角线元素的和
 * 给你一个正方形矩阵 mat，请你返回矩阵对角线元素的和。
 *
 * 请你返回在矩阵主对角线上的元素和副对角线上且不在主对角线上元素的和。
 *
 *
 *
 * 示例  1：
 *
 *
 *
 * 输入：mat = [[1,2,3],
 *             [4,5,6],
 *             [7,8,9]]
 * 输出：25
 * 解释：对角线的和为：1 + 5 + 9 + 3 + 7 = 25
 * 请注意，元素 mat[1][1] = 5 只会被计算一次。
 * 示例  2：
 *
 * 输入：mat = [[1,1,1,1],
 *             [1,1,1,1],
 *             [1,1,1,1],
 *             [1,1,1,1]]
 * 输出：8
 * 示例 3：
 *
 * 输入：mat = [[5]]
 * 输出：5
 *
 *
 * 提示：
 *
 * n == mat.length == mat[i].length
 * 1 <= n <= 100
 * 1 <= mat[i][j] <= 100
 *
 *
 */
public class TestSolution1572 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1572.class);


    static class Solution {

        /**
         *
         * 从第一行的两个顶点走对角线
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：39.5 MB, 在所有 Java 提交中击败了98.28%的用户
         *
         * @param mat
         * @return
         */
        public int diagonalSum(int[][] mat) {
            int size = mat.length;
            int sum = 0;
            //左对角线
            for (int i = 0,j = 0; i < size; i++, j++) {
                sum += mat[i][j];
            }
            //右对角线
            for (int i = 0, j = size - 1; i < size; i++, j--) {
                sum += mat[i][j];
            }
            return (size & 0x1) ==1 ? sum - mat[size/2][size/2] : sum ;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().diagonalSum(
                new int[][]{
                        {1,1,1,1},
                        {1,1,1,1},
                        {1,1,1,1},
                        {1,1,1,1}
                }));//8

        logger.info("{}", new Solution().diagonalSum(
                new int[][]{
                        {5}
                }));//5

        logger.info("{}", new Solution().diagonalSum(
                new int[][]{
                        {1,2,3},
                        {4,5,6},
                        {7,8,9}
                }));//25
    }
}
