package com.guo.roy.research.leetcode.stage2.stage22;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.slf4j.LoggerFactory;

/**
 *
 * 473. 火柴拼正方形
 * 还记得童话《卖火柴的小女孩》吗？现在，你知道小女孩有多少根火柴，请找出一种能使用所有火柴拼成一个正方形的方法。不能折断火柴，可以把火柴连接起来，并且每根火柴都要用到。
 *
 * 输入为小女孩拥有火柴的数目，每根火柴用其长度表示。输出即为是否能用所有的火柴拼成正方形。
 *
 * 示例 1:
 *
 * 输入: [1,1,2,2,2]
 * 输出: true
 *
 * 解释: 能拼成一个边长为2的正方形，每边两根火柴。
 * 示例 2:
 *
 * 输入: [3,3,3,3,4]
 * 输出: false
 *
 * 解释: 不能用所有火柴拼成一个正方形。
 * 注意:
 *
 * 给定的火柴长度和在 0 到 10^9之间。
 * 火柴数组的长度不超过15。
 *
 * @author guojun
 * @date 2021/12/9
 */
public class TestSolution473_1 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution473_1.class);


    static class Solution {
        private int everyGroupSum;
        private int n;
        private int subBase = 0x2;

        private Map<int[], Integer> subProblemList = new HashMap<>();

        /**
         * 解决子问题
         * @param matchsticks
         * @param group
         * @return
         */
        public int subMakesquare(int[] matchsticks, int group) {
            int res = doMakesquare(0, matchsticks, group);
            return subBase | res;
        }

        /**
         * 主问题
         * @param matchsticks
         * @param
         * @return
         */
        public int doMakesquare(int preSum, int[] matchsticks, int group) {
            if (preSum == everyGroupSum) {
                return 1 ;
            } else if (preSum > everyGroupSum) {
                return 0;
            } else {
                int length = matchsticks.length;
                Set<Integer> trapSet = new HashSet<>();//解决重复计算的问题
                for (int i = 0; i < length; i++) {
                    int iVal = matchsticks[i];
                    if (trapSet.contains(iVal)) {
                        continue;
                    }
                    int[] subMatchsticks = new int[length - 1];
                    copyOfRange(matchsticks, subMatchsticks, 0, i, 0);
                    copyOfRange(matchsticks, subMatchsticks, i + 1, length, i);
                    int res = doMakesquare(iVal + preSum, subMatchsticks, group);
                    if ((res & 1) == 1) {
                        //解决子问题(group-1)
                        int subGroup = group -1;
                        //subGroup == 1， 问题都解决了，不用去subGroup=0
                        if (subGroup == 1) {
                            return 1;
                        }
                        int subRes = subMakesquare(subMatchsticks, subGroup);
                        if ((subRes & 1) == 1) {
                            return subRes;
                        } else {
                            //子问题未解决，继续
                            trapSet.add(iVal);
                        }
                    } else {
                        if ((res & subBase) == 0) {
                            break;
                        }
//                        break;
                    }
                }
                return 2;
            }
        }

        //数组拷贝
        private void copyOfRange(int[] srcArray, int[] targetArray, int from, int to, int targetStart) {
            for (int i = 0; i < to - from; i++) {
                targetArray[targetStart + i] = srcArray[from + i];
            }
        }

        /**
         * 通过了171， 没通过175， 超时了，一分钟10秒才计算出来 。。。这种题目做的有点蛋疼，解出来了也是超时
         * @param matchsticks
         * @return
         */
        public boolean makesquare(int[] matchsticks) {
             n = 4;
            /**
             * 1. 元素个数， < 4直接返回false
             * 2. 元素和， 是否被4整除，求 avg = sum /4
             * 3. 遍历，看是否有大于avg的 */
            int length = matchsticks.length;
            if (length < n) {
                return false;
            }
            int sum = Arrays.stream(matchsticks).sum();
            if (sum % n != 0) {
                return false;
            }
            everyGroupSum = sum / n;
            boolean match = Arrays.stream(matchsticks).anyMatch(r -> r > everyGroupSum);
            if (match) {
                return false;
            }

            Arrays.sort(matchsticks);
            int res = doMakesquare(0, matchsticks, n);
            return (res & 0x1) == 1;
        }
    }

    public static void main(String[] args) {
        logger.info("111111");
        logger.info("{}", new Solution().makesquare(new int[]{5,5,5,5,16,4,4,4,4,4,3,3,3,3,4}));//false

        logger.info("{}", new Solution().makesquare(new int[]{1,1,1,1,1,1,5,5,2,6}));//true
        logger.info("{}", new Solution().makesquare(new int[]{3,3,3,3,4}));//false
        logger.info("{}", new Solution().makesquare(new int[]{1,1,2,2,2}));//true
        logger.info("{}", new Solution().makesquare(new int[]{3,3,3,3,4}));//false
    }
}
