package com.roy.leetcode.stage1.stage12;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/6/24
 *
 *
 * 345. 反转字符串中的元音字母
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 *
 * 示例 1:
 *
 * 输入: "hello"
 * 输出: "holle"
 * 示例 2:
 *
 * 输入: "leetcode"
 * 输出: "leotcede"
 * 说明:
 * 元音字母不包含字母"y"。
 *
 * 通过次数38,204提交次数76,246
 *
 *
 */
public class TestSolution345 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution345.class);


    static class Solution {

        /**
         * 双指针，一头一尾
         *
         * 显示详情
         * 执行用时：
         * 2 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：
         * 39.7 MB, 在所有 Java 提交中击败了10.00%的用户
         *
         * @param s
         * @return
         */
        public String reverseVowels(String s) {
            if (null == s) {
                return null;
            }

            char[] chars = s.toCharArray();
            int length = chars.length;
            int p = 0;
            int q = length -1;
            while (p < q) {
                char tempChar;
                if (!isYuanyinChar(chars[p])) {
                    p ++;
                    if (!isYuanyinChar(chars[q])) {
                        q --;
                    } else {}
                } else {
                    if (!isYuanyinChar(chars[q])) {
                        q --;
                    } else {
                        tempChar = chars[p];
                        chars[p] = chars[q];
                        chars[q] = tempChar;

                        p++; q--;
                    }
                }

            }
            return new String(chars);
        }

        private boolean isYuanyinChar (char charVal) {
            switch (charVal) {
                case 'a':
                case 'A':
                case 'e':
                case 'E':
                case 'i':
                case 'I':
                case 'o':
                case 'O':
                case 'u':
                case 'U':return true;
                default: return false;
            }
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().reverseVowels("aA"));//Aa
        logger.info("{}", new Solution().reverseVowels("hello"));//holle
        logger.info("{}", new Solution().reverseVowels("leetcode"));//leotcede
    }
}
