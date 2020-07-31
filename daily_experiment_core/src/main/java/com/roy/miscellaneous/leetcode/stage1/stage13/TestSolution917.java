package com.roy.miscellaneous.leetcode.stage1.stage13;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/7/31
 *
 * 917. 仅仅反转字母
 * 给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
 *
 *
 *
 * 示例 1：
 *
 * 输入："ab-cd"
 * 输出："dc-ba"
 * 示例 2：
 *
 * 输入："a-bC-dEf-ghIj"
 * 输出："j-Ih-gfE-dCba"
 * 示例 3：
 *
 * 输入："Test1ng-Leet=code-Q!"
 * 输出："Qedo1ct-eeLg=ntse-T!"
 *
 *
 * 提示：
 *
 * S.length <= 100
 * 33 <= S[i].ASCIIcode <= 122
 * S 中不包含 \ or "
 *
 *
 *
 */
public class TestSolution917 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution917.class);


    static class Solution {

        /**
         *
         * 双指针
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：
         * 37.6 MB, 在所有 Java 提交中击败了75.51%的用户
         *
         * @param S
         * @return
         */
        public String reverseOnlyLetters(String S) {
            if (S == null || S.length() == 0) {
                return "";
            }

            int length = S.length();
            int p = 0;
            int q = length -1;
            char[] chars = S.toCharArray();

            while (true) {
                //找第一个字母
                while (p < q && !(checkLetter(chars[p])) ) {
                    p ++;
                }
                if (p >= q) {
                    break;
                }
                while (q > p && !(checkLetter(chars[q])) ) {
                    q--;
                }
                if (q <= p) {
                    break;
                }
                //swap
                char tmp = chars[p];
                chars[p] = chars[q];
                chars[q] = tmp;
                p ++;
                q --;
            }
            return new String(chars, 0 , length);
        }

        private boolean checkLetter(char ch) {
            if ((ch >= 'a' && ch <= 'z') ||
                    ( ch >= 'A' && ch <= 'Z' )) {
                return true;
            } else return false;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().reverseOnlyLetters("a-bC-dEf-ghIj"));//j-Ih-gfE-dCba
    }
}






















