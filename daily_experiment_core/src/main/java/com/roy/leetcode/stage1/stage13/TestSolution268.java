package com.roy.leetcode.stage1.stage13;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/7/16
 *
 * 268. 缺失数字
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [3,0,1]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 *
 *
 * 说明:
 * 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
 */
public class TestSolution268 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution268.class);


    static class Solution {
        /**
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：
         * 40.7 MB, 在所有 Java 提交中击败了6.67%的用户
         *
         * @param nums
         * @return
         */
        public int missingNumber(int[] nums) {
            int n = nums.length;
            int expectSum = n * (n + 1) / 2;
            int actualSum = 0;
            for (int num : nums) {
                actualSum += num;
            }
            return expectSum - actualSum;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().missingNumber(new int[]{3,0,1}));//2
        logger.info("{}", new Solution().missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));//8
    }
}
