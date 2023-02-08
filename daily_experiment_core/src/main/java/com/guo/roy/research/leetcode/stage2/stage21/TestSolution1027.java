package com.guo.roy.research.leetcode.stage2.stage21;

import org.slf4j.LoggerFactory;

/**
 * 1027. 最长等差数列
 * 给你一个整数数组 nums，返回 nums 中最长等差子序列的长度。
 *
 * 回想一下，nums 的子序列是一个列表 nums[i1], nums[i2], ..., nums[ik] ，且 0 <= i1 < i2 < ... < ik <= nums.length - 1。并且如果 seq[i+1] - seq[i]( 0 <= i < seq.length - 1) 的值都相同，那么序列 seq 是等差的。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [3,6,9,12]
 * 输出：4
 * 解释：
 * 整个数组是公差为 3 的等差数列。
 * 示例 2：
 *
 * 输入：nums = [9,4,7,2,10]
 * 输出：3
 * 解释：
 * 最长的等差子序列是 [4,7,10]。
 * 示例 3：
 *
 * 输入：nums = [20,1,15,3,10,5,8]
 * 输出：4
 * 解释：
 * 最长的等差子序列是 [20,15,10,5]。
 *
 *
 * 提示：
 *
 * 2 <= nums.length <= 1000
 * 0 <= nums[i] <= 500
 * @author guojun
 * @date 2021/6/11
 */
public class TestSolution1027 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1027.class);


    static class Solution {

        /**
         * 执行结果：通过
         * 显示详情
         * 添加备注
         *
         * 执行用时：2703 ms, 在所有 Java 提交中击败了5.03%的用户
         * 内存消耗：49.2 MB, 在所有 Java 提交中击败了49.77%的用户
         * 通过测试用例：62 / 62
         * @param nums
         * @return
         */
        public int longestArithSeqLength(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            if (nums.length == 1) {
                return 1;
            }
            int length = nums.length;
            int res = 0;
            //数据准备
            int[][] dp = new int[length][length];
            for (int i = 0; i < length; i++) {
                for (int j = i +1; j < length; j++) {
                    dp[i][j] = nums[i] - nums[j];
                }
            }
            //begin
            for (int i = 0; i < length -1; i++) {
                for (int j = i +1; j < length; j++) {
                    int tmpRes = 1;
                    if (j == length -1) {
                        if (tmpRes > res) {
                            res = tmpRes;
                        }
                        break;
                    }
                    int gap = nums[i] - nums[j];
                    int copyJ = j;
                    while (true) {
                        int k;
                        for (k = copyJ + 1; k < length ; k++) {
                            if ((nums[copyJ] - nums[k]) == gap) {
                                copyJ = k;
                                tmpRes ++;
                                break;
                            }
                        }
                        if (k == length) {
                            break;
                        }
                    }
                    if (tmpRes > res) {
                        res = tmpRes;
                    }
                }
            }
            return res +1;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().longestArithSeqLength(new int[]{20,1,15,3,10,5,8}));//4
        logger.info("{}", new Solution().longestArithSeqLength(new int[]{3,6,9,12}));//4
        logger.info("{}", new Solution().longestArithSeqLength(new int[]{9,4,7,2,10}));//3

    }
}
