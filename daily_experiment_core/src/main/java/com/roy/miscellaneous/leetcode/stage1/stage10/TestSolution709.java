package com.roy.miscellaneous.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/9/5.
 *
 *
 * 实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的
 * 大写字母转换成小写字母，之后返回新的字符串。
 */
public class TestSolution709 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution709.class);

    /**
     * 执行用时 :0 ms, 在所有 java 提交中击败了100.00%的用户
     内存消耗 :34.2 MB, 在所有 java 提交中击败了59.86%的用户
     */
    static class Solution {
        public String toLowerCase(String str) {
            char[] chars = new char[str.length()];
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if ( c >= 'A' && c <= 'Z' ) {
                    chars[i] = (char) (c - 'A' + 'a');
                } else {
                    chars[i] = c;
                }
            }

            return new String(chars);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String hello = solution.toLowerCase("Hello");
        String lovely = solution.toLowerCase("LOVELY");

        logger.info("{},{}", hello, lovely);
    }

}
