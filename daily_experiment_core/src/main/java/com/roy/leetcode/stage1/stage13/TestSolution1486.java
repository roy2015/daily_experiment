package com.roy.leetcode.stage1.stage13;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/7/17
 *
 * 1486. 数组异或操作
 * 给你两个整数，n 和 start 。
 *
 * 数组 nums 定义为：nums[i] = start + 2*i（下标从 0 开始）且 n == nums.length 。
 *
 * 请返回 nums 中所有元素按位异或（XOR）后得到的结果。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 5, start = 0
 * 输出：8
 * 解释：数组 nums 为 [0, 2, 4, 6, 8]，其中 (0 ^ 2 ^ 4 ^ 6 ^ 8) = 8 。
 *      "^" 为按位异或 XOR 运算符。
 * 示例 2：
 *
 * 输入：n = 4, start = 3
 * 输出：8
 * 解释：数组 nums 为 [3, 5, 7, 9]，其中 (3 ^ 5 ^ 7 ^ 9) = 8.
 * 示例 3：
 *
 * 输入：n = 1, start = 7
 * 输出：7
 * 示例 4：
 *
 * 输入：n = 10, start = 5
 * 输出：2
 *
 *
 * 提示：
 *
 * 1 <= n <= 1000
 * 0 <= start <= 1000
 * n == nums.length
 */
public class TestSolution1486 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1486.class);


    static class Solution {
        /**
         *
         * todo 也可以思考用XOR特性来解决，虽然已经是双百了
         * XOR 有很多有用的特性：
         *
         * x ⊕ x=0
         * 0 ⊕ x=x
         * 2x ⊕ (2x+1)=1
         *
         *
         *
         *
         *
         *
         *执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：
         * 36.7 MB, 在所有 Java 提交中击败了100.00%的用户
         *
         *
         *
         * @param n
         * @param start
         * @return
         */
        public int xorOperation(int n, int start) {
            int ret =0;
            for(int i = 0; i<n ; i++) {
                ret ^= (i*2 + start);
            }
            return ret;
        }

    }

    public static void main(String[] args) {
        logger.info("{}", new Solution());
    }
}
