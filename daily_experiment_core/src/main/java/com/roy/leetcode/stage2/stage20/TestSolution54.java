package com.roy.leetcode.stage2.stage20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/1/17 13:36
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * 示例 1:
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 * 输入:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TestSolution54 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution54.class);

    static class Solution {

        /**
         * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗 :34.7 MB, 在所有 Java 提交中击败了12.73%的用户
         *
         * @param matrix
         * @return
         */
        public List<Integer> spiralOrder(int[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                return Collections.EMPTY_LIST;
            }
            int row = matrix.length;
            int col = matrix[0].length;
            int[][] presentMatrix = new int[row][col];
            for (int[] ints : presentMatrix) {
                Arrays.fill(ints, 0);
            }
            List<Integer> retList = new ArrayList<>();
            retList.add(matrix[0][0]);
            presentMatrix[0][0] = 1;
            int pos_col = 0, pos_row = 0;

            //1 向左 2下 3左 4上
            int direct = 1;
            while (true) {
                if (direct == 1) {//向左
                    while (pos_col + 1 < col && presentMatrix[pos_row][pos_col + 1] != 1) {
                        pos_col = pos_col + 1;
                        retList.add(matrix[pos_row][pos_col]);
                        presentMatrix[pos_row][pos_col] = 1;
                    }
                    if (!(pos_row + 1 < row && presentMatrix[pos_row + 1][pos_col] != 1)) {//不满足向下， 后面同理
                        return retList;
                    }
                    direct = 2;
                } else if (direct == 2) {//向下
                    while (pos_row + 1 < row && presentMatrix[pos_row + 1][pos_col] != 1) {
                        pos_row = pos_row + 1;
                        retList.add(matrix[pos_row][pos_col]);
                        presentMatrix[pos_row][pos_col] = 1;
                    }
                    if (!(pos_col > 0 && presentMatrix[pos_row][pos_col - 1] != 1)) {
                        return retList;
                    }
                    direct = 3;
                } else if (direct == 3) {//向右
                    while (pos_col > 0 && presentMatrix[pos_row][pos_col - 1] != 1) {
                        pos_col = pos_col - 1;
                        retList.add(matrix[pos_row][pos_col]);
                        presentMatrix[pos_row][pos_col] = 1;
                    }
                    if (!(pos_row > 0 && presentMatrix[pos_row - 1][pos_col] != 1)) {
                        return retList;
                    }
                    direct = 4;
                } else if (direct == 4) {//向上
                    while (pos_row > 0 && presentMatrix[pos_row - 1][pos_col] != 1) {
                        pos_row = pos_row - 1;
                        retList.add(matrix[pos_row][pos_col]);
                        presentMatrix[pos_row][pos_col] = 1;

                    }
                    if (!(pos_col + 1 < col && presentMatrix[pos_row][pos_col + 1] != 1)) {
                        return retList;
                    }
                    direct = 1;
                } else {
                }
            }
        }
    }


    static class Solution1 {

        /**
         * 20221026
         *
         * 执行用时：
         * 0 ms
         * , 在所有 Java 提交中击败了
         * 100.00%
         * 的用户
         * 内存消耗：
         * 39.5 MB
         * , 在所有 Java 提交中击败了
         * 59.44%
         * 的用户
         * @param matrix
         * @return
         */
        public List<Integer> spiralOrder(int[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                return Collections.EMPTY_LIST;
            }

            int row = matrix.length;
            int col = matrix[0].length;

            List<Integer> storeList = new ArrayList<>();
            //剥洋葱，每剥一次矩阵行列长度减2，开始元素行列坐标加1
            for (int m = row,n = col, startRow=0 , startCol =0; m >= 1 && n >=1; m-=2,n-=2, startRow++, startCol++) {
                test(matrix, m, n, startRow, startCol, storeList);
            }
            return storeList;
        }


        /**
         *  通用方法，剥最外一层
         * @param matrix
         * @param row  行数 >=1
         * @param col  列数 >=1
         * @param idxRow 行开始index
         * @param idxCol 列开始index
         * @param outputList 输出数组
         */
        public void test(int[][] matrix, int row, int col, int idxRow, int idxCol, List<Integer> outputList) {
            if (col < 1 || row <1) {
                return;
            }

            int rightColIdx = idxCol + col - 1;
            int downRowIdx = idxRow + row - 1;
            //只有一列
            if (col ==1) {
                //向下结束
                for (int i = 0; i < row; i++) {
                    outputList.add(matrix[idxRow+i][rightColIdx]);
                }
                return;
            }

            //多列，向右
            for (int i = 0; i < col; i++) {
                outputList.add(matrix[idxRow][idxCol+i]);
            }

            //只有一列， 不用向下，结束
            if (row == 1) {
                return;
            }

            //向下
            for (int i = 1; i < row; i++) {
                outputList.add(matrix[idxRow+i][rightColIdx]);
            }

            //多行， 向左
            for (int i = rightColIdx-1; i >= idxCol; i--) {
                outputList.add(matrix[downRowIdx][i]);
            }
            //向上
            for (int i = idxRow + row -2; i > idxRow; i--) {
                outputList.add(matrix[i][idxCol]);
            }
        }
    }

    public static void main(String[] args) {
//        int[][] matrix = new int[][] {
//        { 1, 2 },
//        { 3, 4 },
//        { 5, 6 } };



//        int[][] matrix = new int[][]{
//                { 1,  2,  3,  4},
//                { 5,  6,  7,  8 },
//                { 9, 10, 11, 12 }
//        };

//        int[][] matrix = new int[][]{
//                { 1,   2,  3,  4},
//                { 5,   6,  7,  8 },
//                { 9,  10, 11, 12 },
//                { 13, 14, 15, 16 }
//        };

//        int[][] matrix = new int[][]{
//                { 1},
//                { 2}
//        };

        int[][] matrix = new int[][]{
                { 1,2}
        };

//        List<Integer> list = new ArrayList<>();
//        new Solution1().test(matrix, 1,2, 0,0, list);

        Solution1 solution = new Solution1();
        List<Integer> integers = solution.spiralOrder(matrix);
        logger.info(integers.toString());
    }
}
