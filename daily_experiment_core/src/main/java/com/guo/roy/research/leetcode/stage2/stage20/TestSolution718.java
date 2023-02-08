package com.guo.roy.research.leetcode.stage2.stage20;

import org.slf4j.LoggerFactory;

/**
 *
 * 718. 最长重复子数组 给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7] 输出：3 解释：长度最长的公共子数组是 [3,2,1] 。 示例 2：
 *
 * 输入：nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0] 输出：5
 *
 *
 * 提示：
 *
 * 1 <= nums1.length, nums2.length <= 1000 0 <= nums1[i], nums2[i] <= 100
 *
 *
 * @author guojun
 * @date 2021/1/21 10:40
 */
public class TestSolution718 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution718.class);

    static class Solution {
        /**
         *
         * 执行结果：通过
         * 显示详情
         * 添加备注
         *
         * 执行用时：1956 ms, 在所有 Java 提交中击败了5.01%的用户
         * 内存消耗：50.7 MB, 在所有 Java 提交中击败了5.20%的用户
         * 通过测试用例：
         * 57 / 57
         *
         *
         * @param nums1
         * @param nums2
         * @return
         */
        public int findLength(int[] nums1, int[] nums2) {
            int col = nums1.length;
            int row = nums2.length;
            int[][] dp = new int[row + 1][col + 1];
            for (int i = 0; i < row; i++) {
                int iPlus = i + 1;
                for (int j = 0; j < col; j++) {
                    int jPlus = j + 1;
                    if (nums2[i] == nums1[j]) {
                        int sum = 1;
                        for (int m = i - 1, n = j - 1; (m >= 0 && n >= 0); m--, n--) {
                            if (nums2[m] != nums1[n]) {
                                break;
                            }
                            sum++;
                        }
                        dp[iPlus][jPlus] = Math.max(sum, Math.max(dp[iPlus][j], dp[i][jPlus]));
                    } else {
                        dp[iPlus][jPlus] = Math.max(dp[iPlus][j], dp[i][jPlus]);
                    }
                }
            }
            return dp[row][col];
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().findLength(new int[] { 57, 85, 85, 5, 28 }, new int[] { 82, 85, 85, 32, 50 }));// 2
        logger.info("{}", new Solution().findLength(new int[] { 1, 0, 0, 0, 1 }, new int[] { 1, 0, 0, 1, 1 }));// 3
        logger.info("{}", new Solution().findLength(new int[] { 0, 1, 1, 1, 1 }, new int[] { 1, 0, 1, 0, 1 }));// 2
        logger.info("{}", new Solution().findLength(new int[] { 0, 0, 0, 0, 0, 0, 1, 0, 0, 0 }, new int[] { 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 }));// 9
        logger.info("{}", new Solution().findLength(new int[] { 5, 14, 53, 80, 48 }, new int[] { 50, 47, 3, 80, 83 }));// 1
        logger.info("{}", new Solution().findLength(new int[] { 1, 2, 3, 2, 1 }, new int[] { 1, 2, 2, 1 }));// 2
        logger.info("{}", new Solution().findLength(new int[] { 0, 0, 0, 0, 0 }, new int[] { 0, 0, 0, 0, 0 }));// 5
        logger.info("{}", new Solution().findLength(new int[] { 1, 2, 3, 2, 1 }, new int[] { 3, 2, 1, 4, 7 }));// 3

    }
}
