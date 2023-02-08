package com.guo.roy.research.leetcode.stage1.stage12;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/11/24
 *
 *
 * 1662. 检查两个字符串数组是否相等
 * 给你两个字符串数组 word1 和 word2 。如果两个数组表示的字符串相同，返回 true ；否则，返回 false 。
 *
 * 数组表示的字符串 是由数组中的所有元素 按顺序 连接形成的字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：word1 = ["ab", "c"], word2 = ["a", "bc"]
 * 输出：true
 * 解释：
 * word1 表示的字符串为 "ab" + "c" -> "abc"
 * word2 表示的字符串为 "a" + "bc" -> "abc"
 * 两个字符串相同，返回 true
 * 示例 2：
 *
 * 输入：word1 = ["a", "cb"], word2 = ["ab", "c"]
 * 输出：false
 * 示例 3：
 *
 * 输入：word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
 * 输出：true
 *
 *
 * 提示：
 *
 * 1 <= word1.length, word2.length <= 10^3
 * 1 <= word1[i].length, word2[i].length <= 10^3
 * 1 <= sum(word1[i].length), sum(word2[i].length) <= 10^3
 * word1[i] 和 word2[i] 由小写字母组成
 *
 *
 */
public class TestSolution1662 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1662.class);


    static class Solution {
        /**
         *
         * 双百，~~，算法时间复杂度O(n)
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：36.2 MB, 在所有 Java 提交中击败了100.00%的用户
         *
         *
         * @param word1
         * @param word2
         * @return
         */
        public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
            int word1Len = word1.length;
            int word2Len = word2.length;

            //先转化为二维数组
            char[][] word1Array = new char[word1Len][];
            char[][] word2Array = new char[word2Len][];
            for (int i = 0; i < word1.length; i++) {
                word1Array[i] = word1[i].toCharArray();
            }
            for (int i = 0; i < word2.length; i++) {
                word2Array[i] = word2[i].toCharArray();
            }
            //页号
            int word1pageIdx = 0, word2pageIdx = 0;
            int word1pageSize;
            int word2pageSize;
            //页内偏移量
            int offset1 = 0, offset2 = 0;
            while (word1pageIdx < word1Len && word2pageIdx < word2Len) {
                //有字符不同的
                if (word1Array[word1pageIdx][offset1] != word2Array[word2pageIdx][offset2]) {
                    return false;
                }
                offset1 ++;
                offset2 ++;
                //处理切换页
                word1pageSize = word1Array[word1pageIdx].length;
                word2pageSize = word2Array[word2pageIdx].length;
                if (offset1 == word1pageSize) {
                    word1pageIdx ++;
                    offset1 = 0;
                }
                if (offset2 == word2pageSize) {
                    word2pageIdx ++;
                    offset2 = 0;
                }
            }
            //未遍历完
            if (word1pageIdx != word1Len || word2pageIdx != word2Len) {
                return false;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().arrayStringsAreEqual(
                new String[]{"ab", "c"},
                new String[]{"a", "bc"}));//true

        logger.info("{}", new Solution().arrayStringsAreEqual(
                new String[]{"a", "cb"},
                new String[]{"ab", "c"}));//false

        logger.info("{}", new Solution().arrayStringsAreEqual(
                new String[]{"abc", "d", "defg"},
                new String[]{"abcddefg"}));//true


    }
}
