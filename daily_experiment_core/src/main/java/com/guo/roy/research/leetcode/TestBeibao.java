package com.guo.roy.research.leetcode;

import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 *
 *  两个数组：物品的重量，价值
 *  求给定重量可以达到的最大价值
 *
 *
 *  背包问题的分类
 * 在我看来，背包问题可以总结为三类：01背包问题、完全背包问题以及分组背包问题。
 * 01背包问题：每个元素最多取1次。具体来讲：一共有 N 件物品，第 i（i 从 1 开始）件物品的重量为 w[i]，价值为 v[i]。在总重量不超过背包承载上限 W 的情况下，能够装入背包的最大价值是多少？
 *
 * 完全背包问题：每个元素可以取多次。具体来讲：完全背包与 01 背包不同就是每种物品可以有无限多个：一共有 N 种物品，每种物品有无限多个，第 i（i 从 1 开始）种物品的重量为 w[i]，价值为 v[i]。在总重量不超过背包承载上限 W 的情况下，能够装入背包的最大价值是多少？
 *
 * 分组背包问题：有多个背包，需要对每个背包放入物品，每个背包的处理情况与完全背包完全相同。
 *
 * 在完全背包问题当中根据是否需要考虑排列组合问题（是否考虑物品顺序），可分为两种情况，我们可以通过内外循环的调换来处理排列组合问题，如果题目不是排列组合问题，则这两种方法都可以使用（推荐使用组合来解决）
 *
 * 而每个背包问题要求的也是不同的，按照所求问题分类，又可以分为以下几种：
 * 1、最值问题：要求最大值/最小值
 * 2、存在问题：是否存在…………，满足…………
 * 3、组合问题：求所有满足……的排列组合
 *
 *
 * 解题模板
 * 背包问题大体的解题模板是两层循环，分别遍历物品nums和背包容量target，然后写转移方程，根据背包的分类我们确定物品和容量遍历的先后顺序，根据问题的分类我们确定状态转移方程的写法。
 *
 * 首先是背包分类的模板：
 * 1、0/1背包：外循环nums,内循环target,target倒序且target>=nums[i];
 * 2、完全背包（组合）：外循环nums,内循环target,target正序且target>=nums[i];
 * 3、完全背包（排列）：外循环target,内循环nums,target正序且target>=nums[i];
 * 4、分组背包：这个比较特殊，需要多重循环：外循环nums,内部循环根据题目的要求构建多重背包循环
 *
 *
 *
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

        public int test20221020(int[] weights, int[] values, int target) {
            int size = weights.length;
            //填补第0行，代表不用任何物品
            int[][] dp = new int[size + 1][target + 1];
            Arrays.fill(dp[0], 0);
            //idxItem: 物品
            for (int idxItem = 1; idxItem <= size; idxItem++) {
                //weight：重量 0，1 ，2 ...... tagret
                for (int loopWeightVal = 0; loopWeightVal <= target ; loopWeightVal++) {
                    //重量0的dp[][]=0，continue
                    if (loopWeightVal == 0) {
                        dp[idxItem][loopWeightVal] = 0;
                        continue;
                    }
                    int val ;
                    //当前重量超过了，用上一行的相同重量的时的dp
                    if (weights[idxItem-1] > loopWeightVal) {
                        val = dp[idxItem-1][loopWeightVal];
                    } else   {
                        //不用时，用上一行的相同重量的时的dp
                        int one = dp[idxItem-1][loopWeightVal];
                        //用时，用上一行的差值重量的时的dp
                        int two = values[idxItem-1] + dp[idxItem-1][loopWeightVal - weights[idxItem-1]];
                        //取和不取的较大者
                        val = Math.max(one, two);
                    }
                    dp[idxItem][loopWeightVal] = val;
                }
            }
            return dp[size][target];

        }

        public int test20230515(int[] weights, int[] values, int target) {
            int weightLength = weights.length;
            int[][] dp = new int[weightLength + 1][target + 1];
//            dp[0] = new int[]{};
            for (int i = 1; i <= weightLength; i++) {
                for (int j = 1; j <= target ; j++) {
                    if (weights[i-1] > j) {
                        dp[i][j] =  dp[i-1][j];
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i - 1]] + values[i - 1]);
                    }
                }
            }
            return dp[weightLength][target];
        }

    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().test1(new int[]{2,1,1,4,12}, new int[]{2,2,1,10,4}, 6));
        logger.info("{}", new Solution().test20221020(new int[]{2,1,1,4,12}, new int[]{2,2,1,10,4}, 6));
        logger.info("{}", new Solution().test20230515(new int[]{2,1,1,4,12}, new int[]{2,2,1,10,4}, 6));

        logger.info("{}", new Solution().test20230515(new int[]{5,25,30,45,50}, new int[]{50,200,180,225,200}, 100));
    }
}
