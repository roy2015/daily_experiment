package com.roy.leetcode.stage1.stage13;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/8/8
 *
 *
 * 1470. 重新排列数组
 * 给你一个数组 nums ，数组中有 2n 个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列。
 *
 * 请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,5,1,3,4,7], n = 3
 * 输出：[2,3,5,4,1,7]
 * 解释：由于 x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 ，所以答案为 [2,3,5,4,1,7]
 * 示例 2：
 *
 * 输入：nums = [1,2,3,4,4,3,2,1], n = 4
 * 输出：[1,4,2,3,3,2,4,1]
 * 示例 3：
 *
 * 输入：nums = [1,1,2,2], n = 2
 * 输出：[1,2,1,2]
 *
 *
 * 提示：
 *
 * 1 <= n <= 500
 * nums.length == 2n
 * 1 <= nums[i] <= 10^3
 *
 *
 */
public class TestSolution1470 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1470.class);


    static class Solution {

        /**
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：
         * 39.8 MB, 在所有 Java 提交中击败了78.37%的用户
         *
         * @param nums
         * @param n
         * @return
         */
        public int[] shuffle(int[] nums, int n) {
            int[] newInts = new int[2 * n];
            int j = 0;
            for (int i = 0; i < n; i ++) {
                newInts[j++] = nums[i];
                newInts[j++] = nums[i + n];
            }
            return newInts;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().shuffle(new int[]{2,5,1,3,4,7}, 3));
    }
}
