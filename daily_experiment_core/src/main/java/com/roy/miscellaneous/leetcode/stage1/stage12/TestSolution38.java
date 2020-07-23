package com.roy.miscellaneous.leetcode.stage1.stage12;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/7/23
 *
 *
 * 38. 外观数列
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。
 *
 * 注意：整数序列中的每一项将表示为一个字符串。
 *
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 第一项是数字 1
 *
 * 描述前一项，这个数是 1 即 “一个 1 ”，记作 11
 *
 * 描述前一项，这个数是 11 即 “两个 1 ” ，记作 21
 *
 * 描述前一项，这个数是 21 即 “一个 2 一个 1 ” ，记作 1211
 *
 * 描述前一项，这个数是 1211 即 “一个 1 一个 2 两个 1 ” ，记作 111221
 *
 *
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: "1"
 * 解释：这是一个基本样例。
 * 示例 2:
 *
 * 输入: 4
 * 输出: "1211"
 * 解释：当 n = 3 时，序列是 "21"，其中我们有 "2" 和 "1" 两组，"2" 可以读作 "12"，也就是出现频次 = 1 而 值 = 2；类似 "1" 可以读作 "11"。所以答案是 "12" 和 "11" 组合在一起，也就是 "1211"。
 * 通过次数112,799提交次数201,824
 *
 *
 */
public class TestSolution38 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution38.class);


    static class Solution {
        /**
         *
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：2 ms, 在所有 Java 提交中击败了71.42%的用户
         * 内存消耗：37.1 MB, 在所有 Java 提交中击败了5.41%的用户
         *
         *
         * @param n
         * @return
         */
        public String countAndSay(int n) {
            //前提：1 ≤ n ≤ 30
            String toCalStr = "1";
            for (int i = 2; i <= n; i++) {
                StringBuilder nextToCalSb = new StringBuilder();
                char[] toCalCharArray = toCalStr.toCharArray();
                int p = 0;
                while (p < toCalCharArray.length) {
                    int q = p +1;
                    char pVal = toCalCharArray[p];
                    int sameTimes ;
                    while (q < toCalCharArray.length && toCalCharArray[q] == pVal) {
                        q ++;
                    }
                    sameTimes = q -p;
                    nextToCalSb.append(sameTimes).append(pVal);
                    p = q;
                }
                toCalStr = nextToCalSb.toString();
            }
            return toCalStr;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().countAndSay(1));
        logger.info("{}", new Solution().countAndSay(2));
        logger.info("{}", new Solution().countAndSay(3));
        logger.info("{}", new Solution().countAndSay(4));
        logger.info("{}", new Solution().countAndSay(5));

    }
}
