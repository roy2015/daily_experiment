package com.roy.miscellaneous.leetcode.stage12;

import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.function.BiFunction;

/**
 * @author guojun
 * @date 2020/5/19
 *
 * 面试题50. 第一个只出现一次的字符
在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。

示例:

s = "abaccdeff"
返回 "b"

s = ""
返回 " "


限制：

0 <= s 的长度 <= 50000
 *
 */
public class TestSolutionInterview50 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolutionInterview50.class);


    static class Solution {
        /**
         *
         * 用了jdk8 的map.compute
         *
         *
         * 执行结果：
         通过
         显示详情
         执行用时 :30 ms, 在所有 Java 提交中击败了49.85%的用户
         内存消耗 :39.9 MB, 在所有 Java 提交中击败了100.00%的用户
         *
         * @param s
         * @return
         */
        public char firstUniqChar(String s) {
            if (s.length() == 0) {
                return ' ';
            }
            char[] chars = s.toCharArray();
            HashMap<Character, Integer> map = new HashMap<>();

            for (char aChar : chars) {
                map.compute(aChar, (character, old) -> {
                    Integer newVal ;
                    if (old == null) {
                        newVal = new Integer(1);
                    } else {
                        newVal = old + 1;
                    }
                    return newVal;
                });
            }

            for (char aChar : chars) {
                if (map.get(aChar) == 1) {
                    return aChar;
                }
            }
            return ' ';
        }

        /**
         *
         *
         * 执行结果：通过显示详情
         执行用时 :18 ms, 在所有 Java 提交中击败了67.31%的用户
         内存消耗 :40.5 MB, 在所有 Java 提交中击败了100.00%的用户
         *
         * @param s
         * @return
         */
        public char firstUniqChar1(String s) {
            if (s.length() == 0) {
                return ' ';
            }
            char[] chars = s.toCharArray();
            int len = s.length();

            if (len == 1) {
                return chars[0];
            }

            for (int i = 0; i < len; i++) {
                int j = 0;
                for (; j <len; j++ ) {
                    if (i !=j && chars[i] == chars[j]) {
                        break;
                    }
                }
                if (j == len ) {
                    return chars[i];
                }
            }
            return ' ';
        }
    }

    public static void main(String[] args) {
        logger.info("*{}*", new Solution().firstUniqChar1("dddccdbba"));//a
        logger.info("*{}*", new Solution().firstUniqChar1("aadadaad"));//' '
        logger.info("*{}*", new Solution().firstUniqChar1("cc"));//' '
        logger.info("*{}*", new Solution().firstUniqChar1(""));//' '
        logger.info("*{}*", new Solution().firstUniqChar1("abaccdeff"));//b
        logger.info("*{}*", new Solution().firstUniqChar1("z"));//z
    }
}
