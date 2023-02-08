package com.guo.roy.research.leetcode.stage1.stage11;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/4/29 10:40
 *
 *
 * 1309. 解码字母到整数映射
 * 给你一个字符串 s，它由数字（'0' - '9'）和 '#' 组成。我们希望按下述规则将 s 映射为一些小写英文字符：
 *
 * 字符（'a' - 'i'）分别用（'1' - '9'）表示。
 * 字符（'j' - 'z'）分别用（'10#' - '26#'）表示。
 * 返回映射之后形成的新字符串。
 *
 * 题目数据保证映射始终唯一。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "10#11#12"
 * 输出："jkab"
 * 解释："j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".
 * 示例 2：
 *
 * 输入：s = "1326#"
 * 输出："acz"
 * 示例 3：
 *
 * 输入：s = "25#"
 * 输出："y"
 * 示例 4：
 *
 * 输入：s = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"
 * 输出："abcdefghijklmnopqrstuvwxyz"
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s[i] 只包含数字（'0'-'9'）和 '#' 字符。
 * s 是映射始终存在的有效字符串。
 */
public class TestSolution1309 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1309.class);


    static class Solution {

        /**
         *
         *  a - i 1-9
         *  j -s  10# - 19#   t-z 20#-26#
         *
         *
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗 :37.5 MB, 在所有 Java 提交中击败了5.09%的用户
         * @param s
         * @return
         */
        public String freqAlphabets(String s) {
            int len = s.length();
            char[] chars = s.toCharArray();

            StringBuffer sb = new StringBuffer();
            for(int i =0; i< len; ) {
                if ( i +2 < len && ('#' == chars[i+2])) {
                    if ('1' == chars[i]) {
                        sb.append((char)(chars[i+1] - '0' + 'j'));
                    } else {
                        sb.append((char)(chars[i+1] - '0' + 't'));
                    }
                    i = i +3;
                } else {
                    sb.append((char)(chars[i] - '1' + 'a'));
                    i++;
                }
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().freqAlphabets(new String("25#")));
        logger.info("{}", new Solution().freqAlphabets(new String("1326#")));
        logger.info("{}", new Solution().freqAlphabets(new String("12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#")));


    }
}
