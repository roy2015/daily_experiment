package com.roy.leetcode.stage1.stage12;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/5/27
 */
public class TestSolution434 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution434.class);


    static class Solution {

        /**
         *
         * 双指针
         *
         * 执行结果：
         通过
         显示详情
         执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
         内存消耗 :37.2 MB, 在所有 Java 提交中击败了14.29%的用户
         *
         * @param s
         * @return
         */
        public int countSegments(String s) {
            int segments = 0;
            int start = 0;
            char[] chars = s.toCharArray();
            int length = chars.length;
            int end;

            while (start < length) {
                //找单词开始
                for (; start < length; start++) {
                    if (chars[start] != ' ') {
                        break;
                    }
                }
                if (start == length) {//没有，全是空格
                    return segments;
                }
                //找单词结束
                for (end = start; end < length; end++) {
                    if (chars[end] == ' ') {
                        break;
                    }
                }
                segments ++;
                start = end;
            }
            return segments;
        }

    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().countSegments("               "));
        logger.info("{}", new Solution().countSegments("Hello, my name is a John"));
    }
}
