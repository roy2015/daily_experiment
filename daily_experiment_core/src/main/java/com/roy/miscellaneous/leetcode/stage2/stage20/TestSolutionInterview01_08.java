package com.roy.miscellaneous.leetcode.stage2.stage20;

import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * @author guojun
 * @date 2020/9/8
 *
 *面试题 01.08. 零矩阵
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 *
 *
 *
 * 示例 1：
 *
 * 输入：
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出：
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * 示例 2：
 *
 * 输入：
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出：
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 *
 *
 */
public class TestSolutionInterview01_08 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolutionInterview01_08.class);


    static class Solution {

        /**
         *
         *
         * 如果暴力解法，O(n^4)，思考出来了一个新的解法O(n^2)，行0数组，列0数组，先轮询出行0数组， 列0数组，
         * 再轮询决定是否用0替换原数组
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：41.3 MB, 在所有 Java 提交中击败了41.24%的用户
         *
         * @param matrix
         */
        public void setZeroes(int[][] matrix) {
            int row = matrix.length;
            int col = matrix[0].length;

            int[] rowZero = new int[row];
            int[] colZero = new int[col];

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] == 0) {
                        rowZero[i] = 1;
                        colZero[j] = 1;
                    }
                }
            }

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (rowZero[i] == 1 || colZero[j] == 1) {
                        matrix[i][j]  = 0;
                    }
                }
            }


        }

    }

    public static void main(String[] args) {

        int[][] ints = {
                {1,2,3,4},
                {5,0,5,2},
                {8,9,2,0},
                {5,7,2,1}
        };


        new Solution().setZeroes(ints);

        for (int i = 0; i < ints.length; i++) {
            logger.info("{}", ints[i]);
        }

    }
}
