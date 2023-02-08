package com.guo.roy.research.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/8/8
 *
 *
 * 面试题 17.04. 消失的数字
 * 数组nums包含从0到n的所有整数，但其中缺了一个。请编写代码找出那个缺失的整数。你有办法在O(n)时间内完成吗？
 *
 * 注意：本题相对书上原题稍作改动
 *
 * 示例 1：
 *
 * 输入：[3,0,1]
 * 输出：2
 *
 *
 * 示例 2：
 *
 * 输入：[9,6,4,2,3,5,7,0,1]
 * 输出：8
 *
 *
 */
public class TestSolutionInterview1704 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolutionInterview1704.class);

    static class Solution {

        /**
         *  三分钟搞定。。。
         * @param nums
         * @return
         */
        public int missingNumber(int[] nums) {
            int len = nums.length;
            int sum = (1 + len) * len /2 ;
            int actualSum = 0;
            for(int i = 0; i < len; i++) {
                actualSum += nums[i];
            }
            return sum - actualSum;
        }
    }

    public static void main(String[] args) {
        logger.info("{}",new Solution().missingNumber(new int[]{3,0,1}));//2
        logger.info("{}",new Solution().missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));//8
    }
}
