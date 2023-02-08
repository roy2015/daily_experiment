package com.guo.roy.research.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/9/3
 *
 * 面试题 08.05. 递归乘法
 * 递归乘法。 写一个递归函数，不使用 * 运算符， 实现两个正整数的相乘。可以使用加号、减号、位移，但要吝啬一些。
 *
 * 示例1:
 *
 *  输入：A = 1, B = 10
 *  输出：10
 * 示例2:
 *
 *  输入：A = 3, B = 4
 *  输出：12
 * 提示:
 *
 * 保证乘法范围不会溢出
 *
 */
public class TestSolutionInterview0805 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolutionInterview0805.class);


    static class Solution {
        /**
         *
         * 有个坑，递归过多会导致 java.lang.StackOverflowError  918795921 1，必须交换AB
         *
         * 执行结果：通过
         * 显示详情
         * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：36.6 MB, 在所有 Java 提交中击败了17.11%的用户
         *
         * @param A
         * @param B
         * @return
         */
        public int multiply(int A, int B) {
            int min = A > B ? B : A;
            int max = A > B ? A : B;
            return min == 1 ? max : max + multiply(min - 1, max);
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().multiply(99999, 1));
    }
}
