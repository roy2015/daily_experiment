package com.roy.miscellaneous.leetcode.stage2.stage20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/10/15
 *
 * 357. 计算各个位数不同的数字个数
 * 给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10^n 。
 *
 * 示例:
 *
 * 输入: 2
 * 输出: 91
 * 解释: 答案应为除去 11,22,33,44,55,66,77,88,99 外，在 [0,100) 区间内的所有数字。
 */
public class TestSolution357 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution357.class);


    static class Solution {
        /**
         * 思路过程：
         * 1. 选择应该有两个限制 历史层次限制，当前层已使用限制
         * 2. 从低位到高位，基于这个考虑最高位0可能会增加复杂度
         *
         *  所谓的回溯算法，像是迷宫，一直走走不通调头
         *  时间复杂度不怎么理想，可以优化？？
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：437 ms, 在所有 Java 提交中击败了5.11%的用户
         * 内存消耗：38 MB, 在所有 Java 提交中击败了5.01%的用户
         * @param n
         * @return
         */
        public int countNumbersWithUniqueDigits(int n) {
            if (n == 0) {
                return 1;
            }
            int sum = 10;
            for (int i = 2; i <= n; i++) {
                int nSum = countNumbersWithUniqueDigitsSub(new ArrayList<Integer>(), 1, i);
                sum += nSum;
            }
            return sum;
        }

        private int countNumbersWithUniqueDigitsSub(List<Integer> parentHistory, int level, int n) {
            int retSum = 0;
            int nextLevel = level +1;
            if (level == 1) {
                //最高位1-9
                for (int i = 1; i <=9 ; i++) {
                    List<Integer> copyOfparentHistory = new ArrayList<>(parentHistory);
                    copyOfparentHistory.add(i);
                    retSum += countNumbersWithUniqueDigitsSub(copyOfparentHistory, nextLevel, n);
                }
            } else {
                //非最高位0-9
                for (int i = 0; i <=9 ; i++) {
                    if (parentHistory.contains(i)) {
                        continue;
                    }
                    if (level == n) {
                        retSum++;
                    } else {
                        List<Integer> copyOfparentHistory = new ArrayList<>(parentHistory);
                        copyOfparentHistory.add(i);
                        retSum += countNumbersWithUniqueDigitsSub(copyOfparentHistory, nextLevel, n);
                    }
                }
            }
            return retSum;
        }

        /**
         *
         *
         * 同上，优化了list,改成数组
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：64 ms, 在所有 Java 提交中击败了7.31%的用户
         * 内存消耗：37.9 MB, 在所有 Java 提交中击败了5.01%的用户
         * @param n
         * @return
         */
        public int countNumbersWithUniqueDigits1(int n) {
            if (n == 0) {
                return 1;
            }

            int sum = 10;
            for (int i = 2; i <= n; i++) {
                int nSum = countNumbersWithUniqueDigits1Sub(new int[10], 1, i);
                sum += nSum;
            }
            return sum;
        }

        /**
         *
         * @param parentHistory 上一层用过的数字
         * @param level 当前层级
         * @param n 要计算的层级
         * @return
         */
        private int countNumbersWithUniqueDigits1Sub(int[] parentHistory, int level, int n) {
            int retSum = 0;
            int nextLevel = level +1;
            if (level == 1) {
                //最高位1-9
                int[] copyOfparentHistory = Arrays.copyOfRange(parentHistory, 0, parentHistory.length);
                for (int i = 1; i <=9 ; i++) {
                    copyOfparentHistory[i] = 1;
                    retSum += countNumbersWithUniqueDigits1Sub(copyOfparentHistory, nextLevel, n);
                    copyOfparentHistory[i] = 0;
                }
            } else {
                //非最高位0-9
                for (int i = 0; i <=9 ; i++) {
                    if (parentHistory[i] == 1) {
                        continue;
                    }
                    if (level == n) {
                        retSum++;
                    } else {
                        int[] copyOfparentHistory = Arrays.copyOfRange(parentHistory, 0, parentHistory.length);
                        copyOfparentHistory[i] = 1;
                        retSum += countNumbersWithUniqueDigits1Sub(copyOfparentHistory, nextLevel, n);
                        if (i != 0) {
                            copyOfparentHistory[i - 1] = 0;
                        }
                    }
                }
            }
            return retSum;
        }

    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().countNumbersWithUniqueDigits1(3));//739
        logger.info("{}", new Solution().countNumbersWithUniqueDigits1(2));//91
        logger.info("{}", new Solution().countNumbersWithUniqueDigits(10));//8877691
    }
}
