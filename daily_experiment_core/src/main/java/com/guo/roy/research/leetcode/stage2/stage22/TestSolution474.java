package com.guo.roy.research.leetcode.stage2.stage22;

import org.slf4j.LoggerFactory;


/**
 *
 *
 * 474. 一和零 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 *
 * 请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
 *
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3 输出：4 解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。 其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"}
 * 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。 示例 2：
 *
 * 输入：strs = ["10", "0", "1"], m = 1, n = 1 输出：2 解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
 *
 *
 * 提示：
 *
 * 1 <= strs.length <= 600 1 <= strs[i].length <= 100 strs[i] 仅由 '0' 和 '1' 组成 1 <= m, n <= 100
 *
 * @author guojun
 * @date 2021/9/12
 */
public class TestSolution474 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution474.class);

    static class Solution {

        /**
         *
         * 二维背包问题，不好想，看了官方题解才想起来
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 添加备注
         *
         * 执行用时：
         * 50 ms
         * , 在所有 Java 提交中击败了
         * 51.72%
         * 的用户
         * 内存消耗：
         * 67.4 MB
         * , 在所有 Java 提交中击败了
         * 17.51%
         * 的用户
         * 通过测试用例：
         *
         * @param strs
         * @param m
         * @param n
         * @return
         */
        public int findMaxForm(String[] strs, int m, int n) {
            int[] zeroCntArray;
            int[] oneCntArray;
            int l = strs.length;
            zeroCntArray = new int[l + 1];
            oneCntArray = new int[l + 1];

            // 计算对应字符串中1和0的个数
            for (int i = 1; i <= l; i++) {
                int zeroCnt = 0;
                int oneCnt = 0;
                char[] chars = strs[i - 1].toCharArray();
                int length1 = chars.length;
                for (int j = 0; j < length1; j++) {
                    if (chars[j] == '0') {
                        zeroCnt++;
                    } else {
                        oneCnt++;
                    }
                }
                zeroCntArray[i] = zeroCnt;
                oneCntArray[i] = oneCnt;
            }
            //动态规划
            int[][][] dp = new int[l + 1][m + 1][n + 1];
            for (int i = 1; i <= l; i++) {
                int zeroCnt = zeroCntArray[i];
                int oneCnt = oneCntArray[i];
                for (int j = 0; j <= m; j++) {
                    for (int k = 0; k <= n; k++) {
                        if (zeroCnt > j || oneCnt > k) {
                            dp[i][j][k] = dp[i - 1][j][k];
                        } else {
                            dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - zeroCnt][k - oneCnt] + 1);
                        }
                    }
                }
            }
            return dp[l][m][n];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int maxForm = 0;

        maxForm = solution.findMaxForm(new String[] { "0", "000", "001", "001", "0111", "1111", "11111", "111111", "1111111" }, 4, 23);
        logger.info("{}", maxForm);// 6

        maxForm = solution.findMaxForm(new String[] { "10","0001","111001","1","0" }, 5, 3);//4
        logger.info("{}", maxForm);// 6
    }
}
