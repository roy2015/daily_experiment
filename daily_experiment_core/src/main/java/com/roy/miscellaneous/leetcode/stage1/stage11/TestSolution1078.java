package com.roy.miscellaneous.leetcode.stage1.stage11;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/11/2
 *
 * 1078. Bigram 分词
 * 给出第一个词 first 和第二个词 second，考虑在某些文本 text 中可能以 "first second third" 形式出现的情况，其中 second 紧随 first 出现，third 紧随 second 出现。
 *
 * 对于每种这样的情况，将第三个词 "third" 添加到答案中，并返回答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：text = "alice is a good girl she is a good student", first = "a", second = "good"
 * 输出：["girl","student"]
 * 示例 2：
 *
 * 输入：text = "we will we will rock you", first = "we", second = "will"
 * 输出：["we","rock"]
 *
 *
 * 提示：
 *
 * 1 <= text.length <= 1000
 * text 由一些用空格分隔的单词组成，每个单词都由小写英文字母组成
 * 1 <= first.length, second.length <= 10
 * first 和 second 由小写英文字母组成
 *
 *
 */
public class TestSolution1078 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1078.class);


    static class Solution {
        /**
         * 1. 分离出单词
         * 2. Bigram 分词
         *
         * 顺带手写出来解析文本里单词的通用算法
         *
         * 执行结果：通过
         * 显示详情
         * 执行用时：1 ms, 在所有 Java 提交中击败了70.00%的用户
         * 内存消耗：36.9 MB, 在所有 Java 提交中击败了38.62%的用户
         *
         * @param text
         * @param first
         * @param second
         * @return
         */
        public String[] findOcurrences(String text, String first, String second) {
            List<String> wordList = parseWords(text);
            if (wordList.isEmpty()) {
                return new String[]{};
            }

            List<String> retList = new ArrayList<>();
            int end = wordList.size() -2;
            for (int i = 0; i < end; i++) {
                String iWord = wordList.get(i);
                if (first.equals(iWord) &&  wordList.get(i + 1).equals(second)) {
                    retList.add(wordList.get(i + 2));
                }
            }
            return retList.toArray(new String[retList.size()]);
        }

        /**
         * 手写解析文本里单词的通用算法，
         * 支持
         *  1.单词间多个空格
         *  2.全是空格
         *  3.空字符串
         *
         * @param text 要解析的文本
         * @return 返回单词列表
         *
         */
        public List<String> parseWords(String text) {
            List<String> retList = new ArrayList<>();
            int p = 0, q = 0;
            char[] textChars = text.toCharArray();
            int length = textChars.length;
            while (true) {
                while (q < length && textChars[q] == ' ') {
                    q++;
                }
                if (q == length) {
                    return retList;
                }

                p = q;
                //找空格暨单词结尾
                while (q < length && textChars[q] != ' ') q++;
                String word = new String(textChars, p, q-p);
                retList.add(word);
            }
        }

    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().parseWords(" alice is  a  good girl  she is a good student"));
        logger.info("{}", new Solution().findOcurrences("alice is a good girl she is a good student",
                "a","good"));//["girl","student"]
        logger.info("{}", new Solution().findOcurrences("we will we will rock you",
                "we","will"));//["we","rock"]
    }
}
