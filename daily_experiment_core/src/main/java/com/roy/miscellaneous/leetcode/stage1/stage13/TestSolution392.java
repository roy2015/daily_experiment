package com.roy.miscellaneous.leetcode.stage1.stage13;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/6/29
 *
 * 392. 判断子序列
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 *
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * 示例 1:
 * s = "abc", t = "ahbgdc"
 *
 * 返回 true.
 *
 * 示例 2:
 * s = "axc", t = "ahbgdc"
 *
 * 返回 false.
 *
 * 后续挑战 :
 *
 * 如果有大量输入的 S，称作S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 *
 * 致谢:
 *
 * 特别感谢 @pbrother 添加此问题并且创建所有测试用例。
 *
 *
 */
public class TestSolution392 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution392.class);


    static class Solution {
        /**
         *
         * 头字符需要循环，后面的每个字符的处理不需要循环
         * step1 找t中出现s的开头字符sChars[0]的 idx0
         * step2 剩余[idx0+1, tLen)里找sChars[1]的 idx1, [idx1+1, tLen)里找sChars[2]的 idx2.........,
         *       都满足return，否则 step3
         * step3 循环 step1
         *
         *
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：
         * 37.5 MB, 在所有 Java 提交中击败了100.00%的用户
         *
         * @param s
         * @param t
         * @return
         */

        public boolean isSubsequence(String s, String t) {
            int sLen = s.length();
            int tLen = t.length();
            if (sLen == 0) {
                return true;
            }
            if (tLen == 0 && sLen != 0) {
                return false;
            }

            char[] sChars = s.toCharArray();
            char[] tChars = t.toCharArray();

            int headStart = 0;//从t中找s的头，从t中开始找的位置
            char header = sChars[0];
            while (true) {
                int headIdx ;
                //找头的位置
                for (headIdx = headStart; headIdx < tLen; headIdx++) {
                    if (tChars[headIdx] == header) {
                        break;
                    }
                }
                //can not find a  index of header  in t
                if (headIdx == tLen) {
                    return false;
                }

                int otherIdx = headIdx +1;
                //非头字符的校验
                boolean smallPresent;
                int j ;
                for (j = 1; j < sLen; j++) {
                    char jsChar = sChars[j];

                    smallPresent = false ;
                    int i;
                    for (i = otherIdx; i < tLen; i++) {
                        if (tChars[i] ==  jsChar) {
                            smallPresent = true;
                            break;
                        }
                    }
                    //找不到相等的
                    if (!smallPresent) {
                        return false;
                    }
                    otherIdx = i + 1;
                }
                if (j == sLen) {
                    return true;
                }
                //s中所有字符都能在
                headStart ++;
            }
        }

    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().isSubsequence("abc", "ahbgdc"));//true
        logger.info("{}", new Solution().isSubsequence("axc", "ahbgdc"));//false
    }
}
