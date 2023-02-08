package com.guo.roy.research.leetcode.stage1.stage11;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/5/13 11:30
 *
 * 58. 最后一个单词的长度
给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。

如果不存在最后一个单词，请返回 0 。

说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。



示例:

输入: "Hello World"
输出: 5
 */
public class TestSolution58 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution58.class);


    static class Solution {

        /**
         *
         * 执行结果：通过
         * 显示详情
         * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗 :37.3 MB, 在所有 Java 提交中击败了6.38%的用户
         *
         * @param s
         * @return
         */
        public int lengthOfLastWord(String s) {
            if (s ==null) {
                return 0;
            }

            char[] chars = s.toCharArray();
            int length = chars.length;
            int lastWordLen = 0;
            int i ;
            //找第一个非空格
            for (i = length -1 ; i >= 0 ; i--) {
                if (chars[i] != ' ') {
                    lastWordLen ++;
                    break;
                }
            }
            if (i < 0) {
                return 0;
            }
            for (int j = i -1; j >= 0 ; j--, lastWordLen ++) {
                if (chars[j] == ' ') {
                    break;
                }
            }
            return lastWordLen;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().lengthOfLastWord(" h elloworld1  "));
    }
}
