package com.roy.miscellaneous.leetcode.stage2.stage22;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.LoggerFactory;

/**
 *
 *
 * 397. 整数替换
 * 给定一个正整数 n ，你可以做如下操作：
 *
 * 如果 n 是偶数，则用 n / 2替换 n 。
 * 如果 n 是奇数，则可以用 n + 1或n - 1替换 n 。
 * n 变为 1 所需的最小替换次数是多少？
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 8
 * 输出：3
 * 解释：8 -> 4 -> 2 -> 1
 * 示例 2：
 *
 * 输入：n = 7
 * 输出：4
 * 解释：7 -> 8 -> 4 -> 2 -> 1
 * 或 7 -> 6 -> 3 -> 2 -> 1
 * 示例 3：
 *
 * 输入：n = 4
 * 输出：2
 *
 *
 * 提示：
 *
 * 1 <= n <= 231 - 1
 *
 * @author guojun
 * @date 2021/6/11
 */
public class TestSolution397 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution397.class);


    static class Solution {
        /**
         *
         * 分析过程：
         * 1. 对于每一次(每层)奇数产生两个数字， 偶数产生一个，没一次计算最后只能最多留2个数字(特殊情况，2的n次幂从始到终一个到底)，
         * 对于某层的计算，计算出1，立即结束返回
         * 2. 问题的关键：如何做到每次计算的结果始终保持2个？？
         *
         *
         *
         * @param n
         * @return
         */
        public int integerReplacement(int n) {
            if (n == 1) {
                return 0;
            }
            if (n == Integer.MAX_VALUE) {
                return 32;
            }
            int t = 0;
            HashSet<Integer> pool = new HashSet<>();
            pool.add(n);
            HashSet<Integer> calPool;
            while (true) {
                Set<Integer> newPool = new HashSet<>();
                for (Integer item : pool) {
                    if (item == 1) {
                        return t;
                    }
                    if ((item & 1) == 0) {
                        newPool.add(item / 2);
                    } else {
                        newPool.add( item + 1 );
                        newPool.add(item - 1);
                    }
                }
                calPool = new HashSet<>();
                for (Integer item : newPool) {
                    if ((item & 1) == 0) {
                        if (!newPool.contains(item / 2)) {
                            calPool.add(item);
                        } else {
                        }
                    } else {
                        if (!newPool.contains(item - 1) && !newPool.contains(item + 1)) {
                            calPool.add(item);
                        }
                    }
                }
                pool = calPool;
                t++;
            }
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().integerReplacement(2147483647));//32
        logger.info("{}", new Solution().integerReplacement(3));//2
        logger.info("{}", new Solution().integerReplacement(2));//1
        logger.info("{}", new Solution().integerReplacement(1));//0
        logger.info("{}", new Solution().integerReplacement(1000000000));//38
        logger.info("{}", new Solution().integerReplacement(10000));//16
        logger.info("{}", new Solution().integerReplacement(8));//3
        logger.info("{}", new Solution().integerReplacement(7));//4
        logger.info("{}", new Solution().integerReplacement(4));//2
        logger.info("{}", new Solution().integerReplacement(104));//8
        logger.info("{}", new Solution().integerReplacement(102));//9
        logger.info("{}", new Solution().integerReplacement(8));//3

    }
}
