package com.roy.miscellaneous.leetcode.stage2.stage22;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;

import org.slf4j.LoggerFactory;

/**1048. 最长字符串链
 给出一个单词数组 words ，其中每个单词都由小写英文字母组成。

 如果我们可以 不改变其他字符的顺序 ，在 wordA 的任何地方添加 恰好一个 字母使其变成 wordB ，那么我们认为 wordA 是 wordB 的 前身 。

 例如，"abc" 是 "abac" 的 前身 ，而 "cba" 不是 "bcad" 的 前身
 词链是单词 [word_1, word_2, ..., word_k] 组成的序列，k >= 1，其中 word1 是 word2 的前身，word2 是 word3 的前身，依此类推。一个单词通常是 k == 1 的 单词链 。

 从给定单词列表 words 中选择单词组成词链，返回 词链的 最长可能长度 。


 示例 1：

 输入：words = ["a","b","ba","bca","bda","bdca"]
 输出：4
 解释：最长单词链之一为 ["a","ba","bda","bdca"]
 示例 2:

 输入：words = ["xbc","pcxbcf","xb","cxbc","pcxbc"]
 输出：5
 解释：所有的单词都可以放入单词链 ["xb", "xbc", "cxbc", "pcxbc", "pcxbcf"].
 示例 3:

 输入：words = ["abcd","dbqca"]
 输出：1
 解释：字链["abcd"]是最长的字链之一。
 ["abcd"，"dbqca"]不是一个有效的单词链，因为字母的顺序被改变了。


 提示：

 1 <= words.length <= 1000
 1 <= words[i].length <= 16
 words[i] 仅由小写英文字母组成。

 * @author guojun
 * @date 2021/6/11
 */
public class TestSolution1048 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1048.class);


    static class Solution {

        /**
         *
         * 排序后动态规划
         *
         * 执行结果：通过
         * 显示详情
         * 添加备注
         *
         * 执行用时：51 ms, 在所有 Java 提交中击败了32.53%的用户
         * 内存消耗：41.4 MB, 在所有 Java 提交中击败了14.73%的用户
         * 通过测试用例：
         * 79 / 79
         * @param words
         * @return
         */
        public int longestStrChain(String[] words) {
            Arrays.sort(words, Comparator.comparingInt(String::length));
            int length = words.length;
            int[] dp = new int[length];
            dp[0] = 1;
            for (int i = 1; i < words.length; i++) {
                int max = 0;
                for (int j = i - 1; j >= 0; j--) {
                     if (compareTowString(words[j], words[i] ) ) {
                         if (dp[j] > max) {
                             max = dp[j];
                         }
                     }
                }
                dp[i] = max + 1;
            }

            int ret = 0;
            for (int i : dp) {
                if ( i > ret) ret = i;
            }

            return ret;
        }

        /**
         *
         * 长串一个个去字符看是否形如短串
         * @param shortStr 短的
         * @param longStr 长的
         * @return
         */
        public boolean compareTowString1(String shortStr, String longStr) {
            //长度不对
            int gap = longStr.length() - shortStr.length();
            if (gap != 1) {
                return false;
            }

            int length = longStr.length();
            for (int i = 0; i < length; i++) {
                //去除第几位
                if (i == 0) {
                    //第一位
                    if ( shortStr.equals(longStr.substring(1))) {
                        return true;
                    }
                } else if (i == (length - 1)){
                    //最后一位
                    if ( shortStr.equals(longStr.substring(0, length -1))) {
                        return true;
                    }
                } else {
                    //中间一位
                    String pre = longStr.substring(0, i);
                    String after = longStr.substring(i+1);
                    if (shortStr.equals(pre.concat(after))) {
                        return true;
                    }
                }
            }
            return false;
        }

        /**
         *
         * 双指针优化前面频繁substring，提高了降低了为四分之一的时间复杂度
         * 思路：只允许一次的不同字符
         * @param str1  short string
         * @param str2  long string
         * @return
         */
        public boolean compareTowString(String str1, String str2) {
            //长度不对
            int str1Len = str1.length();
            int str2Len = str2.length();
            int gap = str1Len - str2Len;
            if (gap != -1) {
                return false;
            }

            char[] str1Chars = str1.toCharArray();
            char[] str2Chars = str2.toCharArray();
            int p1 =0, p2= 0;
            while ((p1 < str1Len) && str1Chars[p1] == str2Chars[p2]   ) {
                p1 ++;
                p2++;
            }

            if (p1 == str1Len) {
                return true;
            }
            p2++;
            while ((p1 < str1Len) && str1Chars[p1] == str2Chars[p2]  ) {
                p1 ++;
                p2++;
            }
            return p1 == str1Len;
        }

    }

    public static void main(String[] args) {
//        logger.info("{}", new Solution().compareTowString1("abcd","abeacd"));
        logger.info("{}", new Solution().longestStrChain(new String[]{"a","ab","ac","bd","abc","abd","abdd"}));//4
        logger.info("{}", new Solution().longestStrChain(new String[]{"a","b","ba","bca","bda","bdca"}));//4
        logger.info("{}", new Solution().longestStrChain(new String[]{"xbc","pcxbcf","xb","cxbc","pcxbc"}));//5
        logger.info("{}", new Solution().longestStrChain(new String[]{"abcd","dbqca"}));//1
    }
}
