package com.roy.miscellaneous.leetcode.stage2.stage20;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/3/1 12:13
 *
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。

首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。

当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。

该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。

注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。

在任何情况下，若函数不能进行有效的转换时，请返回 0。

说明：

假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。

示例 1:

输入: "42"
输出: 42
示例 2:

输入: "   -42"
输出: -42
解释: 第一个非空白字符为 '-', 它是一个负号。
     我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
示例 3:

输入: "4193 with words"
输出: 4193
解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
示例 4:

输入: "words and 987"
输出: 0
解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
因此无法执行有效的转换。
示例 5:

输入: "-91283472332"
输出: -2147483648
解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
     因此返回 INT_MIN (−231) 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/string-to-integer-atoi
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TestSolution8 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution8.class);


    static class Solution {
        /**
         * 执行用时 :4 ms, 在所有 Java 提交中击败了32.61%的用户
         内存消耗 :38.1 MB, 在所有 Java 提交中击败了5.02%的用户
         * @param str
         * @return
         */
        public int myAtoi(String str) {
            if (str == null || str.length() == 0) {
                return 0;
            }
            char[] chars = str.toCharArray();
            char charI;
            int negtiveFlag = 0;//-1:'-' ; 1:"+" ; 0:数字
            int length = chars.length;
            //找第一个非空字符位置startIndex
            int startIndex = -1 ;
            for (int i = 0; i < length ; i++) {
                if (chars[i] == ' ') {
                    continue;
                } else {
                    startIndex = i;
                    break;
                }
            }
            //全是' '
            if (startIndex == -1) return 0;
            //处理第一个非空字符
            charI = chars[startIndex];
            if (charI == '-') {
                negtiveFlag = -1;
            } else if (charI == '+') {
                negtiveFlag = 1;
            } else if (charI >= '0' && charI <= '9') {
                negtiveFlag = 0;
            } else {
                return 0;
            }
            //全文只有一个正负号
            if (negtiveFlag != 0 && startIndex == (length - 1) ) {
                return 0;
            }
            //找最后一个非数字的位置endIndex
            int endIndex;
            for (endIndex = startIndex +1 ; endIndex < length; endIndex++) {
                charI = chars[endIndex];
                if (charI < '0' || charI > '9') {
                    break;
                }
            }
            //+-后没有数字
            if (negtiveFlag != 0 && endIndex == (startIndex +1)) {
                return 0;
            }
            try {
                return Integer.parseInt(str.substring(startIndex, endIndex));
            } catch (Exception e) {
                return negtiveFlag == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE ;
            }

            /*String finalStr ;
            int exp = 0;
            if (negtiveFlag != 0) {
                finalStr = str.substring(startIndex + 1, endIndex);
            } else {
                finalStr = str.substring(startIndex, endIndex);
            }
            int finalStrLen = finalStr.length();
            for (startIndex = 0; startIndex < finalStrLen; startIndex++) {

            }

            if (finalStrLen > 10) {
                exp =1;
            }
            if (negtiveFlag == -1) {
                if ( exp ==1 || (finalStrLen == 10 && finalStr.compareTo("2147483648") > 0)) {
                    return Integer.MIN_VALUE;
                }
            } else {
                if (exp ==1 || (finalStrLen == 10 && finalStr.compareTo("2147483647") > 0)) {
                    return Integer.MAX_VALUE;
                }
            }
            return Integer.parseInt(str.substring(startIndex, endIndex));*/

        }
    }

    public static void main(String[] args) {
        logger.info("输出【{}]",String.valueOf(new Solution().myAtoi("-02.3")));//-2
        logger.info("输出【{}]",String.valueOf(new Solution().myAtoi("+42")));//42
        logger.info("输出【{}]",String.valueOf(new Solution().myAtoi(" -42")));//-42
        logger.info("输出【{}]",String.valueOf(new Solution().myAtoi(" 4193 with words")));//4193
        logger.info("输出【{}]",String.valueOf(new Solution().myAtoi("words and 987")));//0
        logger.info("输出【{}]",String.valueOf(new Solution().myAtoi("+1")));//1
        logger.info("输出【{}]",String.valueOf(new Solution().myAtoi("0000000000012345678")));//1
        logger.info(String.valueOf(new Solution().myAtoi("-91283472332 ")));//-2147483648

        logger.info("[{}], [{}]",Integer.MAX_VALUE, Integer.MIN_VALUE);



    }
}
