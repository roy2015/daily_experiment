package com.guo.roy.research.leetcode.stage2.stage21;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2021/6/11
 */
public class TestSolution518 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution518.class);


    static class Solution {
        /**
         *
         * 执行结果：通过
         * 显示详情 添加备注
         *
         * 执行用时：52 ms, 在所有 Java 提交中击败了5.19%的用户
         * 内存消耗：45.7 MB, 在所有 Java 提交中击败了24.82%的用户
         * @param amount
         * @param coins
         * @return
         */
        public int change(int amount, int[] coins) {
            int col = coins.length +1;
            int row = amount +1;
            //行代表target:   0，1， 2 。。。。amount
            //列代表硬币面值   1, 2, 5....
            int[][] dp = new int[row][col];
            //初始化第一行第一列
            for (int i = 0; i < row; i++) {
                dp[i][0]= 0;
            }
            for (int i = 0; i < col ; i++) {
                dp[0][i] =1;
            }
            for (int i = 1; i < row; i++) {
                for (int j = 1; j < col; j++) {
                    int dpVal = dp[i][j-1];
                    //当前面值
                    int currValue = coins[j - 1];
                    int k = i;
                    while (k - currValue >= 0 ) {
                        dpVal += dp[k - currValue][j-1];
                        k = k -currValue;
                    }
                    dp[i][j] = dpVal;
                }
            }
            return dp[amount][coins.length];
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().change(6, new int[]{2,3,5}));//2
        logger.info("{}", new Solution().change(5, new int[]{1,2,5}));//2
    }
}
