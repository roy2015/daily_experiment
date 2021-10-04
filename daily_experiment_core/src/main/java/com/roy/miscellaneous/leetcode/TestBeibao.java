package com.roy.miscellaneous.leetcode;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2021/6/11
 */
public class TestBeibao {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestBeibao.class);


    static class Solution {

        public int test1(int[] weights, int[] values, int max) {
            int len = weights.length;
            int[][] dp = new int[len +1 ][max + 1];

            for (int i = 1; i <= len; i++) {
                for (int j = 1; j <= max ; j++) {
                    if (weights[i -1] > j) {
                        dp[i][j] = dp[i-1][j];
                    } else
                    dp[i][j] = Math.max( dp[i-1][j] , dp[i-1][j - weights[i-1]] + values[i -1]);
//                    dp[i][j] = dp[i-1][j - weights[i-1]] + values[i -1];
                }
            }

            return dp[len][max];
        }

    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().test1(new int[]{2,1,1,4,12}, new int[]{2,2,1,10,4}, 15));
    }
}
