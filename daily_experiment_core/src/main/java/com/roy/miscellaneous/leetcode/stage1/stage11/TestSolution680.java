package com.roy.miscellaneous.leetcode.stage1.stage11;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/1/21 10:40
 *
 *
 * 680. 验证回文字符串 Ⅱ
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 *
 * 示例 1:
 *
 * 输入: "aba"
 * 输出: True
 * 示例 2:
 *
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 * 注意:
 *
 * 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
 *
 *
 * 途虎研发中心第二届技术比武第二题
 *
 */
public class TestSolution680 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution680.class);


    static class Solution {


        /**
         *
         * 执行结果：通过
         * 显示详情
         * 执行用时：7 ms, 在所有 Java 提交中击败了95.18%的用户
         * 内存消耗：39.2 MB, 在所有 Java 提交中击败了18.17%的用户
         *
         * @param s
         * @return
         */
        public boolean validPalindrome(String s) {
            char[] charArray = s.toCharArray();
            int length = charArray.length;
            int lowIdx, highIdx;
            lowIdx = 0;
            highIdx = length -1;

            while (lowIdx <= highIdx && charArray[lowIdx] == charArray[highIdx]) {
                lowIdx ++;
                highIdx --;
            }

            if (lowIdx > highIdx) {
                return true;
            }

            int start = lowIdx;
            int end = highIdx;

            //删lowIdx所在的字符
            lowIdx ++;
            while (lowIdx <= highIdx && charArray[lowIdx] == charArray[highIdx]) {
                lowIdx ++;
                highIdx--;
            }
            if (lowIdx >highIdx) {
                return true;
            }

            //删highIdx所在的字符
            lowIdx = start;
            highIdx = end;
            highIdx --;

            while (lowIdx <= highIdx && charArray[lowIdx] == charArray[highIdx]) {
                lowIdx ++;
                highIdx--;
            }
            if (lowIdx >highIdx) {
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().validPalindrome("eccer"));//true
        logger.info("{}", new Solution().validPalindrome("cbbcc"));//true
        logger.info("{}", new Solution().validPalindrome("abc"));//false
        logger.info("{}", new Solution().validPalindrome("deee"));//true
    }
}
