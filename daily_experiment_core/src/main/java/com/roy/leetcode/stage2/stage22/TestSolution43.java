package com.roy.leetcode.stage2.stage22;

import org.slf4j.LoggerFactory;

/**
 *
 * 43. 字符串相乘
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 *
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 *
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 *
 * @author guojun
 * @date 2021/8/18
 */
public class TestSolution43 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution43.class);


    static class Solution {
        /**
         *
         * 最大位数只可能是m*n，最小位数 m*n-1, 特殊情况0不算
         *
         * 执行结果：通过
         * 显示详情
         * 添加备注
         *
         * 执行用时：
         * 3 ms, 在所有 Java 提交中击败了82.82%的用户内存消耗：
         *
         * @param num1
         * @param num2
         * @return
         */
        public String multiply(String num1, String num2) {
            //先排除空字符串
            if (num1 == null || num1.length() == 0) {
                return "";
            }

            if (num2 == null || num2.length() == 0) {
                return "";
            }

            //排除0
            if ("0".equals(num1) || "0".equals(num2)) {
                return "0";
            }

            char[] nums1Chars = num1.toCharArray();
            char[] nums2Chars = num2.toCharArray();
            int num1Len = nums1Chars.length;
            int num2Len = nums2Chars.length;

            int totalLen = num1Len + num2Len;

            int[] result = new int[totalLen];
            int base = 0;

            for (int i = num2Len -1; i >= 0; i--, base++) {
                char op1 = nums2Chars[i];
                doSingleString(result, op1, nums1Chars, base);
            }

            int extra = 0;
            for (int i = 0; i < totalLen; i++) {
                int iVal = result[i] + extra;
                result[i] =  iVal % 10;
                extra = iVal / 10;
            }

//            logger.info("{}", result);

            int destIdx = totalLen -1;
            for (; destIdx >= 0; destIdx--) {
                if (result[destIdx] != 0) {
                    break;
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = destIdx; i >= 0 ; i--) {
                stringBuilder.append(result[i]);
            }


            return stringBuilder.toString();
        }

        /**
         * 第二个乘数的一位和第一个乘数整个相乘 最多 num1.length + 1位，最少num1.length 比如99*9, 10*1
         * @param result
         * @param op1
         * @param op2
         * @param offset
         */
        private void doSingleString(int[] result, char op1, char[] op2 , int offset) {
            int op1Int = op1 - '0';
            if (op1Int == 0) {
                return;
            }

            int extra = 0;
            int idx = offset;
            for (int i = op2.length - 1; i >= 0; i--) {
                int op2Int = op2[i] - '0';
                int multiply = op1Int * op2Int;
                int sum = multiply + extra;
                result[idx] += sum % 10;
                extra = sum / 10;
                idx ++;
            }
            if (extra > 0) {
                result[idx] += extra;
            }
        }
    }

    public static void main(String[] args) {
        Solution so = new Solution();

        /*
        测试基础方法
        int[] ints = new int[43];
        so.doSingleString(ints, '9', new String("999999990999999999998888888888888888888898").toCharArray(), 0);
        logger.info("{}", ints);*/

//        logger.info("{}", so.multiply("9999", "99999"));//999890001
//        logger.info("{}", so.multiply("90", "99"));//999890001
//        logger.info("{}", so.multiply("123", "456"));//"56088"
        logger.info("{}", so.multiply("900", "999999990999999999998888888888888888888898"));//899999991899999999999000000000000000000008200
    }
}
