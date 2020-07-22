package com.roy.miscellaneous.leetcode.stage1.stage13;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/7/22
 *
 * 883. 三维形体投影面积
 * 在 N * N 的网格中，我们放置了一些与 x，y，z 三轴对齐的 1 * 1 * 1 立方体。
 *
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在单元格 (i, j) 上。
 *
 * 现在，我们查看这些立方体在 xy、yz 和 zx 平面上的投影。
 *
 * 投影就像影子，将三维形体映射到一个二维平面上。
 *
 * 在这里，从顶部、前面和侧面看立方体时，我们会看到“影子”。
 *
 * 返回所有三个投影的总面积。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[[2]]
 * 输出：5
 * 示例 2：
 *
 * 输入：[[1,2],[3,4]]
 * 输出：17
 * 解释：
 * 这里有该形体在三个轴对齐平面上的三个投影(“阴影部分”)。
 *
 * 示例 3：
 *
 * 输入：[[1,0],[0,2]]
 * 输出：8
 * 示例 4：
 *
 * 输入：[[1,1,1],[1,0,1],[1,1,1]]
 * 输出：14
 * 示例 5：
 *
 * 输入：[[2,2,2],[2,1,2],[2,2,2]]
 * 输出：21
 *
 *
 * 提示：
 *
 * 1 <= grid.length = grid[0].length <= 50
 * 0 <= grid[i][j] <= 50
 *
 *
 */
public class TestSolution883 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution883.class);


    static class Solution {
        /**
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 2 ms, 在所有 Java 提交中击败了92.17%的用户
         * 内存消耗：
         * 39.4 MB, 在所有 Java 提交中击败了100.00%的用户
         *
         *
         * @param grid
         * @return
         */
        public int projectionArea(int[][] grid) {
            int row = grid.length;
            int col = grid[0].length;

            int sumSideView = 0;
            int sumFrontView = 0;
            int sumTopView = 0;
            int maxSideVal = -1;
            int maxFrontVal = -1;

            //正(前)视图
            for (int i = 0; i < row; i++) {
                maxFrontVal = -1;
                for (int i1 = 0; i1 < col; i1++) {
                    int gridVal = grid[i][i1];
                    if (gridVal != 0) {
                        sumTopView += 1;
                    }

                    if (gridVal > maxFrontVal) {
                        maxFrontVal = gridVal;
                    }
                }
                sumFrontView += maxFrontVal;
            }

            //侧试图
            for (int i = 0; i < col; i++) {
                maxSideVal = -1;
                for (int j = 0; j < row; j++) {
                    if (grid[j][i] > maxSideVal) {
                        maxSideVal = grid[j][i];
                    }
                }
                sumSideView += maxSideVal;
            }
            return sumTopView + sumFrontView + sumSideView;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().projectionArea(new int[][]{
                {1,2},{3,4}
        }));//17

        logger.info("{}", new Solution().projectionArea(new int[][]{
                {2}
        }));//5

        logger.info("{}", new Solution().projectionArea(new int[][]{
                {1,0},{0,2}
        }));//8
    }
}
