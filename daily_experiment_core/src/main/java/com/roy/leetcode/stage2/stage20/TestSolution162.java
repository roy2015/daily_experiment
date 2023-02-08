package com.roy.leetcode.stage2.stage20;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/10/13 09:57
 *
 * 162. 寻找峰值
 * 峰值元素是指其值大于左右相邻值的元素。
 *
 * 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
 *
 * 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
 *
 * 你可以假设 nums[-1] = nums[n] = -∞。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,1]
 * 输出: 2
 * 解释: 3 是峰值元素，你的函数应该返回其索引 2。
 * 示例 2:
 *
 * 输入: nums = [1,2,1,3,5,6,4]
 * 输出: 1 或 5
 * 解释: 你的函数可以返回索引 1，其峰值元素为 2；
 *      或者返回索引 5， 其峰值元素为 6。
 * 说明:
 *
 * 你的解法应该是 O(logN) 时间复杂度的。
 */
public class TestSolution162 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution162.class);


    static class Solution {

        /**
         * 啥O(logN)，O(n) 0ms就完事了，不扯
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：37.9 MB, 在所有 Java 提交中击败了99.97%的用户
         *
         * @param nums
         * @return
         */
        public int findPeakElement(int[] nums) {
            int length = nums.length;
            if (length == 1) {
                return 0;
            }

            int gather =1;
            for (int i = 0; i < length; i++) {
                if ((i+1) == length || nums[i] > nums[i+1]) {
                    gather ++;
                } else {
                    gather = 1;
                }
                if (gather ==2) {
                    return i;
                }
            }
            return -1;
        }

    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().findPeakElement(new int[]{1,2}));//1
        logger.info("{}", new Solution().findPeakElement(new int[]{1,2,3,1}));//2
        logger.info("{}", new Solution().findPeakElement(new int[]{1,2,1,3,5,6,4}));//1或5
        logger.info("{}", new Solution().findPeakElement(new int[]{1}));//0


    }
}
