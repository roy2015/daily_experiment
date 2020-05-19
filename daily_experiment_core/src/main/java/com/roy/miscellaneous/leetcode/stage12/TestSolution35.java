package com.roy.miscellaneous.leetcode.stage12;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/5/19
 *
 * 35. 搜索插入位置
给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

你可以假设数组中无重复元素。

示例 1:

输入: [1,3,5,6], 5
输出: 2
示例 2:

输入: [1,3,5,6], 2
输出: 1
示例 3:

输入: [1,3,5,6], 7
输出: 4
示例 4:

输入: [1,3,5,6], 0
输出: 0
 */
public class TestSolution35 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution35.class);


    static class Solution {

        /**
         *
         * 除了最后一行 return p;其他代码实际上就是二分查找（手写二分查找，也可以去参考
         * java.util.Arrays#binarySearch0(int[], int)）
         *
         * 执行结果：
         通过
         显示详情
         执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
         内存消耗 :39.2 MB, 在所有 Java 提交中击败了5.55%的用户
         * @param nums
         * @param target
         * @return
         */
        public int searchInsert(int[] nums, int target) {
            int len = nums.length;
            int len_1 = len -1;

            if (target < nums[0]) {
                return 0;
            }
            if (target > nums[len_1]) {
                return len;
            }

            int p = 0;
            int q = len_1;
            int midVal =0;
            int mid = 0;
            while (p <= q) {
                mid = (p + q) /2;
                midVal = nums[mid];
                if (target == midVal) {
                    return mid;
                } else if (target > midVal) {
                    p = mid + 1;
                } else {
                    q = mid -1;
                }
            }
            return p;

        }

    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().searchInsert(new int[]{1,3,5,7}, 6));//3
        logger.info("{}", new Solution().searchInsert(new int[]{1,3,5,6}, 5));//2
        logger.info("{}", new Solution().searchInsert(new int[]{1,3,5,6}, 2));//1
        logger.info("{}", new Solution().searchInsert(new int[]{1,3,5,6}, 7));//4
        logger.info("{}", new Solution().searchInsert(new int[]{1,3,5,6}, 0));//0
    }
}
