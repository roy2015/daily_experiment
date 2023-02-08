package com.guo.roy.research.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/10/31
 *1556. 千位分隔数
 * 给你一个整数 n，请你每隔三位添加点（即 "." 符号）作为千位分隔符，并将结果以字符串格式返回。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 987
 * 输出："987"
 * 示例 2：
 *
 * 输入：n = 1234
 * 输出："1.234"
 * 示例 3：
 *
 * 输入：n = 123456789
 * 输出："123.456.789"
 * 示例 4：
 *
 * 输入：n = 0
 * 输出："0"
 *
 *
 * 提示：
 *
 * 0 <= n < 2^31
 *
 *
 */
public class TestSolution1556 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1556.class);


    static class Solution {
        /**
         *
         * 执行结果：
         * 通过
         * 显示详情
         * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：35.7 MB, 在所有 Java 提交中击败了96.87%的用户
         *
         * @param n
         * @return
         */
        public String thousandSeparator(int n) {
            String str = String.valueOf(n);
            char[] chars = str.toCharArray();
            int length = chars.length;
            //小于等于三位的直接处理
            if (length <= 3) {
                return str;
            }
            //处理多余的部分
            int extra = length % 3;
            StringBuffer sb = new StringBuffer();
            if (extra != 0) {
                for (int i = 0; i < extra; i++) {
                    sb.append(chars[i]);
                }
                sb.append(".");
            }
            //正常处理
            int flag = 0;
            for (int i = extra; i < length; i++) {
                sb.append(chars[i]);
                flag ++;
                if (flag ==3 ) {
                    sb.append(".");
                    flag = 0;
                }
            }
            return sb.toString().substring(0, sb.length() -1);
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().thousandSeparator(1234));//1.234
        logger.info("{}", new Solution().thousandSeparator(987));//987
        logger.info("{}", new Solution().thousandSeparator(123456789));//123.456.789
        logger.info("{}", new Solution().thousandSeparator(0));//0
        logger.info("{}", new Solution().thousandSeparator(1));//1
        logger.info("{}", new Solution().thousandSeparator(51040));//51.040
    }
}
