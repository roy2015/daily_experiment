package com.roy.miscellaneous.leetcode.stage11;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/4/29 13:48
 *
 *125. 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 *
 */
public class TestSolution125 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution125.class);


    static class Solution {

        /**
         *
         * 用的首尾双指针
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时 :2 ms, 在所有 Java 提交中击败了99.88%的用户
         * 内存消耗 :40 MB, 在所有 Java 提交中击败了7.14%的用户
         * @param s
         * @return
         */
        public boolean isPalindrome(String s) {
            if (s.length() ==0 || s == null) {
                return true;
            }

            char[] chars = s.toCharArray();

            int len = s.length();
            int p = 0, q = len -1;
            while (p < q) {
                char pChar = chars[p];
                char qChar = chars[q];
                if ((pChar <'0') || (pChar >'9' && pChar <'A') || (pChar >'Z' && pChar <'a')
                        || (pChar >'z') ) {
                    p ++;
                    continue;
                }
                if ((qChar <'0') || (qChar >'9' && qChar <'A') || (qChar >'Z' && qChar <'a')
                        || (qChar >'z') ) {
                    q --;
                    continue;
                }
                //正常字符

                if ((pChar >='0' && pChar <='9') && (qChar >='0' && qChar <='9')
                        ) {
                    if (pChar == qChar) {
                        p ++;
                        q --;
                        continue;
                    } else return false;
                }

                if (((pChar >='a' && pChar <='z') || (pChar >='A' && pChar <='Z'))
                     && ((qChar >='a' && qChar <='z') || (qChar >='A' && qChar <='Z'))) {
                    if ( pChar == qChar || Math.abs(pChar - qChar) == 32) {
                        p ++;
                        q --;
                        continue;
                    } else {
                        return false;
                    }
                }
                return false;

            }

            return true;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().isPalindrome("A man, a plan, a canal: Panama"));
        logger.info("{}", new Solution().isPalindrome("race a car"));

    }
}
