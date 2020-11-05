package com.roy.miscellaneous.leetcode.stage2.stage21;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/11/5
 *
 *
 * 560. 和为K的子数组
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 * 示例 1 :
 *
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 :
 *
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 */
public class TestSolution560 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution560.class);


    static class Solution {
        /**
         * 我去，想出来写了个DP,居然是5.05%， 看官方题解，可以考虑用前缀和 todo
         *  dp[i] = dp[i-1] + times，i个数和i-1个数的dp值有关系，利用这点就可以用dp动态规划
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：1162 ms, 在所有 Java 提交中击败了5.05%的用户
         * 内存消耗：40.9 MB, 在所有 Java 提交中击败了15.12%的用户
         *
         * @param nums
         * @param k
         * @return
         */
        public int subarraySum(int[] nums, int k) {
            int length = nums.length;
            int[] dp = new int[length +1];
            dp[0] = 0;
            for (int i = 1; i <= length; i++) {
                int sumI =0;
                int times = 0;
                for (int j = i -1; j >= 0 ; j--) {
                    sumI += nums[j];
                    if (sumI == k) {
                        times++;
                    }
                }
                dp[i] = dp[i-1] + times;
            }
            return dp[length];
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().subarraySum(new int[]{1,1,1}, 2));//2
        logger.info("{}", new Solution().subarraySum(new int[]{1,2,1,-1,3,-2,5}, 3));//7
    }
}
