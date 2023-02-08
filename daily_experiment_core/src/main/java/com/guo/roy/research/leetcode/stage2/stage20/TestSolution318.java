package com.guo.roy.research.leetcode.stage2.stage20;

import java.util.Arrays;

import org.slf4j.LoggerFactory;

/**
 * 318. 最大单词长度乘积
 给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，并且这两个单词不含有公共字母。你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。



 示例 1:

 输入: ["abcw","baz","foo","bar","xtfn","abcdef"]
 输出: 16
 解释: 这两个单词为 "abcw", "xtfn"。
 示例 2:

 输入: ["a","ab","abc","d","cd","bcd","abcd"]
 输出: 4
 解释: 这两个单词为 "ab", "cd"。
 示例 3:

 输入: ["a","aa","aaa","aaaa"]
 输出: 0
 解释: 不存在这样的两个单词。


 提示：

 2 <= words.length <= 1000
 1 <= words[i].length <= 1000
 words[i] 仅包含小写字母

 * @author guojun
 * @date 2021/1/21 10:40
 */
public class TestSolution318 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution318.class);


    static class Solution {
        /**
         *
         * 复杂度有点高，有没有优化的方案呢？
         *
         * 执行用时：306 ms, 在所有 Java 提交中击败了18.59%的用户
         * 内存消耗：39.3 MB, 在所有 Java 提交中击败了5.08%的用户
         * 通过测试用例：167 / 167
         * @param words
         * @return
         */
        public int maxProduct(String[] words) {
            if (words == null || words.length == 0 || words.length == 1) {
                return 0;
            }
            // 去重复,可以减少参与计算的字符串数量
            String[] filteredWords = Arrays.stream(words).distinct().toArray(String[]::new);
            int length = filteredWords.length;
            int ret = 0;
            for (int i = 0; i < length - 1; i++) {
                for (int j = i+1; j < length; j++) {
                    if (!checkHaveSameChar(filteredWords[i], filteredWords[j] )) {
                        int k = filteredWords[i].length() * filteredWords[j].length();
                        if (k > ret) ret = k;
                    }
                }
            }
            return ret;
        }

        /**
         * 校验是否包含相同字符
         * @param s1
         * @param s2
         * @return
         */
        private boolean checkHaveSameChar(String s1, String s2) {
            int[] boolmfilter = new int[26];
            for (char c : s1.toCharArray()) {
                boolmfilter[c - 'a'] = 1;
            }
            for (char c : s2.toCharArray()) {
                if (boolmfilter[c - 'a'] == 1) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().maxProduct(new String[]{"a","aa","aaa","aaaa"}));//0
        logger.info("{}", new Solution().maxProduct(new String[]{"a","ab","abc","d","cd","bcd","abcd"}));//4
        logger.info("{}", new Solution().maxProduct(new String[]{"abcw","baz","foo","bar","xtfn","abcdef"}));//16


    }
}
