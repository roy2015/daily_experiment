package com.roy.miscellaneous.leetcode.stage2;

import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * @author guojun
 * @date 2020/1/21 10:40
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 * 两个相邻元素间的距离为 1 。
 * 示例 1:
 * 输入:
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 输出:
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 示例 2:
 * 输入:
 * 0 0 0
 * 0 1 0
 * 1 1 1
 * 输出:
 * 0 0 0
 * 0 1 0
 * 1 2 1
 * 注意:
 * 给定矩阵的元素个数不超过 10000。
 * 给定矩阵中至少有一个元素是 0。
 * 矩阵中的元素只在四个方向上相邻: 上、下、左、右。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/01-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TestSolution542 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution542.class);

    static class Solution {

        /**
         * 执行用时 :8 ms, 在所有 Java 提交中击败了97.50%的用户
         * 内存消耗 :55.3 MB, 在所有 Java 提交中击败了54.27%的用户
         *
         * @param matrix
         * @return
         */
        public int[][] updateMatrix(int[][] matrix) {
            //行列
            int rowLen = matrix.length;
            int colLen = matrix[0].length;

            int[][] updateMatrix = new int[rowLen][colLen];
            /*for (int[] ints : matrix) {//两个二维数组赋值
                updateMatrix = Arrays.copyOfRange(matrix, 0, matrix.length);
            }*/
            for (int[] ints : updateMatrix) {
                ints = new int[] {};
                Arrays.fill(ints, 0);
            }

            for (int rowIndex = 0; rowIndex < rowLen; rowIndex++) {
                for (int colIndex = 0; colIndex < colLen; colIndex++) {
                    updateMatrix[rowIndex][colIndex] = subUpdateMatrix(matrix, rowIndex, colIndex, rowLen, colLen);
                }
            }
            return updateMatrix;
        }

        public int subUpdateMatrix(int[][] matrix, int rowIndex, int colIndex, int rowLen, int colLen) {
            if (matrix[rowIndex][colIndex] == 0) {
                return 0;
            }

            int upMoveStep = rowIndex;
            int downMoveStep = rowLen - rowIndex - 1;
            int rowMoveStep = upMoveStep > downMoveStep ? upMoveStep : downMoveStep;
            int leftMoveStep = colIndex;
            int rightMoveStep = colLen - colIndex - 1;
            int colMoveStep = leftMoveStep > rightMoveStep ? leftMoveStep : rightMoveStep;
            int maxMoveStep = rowMoveStep + colMoveStep;//左右上下加起来能位移的步数

            //挪步,从一步开始，知道moveStep
            for (int step = 1; step <= maxMoveStep; step++) {
                for (int updownStep = 0; updownStep <= step; updownStep++) {
                    int leftRightStep = step - updownStep;
                    if (leftRightStep > colMoveStep) {
                        continue;
                    }
                    //上
                    int up, down, left, right;
                    up = rowIndex - updownStep;
                    down = rowIndex + updownStep;
                    left = colIndex - leftRightStep;
                    right = colIndex + leftRightStep;

                    if (up >= 0 && left >= 0 && matrix[up][left] == 0) {
                        return step;
                    } else if (up >= 0 && right < colLen && matrix[up][right] == 0) {
                        return step;
                    } else if (down < rowLen && left >= 0 && matrix[down][left] == 0) {
                        return step;
                    } else if (down < rowLen && right < colLen && matrix[down][right] == 0) {
                        return step;
                    } else {
                    }
                }
            }
            return 0;
        }

        public static void printMatix(int[][] matrix) {
            for (int[] ints : matrix) {
                StringBuffer sb = new StringBuffer();
                for (int anInt : ints) {
                    sb.append(anInt);
                }
                logger.info(sb.toString());
            }
        }

    }

    public static void main(String[] args) {
        int[][] ints1 = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 }, };

        int[][] ints2 = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 }, };
        logger.info("==================================");
        Solution.printMatix(new Solution().updateMatrix(ints1));

        logger.info("==================================");
        Solution.printMatix(new Solution().updateMatrix(ints2));
    }
}
