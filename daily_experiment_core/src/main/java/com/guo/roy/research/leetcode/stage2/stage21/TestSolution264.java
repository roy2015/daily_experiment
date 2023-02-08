package com.guo.roy.research.leetcode.stage2.stage21;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

import org.slf4j.LoggerFactory;

/**
 *
 * 264. 丑数 II
 * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
 *
 * 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 10
 * 输出：12
 * 解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：1
 * 解释：1 通常被视为丑数。
 *
 *
 * 提示：
 *
 * 1 <= n <= 1690
 *
 * @author guojun
 * @date 2021/9/27
 */
public class TestSolution264 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution264.class);


    static class Solution {


        /**
         *
         * 313超级丑数，和这个类似， 主要还是要用最小堆
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 添加备注
         *
         * 执行用时：
         * 50 ms
         * , 在所有 Java 提交中击败了
         * 17.01%
         * 的用户
         * 内存消耗：
         * 38 MB
         * , 在所有 Java 提交中击败了
         * 24.68%
         * 的用户
         * 通过测试用例：
         *
         * @param n
         * @return
         */
        public int nthUglyNumber(int n) {
            int[] primes = new int[]{2,3,5};
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

            //初始化数据
            priorityQueue.add(1);
            int time = 0;
            Set<Object> filter = new HashSet<>();

            int[] maxBase = new int[primes.length];
            for (int i = 0; i < primes.length; i++) {
                maxBase[i] = Integer.MAX_VALUE / primes[i];
            }

            //start
            while (true) {
                int min = priorityQueue.poll();
                time++;
                if (time == n) {
                    return min;
                }

                for (int i = 0; i < primes.length; i++) {
                    int iVal = primes[i];
                    //处理超界有讲究
                    if (min > maxBase[i]) {
                        continue;
                    }
                    int toAdd = min * iVal;
                    if (!filter.contains(toAdd)) {
                        priorityQueue.add(toAdd);
                        filter.add(toAdd);
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        logger.info("{}", System.currentTimeMillis());
        logger.info("{}", new Solution().nthUglyNumber(1352));
        logger.info("{}", System.currentTimeMillis());
    }
}
