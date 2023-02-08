package com.roy.leetcode.stage1.stage11;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/9/15
 *
 * 剑指 Offer 05. 替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *
 *
 * 限制：
 *
 * 0 <= s 的长度 <= 10000
 *
 */
public class TestSolutionJZoffer05 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolutionJZoffer05.class);



    static class Solution {
        /**
         * easy，剑指offer有点水拉低leecode下限
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：37.2 MB, 在所有 Java 提交中击败了94.23%的用户
         *
         * @param s
         * @return
         */
        public String replaceSpace(String s) {
            char blank = ' ';
            String paddingStr = "%20";

            if (s == null || s.length() == 0) {
                return s;
            }

            char[] chars = s.toCharArray();
            StringBuilder retSb = new StringBuilder();

            for (char aChar : chars) {
                if (aChar == blank) {
                    retSb.append(paddingStr);
                } else {
                    retSb.append(aChar);
                }
            }

            return retSb.toString();
        }


    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().replaceSpace("We are happy."));
    }
}
