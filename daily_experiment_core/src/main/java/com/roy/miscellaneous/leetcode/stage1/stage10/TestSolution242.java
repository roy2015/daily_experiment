package com.roy.miscellaneous.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/10/14
 *
 * 242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */
public class TestSolution242 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution242.class);


    static class Solution {

        /**
         *
         * 统计每个字符出现的次数，利用ascii码值作为数组index
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：2 ms, 在所有 Java 提交中击败了99.90%的用户
         * 内存消耗：38.5 MB, 在所有 Java 提交中击败了98.10%的用户
         *
         * @param s
         * @param t
         * @return
         */
        public boolean isAnagram(String s, String t) {
            char[] chars1 = s.toCharArray();
            char[] chars2 = t.toCharArray();

            //length invalid
            if (chars1.length != chars2.length) {
                return false;
            }

            int[] dic = new int[26];
            for (char c : chars1) {
                dic[c - 'a']++ ;
            }
            for (char c : chars2) {
                if (dic[c - 'a'] == 0) {
                    return false;
                } else {
                    dic[c - 'a'] -- ;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().isAnagram("aacc", "ccac"));//false
        logger.info("{}", new Solution().isAnagram("ab", "a"));//false
        logger.info("{}", new Solution().isAnagram("anagram", "nagaram"));//true
        logger.info("{}", new Solution().isAnagram("rat", "cat"));//false
    }
}
