package com.roy.miscellaneous.leetcode.stage2.stage22;

import org.slf4j.LoggerFactory;


/**
 *
 * 91. 解码方法
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 *
 * 'A' -> "1"
 * 'B' -> "2"
 * ...
 * 'Z' -> "26"
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
 *
 * "AAJF" ，将消息分组为 (1 1 10 6)
 * "KJF" ，将消息分组为 (11 10 6)
 * 注意，消息不能分组为  (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
 *
 * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
 *
 * 题目数据保证答案肯定是一个 32 位 的整数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "12"
 * 输出：2
 * 解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2：
 *
 * 输入：s = "226"
 * 输出：3
 * 解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * 示例 3：
 *
 * 输入：s = "0"
 * 输出：0
 * 解释：没有字符映射到以 0 开头的数字。
 * 含有 0 的有效映射是 'J' -> "10" 和 'T'-> "20" 。
 * 由于没有字符，因此没有有效的方法对此进行解码，因为所有数字都需要映射。
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 100
 * s 只包含数字，并且可能包含前导零。
 *
 * @author guojun
 * @date 2022/3/11
 */
public class TestSolution91 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution91.class);


    static class Solution {
        /**
         *
         * 0：必须和前面1位结合,且不能>=3
         * >=3：不能和后面结合
         * 7，8，9： 如果和前面结合，前面不能>=2
         * 从后往前读字符串（否则是递归）， dp计数又是从前往后，index比较友好
         *
         *
         * 执行结果：通过
         * 显示详情
         * 添加备注
         *
         * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：
         * 39.9 MB, 在所有 Java 提交中击败了5.77%的用户
         * 通过测试用例：
         * 269 / 269
         *
         * @param s
         * @return
         */
        public int numDecodings(String s) {
            char[] chars = s.toCharArray();
            //排除特殊情况，开头0，长度1
            if (chars[0] == '0') {
                return 0;
            }
            int length = chars.length;
            if (length == 1) {
                return 1;
            }
            //start
            int[] dp = new int[length + 1];
            dp[0] = 1;
            Integer val;
            //计算dp[1]
            if (chars[length-1] == '0') {
                dp[1] = 0;
            } else {
                dp[1] =1;
            }
            //动态规划
            for (int i = 2; i <= length; i++) {
                int i1 = 0;
                int i2 = 0;
                if (chars[length - i] != '0') {
                    i1 = dp[i-1];
                    if (isValid(chars[length - i], chars[length - i + 1])) {
                        i2 = dp[i-2];
                    }
                }
                dp[i] = i1 + i2;
            }
            return dp[length];
        }

        /**
         * 判断两位数是否合法
         * @param char1
         * @param char2
         * @return
         */
        private boolean isValid(char char1, char char2) {
            switch (char1) {
                case '1':
                    return true;
                case '2':
                    if (char2 > '6') {
                        return false;
                    }else return true;
                default:
                    return false;
            }
        }
    }

    public static void main(String[] args) {
//        logger.info("{}", new Solution().isValid('3', '7'));
        logger.info("{}", new Solution().numDecodings("0000032"));//0
        logger.info("{}", new Solution().numDecodings("0"));//0
        logger.info("{}", new Solution().numDecodings("12"));//2
        logger.info("{}", new Solution().numDecodings("226"));//3
        logger.info("{}", new Solution().numDecodings("11106"));//2

    }
}
