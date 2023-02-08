package com.guo.roy.research.leetcode.stage2.stage21;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/11/16
 *
 *
 * 152. 乘积最大子数组
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 *
 *
 */
public class TestSolution152 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution152.class);


    static class Solution {


        /**
         * 动态规划的思路，主要是每次保留最小值最大值
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 2 ms
         * , 在所有 Java 提交中击败了
         * 89.05%
         * 的用户
         * 内存消耗：
         * 38.3 MB
         * , 在所有 Java 提交中击败了
         * 83.87%
         * 的用户
         *
         * @param nums
         * @return
         */
        public int maxProduct(int[] nums) {
            int len = nums.length;
            int max = nums[0];
            int imax = nums[0];
            int imin = nums[0];
            for (int i = 1; i < len; i++) {
                //求三个数里的最小值，最大值 （imax*nums[i], imix*nums[i], nums[i]）
                int a = Math.max(nums[i], imax * nums[i]);
                a = Math.max(a, imin * nums[i]);

                int b = Math.min(nums[i], imin * nums[i]);
                b = Math.min(b, imax * nums[i]);

                imax = a;
                imin = b;
                if (imax > max) {
                    max = imax;
                }
            }
            return max;
        }

        /**
         * 通过了所有的测试用例，但算超时？
         * @param nums
         * @return
         */
        public int maxProduct1(int[] nums) {
            int retMax = nums[0];
            int len = nums.length;
            int[] prefixProduct = new int[len];
            prefixProduct[0] = nums[0];

            //初始前缀积
            for (int i = 1; i < nums.length; i++) {
                prefixProduct[i] = (prefixProduct[i-1] == 0) ? nums[i]  : prefixProduct[i-1] * nums[i];
            }
            //初始前缀积的差集
            for (int i = nums.length -1; i >= 0; i--) {
                int resetVal = prefixProduct[i];
                int max = resetVal;
                int temp;
                for (int j = i-1; j >= 0 ; j--) {
                    temp = prefixProduct[j] == 0 ? prefixProduct[i] : prefixProduct[i] / prefixProduct[j];
                    if (temp > max) {
                        max = temp;
                    }
                    if (nums[j] == 0) {
                        prefixProduct[i] = 0;
                    }
                }
                //reset i
                prefixProduct[i] = resetVal;
                if (max > retMax) {
                    retMax = max;
                }
            }
            return retMax;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().maxProduct(new int[]{2,3,-2,4}));//6
        logger.info("{}", new Solution().maxProduct(new int[]{0,-1,0,-3}));//0
        logger.info("{}", new Solution().maxProduct(new int[]{-1,0,-2,2}));//2
        logger.info("{}", new Solution().maxProduct(new int[]{0,2,0}));//2
        logger.info("{}", new Solution().maxProduct(new int[]{-2,0,-1}));//0
        logger.info("{}", new Solution().maxProduct(new int[]{0,2}));//2
        logger.info("{}", new Solution().maxProduct(new int[]{-1,0,-2,2,-2}));//8
    }
}
