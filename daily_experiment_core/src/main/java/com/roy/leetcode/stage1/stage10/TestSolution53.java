package com.roy.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/8/3
 *
 *
 * 53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 *
 */
public class TestSolution53 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution53.class);


    static class Solution {

        /**
         *
         * DP 0/1背包问题吧，靠感觉写出来的~
         * 主要是 当前"取或不取"的求值和前一个元素的"取或没取"有关，和其他元素无关，四种情况判断就是了
         * 主要有坑： 全是负数的情况，全部不取，最终结果0,但题目说必须取一个，那就O(n)遍历的时顺便把
         * max Element带出来就OK了
         *
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 1 ms, 在所有 Java 提交中击败了95.45%的用户
         * 内存消耗：
         * 39.7 MB, 在所有 Java 提交中击败了69.59%的用户
         *
         * @param nums
         * @return
         */
        public int maxSubArray(int[] nums) {
            int preNoPick = 0;
            int prePick = 0;

            int maxVal = nums[0];

            for (int num : nums) {
                if (num > maxVal) {
                    maxVal = num;
                }
                //no pick 本次不取的话求上次取和不取的最大值
                int currentNoPick = Math.max(preNoPick, prePick);
                //pick 本次取的话求上次取和取i的最大值
                int currentPick = Math.max(num, prePick + num);
                preNoPick = currentNoPick;
                prePick = currentPick;
            }

            int retVal = Math.max(preNoPick, prePick);
            if (retVal == 0) {
                return maxVal;
            } else return retVal;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().maxSubArray(new int[]{-2,-1}));//-1
        logger.info("{}", new Solution().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));//6
        logger.info("{}", new Solution().maxSubArray(new int[]{-2}));//-2




    }
}
