package com.roy.leetcode.stage1.stage12;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/7/24
 * <p>
 * 892. 三维形体的表面积
 * 在 N * N 的网格上，我们放置一些 1 * 1 * 1  的立方体。
 * <p>
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
 * <p>
 * 请你返回最终形体的表面积。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[[2]]
 * 输出：10
 * 示例 2：
 * <p>
 * 输入：[[1,2],[3,4]]
 * 输出：34
 * 示例 3：
 * <p>
 * 输入：[[1,0],[0,2]]
 * 输出：16
 * 示例 4：
 * <p>
 * 输入：[[1,1,1],[1,0,1],[1,1,1]]
 * 输出：32
 * 示例 5：
 * <p>
 * 输入：[[2,2,2],[2,1,2],[2,2,2]]
 * 输出：46
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= N <= 50
 * 0 <= grid[i][j] <= 50
 */
public class TestSolution892 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution892.class);


    static class Solution {
        /**
         * 解法错误，无法解决中间有窟窿少算的问题
         *
         * @param grid
         * @return
         */
        public int surfaceArea(int[][] grid) {
            int frontBackViewSum = 0;
            int leftRightViewSum = 0;
            int upDownViewSum = 0;
            int row = grid.length;
            int col = grid[0].length;

            //upDown view
//            upDownViewSum = col * row;//不能这么算，因为可能有0

            //frontBack view
            for (int i = 0; i < row; i++) {
                int maxVal = -1;
                for (int j = 0; j < col; j++) {
                    int gridVal = grid[i][j];
                    if (gridVal > maxVal) {
                        maxVal = gridVal;
                    }
                    if (gridVal != 0) {
                        upDownViewSum++;
                    }
                }
                frontBackViewSum += maxVal;
            }

            //leftRight view
            for (int i = 0; i < col; i++) {
                int maxVal = -1;
                for (int j = 0; j < row; j++) {
                    int gridVal = grid[j][i];
                    if (gridVal > maxVal) {
                        maxVal = gridVal;
                    }
                }
                leftRightViewSum += maxVal;
            }
            return (upDownViewSum + leftRightViewSum + frontBackViewSum) * 2;
        }

        /**
         *
         * 减去覆盖的面数
         * 执行时间不怎么理想是不是要优化下? todo
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 16 ms, 在所有 Java 提交中击败了5.35%的用户
         * 内存消耗：
         * 39.7 MB, 在所有 Java 提交中击败了100.00%的用户
         *
         * @param grid
         * @return
         */
        public int surfaceArea1(int[][] grid) {
            int row = grid.length;
            int col = grid[0].length;

            int sum = 0;
            int coverSum = 0;

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    int gridVal = grid[i][j];
                    //none
                    if (gridVal == 0) {
                        continue;
                    }
                    sum += 6 * gridVal;
                    for (int i1 = 1; i1 <= gridVal; i1++) {
                        int left = 0, right = 0, front = 0, back = 0, up = 0, down = 0;
                        //left
                        if (i >= 1) {
                            if (grid[i - 1][j] > 0 &&
                                    (grid[i - 1][j] >= i1)) {
                                left = 1;
                            }
                        }
                        //right
                        if (i < row - 1) {
                            if (grid[i + 1][j] > 0 &&
                                    (grid[i + 1][j] >= i1)) {
                                right = 1;
                            }
                        }
                        //up
                        if (i1 < gridVal) {
                            up = 1;
                        }
                        //down
                        if (i1 > 1) {
                            down = 1;
                        }
                        //front
                        if (j >= 1) {
                            if (grid[i][j - 1] > 0 &&
                                    (grid[i][j - 1] >= i1)) {
                                front = 1;
                            }
                        }
                        //back
                        if (j < col - 1) {
                            if (grid[i][j + 1] > 0 &&
                                    (grid[i][j + 1] >= i1)) {
                                back = 1;
                            }
                        }
                        coverSum += left + right + up + down + front + back;
                    }
                }
            }
            return sum - coverSum;
        }



        /**
         *
         * 基于上面的优化， 减少了比较多的重复if判断
         *执行时间还不怎么理想是不是要优化下? todo
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 5 ms, 在所有 Java 提交中击败了31.45%的用户
         * 内存消耗：
         * 39.3 MB, 在所有 Java 提交中击败了100.00%的用户
         *
         * @param grid
         * @return
         */
        public int surfaceArea2(int[][] grid) {
            int row = grid.length;
            int col = grid[0].length;

            int sum = 0;
            int toRemoveSum = 0;
            int count =0;

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    int gridVal = grid[i][j];
                    //none
                    if (gridVal == 0) {
                        continue;
                    }
                    count +=  gridVal;
                    int leftGridVal = (i >= 1) ? grid[i - 1][j] : 0;
                    int rightGridVal = (i < row - 1) ? grid[i + 1][j] : 0;

                    int frontGridVal = (j >= 1) ? grid[i][j - 1] : 0;
                    int backGridVal = (j < col - 1) ? grid[i][j + 1] : 0;

                    for (int i1 = 1; i1 <= gridVal; i1++) {
                        //left
                        if ((leftGridVal >= i1)) {
                            toRemoveSum++;
                        }
                        //right
                        if ((rightGridVal >= i1)) {
                            toRemoveSum++;
                        }
                        //up
                        if (i1 < gridVal) {
                            toRemoveSum++;
                        }
                        //down
                        if (i1 > 1) {
                            toRemoveSum++;
                        }
                        //front
                        if ((frontGridVal >= i1)) {
                            toRemoveSum++;
                        }
                        //back
                        if ((backGridVal >= i1)) {
                            toRemoveSum++;
                        }
                    }
                }
            }
            return count * 6 - toRemoveSum;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().surfaceArea2(new int[][]{
                {2}
        }));//10

        //中间有窟窿
        logger.info("{}", new Solution().surfaceArea2(new int[][]{
                {1, 1, 1}, {1, 0, 1}, {1, 1, 1}
        }));//32

        logger.info("{}", new Solution().surfaceArea2(new int[][]{
                {1, 2}, {3, 4}
        }));//34

        logger.info("{}", new Solution().surfaceArea2(new int[][]{
                {1, 0}, {0, 2}
        }));//16


    }
}
