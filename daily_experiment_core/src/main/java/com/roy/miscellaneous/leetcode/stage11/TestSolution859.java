package com.roy.miscellaneous.leetcode.stage11;

import org.slf4j.LoggerFactory;

import java.util.BitSet;

/**
 * @author guojun
 * @date 2020/5/10 16:42
 *
 * 859. 亲密字符串
给定两个由小写字母构成的字符串 A 和 B ，只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，就返回 true ；否则返回 false 。



示例 1：

输入： A = "ab", B = "ba"
输出： true
示例 2：

输入： A = "ab", B = "ab"
输出： false
示例 3:

输入： A = "aa", B = "aa"
输出： true
示例 4：

输入： A = "aaaaaaabc", B = "aaaaaaacb"
输出： true
示例 5：

输入： A = "", B = "aa"
输出： false


提示：

0 <= A.length <= 20000
0 <= B.length <= 20000
A 和 B 仅由小写字母构成。
 */
public class TestSolution859 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution859.class);


    static class Solution {
        /**
         * 用了bitset 打点，主要是考虑到 两个字符串相等 ，用来出来字符串内部有无相同字符
         *
         * 有两种情况，
         * 1. 两个字符串相等 ，字符串内部有无相同字符可以用来交换
         * 2. 两个字符串不相等， 两次不相等的是否可以交换
         *
         *
         *
         * 执行结果：通过显示详情
         * 执行用时 :1 ms, 在所有 Java 提交中击败了99.52%的用户
         * 内存消耗 :40.1 MB, 在所有 Java 提交中击败了8.33%的用户
         * @param A
         * @param B
         * @return
         */
        public boolean buddyStrings(String A, String B) {
            char[] aChars = A.toCharArray();
            char[] bChars = B.toCharArray();
            int aLen = aChars.length;
            int bLen = bChars.length;

            BitSet bitSet = new BitSet(aLen);

            if (aLen < 2 || bLen < 2) {
                return false;
            }

            if (aLen != bLen) {
                return false;
            }

            int diff1AChar='a', diff1BChar='a';
            int diffTimes = 0;//不相等的次数
            boolean hasSameChar = false;//内部是否有相同的字符，两个字符串相等时的最后判断需要使用

            for (int i = 0; i < aChars.length; i++) {
                char aChar = aChars[i];
                char bChar = bChars[i];

                if (aChar != bChar) {//不相等
                    if (diffTimes > 1) {//已经有两次不相等
                        return false;
                    }
                    if ( diffTimes == 0) {//之前都是相等
                        diff1AChar = aChar;
                        diff1BChar = bChar;
                    } else {//已有一次不相等
                        if (bChar != diff1AChar || aChar != diff1BChar) {
                            return false;
                        }
                    }
                    diffTimes ++;
                }
            }

            if (diffTimes == 0) {//两个字符串相等
                for (char aChar : aChars) {
                    if (hasSameChar == false) {
                        if (bitSet.get(aChar)) {
                            return true;
                        } else {
                            bitSet.set(aChar);
                        }
                    }
                }

                if (!hasSameChar) {
                    return false;
                } else return true;
            }
            if (diffTimes == 2) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new TestSolution859.Solution().buddyStrings("ab", "ba"));//true
        logger.info("{}", new TestSolution859.Solution().buddyStrings("ab", "ab"));//f
        logger.info("{}", new TestSolution859.Solution().buddyStrings("aa", "aa"));//t
        logger.info("{}", new TestSolution859.Solution().buddyStrings("aaaaaaabc", "aaaaaaacb"));//t
        logger.info("{}", new TestSolution859.Solution().buddyStrings("", "aa"));//false
    }
}
