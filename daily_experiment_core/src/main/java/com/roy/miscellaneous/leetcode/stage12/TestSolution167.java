package com.roy.miscellaneous.leetcode.stage12;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/5/25
 *
 * 167. 两数之和 II - 输入有序数组
给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。

函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。

说明:

返回的下标值（index1 和 index2）不是从零开始的。
你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
示例:

输入: numbers = [2, 7, 11, 15], target = 9
输出: [1,2]
解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 *
 */
public class TestSolution167 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution167.class);


    static class Solution {

        /**
         *
         * 双指针
         *
         * 执行结果：
         通过
         显示详情
         执行用时 :1 ms, 在所有 Java 提交中击败了97.29%的用户
         内存消耗 :40.4 MB, 在所有 Java 提交中击败了6.67%的用户
         *
         * @param numbers
         * @param target
         * @return
         */
        public int[] twoSum(int[] numbers, int target) {
            int len = numbers.length;
            int p = 0, q = len - 1;
            while (p <= q) {
                int pVal = numbers[p];
                int qVal = numbers[q];
                int sum = pVal + qVal;
                if (sum == target) {
                    return new int[]{p +1, q+1};
                } else if (sum > target) {
                    q --;
                } else {
                    p ++;
                }
            }
            return new int[]{p, q};
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().twoSum(new int[]{2, 7, 11, 15}, 9));
    }
}
