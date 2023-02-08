package com.guo.roy.research.leetcode.stage2.stage22;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/9/17
 *
 *
 *213. 打家劫舍 II
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * 示例 1:
 *
 * 输入: [2,3,2]
 * 输出: 3
 * 解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * 示例 2:
 *
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 *
 *
 *
 *
 *
 */
public class TestSolution213 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution213.class);


    static class Solution {
        /**
         *
         * 硬是画01二叉树把动态方程给推导出来了
         *
         * 根据是否偷第一家分成两个问题f0(不偷), f1(偷)
         * f0：  从1偷到n-1
         * f1:   从2偷到n-2
         *
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：36.8 MB, 在所有 Java 提交中击败了5.11%的用户
         *
         * @param nums
         * @return
         */
        public int rob(int[] nums) {
            int len = nums.length;
            if (len == 0) {
                return 0;
            } else if(len == 1) {
                return nums[0];
            } else if (len == 2) {
                return Math.max(nums[0], nums[1]);
            } else if (len == 2) {
                return Math.max(Math.max(nums[0], nums[1]), nums[2]);
            } else {}

            int f0 = 0;
            int f1 = nums[0];

            //f0问题  从1偷到n-1
            int pVal =  0;//上轮偷的最大值
            int pnVal = 0;//上轮不偷的最大值
            int cVal =  0;//本轮偷的最大值
            int cnVal = 0;//本轮不偷的最大值

            int f0Val = 0;

            for (int i = 1; i < len; i++) {
                int value = nums[i];
                cVal = pnVal + value;
                cnVal = Math.max(pnVal, pVal);

                pnVal = cnVal;
                pVal = cVal;
            }
            f0Val = Math.max(cnVal, cVal);
            f0Val += f0;

            //f1问题  从2偷到n-2
            pVal =  0;
            pnVal = 0;
            cVal =  0;
            cnVal = 0;
            int f1Val = 0;
            for (int i = 2; i < len - 1; i++) {
                int value = nums[i];
                cVal = pnVal + value;
                cnVal = Math.max(pnVal, pVal);

                pnVal = cnVal;
                pVal = cVal;
            }
            f1Val = Math.max(cnVal, cVal);
            f1Val += f1;

            return Math.max(f0Val, f1Val);
        }
    }

    public static void main(String[] args) {

        logger.info("{}", new Solution().rob(new int[]{2,3,2,7,8,9,10, 12,1,6}));//37
        logger.info("{}", new Solution().rob(new int[]{2,3,2}));//3
        logger.info("{}", new Solution().rob(new int[]{1,2,3,1}));//4

    }
}
