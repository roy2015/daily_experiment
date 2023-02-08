package com.guo.roy.research.leetcode.stage2.stage22;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/6/30
 *
 *
 *
 * 378. 有序矩阵中第K小的元素
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
 *
 *
 *
 * 示例：
 *
 * matrix = [
 *    [ 1,  5,  9],
 *    [10, 11, 13],
 *    [12, 13, 15]
 * ],
 * k = 8,
 *
 * 返回 13。
 *
 *
 * 提示：
 * 你可以假设 k 的值永远是有效的，1 ≤ k ≤ n2 。
 *
 * todo 没想好怎么写，遗留
 */
public class TestSolution378 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution378.class);


    static class Solution {
        /**
         *
         * n x n 矩阵
         *
         *
         * @param matrix
         * @param k
         * @return
         */
        public int kthSmallest(int[][] matrix, int k) {
            int size = matrix.length;
            if (size == 0) {
                return -1;
            }


            return 0;


        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution());
    }
}
