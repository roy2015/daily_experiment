package com.roy.miscellaneous.leetcode.stage2.stage20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.slf4j.LoggerFactory;

/**
 * 120. 三角形最小路径和
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 *
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 *    2
 *   3 4
 *  6 5 7
 * 4 1 8 3
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * 示例 2：
 *
 * 输入：triangle = [[-10]]
 * 输出：-10
 *
 *
 * 提示：
 *
 * 1 <= triangle.length <= 200
 * triangle[0].length == 1
 * triangle[i].length == triangle[i - 1].length + 1
 * -104 <= triangle[i][j] <= 104
 *
 *
 * 进阶：
 *
 * 你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？
 *
 * @author guojun
 * @date 2021/10/10
 */
public class TestSolution120 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution120.class);


    static class Solution {

        /**
         *
         * dp方程是关键，就是个杨辉三角
         *
         * 执行结果：通过
         * 显示详情添加备注
         *
         * 执行用时：3 ms, 在所有 Java 提交中击败了60.32%的用户
         * 内存消耗：38.1 MB, 在所有 Java 提交中击败了79.71%的用户
         * 通过测试用例：44 / 44
         *
         * @param triangle
         * @return
         */
        public int minimumTotal(List<List<Integer>> triangle) {
            if (triangle == null) {
                return 0;
            }
            int size = triangle.size();
            if (size == 1) {
                return triangle.get(0).get(0);
            }

            int[][] dp = new int[size][size];
            dp[0][0] = triangle.get(0).get(0);
            for (int i = 1; i < size; i++) {
                for (int j = 0; j <= i; j++) {
                    Integer val = triangle.get(i).get(j);
                    if (j ==0) {
                        dp[i][j] = dp[i -1][j] + val;
                    } else if (j == i){
                        dp[i][j] = dp[i -1][j - 1] + val;
                    } else {
                        dp[i][j] = Math.min(dp[i -1][j - 1], dp[i -1][j])  + val;
                    }
                }
            }
            int min = Integer.MAX_VALUE;
            int size1 = size -1;
            for (int i = 0; i < size ; i++) {
                int iVal = dp[size1][i];
                if (iVal < min) {
                    min = iVal;
                }
            }
            return min;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists;
        lists = new ArrayList<>();
        lists.add(Arrays.asList(2));
        lists.add(Arrays.asList(3,4));
        lists.add(Arrays.asList(6,5,7));
        lists.add(Arrays.asList(4,1,8,4));
        logger.info("{}", new Solution().minimumTotal(lists));//11

        lists = new ArrayList<>();
        lists.add(Arrays.asList(-10));
        logger.info("{}", new Solution().minimumTotal(lists));//-10
    }
}
