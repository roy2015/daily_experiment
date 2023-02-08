package com.roy.leetcode.stage2.stage20;

import java.util.Arrays;

import org.slf4j.LoggerFactory;

/**
 *
 *
 *
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。

 示例:

 输入: 3
 输出:
 [
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
 ]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/spiral-matrix-ii
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author guojun
 * @date 2020/1/30 10:20
 */
public class TestSolution59 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution59.class);

    static class Solution {
        /**
         * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗 :34.3 MB, 在所有 Java 提交中击败了39.87%的用户
         * @param n
         * @return
         */
        public int[][] generateMatrix(int n) {
            //生成一个数组，1-n*2
            int retMatrix[][] = new int[n][n];
            for (int[] ints : retMatrix) {
                Arrays.fill(ints, 0);
            }

            int col = n;
            int row = n;
            int step =1;
            retMatrix[0][0] = step ++;
            int pos_col = 0, pos_row = 0;

            //1 向左 2下 3左 4上
            int direct = 1;
            while (true) {
                if (direct == 1) {//向左
                    while (pos_col + 1 < col && retMatrix[pos_row][pos_col + 1] == 0) {
                        pos_col = pos_col + 1;
                        retMatrix[pos_row][pos_col] = step ++;
                    }
                    if (!(pos_row + 1 < row && retMatrix[pos_row + 1][pos_col] == 0)) {//不满足向下， 后面同理
                        return retMatrix;
                    }
                    direct = 2;
                } else if (direct == 2) {//向下
                    while (pos_row + 1 < row && retMatrix[pos_row + 1][pos_col] == 0) {
                        pos_row = pos_row + 1;
                        retMatrix[pos_row][pos_col] = step ++;
                    }
                    if (!(pos_col > 0 && retMatrix[pos_row][pos_col - 1] == 0)) {
                        return retMatrix;
                    }
                    direct = 3;
                } else if (direct == 3) {//向右
                    while (pos_col > 0 && retMatrix[pos_row][pos_col - 1] == 0) {
                        pos_col = pos_col - 1;
                        retMatrix[pos_row][pos_col] = step ++;
                    }
                    if (!(pos_row > 0 && retMatrix[pos_row - 1][pos_col] == 0)) {
                        return retMatrix;
                    }
                    direct = 4;
                } else if (direct == 4) {//向上
                    while (pos_row > 0 && retMatrix[pos_row - 1][pos_col] == 0) {
                        pos_row = pos_row - 1;
                        retMatrix[pos_row][pos_col] = step ++;

                    }
                    if (!(pos_col + 1 < col && retMatrix[pos_row][pos_col + 1] == 0)) {
                        return retMatrix;
                    }
                    direct = 1;
                } else {
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new Solution().generateMatrix(3);
        int k =0;
    }
}
