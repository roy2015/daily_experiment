package com.roy.leetcode.stage1.stage13;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/7/13
 *
 * 1512. 好数对的数目
 * 给你一个整数数组 nums 。
 *
 * 如果一组数字 (i,j) 满足 nums[i] == nums[j] 且 i < j ，就可以认为这是一组 好数对 。
 *
 * 返回好数对的数目。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,1,1,3]
 * 输出：4
 * 解释：有 4 组好数对，分别是 (0,3), (0,4), (3,4), (2,5) ，下标从 0 开始
 * 示例 2：
 *
 * 输入：nums = [1,1,1,1]
 * 输出：6
 * 解释：数组中的每组数字都是好数对
 * 示例 3：
 *
 * 输入：nums = [1,2,3]
 * 输出：0
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 */
public class TestSolution1512 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1512.class);


    static class Solution {
        /**
         *
         * 双指针，双百，也可以用排列组合来做 c(n, k)= n!/((n-k)!k!) k =2
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 1 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：
         * 37.1 MB, 在所有 Java 提交中击败了100.00%的用户
         *
         * @param nums
         * @return
         */
        public int numIdenticalPairs(int[] nums) {
            int sum = 0;
            int len = nums.length;
            for (int i = 0; i < len -1; i++) {
                int iVal = nums[i];
                for (int j = i +1; j < len; j++) {
                    if (iVal == nums[j]) {
                        sum ++;
                    }
                }
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().
                numIdenticalPairs(new int[]{1}));//0
        logger.info("{}", new Solution().
                numIdenticalPairs(new int[]{1,2,3,1,1,3}));//4
        logger.info("{}", new Solution().
                numIdenticalPairs(new int[]{1,1,1,1}));//6
        logger.info("{}", new Solution().
                numIdenticalPairs(new int[]{1,2,3}));//0

    }
}
