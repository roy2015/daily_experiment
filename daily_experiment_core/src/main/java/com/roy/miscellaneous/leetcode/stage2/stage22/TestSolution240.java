package com.roy.miscellaneous.leetcode.stage2.stage22;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/6/29
 *
 *
 * 240. 搜索二维矩阵 II
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 *
 * 给定 target = 20，返回 false。
 *
 * 通过次数62,669提交次数153,083
 *
 *
 */
public class TestSolution240 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution240.class);


    static class Solution {

        /**
         *
         * 参考了官方题解3
         *
         * 找对角线上的点，然后作二分查找，我去，滥用了多少个二分查找？知道了二分查找的精髓在有序数组
         *
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 9 ms, 在所有 Java 提交中击败了28.23%的用户
         * 内存消耗：
         * 44.9 MB, 在所有 Java 提交中击败了35.71%的用户
         *
         * @param matrix
         * @param target
         * @return
         */
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix.length == 0) {
                return false;
            }
            int col = matrix[0].length;
            int row = matrix.length;
            int size = Math.min(row, col);
            int maxSize = Math.max(row, col);

            int i = 0;
            for (; i < size; i++) {
                if (target == matrix[i][i]) {
                    return true;
                }
                if (target < matrix[i][i]) {
                    break;
                }
            }
            int low;
            int high;
            //正方矩阵内
            if (i < size) {
                //正方矩阵对角线
                for (int k = i ; k< size; k++) {
                    //行
                    low = 0;
                    high = size -1;
                    while (low <= high) {
                        int mid = (low +high) /2;
                        int midVal = matrix[k][mid];
                        if (midVal == target) {
                            return true;
                        } else if (midVal > target) {
                            high = mid -1;
                        } else {
                            low =  mid +1;
                        }
                    }

                    //列
                    low = 0;
                    high = size -1;
                    while (low <= high) {
                        int mid = (low +high) /2;
                        int midVal = matrix[mid][k];
                        if (midVal == target) {
                            return true;
                        } else if (midVal > target) {
                            high = mid -1;
                        } else {
                            low =  mid +1;
                        }
                    }
                }

            }
            if (i == size && (size == maxSize)) {//结束
                return false;
            } else {//行列不相等，延长线
                if (col > row) {
                    for (; i < maxSize; i++) {//对每一列二分查找
                        low = 0;
                        high = size -1;
                        while (low <= high) {
                            int mid = (low +high) /2;
                            int midVal = matrix[mid][i];
                            if (midVal == target) {
                                return true;
                            } else if (midVal > target) {
                                high = mid -1;
                            } else {
                                low =  mid +1;
                            }
                        }
                    }
                    return false;
                } else {
                    for (; i < maxSize; i++) {//对每一行二分查找
                        low = 0;
                        high = size -1;
                        while (low <= high) {
                            int mid = (low +high) /2;
                            int midVal = matrix[i][mid];
                            if (midVal == target) {
                                return true;
                            } else if (midVal > target) {
                                high = mid -1;
                            } else {
                                low =  mid +1;
                            }
                        }
                    }
                    return false;
                }
            }
        }

        /**
         * 参考了官方题解4，不好想到但又非常巧妙
         * 思路一句话描述：
         *   占据左下角，然后向上(targe > idxVal)向右(targe < idxVal), 蛇形走位向上向右走
         *
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 6 ms, 在所有 Java 提交中击败了99.77%的用户
         * 内存消耗：
         * 45.3 MB, 在所有 Java 提交中击败了17.86%的用户
         * @param matrix
         * @param target
         * @return
         */
        public boolean searchMatrix1(int[][] matrix, int target) {
            int row = matrix.length;
            if (row == 0) {
                return false;
            }

            int col = matrix[0].length;
            if (col == 0) {
                return false;
            }

            //去左下角
            int idxR = row -1;
            int idxC = 0;

            while (true) {
                int idxVal = matrix[idxR][idxC];
                if (target == idxVal) {
                    return true;
                } else if (target > idxVal) {
                    idxC ++;
                    if (idxC == col) {
                        return false;
                    }
                } else {
                    idxR --;
                    if (idxR < 0) {
                        return false;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        logger.info("{}", new Solution().searchMatrix1(new int[][]{
                new int[]{}
                }, 1));//false

        logger.info("{}", new Solution().searchMatrix(new int[][]{
                {1,1}
        }, 0));//false

        logger.info("{}", new Solution().searchMatrix(new int[][]{
                {1,  2,  3,  4, 5},
                {6,  7,  8,  9, 10},
                {11,12, 13, 14, 15},
                {16,17, 18, 19, 20},
                {21,22, 23, 24, 25}
        }, 15));//true


        logger.info("{}", new Solution().searchMatrix(new int[][]{}, 0));//false

        logger.info("{}", new Solution().searchMatrix(new int[][]{
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        }, 5));//true

        logger.info("{}", new Solution().searchMatrix(new int[][]{
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        }, 20));//false
    }
}
