package com.roy.leetcode.stage2.stage21;

import org.slf4j.LoggerFactory;

/**
 *
 * 6. Z 字形变换
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 *
 *
 * 示例 1：
 *
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 示例 3：
 *
 * 输入：s = "A", numRows = 1
 * 输出："A"
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 由英文字母（小写和大写）、',' 和 '.' 组成
 * 1 <= numRows <= 1000
 *
 *
 *
 * @author guojun
 * @date 2021/7/8
 */
public class TestSolution6 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution6.class);


    static class Solution {
        /**
         *
         * StringBuilder数组，合理运用StringBuilder的append追加特性
         *
         * 执行结果：通过
         * 显示详情
         * 执行用时：4 ms, 在所有 Java 提交中击败了85.57%的用户
         * 内存消耗：39 MB, 在所有 Java 提交中击败了54.93%的用户
         *
         * @param s
         * @param numRows
         * @return
         */
        public String convert(String s, int numRows) {
            int len = s.length();
            if (len <= numRows) {
                return s;
            }
            StringBuilder[] sbs = new StringBuilder[numRows];
            for (int i = 0; i < numRows; i++) {
                sbs[i] = new StringBuilder();
            }
            char[] srcChars = s.toCharArray();
            int idx = 0;
            int rowIdx;
            while (true) {
                //向下
                for (rowIdx = 0; rowIdx < numRows && idx < len; rowIdx++) {
                    sbs[rowIdx].append(srcChars[idx++]);
                }
                if (idx == len) {
                    break;
                }
                //斜上（简化成向上）
                for (rowIdx= numRows -2; rowIdx > 0 && idx < len ; rowIdx--) {
                    sbs[rowIdx].append(srcChars[idx++]);
                }
                if (idx == len) {
                    break;
                }
            }

            StringBuilder retSb = new StringBuilder();
            for (int i = 0; i < numRows; i++) {
                retSb.append(sbs[i]);
            }
            return retSb.toString();
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().convert("PAYPALISHIRING", 3));//PAHNAPLSIIGYIR
        logger.info("{}", new Solution().convert("PAYPALISHIRING", 4));//PINALSIGYAHRPI
        logger.info("{}", new Solution().convert("A", 1));//A
    }
}
