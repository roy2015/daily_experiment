package com.roy.leetcode.stage1.stage12;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/8/27
 *
 *面试题 05.01. 插入
 * 插入。给定两个32位的整数N与M，以及表示比特位置的i与j。编写一种方法，将M插入N，使得M从N的第j位开始，到第i位结束。假定从j位到i位足以容纳M，也即若M = 10 011，那么j和i之间至少可容纳5个位。例如，不可能出现j = 3和i = 2的情况，因为第3位和第2位之间放不下M。
 *
 * 示例1:
 *
 *  输入：N = 1024(10000000000), M = 19(10011), i = 2, j = 6
 *  输出：N = 1100(10001001100)
 * 示例2:
 *
 *  输入： N = 0, M = 31(11111), i = 0, j = 4
 *  输出：N = 31(11111)
 *
 */
public class TestSolutionInterview0501 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolutionInterview0501.class);

    static class Solution {

        /**
         *
         * 有坑：当(j-i +1)大于 M长度时候，M要靠近i， 所以要做出一个PADDING, eg: 000XXX000，再~PADDING （111000111）
         *  再和N做&&， 中间的位在和M |
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：
         * 36.4 MB, 在所有 Java 提交中击败了46.84%的用户
         *
         * @param N
         * @param M
         * @param i
         * @param j
         * @return
         */
        public int insertBits(int N, int M, int i, int j) {
            int padding = (0x1 << (j - i + 1)) -1;
            padding = ~(padding << i);
            return padding & N | (M << i);
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().insertBits(0,31, 0,4));//31
        logger.info("{}", new Solution().insertBits(28,5, 0,3));//21
        logger.info("{}", new Solution().insertBits(1024,19, 2,6));//1100
    }
}
