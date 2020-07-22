package com.roy.miscellaneous.leetcode.stage1.stage13;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/7/22
 *
 *
 * 696. 计数二进制子串
 * 给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。
 *
 * 重复出现的子串要计算它们出现的次数。
 *
 * 示例 1 :
 *
 * 输入: "00110011"
 * 输出: 6
 * 解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。
 *
 * 请注意，一些重复出现的子串要计算它们出现的次数。
 *
 * 另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。
 * 示例 2 :
 *
 * 输入: "10101"
 * 输出: 4
 * 解释: 有4个子串：“10”，“01”，“10”，“01”，它们具有相同数量的连续1和0。
 * 注意：
 *
 * s.length 在1到50,000之间。
 * s 只包含“0”或“1”字符。
 *
 *
 */
public class TestSolution696 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution696.class);


    /**
     *
     * s.length 在1到50,000之间。
     * s 只包含“0”或“1”字符。
     *
     */
    static class Solution {
        /**
         *
         *
         * 超出时间限制 todo
         * 思路：1. p=0,找第一个"不同的元素"并记录相同的个数num,记录下标 q
         *      2. 从q开始，找num个"不同的元素"，找不够跳出， p++
         *
         */
        public int countBinarySubstrings(String s) {
            int len = s.length();
            if (len == 1) {
                return 0;
            }
            char[] chars = s.toCharArray();
            int p;
            int q ;
            int ret = 0;

            for (p = 0; p < len ; p ++) {
                char pChar = chars[p];
                char qChar = (pChar == '1' ? '0' : '1') ;
                int appearTimes = 1;
                q = p +1;
                //find first diff
                while (q < len && chars[q] == pChar) {
                    appearTimes ++;
                    q ++;
                }
                // not find
                if (q == len) {
                    return ret;
                }
                //can find nums diffs
                int diffAppearTimes = 0;
                for (; q < len && diffAppearTimes < appearTimes ; q++) {
                    if (chars[q] != qChar ) {
                        break;
                    }
                    diffAppearTimes ++;
                }
                if (diffAppearTimes == appearTimes) {
                    ret ++;
                }
            }
            return ret;
        }

        public int countBinarySubstrings1(String s) {
            int len = s.length();
            if (len == 1) {
                return 0;
            }
            char[] chars = s.toCharArray();
            int p;
            int q ;
            int ret = 0;

            for (p = 0; p < len ; p ++) {
                char pChar = chars[p];
                char qChar = (pChar == '1' ? '0' : '1') ;
                int appearTimes = 1;
                q = p +1;
                //find first diff
                while (q < len && chars[q] == pChar) {
                    appearTimes ++;
                    q ++;
                }
                // not find
                if (q == len) {
                    return ret;
                }
                //can find nums diffs
                int diffAppearTimes = 0;
                for (; q < len && diffAppearTimes < appearTimes ; q++) {
                    if (chars[q] != qChar ) {
                        break;
                    }
                    diffAppearTimes ++;
                }
                if (diffAppearTimes == appearTimes) {
                    ret ++;
                }
            }
            return ret;
        }

    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().countBinarySubstrings("00110011"));//6
        logger.info("{}", new Solution().countBinarySubstrings("10101"));//4
    }
}
