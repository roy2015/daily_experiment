package com.roy.miscellaneous.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/11/14.
 *给定一个Excel表格中的列名称，返回其相应的列序号。

 例如，

 A -> 1
 B -> 2
 C -> 3
 ...
 Z -> 26
 AA -> 27
 AB -> 28
 ...
 示例 1:

 输入: "A"
 输出: 1
 示例 2:

 输入: "AB"
 输出: 28
 示例 3:

 输入: "ZY"
 输出: 701

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/excel-sheet-column-number
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TestSolution171 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution171.class);


    static class Solution {
        /**
         *
         * 执行用时 :1 ms, 在所有 java 提交中击败了100.00%的用户
         内存消耗 :36 MB, 在所有 java 提交中击败了36.96%的用户
         *
         */
        public int titleToNumber(String s) {
            char[] chars = s.toCharArray();
            int radix = 1;
            int sum =0;
            for (int i= chars.length -1; i >= 0; i--) {
                sum += (chars[i] - 'A' + 1) * radix;
                radix *= 26;
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().titleToNumber("ABB"));
    }

}
