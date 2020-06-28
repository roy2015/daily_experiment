package com.roy.miscellaneous.leetcode.stage1.stage12;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/6/28
 *
 *
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 * 一个长度为n的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [0,1,3]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 *
 *
 * 限制：
 *
 * 1 <= 数组长度 <= 10000
 */
public class TestSolutionJZoffer53II {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolutionJZoffer53II.class);


    static class Solution {

        /**
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：
         * 40.5 MB, 在所有 Java 提交中击败了100.00%的用户
         *
         * @param nums
         * @return
         */
        public int missingNumber(int[] nums) {
            int i =0;
            for(; i< nums.length; i++) {
                int idxVal = nums[i];
                if (idxVal != i) {
                    return i;
                }
            }
            return i;
        }



    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().missingNumber(new int[]{0,1,3}));
    }
}
