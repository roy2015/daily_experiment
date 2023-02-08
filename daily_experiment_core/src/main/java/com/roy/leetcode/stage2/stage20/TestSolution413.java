package com.roy.leetcode.stage2.stage20;

import org.slf4j.LoggerFactory;

/**
 *
 * 413. 等差数列划分
 * 如果一个数列至少有三个元素，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 *
 * 例如，以下数列为等差数列:
 *
 * 1, 3, 5, 7, 9
 * 7, 7, 7, 7
 * 3, -1, -5, -9
 * 以下数列不是等差数列。
 *
 * 1, 1, 2, 5, 7
 *
 *
 * 数组 A 包含 N 个数，且索引从0开始。数组 A 的一个子数组划分为数组 (P, Q)，P 与 Q 是整数且满足 0<=P<Q<N 。
 *
 * 如果满足以下条件，则称子数组(P, Q)为等差数组：
 *
 * 元素 A[P], A[p + 1], ..., A[Q - 1], A[Q] 是等差的。并且 P + 1 < Q 。
 *
 * 函数要返回数组 A 中所有为等差数组的子数组个数。
 *
 *
 *
 * 示例:
 *
 * A = [1, 2, 3, 4]
 *
 * 返回: 3, A 中有三个子等差数组: [1, 2, 3], [2, 3, 4] 以及自身 [1, 2, 3, 4]。
 *
 *
 * @author guojun
 * @date 2021/6/11
 */
public class TestSolution413 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution413.class);


    static class Solution {
        public int numberOfArithmeticSlices(int[] nums) {
            int len = nums.length;
            if (len < 3) {
                return 0;
            }
            int[] dp = new int[len];
            int sum =0;
            dp[0]=dp[1]=0;
            for(int i=2;i < len;i++) {
                if ((nums[i]-nums[i-1]) == (nums[i-1]-nums[i-2])) {
                    dp[i] = dp[i-1] +1;
                    sum += dp[i];
                }
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().numberOfArithmeticSlices(new int[]{1,2,3,4}));
    }
}
