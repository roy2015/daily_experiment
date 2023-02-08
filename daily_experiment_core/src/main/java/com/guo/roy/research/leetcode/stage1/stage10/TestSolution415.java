package com.guo.roy.research.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/4/27 14:23
 *
 * 415. 字符串相加
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 *
 * 注意：
 *
 * num1 和num2 的长度都小于 5100.
 * num1 和num2 都只包含数字 0-9.
 * num1 和num2 都不包含任何前导零。
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 *
 *
 * 和67. 二进制求和类似，进位2改成10
 */
public class TestSolution415 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution415.class);


    static class Solution {

        /**
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时 :2 ms, 在所有 Java 提交中击败了99.45%的用户
         * 内存消耗 :40.1 MB, 在所有 Java 提交中击败了8.33%的用户
         * @param num1
         * @param num2
         * @return
         */
        public String addStrings(String num1, String num2)  {
            int aLen = num1.length();
            int bLen = num2.length();

            char[] aChars = num1.toCharArray();
            char[] bChars = num2.toCharArray();

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
                if (sub >= 10) {
                    sub = sub - 10;
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
        logger.info("{}", new Solution().addStrings("123", "3"));//100
        logger.info("{}", new Solution().addStrings("15", "5"));//100
        logger.info("{}", new Solution().addStrings("1010", "1011"));// 10101
    }
}
