package com.roy.miscellaneous.leetcode.stage2.stage20;

import org.slf4j.LoggerFactory;

/**
 *
 * 396. 旋转函数
 * 给定一个长度为 n 的整数数组 A 。
 *
 * 假设 Bk 是数组 A 顺时针旋转 k 个位置后的数组，我们定义 A 的“旋转函数” F 为：
 *
 * F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1]。
 *
 * 计算F(0), F(1), ..., F(n-1)中的最大值。
 *
 * 注意:
 * 可以认为 n 的值小于 105。
 *
 * 示例:
 *
 * A = [4, 3, 2, 6]
 *
 * F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
 * F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
 * F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
 * F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
 *
 * 所以 F(0), F(1), F(2), F(3) 中的最大值是 F(3) = 26 。
 *
 *
 * @author guojun
 * @date 2021/1/21 10:40
 */
public class TestSolution396 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution396.class);


    static class Solution {
        /**
         *
         *
         * F(k)=F(k-1)+ sum(A[]) - n*A[n-k]
         *
         * 执行结果：通过
         * 显示详情
         * 添加备注
         *
         * 执行用时：3 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：51 MB, 在所有 Java 提交中击败了62.05%的用户通过测试用例：58 / 58
         *
         *
         * @param nums
         * @return
         */
        public int maxRotateFunction(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            if (nums.length == 1) {
                return 0 * nums[0];
            }

            int len = nums.length;
            int lastVal = 0;
            int sum = 0;
            for (int i = 0; i < len; i++) {
                lastVal += i * nums[i];
                sum += nums[i];
            }

            int retMax = lastVal;
            for (int i = 1; i < len; i++) {
                int currentVal = lastVal + sum - len * nums[len - i];
                if (currentVal > retMax) {
                    retMax = currentVal;
                }
                lastVal = currentVal;
            }
            return retMax;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().maxRotateFunction(new int[]{1,2,3,4,5,6,7,8,9,10}));//330
        logger.info("{}", new Solution().maxRotateFunction(new int[]{4,3,2,6}));//26
        logger.info("{}", new Solution().maxRotateFunction(new int[]{100}));//26
    }
}
