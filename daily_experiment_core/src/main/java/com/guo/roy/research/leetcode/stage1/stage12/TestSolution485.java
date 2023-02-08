package com.guo.roy.research.leetcode.stage1.stage12;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/8/4
 *
 *
 * 485. 最大连续1的个数
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 *
 * 示例 1:
 *
 * 输入: [1,1,0,1,1,1]
 * 输出: 3
 * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 * 注意：
 *
 * 输入的数组只包含 0 和1。
 * 输入数组的长度是正整数，且不超过 10,000。
 *
 *
 *
 */
public class TestSolution485 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution485.class);


    static class Solution {
        /**
         *
         * 300 milestone completed!
         *
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 1 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：
         * 41.4 MB, 在所有 Java 提交中击败了73.64%的用户
         *
         * @param nums
         * @return
         */
        public int findMaxConsecutiveOnes(int[] nums) {
            //输入数组的长度是正整数
            int idx = 0;
            int maxConsecutiveOnes = 0;
            int len = nums.length;
            while (idx < len) {
                //find first 1
                while (idx < len && nums[idx] == 0) {
                    idx ++;
                }
                if (idx == len) {
                    continue;
                }
                int start = idx;//start: 1 place idx

                //find 0
                idx ++;
                while (idx < len && nums[idx] == 1) {
                    idx ++;
                }

                int curLen = idx - start;
                if (curLen > maxConsecutiveOnes) {
                    maxConsecutiveOnes = curLen;
                }
            }
            return maxConsecutiveOnes;
        }

    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().findMaxConsecutiveOnes(new int[]{1}));//1
        logger.info("{}", new Solution().findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}));//3
    }
}
