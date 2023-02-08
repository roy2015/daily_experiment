package com.guo.roy.research.leetcode.stage1.stage13;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/7/2
 *
 *
 *720. 词典中最长的单词
 * 给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。若其中有多个可行的答案，则返回答案中字典序最小的单词。
 *
 * 若无答案，则返回空字符串。
 *
 * 示例 1:
 *
 * 输入:
 * words = ["w","wo","wor","worl", "world"]
 * 输出: "world"
 * 解释:
 * 单词"world"可由"w", "wo", "wor", 和 "worl"添加一个字母组成。
 * 示例 2:
 *
 * 输入:
 * words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
 * 输出: "apple"
 * 解释:
 * "apply"和"apple"都能由词典中的单词组成。但是"apple"得字典序小于"apply"。
 * 注意:
 *
 * 所有输入的字符串都只包含小写字母。
 * words数组长度范围为[1,1000]。
 * words[i]的长度范围为[1,30]。
 *
 *
 */
public class TestSolution720 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution720.class);


    static class Solution {

        /**
         *
         *
         * 性能不怎么好，以后优化吧
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 38 ms, 在所有 Java 提交中击败了21.89%的用户
         * 内存消耗：
         * 40 MB, 在所有 Java 提交中击败了100.00%的用户
         *
         * @param words
         * @return
         */
        public String longestWord(String[] words) {
            if (words == null && (words.length)== 0) {
                return "";
            }

            Set<String> hashSet = new HashSet<>();
            for (String word : words) {
                if (word != "") {
                    hashSet.add(word);
                }
            }

            int maxLen = 0;
            String maxString = "" ;

            for (String str : hashSet) {
                int tmpLen = str.length();
                if (tmpLen > 1) {
                    int i;
                    for (i = tmpLen -1; i > 0 ; i--) {
                        String substring = str.substring(0, i);
                        if (!hashSet.contains(substring)) {
                            break;
                        }
                    }
                    if (i > 0) {
                        continue;
                    }
                } else {
                    if (maxLen == 0) {
                        tmpLen = 1;
                    }
                }

                if (tmpLen > maxLen) {
                    maxLen = tmpLen;
                    maxString = str;
                } else if (tmpLen == maxLen) {
                    if (maxString.compareTo(str) > 0) {
                        maxString = str;
                    }
                }
            }
            return maxString;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().longestWord(new String[]{
                "a", "banana", "app", "appl", "ap", "apply", "apple"
        }));//apple

        logger.info("{}", new Solution().longestWord(new String[]{
                "w","wo","wor","worl", "world"
        }));//world

    }
}
