package com.roy.miscellaneous.leetcode.stage3;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2021/6/11
 * 有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 *
 * 现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得 nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。 这里的 i - 1 和 i + 1 代表和 i 相邻的两个气球的序号。如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。
 *
 * 求所能获得硬币的最大数量。
 *
 *  
 *
 * 示例 1：
 * 输入：nums = [3,1,5,8]
 * 输出：167
 * 解释：
 * nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
 * coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167
 * 示例 2：
 *
 * 输入：nums = [1,5]
 * 输出：10
 *  
 *
 * 提示：
 *
 * n == nums.length
 * 1 <= n <= 500
 * 0 <= nums[i] <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/burst-balloons
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestSolution312 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution312.class);


    static class Solution {
        /**
         *
         *
         * 提交结果	执行用时	内存消耗	语言	提交时间	备注
         * 通过	77 ms	38.1 MB	Java	2021/06/15 10:48
         * @param nums
         * @return
         */
        public int maxCoins(int[] nums) {
            int originalLen = nums.length;
            if (originalLen == 1 ) {
                return nums[0];
            }

            int dpLen = originalLen + 2;
            int[][] dp = new int[dpLen][dpLen];
            int[] valArray = new int[dpLen];
            valArray[0] = 1;
            valArray[dpLen -1] = 1;
            for (int i = 0; i < originalLen; i++) {
                valArray[i + 1] = nums[i];
            }

            for (int i = dpLen - 1; i >= 0 ; i--) {
                for (int j = 0; j < dpLen; j++) {
                    if (j <= i) {
                        dp[i][j] = 0;
                    } else if (j - i == 1) {
                        dp[i][j] = 0;
                    } else {
                        int max = 0;
                        int candidateVal;
                        for (int k = i + 1; k < j; k++) {
                            candidateVal = dp[i][k] + valArray[i] * valArray[k] * valArray[j] + dp[k][j];
                            if (candidateVal > max) {
                                max = candidateVal;
                            }
                        }
                        dp[i][j] = max;
                    }
                }
            }


            return dp[0][dpLen -1];
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution());
    }
}
