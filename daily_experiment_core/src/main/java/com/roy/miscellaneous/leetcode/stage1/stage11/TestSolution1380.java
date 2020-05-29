package com.roy.miscellaneous.leetcode.stage1.stage11;

import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author guojun
 * @date 2020/5/12 14:53
 *
 *
 * 1380. 矩阵中的幸运数
给你一个 m * n 的矩阵，矩阵中的数字 各不相同 。请你按 任意 顺序返回矩阵中的所有幸运数。

幸运数是指矩阵中满足同时下列两个条件的元素：

在同一行的所有元素中最小
在同一列的所有元素中最大


示例 1：

输入：matrix = [[3,7,8],[9,11,13],[15,16,17]]
输出：[15]
解释：15 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
示例 2：

输入：matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
输出：[12]
解释：12 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
示例 3：

输入：matrix = [[7,8],[1,2]]
输出：[7]


提示：

m == mat.length
n == mat[i].length
1 <= n, m <= 50
1 <= matrix[i][j] <= 10^5
矩阵中的所有元素都是不同的
 *
 */
public class TestSolution1380 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1380.class);


    static class Solution {
        /**
         *
         * 比较常规的思路，两个map,看什么有交集，  需要改善
         *
         * 执行结果：通过显示详情
         * 执行用时 :3 ms, 在所有 Java 提交中击败了59.69%的用户
         * 内存消耗 :40 MB, 在所有 Java 提交中击败了100.00%的用户
         *
         * @param matrix
         * @return
         */
        public List<Integer> luckyNumbers (int[][] matrix) {
            int rowCnt = matrix.length;
            int colCnt = matrix[0].length;

            Map<Integer, Integer> rowMinMap = new HashMap<>();
            Map<Integer, Integer> colMaxMap = new HashMap<>();

            List<Integer> retList = new ArrayList<>();

            //求每行的最小值
            for (int i = 0; i < rowCnt; i++) {
                int rowMinIndex = 0;
                int rowMinVal = matrix[i][0];
                for (int j = 0; j < colCnt; j++) {
                    if (matrix[i][j] < rowMinVal) {
                        rowMinVal =  matrix[i][j];
                        rowMinIndex = j;
                    }
                }
                rowMinMap.put(i, rowMinIndex);
            }

            //循环每列
            for (int j = 0; j < colCnt; j++) {
                int colMaxIndex = 0;
                int colMaxVal = matrix[0][j];
                int i;
                for (i= 0; i < rowCnt; i++) {
                    if (matrix[i][j] > colMaxVal) {
                        colMaxVal =  matrix[i][j];
                        colMaxIndex = i;
                    }
                }
                //是否是行里最小的
                if ( rowMinMap.get(colMaxIndex) == j ) {
                    retList.add(colMaxVal);
                }

            }
            return retList;
        }

        /**
         *
         * 5ms
         * @param matrix
         * @return
         */
        public List<Integer> luckyNumbers_1 (int[][] matrix) {
            int rowCnt = matrix.length;
            int colCnt = matrix[0].length;
            List<Integer> retList = new ArrayList<>();

//            Map<Integer, Integer> rowMinMap = new HashMap<>();
            Map<Integer, Integer> colMaxMap = new HashMap<>();

            for (int i = 0; i < rowCnt; i++) {
                int rowMinIndex = 0;
                int rowMinVal = matrix[i][0];
                int j;
                for (j = 0; j < colCnt; j++) {
                    Integer existMax = colMaxMap.get(j);
                    if (existMax != null) {
                        continue;
                    }

                    if (matrix[i][j] < rowMinVal) {
                        rowMinVal =  matrix[i][j];
                        rowMinIndex = j;
                    }
                }
                //是否是这列里最大的 (i,rowMinIndex)
                int k =0;
                for (k = 0; k < rowCnt; k++) {
                    if (matrix[k][rowMinIndex] > rowMinVal) {
                        break;
                    }
                }
                if (k == rowCnt) {
                    retList.add(matrix[i][rowMinIndex]);
                    colMaxMap.put(rowMinIndex, i);
                }
            }
            return retList;

        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().luckyNumbers(new int[][]
                {
                        {1,10,4,2},
                        {9,3,8,7},
                        {15,16,17,12}
                }));
    }
}
