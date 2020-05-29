package com.roy.miscellaneous.leetcode.stage1.stage12;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/5/24
 *
 *
 * 724. 寻找数组的中心索引
给定一个整数类型的数组 nums，请编写一个能够返回数组“中心索引”的方法。

我们是这样定义数组中心索引的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。

如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。

示例 1:

输入:
nums = [1, 7, 3, 6, 5, 6]
输出: 3
解释:
索引3 (nums[3] = 6) 的左侧数之和(1 + 7 + 3 = 11)，与右侧数之和(5 + 6 = 11)相等。
同时, 3 也是第一个符合要求的中心索引。
示例 2:

输入:
nums = [1, 2, 3]
输出: -1
解释:
数组中不存在满足此条件的中心索引。
说明:

nums 的长度范围为 [0, 10000]。
任何一个 nums[i] 将会是一个范围在 [-1000, 1000]的整数。
 *
 */
public class TestSolution724 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution724.class);


    static class Solution {

        /**
         *
         *
         * 算法复杂度 <= 2* O(n)
         *
         * 执行结果：
         通过
         显示详情
         执行用时 :1 ms, 在所有 Java 提交中击败了100.00%的用户
         内存消耗 :40.6 MB
         , 在所有 Java 提交中击败了14.29%的用户
         *
         * @param nums
         * @return
         */
        public int pivotIndex(int[] nums) {
            int len = nums.length;
            //1. 求和
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }

            int areadySum =0;
            for (int i = 0; i < len; i++) {
                int val = nums[i];
                if (sum - val == areadySum * 2 ) {
                    return i;
                }
                areadySum += val;
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));//3
        logger.info("{}", new Solution().pivotIndex(new int[]{5}));//0
        logger.info("{}", new Solution().pivotIndex(new int[]{0,3}));//1
        logger.info("{}", new Solution().pivotIndex(new int[]{1,2,3}));//-1
    }
}
