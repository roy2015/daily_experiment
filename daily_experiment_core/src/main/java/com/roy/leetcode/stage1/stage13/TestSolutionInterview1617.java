package com.roy.leetcode.stage1.stage13;

import org.slf4j.LoggerFactory;

/**
 *  @author guojun
 *  @date 2020/8/13
 *
 *  面试题 16.17. 连续数列
 * 给定一个整数数组，找出总和最大的连续数列，并返回总和。
 *
 * 示例：
 *
 * 输入： [-2,1,-3,4,-1,2,1,-5,4]
 * 输出： 6
 * 解释： 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶：
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 *
 */
public class TestSolutionInterview1617 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolutionInterview1617.class);

    static class Solution {
        /**
         *
         * DP,感觉路子比较野~
         *
         * 当前元素的选与不选对dp的影响只和 "前面所有元素的(最后一个未选)最大连续和" "前面所有元素的(最后一个选)最大连续和"
         * 主要是特殊情况的考虑， "maxNoSelecedSum ==0，一个元素都不选，只能选最大的元素"
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：1 ms, 在所有 Java 提交中击败了95.90%的用户
         * 内存消耗：39.7 MB, 在所有 Java 提交中击败了57.98%的用户
         * @param nums
         * @return
         */
        public int maxSubArray(int[] nums) {
            int length = nums.length;

            int maxSelecedSum = nums[0];
            int maxNoSelecedSum = 0;
            int maxEl = nums[0];

            for (int i = 1; i < length; i++) {
                int num = nums[i];
                if (num > maxEl) {
                    maxEl = num;
                }
                int tmpMaxSelecedSum =  Math.max(maxSelecedSum + num, num);
                int tmpMaxNoSelecedSum = Math.max(maxSelecedSum, maxNoSelecedSum);
                maxNoSelecedSum = tmpMaxNoSelecedSum;
                maxSelecedSum = tmpMaxSelecedSum;
            }

            if (maxNoSelecedSum == 0) {
                return maxEl;
            } else {
                return Math.max(maxSelecedSum, maxNoSelecedSum);
            }
        }

    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().maxSubArray(new int[]{-1,-2,2}));//2
        logger.info("{}", new Solution().maxSubArray(new int[]{-1}));//-1
        logger.info("{}", new Solution().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));//6
    }

}
