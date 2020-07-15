package com.roy.miscellaneous.leetcode.stage1.stage13;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/7/15
 *
 * 643. 子数组最大平均数 I
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 *
 * 示例 1:
 *
 * 输入: [1,12,-5,-6,50,3], k = 4
 * 输出: 12.75
 * 解释: 最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 *
 *
 * 注意:
 *
 * 1 <= k <= n <= 30,000。
 * 所给数据范围 [-10,000，10,000]。
 *
 *
 */
public class TestSolution643 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution643.class);



    static class Solution {
        public double findMaxAverage(int[] nums, int k) {
            //1 <= k <= n <= 30,000。
            int len = nums.length;
            int minIdx = k -1;
            int maxSum = 0 ;
            boolean initMaxSum = false;
            for (int i = len -1; i >= minIdx ; i--) {
                int tmpSum = 0;
                // sum K elements
                for (int j = i - k + 1; j <= i ; j++) {
                    tmpSum += nums[j];
                }
                if (!initMaxSum) {
                    maxSum = tmpSum;
                    initMaxSum = true;
                } else if (tmpSum > maxSum) {
                    maxSum = tmpSum;
                }
            }
            return maxSum / (double)k;
        }

    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().findMaxAverage(new int[]{
                8860,-853,6534,4477,-4589,8646,-6155,-5577,-1656,-5779,-2619,-8604,-1358,-8009,4983,7063,3104,
                -1560,4080,2763,5616,-2375,2848,1394,-7173,-5225,-8244,-809,8025,-4072,-4391,-9579,1407,6700,2421,
                -6685,5481,-1732,-8892,-6645,3077,3287,-4149,8701,-4393,-9070,-1777,2237,-3253,-506,-4931,-7366,
                -8132,5406,-6300,-275,-1908,67,3569,1433,-7262,-437,8303,4498,-379,3054,-6285,4203,6908,4433,3077,
                2288,9733,-8067,3007,9725,9669,1362,-2561,-4225,5442,-9006,-429,160,-9234,-4444,3586,-5711,-9506,-79,
                -4418,-4348,-5891
        },93));
        logger.info("{}", new Solution().findMaxAverage(new int[]{-1},1));
        logger.info("{}", new Solution().findMaxAverage(new int[]{1,12,-5,-6,50,3},4));
    }
}
