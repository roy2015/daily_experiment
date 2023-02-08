package com.guo.roy.research.leetcode.stage2.stage21;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.PriorityQueue;

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

        /**
         * 执行用时：
         * 1077 ms
         * , 在所有 Java 提交中击败了
         * 5.02%
         * 的用户
         * 内存消耗：
         * 63.9 MB
         * , 在所有 Java 提交中击败了
         * 44.76%
         * 的用户
         * 通过测试用例：
         * @param n
         * @param primes
         * @return
         */
        public int nthSuperUglyNumber1(int n, int[] primes) {
            int length = primes.length;
            int[] pointers = new int[length];
            List<Integer> dp = new ArrayList<>(n);
            dp.add(1);

            int i = 1;//从1开始
            int limit = n -1;
            while (i <= limit) {
                int minIdx = 0;
                int minVal = Integer.MAX_VALUE;
                for (int j = 0; j < length; j++) {
                    Integer dpVal = dp.get(pointers[j]);
                    int dpValPrimes = dpVal * primes[j];
                    if (dpValPrimes < minVal) {
                        minIdx = j;
                        minVal = dpValPrimes;
                    }
                }
                if (dp.get(dp.size() -1 ).compareTo(minVal) != 0) {
                    dp.add(minVal);
                    i ++;
                }
                pointers[minIdx]++;
            }
            return dp.get(dp.size() -1 );
        }

        /**
         * 执行结果：
         * 通过
         * 显示详情
         * 添加备注
         *
         * 执行用时：
         * 598 ms
         * , 在所有 Java 提交中击败了
         * 9.80%
         * 的用户
         * 内存消耗：
         * 39.9 MB
         * , 在所有 Java 提交中击败了
         * 54.90%
         * 的用户
         * 通过测试用例：
         * 85 / 85
         * @param n
         * @param primes
         * @return
         */
        public int nthSuperUglyNumber2(int n, int[] primes) {
            int length = primes.length;
            int[] pointers = new int[length];
            int[] dp = new int[n];
            dp[0] = 1;

            int i = 1;//从1开始
            int limit = n -1;
            while (i <= limit) {
                int minIdx = 0;
                int minVal = Integer.MAX_VALUE;
                for (int j = 0; j < length; j++) {
                    int dpVal = dp[pointers[j]];
                    int dpValPrimes = dpVal * primes[j];
                    if (dpValPrimes < minVal) {
                        minIdx = j;
                        minVal = dpValPrimes;
                    }
                }
                if (dp[i -1] != minVal) {
                    dp[i] = minVal;
                    i ++;
                }
                pointers[minIdx]++;
            }
            return dp[i -1];
        }


        /**
         *
         *
         * 优化点：
         * 提前检验重复可以减少外层循环，毕竟pointers元素个数和primes一致，不是长数据不耗时 pointers元素的值是dp元素的指针
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 添加备注
         *
         * 执行用时：
         * 313 ms
         * , 在所有 Java 提交中击败了
         * 49.89%
         * 的用户
         * 内存消耗：
         * 39.9 MB
         * , 在所有 Java 提交中击败了
         * 54.91%
         * 的用户
         * 通过测试用例：
         * 85 / 85
         *
         * @param n
         * @param primes
         * @return
         */
        public int nthSuperUglyNumber3(int n, int[] primes) {
            int length = primes.length;
            int[] pointers = new int[length];
            int[] dp = new int[n];
            dp[0] = 1;

            int i = 1;//从1开始
            int limit = n -1;
            while (i <= limit) {
                int minVal = Integer.MAX_VALUE;
                for (int j = 0; j < length; j++) {
                    int dpValPrimes = dp[pointers[j]] * primes[j];
                    if (dpValPrimes < minVal) {
                        minVal = dpValPrimes;
                    }
                }
                //提前检验重复可以减少外层循环，毕竟pointers元素个数和primes一致，不是长数据不耗时 pointers元素的值是dp元素的指针
                for (int i1 = 0; i1 < pointers.length; i1++) {
                    if (dp[pointers[i1]] * primes[i1] == minVal) {
                        pointers[i1] ++;
                    }
                }
                dp[i] = minVal;
                i ++;
            }
            return dp[i -1];
        }
    }

    public static void main(String[] args) {
        logger.info("cost time{}", System.currentTimeMillis());
        logger.info("{}", new Solution().nthSuperUglyNumber3(1000000, new int[]{2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,
        89,97,101,103,107,109,113,127,131,137,139,149,151,157,163,167,173,179,181,191,193,197,199,211,223,227,229,233,239,241,251,257,263,269,
        271,277,281,283,293,307,311,313,317,331,337,347,
            349,353,359,367,373,379,383,389,397,401,409,419,421,431,433,439,443,449,457,461
            ,463,467,479,487,491,499,503,509,521,523,541}));//6262476

        logger.info("cost time{}", System.currentTimeMillis());

//        logger.info("{}", new Solution().nthSuperUglyNumber1(100000,
//            new int[]{7,19,29,37,41,47,53,59,61,79,83,89,101,103,109,127,131,137,139,
//                157,167,179,181,199,211,229,233,239,241,251}));//1092889481

        logger.info("cost time{}", System.currentTimeMillis());
//
        logger.info("{}", new Solution().nthSuperUglyNumber3(12, new int[]{2,7,13,19}));//32   [1,2,4,7,8,13,14,16,19,26,28,32]
//        logger.info("cost time{}", System.currentTimeMillis());
//        logger.info("{}", new Solution().nthSuperUglyNumber(1, new int[]{2,3,5}));//1
    }
}
