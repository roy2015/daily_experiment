package com.roy.leetcode.stage1.stage12;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/6/28
 *
 * 674. 最长连续递增序列
 * 给定一个未经排序的整数数组，找到最长且连续的的递增序列，并返回该序列的长度。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [1,3,5,4,7]
 * 输出: 3
 * 解释: 最长连续递增序列是 [1,3,5], 长度为3。
 * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为5和7在原数组里被4隔开。
 * 示例 2:
 *
 * 输入: [2,2,2,2,2]
 * 输出: 1
 * 解释: 最长连续递增序列是 [2], 长度为1。
 *
 *
 * 注意：数组长度不会超过10000。
 */
public class TestSolution674 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution674.class);


    static class Solution {

        /**
         *
         * 双指针
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 1 ms, 在所有 Java 提交中击败了99.78%的用户
         * 内存消耗：
         * 40 MB, 在所有 Java 提交中击败了12.50%的用户
         *
         * @param nums
         * @return
         */
        public int findLengthOfLCIS(int[] nums) {
            int length = nums.length;
            if (length == 0) {
                return 0;
            }
            if (length == 1) {
                return 1;
            }

            int maxLCIS = 1;
            int p =0;
            int q = 1;

            while (p < length && q < length) {
                //no chance bigger than maxLCIS, return
                if (p + maxLCIS >= length) {
                    return maxLCIS;
                }

                int tmpLen;
                //find first element that  less than nums[p]
                while ( q < length && nums[q] > nums[q - 1]) {
                    q ++;
                }
                tmpLen = q -p;

                if (tmpLen > maxLCIS) {
                    maxLCIS = tmpLen;
                }
                p = q;
                q ++;
            }
            return maxLCIS;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().findLengthOfLCIS(new int[]{}));//0
        logger.info("{}", new Solution().findLengthOfLCIS(new int[]{1,3,5,4,7}));//3
        logger.info("{}", new Solution().findLengthOfLCIS(new int[]{2,2,2,2,2}));//1
    }
}
