package com.guo.roy.research.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/4/27 11:59
 *
 * 67. 二进制求和
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 *
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 *
 * 提示：
 *
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 */
public class TestSolution67 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution67.class);


    static class Solution {
        /**
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时 :2 ms, 在所有 Java 提交中击败了98.53%的用户
         * 内存消耗 :39.6 MB, 在所有 Java 提交中击败了7.69%的用户
         *
         * @param a
         * @param b
         * @return
         */
        public String addBinary(String a, String b) {
            int aLen = a.length();
            int bLen = b.length();

            char[] aChars = a.toCharArray();
            char[] bChars = b.toCharArray();

            int maxLen = aLen > bLen ? aLen : bLen ;
            StringBuffer sb = new StringBuffer();
            int carry =0;

            for (int i = 0; i < maxLen; i++) {
                int aInt = 0, bInt = 0;
                //取两个加数aInt, bInt
                if (i > aLen -1 || i > bLen -1 ) {
                    if (i > aLen -1) {
                        aInt = 0;
                        bInt = bChars[bLen -1 - i] - '0';
                    } else {
                        aInt = aChars[aLen - 1 - i] - '0';
                        bInt = 0;
                    }
                } else {
                    aInt = aChars[aLen - 1 - i] - '0';
                    bInt = bChars[bLen -1 - i] - '0';
                }
                int sub = aInt + bInt + carry;
                //处理相加和进位
                if (sub > 1) {
                    sub = sub -2;
                    carry =1;
                    sb.append(sub);
                    if (i == maxLen - 1) {
                        sb.append("1");
                    }
                } else {
                    sb.append(sub);
                    carry = 0;
                }
            }
            return sb.reverse().toString();
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().addBinary("10", "10"));//100
        logger.info("{}", new Solution().addBinary("11", "1"));//100
        logger.info("{}", new Solution().addBinary("1010", "1011"));// 10101
    }
}
