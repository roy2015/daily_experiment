package com.roy.miscellaneous.leetcode.stage2.stage21;

import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

import org.slf4j.LoggerFactory;

/**
 *
 *
 * 313. 超级丑数
 * 超级丑数 是一个正整数，并满足其所有质因数都出现在质数数组 primes 中。
 *
 * 给你一个整数 n 和一个整数数组 primes ，返回第 n 个 超级丑数 。
 *
 * 题目数据保证第 n 个 超级丑数 在 32-bit 带符号整数范围内。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 12, primes = [2,7,13,19]
 * 输出：32
 * 解释：给定长度为 4 的质数数组 primes = [2,7,13,19]，前 12 个超级丑数序列为：[1,2,4,7,8,13,14,16,19,26,28,32] 。
 * 示例 2：
 *
 * 输入：n = 1, primes = [2,3,5]
 * 输出：1
 * 解释：1 不含质因数，因此它的所有质因数都在质数数组 primes = [2,3,5] 中。
 *
 * 提示：
 *
 * 1 <= n <= 106
 * 1 <= primes.length <= 100
 * 2 <= primes[i] <= 1000
 * 题目数据 保证 primes[i] 是一个质数
 * primes 中的所有值都 互不相同 ，且按 递增顺序 排列
 *
 * @author guojun
 * @date 2021/9/26
 */
public class TestSolution313 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution313.class);


    static class Solution {
        /**
         *
         * 未通过
         * 思路
         * 无界堆，bitSet
         * bitset的性能由于hashmap/hashset , 超出内存限制
         *
         * @param n
         * @param primes
         * @return
         */
        public int nthSuperUglyNumber(int n, int[] primes) {
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

            //初始化数据
            priorityQueue.add(1);
            int time = 0;
            BitSet bitSet = new BitSet();
            bitSet.set(1);

            int[] maxBase = new int[primes.length];
            for (int i = 0; i < primes.length; i++) {
                maxBase[i] = Integer.MAX_VALUE / primes[i];
            }

            //start
            while (true) {
                int min = priorityQueue.poll();
                time ++;
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
                    if (!bitSet.get(toAdd)) {
                        priorityQueue.add(toAdd);
                        bitSet.set(toAdd);
                    }

                }
            }
        }



    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().nthSuperUglyNumber(1000000, new int[]{2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,
        89,97,101,103,107,109,113,127,131,137,139,149,151,157,163,167,173,179,181,191,193,197,199,211,223,227,229,233,239,241,251,257,263,269,
        271,277,281,283,293,307,311,313,317,331,337,347,
            349,353,359,367,373,379,383,389,397,401,409,419,421,431,433,439,443,449,457,461
            ,463,467,479,487,491,499,503,509,521,523,541}));//1

//        logger.info("{}", new Solution().nthSuperUglyNumber(100000,
//            new int[]{7,19,29,37,41,47,53,59,61,79,83,89,101,103,109,127,131,137,139,
//                157,167,179,181,199,211,229,233,239,241,251}));//1092889481

//        logger.info("{}", new Solution().nthSuperUglyNumber(12, new int[]{2,7,13,19}));//32   [1,2,4,7,8,13,14,16,19,26,28,32]
//        logger.info("{}", new Solution().nthSuperUglyNumber(1, new int[]{2,3,5}));//1
    }
}
