package com.roy.leetcode.stage2.stage21;

import org.slf4j.LoggerFactory;

/**
 *
 * 583. 两个字符串的删除操作
 * 给定两个单词 word1 和 word2 ，返回使得 word1 和  word2 相同所需的最小步数。
 *
 * 每步 可以删除任意一个字符串中的一个字符。
 *
 *
 *
 * 示例 1：
 *
 * 输入: word1 = "sea", word2 = "eat"
 * 输出: 2
 * 解释: 第一步将 "sea" 变为 "ea" ，第二步将 "eat "变为 "ea"
 * 示例  2:
 *
 * 输入：word1 = "leetcode", word2 = "etco"
 * 输出：4
 *
 *
 * 提示：
 *
 * 1 <= word1.length, word2.length <= 500
 * word1 和 word2 只包含小写英文字母
 * @author guojun
 * @date 2021/6/11
 */
public class TestSolution583 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution583.class);


    static class Solution {
        /**
         *
         *
         * 根据 1143 https://leetcode-cn.com/problems/longest-common-subsequence/举一反三吧
         * 一分钟搞定
         *
         * 执行结果：通过
         * 显示详情
         * 添加备注
         *
         * 执行用时：4 ms, 在所有 Java 提交中击败了99.67%的用户
         * 内存消耗：
         * 41.7 MB, 在所有 Java 提交中击败了54.10%的用户
         * 通过测试用例：1306 / 1306
         *
         * @param word1
         * @param word2
         * @return
         */
        public int minDistance(String word1, String word2) {
            char[] chars1Array = word1.toCharArray();
            char[] chars2Array = word2.toCharArray();
            int chars1Len = chars1Array.length;//行
            int chars2Len = chars2Array.length;//列

            int[][] dp = new int[chars1Len + 1][chars2Len +1];
            for (int i = 1; i <= chars1Len; i++) {
                for (int j = 1; j <=chars2Len ; j++) {
                    if (chars1Array[i-1] == chars2Array[j-1] ) {
                        dp[i][j] = dp[i-1][j-1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    }
                }
            }
            int k = dp[chars1Len][chars2Len];
            return chars1Len + chars2Len - 2*k;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution());
    }
}
