package com.roy.leetcode.stage1.stage12;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/1/21 10:40
 *
 * LCP 17. 速算机器人
 * 小扣在秋日市集发现了一款速算机器人。店家对机器人说出两个数字（记作 x 和 y），请小扣说出计算指令：
 *
 * "A" 运算：使 x = 2 * x + y；
 * "B" 运算：使 y = 2 * y + x。
 * 在本次游戏中，店家说出的数字为 x = 1 和 y = 0，小扣说出的计算指令记作仅由大写字母 A、B 组成的字符串 s，字符串中字符的顺序表示计算顺序，请返回最终 x 与 y 的和为多少。
 *
 * 示例 1：
 *
 * 输入：s = "AB"
 *
 * 输出：4
 *
 * 解释：
 * 经过一次 A 运算后，x = 2, y = 0。
 * 再经过一次 B 运算，x = 2, y = 2。
 * 最终 x 与 y 之和为 4。
 *
 * 提示：
 *
 * 0 <= s.length <= 10
 * s 由 'A' 和 'B' 组成
 */
public class TestSolutionLCP17 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolutionLCP17.class);


    static class Solution {

        /**
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：36.8 MB, 在所有 Java 提交中击败了7.72%的用户
         *
         * @param s
         * @return
         */
        public int calculate(String s) {
            if (s == null || s.length() == 0) {
                return 1;
            }

            char[] chars = s.toCharArray();
            int x = 1, y =0;
            for (char aChar : chars) {
                if (aChar == 'A') {
                    x = x * 2 + y;
                } else {
                    y = y * 2 + x;
                }
            }
            return x + y;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().calculate(""));
        logger.info("{}", new Solution().calculate("AB"));
    }
}
