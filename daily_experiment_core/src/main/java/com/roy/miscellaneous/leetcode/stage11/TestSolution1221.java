package com.roy.miscellaneous.leetcode.stage11;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/5/11 14:04
 *
 * 1221. 分割平衡字符串
在一个「平衡字符串」中，'L' 和 'R' 字符的数量是相同的。

给出一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。

返回可以通过分割得到的平衡字符串的最大数量。



示例 1：

输入：s = "RLRRLLRLRL"
输出：4
解释：s 可以分割为 "RL", "RRLL", "RL", "RL", 每个子字符串中都包含相同数量的 'L' 和 'R'。
示例 2：

输入：s = "RLLLLRRRLR"
输出：3
解释：s 可以分割为 "RL", "LLLRRR", "LR", 每个子字符串中都包含相同数量的 'L' 和 'R'。
示例 3：

输入：s = "LLLLRRRR"
输出：1
解释：s 只能保持原样 "LLLLRRRR".


提示：

1 <= s.length <= 1000
s[i] = 'L' 或 'R'
分割得到的每个字符串都必须是平衡字符串。
 */
public class TestSolution1221 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1221.class);


    static class Solution {
        /**
         *
         * 执行结果：通过显示详情
         * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗 :37.4 MB, 在所有 Java 提交中击败了5.00%的用户
         * 
         * @param s
         * @return
         */
        public int balancedStringSplit(String s) {
            int len = s.length();
            if (len <= 1) {
                return 0;
            }

            int total =0;//总个数
            int perTotal =0;//每次RL
            char[] chars = s.toCharArray();

            for (int i = 0; i < len; i++) {
                char aChar = chars[i];

                //L -- , R ++
                if (aChar =='L') {
                    perTotal --;
                } else if (aChar =='R') {
                    perTotal ++;
                } else {}

                if (perTotal == 0) {
                    total ++;
                }
            }
            return total;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new TestSolution1221.Solution().balancedStringSplit("RLRRLLRLRL"));//4
        logger.info("{}", new TestSolution1221.Solution().balancedStringSplit("RLLLLRRRLR"));//3
        logger.info("{}", new TestSolution1221.Solution().balancedStringSplit("RRRLLRLR"));//0

    }
}
