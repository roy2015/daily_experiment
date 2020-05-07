package com.roy.miscellaneous.leetcode.stage11;

import org.slf4j.LoggerFactory;

import java.util.HashSet;

/**
 * @author guojun
 * @date 2020/5/6 14:38
 */
public class TestSolution771 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution771.class);


    static class Solution {
        /**
         * 作一个映射
         *
         * 执行结果：通过显示详情
         * 执行用时 :1 ms, 在所有 Java 提交中击败了99.66%的用户
         * 内存消耗 :38.3 MB, 在所有 Java 提交中击败了9.09%的用户
         * @param J
         * @param S
         * @return
         */
        public int numJewelsInStones(String J, String S) {
            char[] jChars = J.toCharArray();
            char[] sChars = S.toCharArray();
            HashSet<Character> set = new HashSet<>();
            for (char jChar : jChars) {
                set.add(jChar);
            }
            int count =0 ;
            for (char sChar : sChars) {
                if (set.contains(sChar)) count ++;
            }
            return count;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().numJewelsInStones("aA", "aAAbbbb"));
        logger.info("{}", new Solution().numJewelsInStones("z", "ZZ"));
    }
}
