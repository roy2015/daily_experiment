package com.guo.roy.research.leetcode.stage1.stage11;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/5/10 22:10
 * 665. 非递减数列
给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。

我们是这样定义一个非递减数列的： 对于数组中所有的 i (1 <= i < n)，总满足 array[i] <= array[i + 1]。



示例 1:

输入: nums = [4,2,3]
输出: true
解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
示例 2:

输入: nums = [4,2,1]
输出: false
解释: 你不能在只改变一个元素的情况下将其变为非递减数列。


说明：

1 <= n <= 10 ^ 4
- 10 ^ 5 <= nums[i] <= 10 ^ 5
 */
public class TestSolution665 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution665.class);


    static class Solution {

        /**
         *
         * testcse 调试出来的，有点懵逼
         *
         * 执行结果：通过显示详情
         * 执行用时 :1 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗 :40.9 MB, 在所有 Java 提交中击败了16.67%的用户
         * @param nums
         * @return
         */

        public boolean checkPossibility(int[] nums) {
            int len = nums.length;
            int p;
            //找第一个不是递增的数字
            for (p = 0; p < len -1 ; p++) {
                int tmp = nums[p ];
                if (nums[p +1] < tmp) {
                    break;
                }
            }
            //全部是递增或者是倒数第二个元素不合要求的
            if (p == len - 1 || p == len -2) {
                return true;
            }
            //倒数第三个（含）或者之前就已经不合要求的
            int preVal;
            int curVal = nums[p];
            if (p ==0) {
                preVal = - 100000;
            } else {
                preVal = nums[p -1];
            }

            int i = p+1;
            int min = nums[p +1];
            for (; i < len; i++) {
                if (nums[i] < min) {
                    return false;
                }
                if ( ( nums[i] < curVal && nums[i] < preVal)) {
                    min = curVal;
                } else if (nums[i] > min) {
                    min = nums[i];
                }
            }
            return true;
        }
    }
    public static void main(String[] args) {
        logger.info("{}", new Solution().checkPossibility(new int[]{1,3 ,4, 2, 5}));//true
        logger.info("{}", new Solution().checkPossibility(new int[]{1,3,4,2,5}));//true
        logger.info("{}", new Solution().checkPossibility(new int[]{1,5,4,6,7,10,8,9}));//false
        logger.info("{}", new Solution().checkPossibility(new int[]{4, 2,3}));//true
        logger.info("{}", new Solution().checkPossibility(new int[]{4, 2,1}));//false
        logger.info("{}", new Solution().checkPossibility(new int[]{3,4, 2,3}));//false
        logger.info("{}", new Solution().checkPossibility(new int[]{2,3,3, 2,4}));//true
        logger.info("{}", new Solution().checkPossibility(new int[]{1,3,5, 2,4}));//false
        logger.info("{}", new Solution().checkPossibility(new int[]{3,3, 2,2}));//false
    }
}
