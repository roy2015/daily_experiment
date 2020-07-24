package com.roy.miscellaneous.leetcode.stage1.stage12;

import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author guojun
 * @date 2020/7/24
 *
 *
 * 409. 最长回文串
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 *
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 *
 * 注意:
 * 假设字符串的长度不会超过 1010。
 *
 * 示例 1:
 *
 * 输入:
 * "abccccdd"
 *
 * 输出:
 * 7
 *
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 *
 *
 */
public class TestSolution409 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution409.class);


    static class Solution {
        /**
         *
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 6 ms, 在所有 Java 提交中击败了35.85%的用户
         * 内存消耗：
         * 37.9 MB, 在所有 Java 提交中击败了5.00%的用户
         *
         * @param s
         * @return
         */
        public int longestPalindrome(String s) {
            if (s.length() ==0) {
                return 0;
            }
            char[] chars = s.toCharArray();
//            int length = chars.length;
            Map<Integer, Integer> map = new HashMap<>();
            for (char aChar : chars) {
                int val = aChar;
                map.compute(val, (key, oldVal) -> {
                    if (oldVal == null) {
                        oldVal = new Integer(1);
                    } else {
                        oldVal ++;
                    }
                    return oldVal;
                });
            }

            boolean oneFlag = false;
            int sum = 0;

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                Integer value = entry.getValue();
                if ( !oneFlag && ((value & 0x1) == 1) ) {
                    oneFlag = true;
                } else {}
                sum += value /2;
            }
            if (oneFlag) {
                sum = sum * 2 +1;
            } else {
                sum = sum *2;
            }
            return sum;
        }

        /**
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 2 ms, 在所有 Java 提交中击败了70.90%
         * 的用户
         * 内存消耗：
         * 37.7 MB, 在所有 Java 提交中击败了5.00%
         * 的用户
         *
         * @param s
         * @return
         */
        public int longestPalindrome1(String s) {
            if (s.length() ==0) {
                return 0;
            }

            int[] lowerCaseArray = new int[26];
            int[] upperCaserray = new int[26];
            char[] chars = s.toCharArray();

            for (char aChar : chars) {
                if (aChar >= 'a') {
                    lowerCaseArray[aChar - 'a'] ++;
                } else {
                    upperCaserray[aChar - 'A']++;
                }
            }

            boolean oneFlag = false;
            int sum = 0;
            for (int value : lowerCaseArray) {
                if ( !oneFlag && ((value & 0x1) == 1) ) {
                    oneFlag = true;
                } else {}
                sum += value /2;
            }

            for (int value : upperCaserray) {
                if ( !oneFlag && ((value & 0x1) == 1) ) {
                    oneFlag = true;
                } else {}
                sum += value /2;
            }


            if (oneFlag) {
                sum = sum * 2 +1;
            } else {
                sum = sum *2;
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        logger.info("{}" + (int)'a');
        logger.info("{}" + (int)'z');
        logger.info("{}" + (int)'A');
        logger.info("{}" + (int)'Z');
        logger.info("{}", new Solution().longestPalindrome1("ababababa"));//9
        logger.info("{}", new Solution().longestPalindrome1("aab"));//3
        logger.info("{}", new Solution().longestPalindrome1("aaa"));//3
        logger.info("{}", new Solution().longestPalindrome1("aa"));//2
        logger.info("{}", new Solution().longestPalindrome1("a"));//1
        logger.info("{}", new Solution().longestPalindrome1("abccccdd"));//7
    }
}
