package com.roy.leetcode.stage1.stage10;

import java.util.BitSet;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/10/20.
 *统计所有小于非负整数 n 的质数的数量。

 示例:

 输入: 10
 输出: 4
 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 *
 */
public class TestSolution204 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution204.class);

    /**
     *
     *
     * 暴力法（超时）
     */
    static class Solution {
        public int countPrimes(int n) {
            if (n ==1) {
                return 0;
            }
            int cnt =0;
            boolean flag = false;
            for (int i =2; i<n; i++) {
                flag = false;
                for (int j =2; j<=i; j++) {
                    if (i % j ==0 && i !=j) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    cnt += 1;
                }


            }
            return cnt;
        }

        /**
         *
         *
         * 厄拉多塞法 ,用bitmap，防止数据过大
         *
         * 执行用时 :36 ms, 在所有 java 提交中击败了48.89%的用户
         * 内存消耗 :33.9 MB, 在所有 java 提交中击败了80.45%的用户
         *
         * @param n
         * @return
         */
        public int countPrimes1(int n) {
            BitSet bitSet = new BitSet(n + 1);
            bitSet.set(0, true);
            bitSet.set(1, true);
            bitSet.set(n, true);

            int ret =0;
            for (int i = 2; i < n ; i++) {
                if (bitSet.get(i) == false) {
                    ret ++;
                    for (int j = i; j < n; j= j +i) {
                        bitSet.set(j + i, true);
                    }
                }
            }


            /*for (int i = 2; i < n ; i++) {
                if (bitSet.get(i) == false) {
                   ret +=1;
                }
            }*/

            return ret;
        }

        /**厄拉多塞法 ，不用bitmap
         *
         *
         * 执行用时 :15 ms, 在所有 java 提交中击败了93.02%的用户
         * 内存消耗 :34.6 MB, 在所有 java 提交中击败了79.70%的用户
         * @param n
         * @return
         */
        public int countPrimes2(int n) {
            if (n == 0) {
                return 0;
            }

            boolean[] arr = new boolean[n + 1];
            arr[0] = true;
            arr[1] = true;
            arr[n] = true;

            int ret =0;
            for (int i = 2; i < n ; i++) {
                if (arr[i] == false) {
                    ret ++;
                    for (int j = i + i; j < n; j= j +i) {
                        arr[j] = true;
                    }
                }
            }

            return ret;
        }

    }

    public static void main(String[] args) {
        logger.info("{}", 123);
        int i = new Solution().countPrimes2(999999999);
        logger.info("{}", i);
    }

}
