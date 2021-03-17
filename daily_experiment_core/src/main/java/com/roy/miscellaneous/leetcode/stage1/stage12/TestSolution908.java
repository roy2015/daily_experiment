package com.roy.miscellaneous.leetcode.stage1.stage12;

import java.util.Arrays;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/5/24
 *
 * 908. 最小差值 I
给你一个整数数组 A，对于每个整数 A[i]，我们可以选择处于区间 [-K, K] 中的任意数 x ，将 x 与 A[i] 相加，结果存入 A[i] 。

在此过程之后，我们得到一些数组 B。

返回 B 的最大值和 B 的最小值之间可能存在的最小差值。



示例 1：

输入：A = [1], K = 0
输出：0
解释：B = [1]
示例 2：

输入：A = [0,10], K = 2
输出：6
解释：B = [2,8]
示例 3：

输入：A = [1,3,6], K = 3
输出：0
解释：B = [3,3,3] 或 B = [4,4,4]


提示：

1 <= A.length <= 10000
0 <= A[i] <= 10000
0 <= K <= 10000
 */
public class TestSolution908 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution908.class);


    static class Solution {


        /**
         *
         * 走了弯路，先做了排序 n * O(logn)就为了找最大数最小树，没必要，直接遍历O(n)就可以了
         *
         * 执行用时：5 ms
         内存消耗：40.1 MB
         *
         * @param A
         * @param K
         * @return
         */
        public int smallestRangeI(int[] A, int K) {
            int len = A.length;
            if (len == 1) {
                return 0;
            }
            Arrays.sort(A);

            int retGap ;
            int val0 = A[0];
            int valLen_1 = A[len-1];
            if (K ==0) {
                retGap = valLen_1 - val0;
            } else{
                if (val0 + K  >= valLen_1 - K) {
                    retGap = 0;
                } else{
                    int mid = (val0 + valLen_1) /2;
                    retGap = Math.abs(valLen_1 - mid - K) + Math.abs(mid - K - val0);
                }

            }
            return retGap;

        }


        /**
         *优化后的
         * 只需要考虑最大数和最小数即可
         *
         *执行结果：
         通过
         显示详情
         执行用时 :1 ms, 在所有 Java 提交中击败了100%的用户
         内存消耗 :40.4 MB, 在所有 Java 提交中击败了50.00%的用户
         *
         * @param A
         * @param K
         * @return
         */
        public int smallestRangeI1(int[] A, int K) {
            int len = A.length;
            if (len == 1) {
                return 0;
            }

            int minVal = A[0];
            int maxVal = A[0];

            for(int i = 0; i< len; i++) {
                int iVal = A[i];
                if (iVal < minVal) {
                    minVal = iVal;
                }
                if (iVal > maxVal) {
                    maxVal = iVal;
                }
            }
            int retGap ;
            if (K ==0) {
                retGap = maxVal - minVal;
            } else{
                if (minVal + K  >= maxVal - K) {
                    retGap = 0;
                } else{
                    int mid = (minVal + maxVal) /2;
                    retGap = Math.abs(maxVal - mid - K) + Math.abs(mid - K - minVal);
                }

            }
            return retGap;
        }

    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().smallestRangeI(new int[]{1,3, 6} ,3));
    }
}
