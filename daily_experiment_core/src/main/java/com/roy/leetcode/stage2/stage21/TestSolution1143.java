package com.roy.leetcode.stage2.stage21;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;

/**1143. 最长公共子序列
 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。

 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。

 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。



 示例 1：

 输入：text1 = "abcde", text2 = "ace"
 输出：3
 解释：最长公共子序列是 "ace" ，它的长度为 3 。
 示例 2：

 输入：text1 = "abc", text2 = "abc"
 输出：3
 解释：最长公共子序列是 "abc" ，它的长度为 3 。
 示例 3：

 输入：text1 = "abc", text2 = "def"
 输出：0
 解释：两个字符串没有公共子序列，返回 0 。


 提示：

 1 <= text1.length, text2.length <= 1000
 text1 和 text2 仅由小写英文字符组成。
 * @author guojun
 * @date 2021/6/11
 */
public class TestSolution1143 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1143.class);


    static class Solution {

        /**
         *
         * 二维动态规划， 借鉴的思路，后面自己写的递归超时了，带也有参考意义
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 添加备注
         *
         * 执行用时：
         * 5 ms
         * , 在所有 Java 提交中击败了
         * 98.89%
         * 的用户
         * 内存消耗：
         * 45 MB
         * , 在所有 Java 提交中击败了
         * 42.21%
         * 的用户
         * 通过测试用例：
         * 44 / 44
         * @param text1
         * @param text2
         * @return
         */
        public int longestCommonSubsequence(String text1, String text2) {
            char[] chars1Array = text1.toCharArray();
            char[] chars2Array = text2.toCharArray();
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
            return dp[chars1Len][chars2Len];

        }
    }

    static class Solution1 {
        private char[] chars1;
        private char[] chars2;
        private int chars1Len;
        private int chars2Len;
        private List<Integer>[] idxs;
        private int retMax;

        public int longestCommonSubsequence(String text1, String text2) {
            if (text1.indexOf(text2) != -1) {
                return text2.length();
            } else if (text2.indexOf(text1) != -1) {
                return text1.length();
            }

            chars1 = text1.toCharArray();
            chars2 = text2.toCharArray();

            chars1Len = chars1.length;
            chars2Len = chars2.length;

            idxs = new ArrayList[chars1Len];
            //构建字符串1每个字符在字符串2的位置
            for (int i = 0; i < chars1Len; i++) {
                char c = chars1[i];
                List<Integer> searchCharIdxs = getSearchCharIdxs(c);
                idxs[i] = searchCharIdxs;
            }

            doProcess(0, -1, 0);
            return retMax;
        }

        private void doProcess(int loop, int limit, int preMax) {
            if ((chars1Len - loop + preMax) <=retMax ) {
                return;
            }
            if (loop == chars1Len) {
                if (preMax > retMax) {
                    retMax = preMax;
                }
                return;
            }
            //选
            List<Integer> idx = idxs[loop];
            if (idx.size() ==0 || idx.get(idx.size()-1) < limit ) {
                doProcess(loop+1,limit, preMax);
            } else {
                for (int i = 0; i < idx.size(); i++) {
                    Integer iVal = idx.get(i);
                    if (iVal > limit ) {
                        doProcess(loop+1, iVal, preMax +1);
                        if (i == 0) break;
                    }
                }
                doProcess(loop+1,limit, preMax);
            }
        }

        private void doProcess1(int loop, int limit, int preMax) {
            if ((chars1Len - loop + preMax) <=retMax ) {
                return;
            }
            if (loop == chars1Len) {
                if (preMax > retMax) {
                    retMax = preMax;
                }
                return;
            }

            //不选
            doProcess(loop+1,limit, preMax);

            //选
            List<Integer> idx = idxs[loop];
            if (idx.size() ==0 || idx.get(idx.size()-1) < limit ) {
                return;
            }
            for (int i = 0; i < idx.size(); i++) {
                Integer iVal = idx.get(i);
                if (iVal > limit ) {
                    limit = iVal;
                    doProcess(loop+1, limit, preMax +1);
                    if (i == 0) return;
                }
            }
        }

        private List<Integer> getSearchCharIdxs(char search) {
            List<Integer> ret = new ArrayList<>();
            for (int i = 0; i < chars2Len; i++) {
                if (chars2[i] == search) {
                    ret.add(i);
                }
            }
            return ret;
        }
    }

    public static void main(String[] args) {

        logger.info("");
        logger.info("{}", new Solution().longestCommonSubsequence("hergrwzsjgjmnwfwjyxyhafstetgbydobynmxabavodsfwbqbevozkjkpwvw",
            "pgrwlabutilctsrgbgxorwjezspgxwredqjklabwterwzyzstwpobwjujwjkb"));//19
        logger.info("{}", new Solution().longestCommonSubsequence("zelohidwdcxilkvytazgfozonwrkbalcpizgtmzuhkbsfefshmtctuvc",
            "rwjmzoncvihmlmvgdujopwrajuxmjefonivyvkncnwnkjaxkritkporsj"));//17

        logger.info("{}", new Solution().longestCommonSubsequence("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));

        logger.info("{}", new Solution().longestCommonSubsequence("abcba","abcbcba"));//5
        logger.info("{}", new Solution().longestCommonSubsequence("abcde","ace"));//3
        logger.info("{}", new Solution().longestCommonSubsequence("abc","abc"));//3
        logger.info("{}", new Solution().longestCommonSubsequence("abc","def"));//0

    }
}
