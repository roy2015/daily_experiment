package com.roy.leetcode.stage1.stage13;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/8/2
 *
 * 1446. 连续字符
 * 给你一个字符串 s ，字符串的「能量」定义为：只包含一种字符的最长非空子字符串的长度。
 *
 * 请你返回字符串的能量。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "leetcode"
 * 输出：2
 * 解释：子字符串 "ee" 长度为 2 ，只包含字符 'e' 。
 * 示例 2：
 *
 * 输入：s = "abbcccddddeeeeedcba"
 * 输出：5
 * 解释：子字符串 "eeeee" 长度为 5 ，只包含字符 'e' 。
 * 示例 3：
 *
 * 输入：s = "triplepillooooow"
 * 输出：5
 * 示例 4：
 *
 * 输入：s = "hooraaaaaaaaaaay"
 * 输出：11
 * 示例 5：
 *
 * 输入：s = "tourist"
 * 输出：1
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 500
 * s 只包含小写英文字母。
 *
 *
 */
public class TestSolution1446 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1446.class);


    static class Solution {
        /**
         *
         * 还是老套路，双指针，这回写得更简洁了~~
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 1 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：
         * 39.9 MB, 在所有 Java 提交中击败了10.71%的用户
         *
         *
         * @param s
         * @return
         */
        public int maxPower(String s) {
            int p = 0;
            int q = 0;
            char[] chars = s.toCharArray();
            int len = chars.length;
            int maxPower = 0;
            while (p < len ) {
                char pChar = chars[p];
                int cnt = 0;
                while (q < len && chars[q] == pChar) {
                    cnt ++;
                    q ++;
                }

                if (cnt > maxPower) {
                    maxPower = cnt;
                }
                p = q;
            }
            return maxPower;
        }

    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().maxPower("hooraaaaaaaaaaay"));//11
        logger.info("{}", new Solution().maxPower("triplepillooooow"));//5
        logger.info("{}", new Solution().maxPower("tourist"));//1

    }
}
