package com.roy.miscellaneous.leetcode.stage1.stage12;

import java.util.Arrays;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/5/19
 * 628. 三个数的最大乘积
给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。

示例 1:

输入: [1,2,3]
输出: 6
示例 2:

输入: [1,2,3,4]
输出: 24
注意:

给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。
输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。
 *
 */
public class TestSolution628 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution628.class);


    //给定的整型数组长度范围是[3,104]
    static class Solution {

        /**
         *
         * 要考虑正负，不能简单的排序，在后三个相乘
         *
         * 执行结果：
         通过
         显示详情
         执行用时 :12 ms, 在所有 Java 提交中击败了70.28%的用户
         内存消耗 :41.9 MB, 在所有 Java 提交中击败了7.69%的用户
         *
         * @param nums
         * @return
         */
        public int maximumProduct(int[] nums) {
            int len = nums.length;
            if (len == 3) {
                return nums[len -1] * nums[len -2] *nums[len -3];
            }
            Arrays.sort(nums);
            //全部非负或者全部非正
            if (nums[len-1] <= 0 || nums[0] >= 0) {
                return nums[len -1] * nums[len -2] *nums[len -3];
            }

            int negtiveFistTwo = nums[0] * nums[1];
            int passtiveFistTwo = nums[len -2] * nums[len-3];
            return negtiveFistTwo > passtiveFistTwo ?
                    negtiveFistTwo * nums[len-1]  :
                    passtiveFistTwo  * nums[len -1];
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().maximumProduct(
                new int[]{-4,-3,-2,-1}));//-6

        logger.info("{}", new Solution().maximumProduct(
                new int[]{4,3,2,1}));//24

        logger.info("{}", new Solution().maximumProduct(
                new int[]{-4,-3,1}));//12

        logger.info("{}", new Solution().maximumProduct(
                new int[]{-4,-3,-2,-1,60}));//720

    }
}
