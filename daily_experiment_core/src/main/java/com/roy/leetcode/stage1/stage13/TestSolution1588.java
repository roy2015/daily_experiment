package com.roy.leetcode.stage1.stage13;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/1/21 10:40
 *
 * 1588. 所有奇数长度子数组的和
 * 给你一个正整数数组 arr ，请你计算所有可能的奇数长度子数组的和。
 *
 * 子数组 定义为原数组中的一个连续子序列。
 *
 * 请你返回 arr 中 所有奇数长度子数组的和 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [1,4,2,5,3]
 * 输出：58
 * 解释：所有奇数长度子数组和它们的和为：
 * [1] = 1
 * [4] = 4
 * [2] = 2
 * [5] = 5
 * [3] = 3
 * [1,4,2] = 7
 * [4,2,5] = 11
 * [2,5,3] = 10
 * [1,4,2,5,3] = 15
 * 我们将所有值求和得到 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
 * 示例 2：
 *
 * 输入：arr = [1,2]
 * 输出：3
 * 解释：总共只有 2 个长度为奇数的子数组，[1] 和 [2]。它们的和为 3 。
 * 示例 3：
 *
 * 输入：arr = [10,11,12]
 * 输出：66
 *
 *
 * 提示：
 *
 * 1 <= arr.length <= 100
 * 1 <= arr[i] <= 1000
 *
 */
public class TestSolution1588 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1588.class);


    static class Solution {

        /**
         *
         * 执行用时：4 ms, 在所有 Java 提交中击败了24.88%的用户
         * 内存消耗：36.8 MB, 在所有 Java 提交中击败了33.23%的用户
         * @param arr
         * @return
         */
        public int sumOddLengthSubarrays(int[] arr) {
            if (arr == null || arr.length == 0) {
                return 0;
            }
            // 1, 3, 5
            int len = arr.length;
            int max = len;
            if ((len & 1) == 0) {//奇数
                max = len -1;
            }
            int sum = 0;
            for (int i = 1; i <= max; i +=2) {//几个数 1,3,5
                int subSum = 0;
                for (int j = 0; j + i <= len; j++) {//start idx
                    for (int k = 0; k < i; k++) {
                        subSum += arr[j + k];
                    }
                }
                sum += subSum;
            }
            return sum;
        }

    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().sumOddLengthSubarrays(new int[]{ 1,4,2,5,3 }));
    }
}
