package com.guo.roy.research.leetcode.stage2.stage21;

import org.slf4j.LoggerFactory;

/**
 *
 *
 * 673. 最长递增子序列的个数
 * 给定一个未排序的整数数组，找到最长递增子序列的个数。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,4,7]
 * 输出: 2
 * 解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
 * 示例 2:
 *
 * 输入: [2,2,2,2,2]
 * 输出: 5
 * 解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
 * 注意: 给定的数组长度不超过 2000 并且结果一定是32位有符号整数。
 *
 *
 * @author guojun
 * @date 2021/10/28
 */
public class TestSolution673 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution673.class);


    static class Solution {

        /**
         *
         * 复杂度有点高，以后再优化
         *
         * 执行用时：45 ms, 在所有 Java 提交中击败了5.02%的用户
         * 内存消耗：37.9 MB, 在所有 Java 提交中击败了71.89%的用户
         *
         * @param nums
         * @return
         */
        public int findNumberOfLIS(int[] nums) {
            if (nums.length == 0 ) {
                return 0;
            }
            int len = nums.length;
            int[] newNums = new int[len + 1];
            int[] dp = new int[len + 1];
            int[] dpNum = new int[len + 1];
            System.arraycopy(nums, 0, newNums, 1, len);
            newNums[0] = Integer.MIN_VALUE;
            dpNum[0] = 1;

            int glbMax = 0;
            for (int i = 1; i <= len; i++) {
                int max = dp[0];
                int current = newNums[i];
                for (int i1 = 0; i1 < i; i1++) {
                    int pre = newNums[i1];
                    int dpVal = dp[i1];
                    if ( pre < current &&  dpVal > max) {
                        max = dp[i1];
                    }
                }
                dp[i] = max +1;
                if (dp[i] > glbMax) {
                    glbMax = dp[i];
                }
                int sum = 0;
                for (int i1 = 0; i1 < i; i1++) {
                    if ( newNums[i1] < current && dp[i1] == max) {
                        sum += dpNum[i1] ;
                    }
                }
                dpNum[i] = sum;
            }
            int ret = 0;
            for (int i = 1; i < dp.length; i++) {
                if ( dp[i] == glbMax) {
                    ret += dpNum[i];
                }
            }
            return ret;
        }
    }

    public static void main(String[] args) {


        logger.info("{}", new Solution().findNumberOfLIS(new int[]{-100,-99,-98,-97,-96,-96}));//2
        logger.info("{}", new Solution().findNumberOfLIS(new int[]{1,2,4,3,5,4,7,2}));//3
        logger.info("{}", new Solution().findNumberOfLIS(new int[]{2,2,2,2,2}));//5
        logger.info("{}", new Solution().findNumberOfLIS(new int[]{1,3,3}));//2
        logger.info("{}", new Solution().findNumberOfLIS(new int[]{1,3,5,4,7}));//2


    }
}
