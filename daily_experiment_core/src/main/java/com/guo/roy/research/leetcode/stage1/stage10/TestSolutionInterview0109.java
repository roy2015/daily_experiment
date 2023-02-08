package com.guo.roy.research.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/9/7
 *
 *
 *
 * 面试题 01.09. 字符串轮转
 * 字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
 *
 * 示例1:
 *
 *  输入：s1 = "waterbottle", s2 = "erbottlewat"
 *  输出：True
 * 示例2:
 *
 *  输入：s1 = "aa", s2 = "aba"
 *  输出：False
 * 提示：
 *
 * 字符串长度在[0, 100000]范围内。
 * 说明:
 *
 * 你能只调用一次检查子串的方法吗？
 *
 *
 */
public class TestSolutionInterview0109 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolutionInterview0109.class);

    static class Solution {

        /**
         *
         *
         * 首先s1,s2长度是否相等 s1拼接自己得到newS1， 看s2在不在s1里
         *
         * 执行结果：通过
         * 显示详情
         * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：39.5 MB, 在所有 Java 提交中击败了75.03%的用户
         *
         *
         * @param s1
         * @param s2
         * @return
         */
        public boolean isFlipedString(String s1, String s2) {
            int s1len = s1.length();
            int s2len = s2.length();
            if (s1len != s2len) {
                return false;
            }
            String newS1 = s1 + s1;
            return newS1.indexOf(s2) != -1 ? true : false ;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().isFlipedString("aa", "aba"));
        logger.info("{}", new Solution().isFlipedString("waterbottle", "erbottlewat"));
    }
}
