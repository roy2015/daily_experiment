package com.guo.roy.research.leetcode.stage2.stage22;

import java.util.Arrays;

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
public class TestSolution473_2 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution473_2.class);


    static class Solution {
        private int avg;

        private int n;

        /**
         * 这种题目做的有点蛋疼，解出来了也是超时
         *
         *    执行结果：
         * 通过
         * 显示详情
         * 添加备注
         *
         * 执行用时：
         * 114 ms
         * , 在所有 Java 提交中击败了
         * 29.66%
         * 的用户
         * 内存消耗：
         * 35.8 MB
         * , 在所有 Java 提交中击败了
         * 83.60%
         * 的用户
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
            avg = sum / n;
            boolean match = Arrays.stream(matchsticks).anyMatch(r -> r > avg);
            if (match) {
                return false;
            }

            Arrays.sort(matchsticks);
            return test(matchsticks, new int[4], 0);
        }


        private boolean test(int[] matchsticks, int[] side, int idx) {
            if (idx == matchsticks.length) {
                return (side[0] == side[1]) && (side[1] == side[2]) && (side[2] == side[3]);
            }

            for (int i = 0; i < 4; i++) {
                int idxVal = matchsticks[idx];
                if (side[i] + idxVal > avg || (i > 0 && (side[i] == side[i - 1]))) {
                    continue;
                }
                side[i] += idxVal;
                boolean test = test(matchsticks, side, idx + 1);
                if (!test) {
                    side[i] -= idxVal;
                } else {
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        logger.info("111111");
        logger.info("{}", new Solution().makesquare(new int[]{5,5,5,5,16,4,4,4,4,4,3,3,3,3,4}));//false

        logger.info("{}", new Solution().makesquare(new int[]{3,3,3,3,4}));//false
        logger.info("{}", new Solution().makesquare(new int[]{1,1,2,2,2}));//true
        logger.info("{}", new Solution().makesquare(new int[]{3,3,3,3,4}));//false
        logger.info("{}", new Solution().makesquare(new int[]{1,1,1,1,1,1,5,5,2,6}));//true
    }
}
