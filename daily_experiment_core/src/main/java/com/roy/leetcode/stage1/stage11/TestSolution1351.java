package com.roy.leetcode.stage1.stage11;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/4/29 17:00
 *
 * 1351. 统计有序矩阵中的负数
 * 给你一个 m * n 的矩阵 grid，矩阵中的元素无论是按行还是按列，都以非递增顺序排列。
 *
 * 请你统计并返回 grid 中 负数 的数目。
 *
 *
 *
 * 示例 1：
 *
 * 输入：grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
 * 输出：8
 * 解释：矩阵中共有 8 个负数。
 * 示例 2：
 *
 * 输入：grid = [[3,2],[1,0]]
 * 输出：0
 * 示例 3：
 *
 * 输入：grid = [[1,-1],[-1,-1]]
 * 输出：3
 * 示例 4：
 *
 * 输入：grid = [[-1]]
 * 输出：1
 *
 *
 * 提示：
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 100
 * -100 <= grid[i][j] <= 100
 *
 *
 */
public class TestSolution1351 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1351.class);


    static class Solution {

        /**
         *
         * skip掉右下角，→ ↓, 然后跳到下一行第一列
         *
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗 :40.2 MB, 在所有 Java 提交中击败了100.00%的用户
         * @param grid
         * @return
         */
        public int countNegatives(int[][] grid) {
            int sumNum = 0;
            int rowLimit = grid.length;
            int colLimit = grid[0].length;


            for (int i =0; i < rowLimit; i++) {
                for (int j = 0; j< colLimit; j++) {
                    if (grid[i][j] < 0) {
                        sumNum += (rowLimit -i) * (colLimit - j);
                        colLimit = j;
                        break;
                    }
                }
            }
            return sumNum;
        }
    }

    public static void main(String[] args) {

        logger.info("{}", new Solution().countNegatives(new int[][]{
                {4,3,2,-1},
                {3,2,1,-1},
                {1,1,-1,-2},
                {-1,-1,-2,-3}} ));//8

        logger.info("{}", new Solution().countNegatives(new int[][]{
                {3,2},
                {1,0}} ));//0

        logger.info("{}", new Solution().countNegatives(new int[][]{
                {1,-1},
                {-1,-1}} ));//3

        logger.info("{}", new Solution().countNegatives(new int[][]{
                {-1}} ));//1
    }
}
