package com.roy.miscellaneous.leetcode.stage2.stage21;

import org.slf4j.LoggerFactory;

/**
 *
 * 53. 最大子数组和
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 *
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 *
 * 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解
 *
 * @author guojun
 * @see com.roy.miscellaneous.leetcode.stage1.stage10.TestSolution53
 * @date 2021/6/11
 */
public class TestSolution53 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution53.class);


    static class Solution {
        public int maxSubArray(int[] nums) {
            int length = nums.length;
            if (length == 1) {
                return nums[0];
            }

            int[] dp = new int[length];
            dp[0] = nums[0];
            for (int i = 1; i < length; i++) {
                int ival = nums[i];
                if (dp[i-1] >0 && ival <= 0) {
                    dp[i] = dp[i-1];
                    continue;
                }

                int max = ival;
                int sum = ival;
                for (int j = i-1; j >= 0; j--) {
                    sum += nums[j];
                    if (max < sum) {
                        max = sum;
                    }
                }
                dp[i] = max > dp[i-1] ? max : dp[i-1];
            }

            return dp[length -1 ];

        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().maxSubArray(new int[]{-2, -1}));//-1
        logger.info("{}", new Solution().maxSubArray(new int[]{1}));//1
        logger.info("{}", new Solution().maxSubArray(new int[]{5,4,-1,7,8}));//23
        logger.info("{}", new Solution().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));//6
    }
}
