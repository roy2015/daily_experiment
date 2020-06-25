package com.roy.miscellaneous.leetcode.stage1.stage12;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/6/24
 * 28. 实现 strStr()
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 *
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 *
 *
 */
public class TestSolution28 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution28.class);


    static class Solution {
        /**
         *
         *
         * 1ms了，不纠结0ms了，这个题有坑， "mississippi", "issip" , 第一次不满足，第二次才满足，也只有leetcode的测试用例才回测出来
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 1 ms, 在所有 Java 提交中击败了75.46%的用户
         * 内存消耗：
         * 38.5 MB, 在所有 Java 提交中击败了5.43%的用户
         *
         * @param haystack
         * @param needle
         * @return
         */
        public int strStr(String haystack, String needle) {
            if ( haystack == null ||  needle == null) {
                throw new NullPointerException();
            }
            if (needle.length() == 0) {
                return 0;
            }

            char[] aChars = haystack.toCharArray();
            char[] bChars = needle.toCharArray();
            int aLen = aChars.length;
            int bLen = bChars.length;
            char bFirstChar = bChars[0];

            if (aLen < bLen) {
                return -1;
            }

            int p =0;
            int q = 0;
            int ret;

            while (p < aLen) {
                while (p < aLen) {
                    if (aChars[p] ==  bFirstChar) break;
                    p ++;
                }

                //not find equal to b fisrt char
                if (p == aLen) {
                    return -1;
                }

                //out of range, return ahead
                if (p + bLen > aLen) {
                    return -1;
                }

                // 'ret' can be represented to be rollblack-point or final retrune-Val
                ret = p;
                // go ahead together
                while (p < aLen && q < bLen) {
                    if (aChars[p] != bChars[q]) {
                        break;
                    }
                    p ++;
                    q ++;
                }
                if (q == bLen) {
                    return ret;
                } else if (p < aLen && q < bLen) {//midway break, give a chance to try a next;
                    p = ret + 1;
                    q = 0;
                } else {
                    return -1;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().strStr("mississippi", "issip"));//4
        logger.info("{}", new Solution().strStr("hello", "ll"));//2
        logger.info("{}", new Solution().strStr("aaaaa", "bba"));//-1
        logger.info("{}", "123".lastIndexOf(""));//
    }
}
