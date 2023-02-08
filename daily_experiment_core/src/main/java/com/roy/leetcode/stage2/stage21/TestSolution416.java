package com.roy.leetcode.stage2.stage21;

import org.slf4j.LoggerFactory;

/**
 *
 * 416. 分割等和子集
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 * 示例 2：
 *
 * 输入：nums = [1,2,3,5]
 * 输出：false
 * 解释：数组不能分割成两个元素和相等的子集。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 *
 *
 * @author guojun
 * @date 2021/6/11
 */
public class TestSolution416 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution416.class);


    static class Solution {

        /**
         *
         * 想了半夜想出来的dfs肯定超时，看了提示说是要背包，瞬间豁然开朗，算是90%吧，比较没看任何别人代码，
         * 还优化了dp,简单的背包对于这个问题是要二维数组，优化成以为数组
         *
         * 执行结果：通过
         * 显示详情
         * 添加备注
         *
         * 执行用时：
         * 13 ms, 在所有 Java 提交中击败了97.17%的用户
         * 内存消耗：
         * 40.9 MB, 在所有 Java 提交中击败了44.13%的用户
         * 通过测试用例：
         * 117 / 117
         *
         *
         * @param nums
         * @return
         */
        public boolean canPartition(int[] nums) {
            int length = nums.length;
            if (length == 1) {
                return false;
            }
            int sum = 0;
            int max = 0;
            //统计半数和最大数
            for (int i = 0; i < length; i++) {
                int iVal = nums[i];
                if (iVal > max) {
                    max = iVal;
                }
                sum += iVal;
            }
            //总和奇数 false
            if ((sum & 0x1) == 1) {
                return false;
            }
            int avg = (sum >> 1);
            //最大数大于半数 false
            if (max > avg) {
                return false;
            }
            //背包问题
            //dp从后往前，这样就只需要一维数组，否则从后往前要用二维数组
            int[] dp = new int[avg + 1];
            for (int i = 0; i < length ; i++) {
                int num = nums[i];
                for (int j = avg; j > 0 ; j--) {
                    if (num == j) {
                        dp[j] = 1;
                    } else if (num < j) {
                        if (dp[j] != 1) {
                            dp[j] = dp[j - num];
                        }
                    } else {
                        //pass
                    }
                    if (j == avg && dp[avg] == 1) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().canPartition(new int[]{7,8,5,3}));//true
        logger.info("{}", new Solution().canPartition(new int[]{1}));//false
        logger.info("{}", new Solution().canPartition(new int[]{1,5,5,11}));//true
        logger.info("{}", new Solution().canPartition(new int[]{1,2,3,5}));//false
    }
}
