package com.roy.miscellaneous.leetcode.stage1.stage11;

import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author guojun
 * @date 2020/8/4
 *
 *
 *
 * 1260. 二维网格迁移
 * 给你一个 m 行 n 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。
 *
 * 每次「迁移」操作将会引发下述活动：
 *
 * 位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。
 * 位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。
 * 位于 grid[m - 1][n - 1] 的元素将会移动到 grid[0][0]。
 * 请你返回 k 次迁移操作后最终得到的 二维网格。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
 * 输出：[[9,1,2],[3,4,5],[6,7,8]]
 * 示例 2：
 *
 *
 *
 * 输入：grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
 * 输出：[[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
 * 示例 3：
 *
 * 输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9
 * 输出：[[1,2,3],[4,5,6],[7,8,9]]
 *
 *
 * 提示：
 *
 * 1 <= grid.length <= 50
 * 1 <= grid[i].length <= 50
 * -1000 <= grid[i][j] <= 1000
 * 0 <= k <= 100
 *
 *
 *
 */
public class TestSolution1260 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1260.class);


    static class Solution {
        /**
         *
         *  迁移思路就是    每移动一次元素往后挪动一个位置，考虑跨行和跨整个矩阵
         *  应该可以优化 todo
         *
         *执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 11 ms, 在所有 Java 提交中击败了26.26%的用户
         * 内存消耗：
         * 40.8 MB, 在所有 Java 提交中击败了14.81%的用户
         *
         * @param grid
         * @param k
         * @return
         */
        public List<List<Integer>> shiftGrid(int[][] grid, int k) {
            List<List<Integer>> retList = new ArrayList<>();
            if (k == 0) {
                for (int[] ints : grid) {
                    retList.add(Arrays.stream(ints).boxed().collect(Collectors.toList()));
                }
                return retList;
            }

            int row = grid.length;
            int col = grid[0].length;
            int[][] retInts = new int[row][col];
            int total = row * col;

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    int currentIdx = i * col + j;
                    int newCurrentIdx = (currentIdx + k) % total;
                    int newRow = newCurrentIdx / col;
                    int newCol = newCurrentIdx % col;
                    retInts[newRow][newCol] = grid[i][j];
                }
            }
            for (int[] ints : retInts) {
                retList.add(Arrays.stream(ints).boxed().collect(Collectors.toList()));
            }
            return retList;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().shiftGrid(
                new int[][]{
                        {1,2,3},
                        {4,5,6},
                        {7,8,9}
                }, 1
        ));// [[9, 1, 2], [3, 4, 5], [6, 7, 8]]

        logger.info("{}", new Solution().shiftGrid(
                new int[][]{
                        {3,8,1,9},{19,7,2,5},{4,6,11,10},{12,0,21,13}
                }, 4
        ));//[[12, 0, 21, 13], [3, 8, 1, 9], [19, 7, 2, 5], [4, 6, 11, 10]]
    }
}
