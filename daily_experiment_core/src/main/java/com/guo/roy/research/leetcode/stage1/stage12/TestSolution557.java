package com.guo.roy.research.leetcode.stage1.stage12;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/5/20
 *
 * 557. 反转字符串中的单词 III
给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。

示例 1:

输入: "Let's take LeetCode contest"
输出: "s'teL ekat edoCteeL tsetnoc"
注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 */
public class TestSolution557 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution557.class);


    static class Solution {

        /**
         *
         * step1. 分割成单词
         * step2. 单词翻转
         *
         * 执行结果：通过显示详情
         执行用时 :4 ms, 在所有 Java 提交中击败了95.22%的用户
         内存消耗 :40.6 MB, 在所有 Java 提交中击败了5.00%的用户
         *
         * @param s
         * @return
         */
        public String reverseWords(String s) {
            char[] chars = s.toCharArray();
            int len = chars.length;
            int start =0;
            int end =0;
            while (true) {
                // find blank
                while ( end < len && chars[end] != ' ') {
                    end ++;
                }
                if (end == len) {//最后一个单词
                    reverseSegment(chars, start, end -1);
                    break;
                }
                reverseSegment(chars, start, end -1);
                start = end +1;
                end = start;
            }
            return new String(chars);
        }

        /**
         * 翻转单词
         * @param chars
         * @param start
         * @param end
         */
        private void reverseSegment(char[] chars, int start, int end) {
            while (start <= end) {
                char tmp;
                tmp = chars[start];
                chars[start] = chars[end];
                chars[end] = tmp;
                start ++;
                end --;
            }
        }
    }

    public static void main(String[] args) {
        logger.info("*{}*", new Solution().reverseWords("i love "));
        logger.info("*{}*", new Solution().reverseWords("Let's take LeetCode contest"));
        logger.info("*{}*", new Solution().reverseWords("Let's"));

    }
}
