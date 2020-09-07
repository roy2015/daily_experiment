package com.roy.miscellaneous.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/9/7
 *
 *
 *
 *面试题 01.04. 回文排列
 * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
 *
 * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
 *
 * 回文串不一定是字典当中的单词。
 *
 *
 *
 * 示例1：
 *
 * 输入："tactcoa"
 * 输出：true（排列有"tacocat"、"atcocta"，等等）
 *
 *
 */
public class TestSolutionInterview0104 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolutionInterview0104.class);

    static class Solution {

        /**
         *
         * 应该是回文的标准解法吧，直接统计出现一次的字符个数，最多只能一个
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：
         * 37.3 MB, 在所有 Java 提交中击败了82.81%的用户
         *
         * @param s
         * @return
         */
        public boolean canPermutePalindrome(String s) {
            if (s == "") {
                return true;
            }

            int[] dic = new int[256];
            char[] chars = s.toCharArray();
            for (char aChar : chars) {
                dic[aChar] ++;
            }

            int jishu = 0;
            for (int i : dic) {
                if ((i & 0x1) == 1) {
                    jishu ++;
                }
                if (jishu > 1) {
                    return false;
                }
            }
            return true;
        }

    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().canPermutePalindrome("tactcoa"));
        logger.info("{}", new Solution().canPermutePalindrome("ac"));

    }
}
