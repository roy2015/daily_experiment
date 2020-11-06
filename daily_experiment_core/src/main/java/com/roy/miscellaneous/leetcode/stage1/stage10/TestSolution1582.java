package com.roy.miscellaneous.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

/**
 * @author guojun
 * @date 2020/11/6
 *
 *
 * 1582. 二进制矩阵中的特殊位置
 * 给你一个大小为 rows x cols 的矩阵 mat，其中 mat[i][j] 是 0 或 1，请返回 矩阵 mat 中特殊位置的数目 。
 *
 * 特殊位置 定义：如果 mat[i][j] == 1 并且第 i 行和第 j 列中的所有其他元素均为 0（行和列的下标均 从 0 开始 ），则位置 (i, j) 被称为特殊位置。
 *
 *
 *
 * 示例 1：
 *
 * 输入：mat = [[1,0,0],
 *             [0,0,1],
 *             [1,0,0]]
 * 输出：1
 * 解释：(1,2) 是一个特殊位置，因为 mat[1][2] == 1 且所处的行和列上所有其他元素都是 0
 * 示例 2：
 *
 * 输入：mat = [[1,0,0],
 *             [0,1,0],
 *             [0,0,1]]
 * 输出：3
 * 解释：(0,0), (1,1) 和 (2,2) 都是特殊位置
 * 示例 3：
 *
 * 输入：mat = [[0,0,0,1],
 *             [1,0,0,0],
 *             [0,1,1,0],
 *             [0,0,0,0]]
 * 输出：2
 * 示例 4：
 *
 * 输入：mat = [[0,0,0,0,0],
 *             [1,0,0,0,0],
 *             [0,1,0,0,0],
 *             [0,0,1,0,0],
 *             [0,0,0,1,1]]
 * 输出：3
 *
 *
 * 提示：
 *
 * rows == mat.length
 * cols == mat[i].length
 * 1 <= rows, cols <= 100
 * mat[i][j] 是 0 或 1
 *
 *
 */
public class TestSolution1582 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1582.class);


    static class Solution {

        /**
         *
         * 思路：搞两个黑名单
         *
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：2 ms, 在所有 Java 提交中击败了95.17%的用户
         * 内存消耗：38.7 MB, 在所有 Java 提交中击败了92.93%的用户
         *
         * @param mat
         * @return
         */
        public int numSpecial(int[][] mat) {
            //大数据量是用BitSet，小数据时array性能好
            int[] rowBlackList = new int[100];
            int[] colBlackList = new int[100];

            int row = mat.length;
            int col = mat[0].length;
            int ret = 0;

            for (int i = 0; i < row; i++) {
                if (rowBlackList[i] == 1) {
                    continue;
                }
                for (int j = 0; j < col; j++) {
                    if (colBlackList[j] == 1) {
                        continue;
                    }

                    if (mat[i][j] == 1 ) {
                        //同行
                        int sum = 0;
                        for (int i1 = 0; i1 < col; i1++) {
                            if (i1 !=j && mat[i][i1] == 1) {
                                sum = 1;
                                break;
                            }
                        }
                        if (sum == 0) {
                            sum = 0;
                            for (int i1 = 0; i1 < row; i1++) {
                                if (i1 != i && mat[i1][j] == 1) {
                                    sum = 1;
                                    break;
                                }
                            }
                            if (sum == 0) {
                                rowBlackList[i] =1;
                                colBlackList[j] =1;
                                ret ++;
                            }
                        }
                    }
                }
            }
            return ret;
        }

    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().numSpecial(new int[][]{
                {0,0,0,0,0},
                {1,0,0,0,0},
                {0,1,0,0,0},
                {0,0,1,0,0},
                {0,0,0,1,1}
        }));//3

        logger.info("{}", new Solution().numSpecial(new int[][]{
                {0,0,0,1},
                {1,0,0,0},
                {0,1,1,0},
                {0,0,0,0}
        }));//2

        logger.info("{}", new Solution().numSpecial(new int[][]{
                {1,0,0},
                {0,1,0},
                {0,0,1}
        }));//3

        logger.info("{}", new Solution().numSpecial(new int[][]{
                {1,0,0},
                {0,0,1},
                {1,0,0}
        }));//1
    }
}
