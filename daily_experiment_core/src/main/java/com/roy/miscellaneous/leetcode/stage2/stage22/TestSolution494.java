package com.roy.miscellaneous.leetcode.stage2.stage22;

import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * @author guojun
 * @date 2020/11/19
 *
 *
 * 494. 目标和
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 *
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 *
 *
 *
 * 示例：
 *
 * 输入：nums: [1, 1, 1, 1, 1], S: 3
 * 输出：5
 * 解释：
 *
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 *
 * 一共有5种方法让最终目标和为3。
 *
 *
 * 提示：
 *
 * 数组非空，且长度不会超过 20 。
 * 初始的数组的和不会超过 1000 。
 * 保证返回的最终结果能被 32 位整数存下。
 *
 *
 */
public class TestSolution494 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution494.class);


    static class Solution {
        /**
         *    0/1背包问题   dp[i][j] = dp[i-1][j-newNums[i]] + dp[i-1][j] 考虑特殊情况
         *     举例：数组[1,4,1,3,2,1,2] 选出和为4的背包有几种方式？
         *           0   1 2 3 4
         *         0    0 0 0 0  (虚拟行)
         *         1    1 0 0 0
         *         4    1 0 0 1
         *         1    2 1 0 1
         *         3    2 1 1 3
         *         2    2 2 3 4
         *         1    3 4 5 7
         *         2    3 5 8 11
         *
         *             0 1
         *          0  1 0
         *          0  3 0
         *          0  7 0
         *          1  3 8
         *
         *
         *
         * 把0分开讨论了，这个0有点烦~~
         *
         * 执行结果：通过
         * 显示详情
         * 执行用时：12 ms, 在所有 Java 提交中击败了58.53%的用户
         * 内存消耗：38 MB, 在所有 Java 提交中击败了38.50%的用户
         *
         * @param nums
         * @param S
         * @return
         */
        public int findTargetSumWays(int[] nums, int S) {
            int[] newNums = Arrays.stream(nums).filter(item -> item != 0).toArray();
            int zeroCnt = (int) Arrays.stream(nums).filter(item -> item == 0).count();
            int salt = 1 << zeroCnt;
            int sum = 0;
            int len = newNums.length;
            if (len == 0) {
                return salt;
            }
            for (int num : newNums) {
                sum += num;
            }
            int x;
            int y;
            x = sum + S;
            y = sum - S;
            if (x < 0 || y < 0) {
                return 0;
            }
            //两个背包大小不正常
            if ((x & 0x1) == 1 || ((y & 0x1) == 1)) {
                return 0;
            }
            //取小值，防止dp过大
            x = Math.max(x,y);
            x = x /2;
            int[][] dp = new int[len + 1][];
            //初始化第一行
            dp[0] = new int[x + 1];
            for (int j = 0; j < x; j++) {
                dp[0][j] =0;
            }
            for (int i = 1; i <= len; i++) {
                dp[i] = new int[x + 1];
                for (int j = 1; j <= x ; j++) {
                    int i1 = j - newNums[i-1];
                    int ijVal = dp[i - 1][j];;
                    if (i1 > 0) {
                        ijVal += dp[i - 1][i1];
                    } else if (i1 == 0) {
                        ijVal += 1;
                    } else {}
                    dp[i][j]= ijVal;
//                    logger.info(" {}", ijVal);
                }
//                logger.info("");
            }
            return dp[len][x] * salt;
        }

        /**
         *
         *
         * 优化，不单独考虑0的通用解法，打表如下
         *  [0,0,1,0]里取和为1的背包的有多少种取法？ 8
         *     0 1
         *   0  1 0 （虚拟行）
         *   0 2 0
         *   0 4 0
         *   1 4 4
         *   0 8 8
         *
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 4 ms
         * , 在所有 Java 提交中击败了
         * 82.60%
         * 的用户
         * 内存消耗：
         * 37.8 MB
         * , 在所有 Java 提交中击败了
         * 39.97%
         * 的用户
         *
         * @param nums
         * @param S
         * @return
         */
        public int findTargetSumWays1(int[] nums, int S) {
            int sum = 0;
            int len = nums.length;
            for (int num : nums) {
                sum += num;
            }
            int x;
            int y;
            x = sum + S;
            y = sum - S;
            if (x < 0 || y < 0) {
                return 0;
            }
            //两个背包大小不正常
            if ((x & 0x1) == 1 || ((y & 0x1) == 1)) {
                return 0;
            }
            //不能用min
            x = Math.max(x,y);
            x = x /2;
            int[][] dp = new int[len + 1][];
            //初始化第一行
            dp[0] = new int[x + 1];
            for (int j = 1; j < x; j++) {
                dp[0][j] =0;
            }
            dp[0][0] =1;// 00 => 1
            for (int i = 1; i <= len; i++) {
                dp[i] = new int[x + 1];
                for (int j = 0; j <= x ; j++) {
                    int i1 = j - nums[i-1];
                    int ijVal = dp[i - 1][j];
                    if (i1 >= 0) {
                        ijVal += dp[i - 1][i1];
                    } else {
                        //pass
                    }
                    dp[i][j]= ijVal;
//                    logger.info(" {}", ijVal);
                }
//                logger.info("");
            }
            return dp[len][x];
        }

    }

    public static void main(String[] args) {


        logger.info("{}", new Solution().findTargetSumWays1(new int[]{0,0,1,0}, 1));//8
        logger.info("{}", new Solution().findTargetSumWays1(new int[]{0,0,0,0,0,0,0,0,1}, 1));//256

        logger.info("{}", new Solution().findTargetSumWays1(new int[]{1, 0}, 1));//2
        logger.info("{}", new Solution().findTargetSumWays1(new int[]{1}, 1));//1
        logger.info("{}", new Solution().findTargetSumWays1(new int[]{1,4,1,3,2,1,2,10,8,9}, 25));//16

        logger.info("{}", new Solution().findTargetSumWays1(new int[]{1,4,1,3,2,1,2}, 6));//11
        logger.info("{}", new Solution().findTargetSumWays1(new int[]{1,3}, -2));//1
        logger.info("{}", new Solution().findTargetSumWays1(new int[]{1,1,1,1,1}, 3));//5

    }
}
