package com.roy.miscellaneous.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/11/14.
 *给定一个正整数，返回它在 Excel 表中相对应的列名称。

 例如，

 1 -> A
 2 -> B
 3 -> C
 ...
 26 -> Z
 27 -> AA
 28 -> AB
 ...
 示例 1:

 输入: 1
 输出: "A"
 示例 2:

 输入: 28
 输出: "AB"
 示例 3:

 输入: 701
 输出: "ZY"

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/excel-sheet-column-title
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestSolution168 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution168.class);

    /**
     *
     *  总和 = an *power(26,n-1) + a3* power(26,2) + a2* power(26,1) +  a1* power(26,0)
     *  an表示第n位的数字
     *  对这个求和 ai *power(26,i-1) i的范围[1,n]
     *
     * 执行用时 :0 ms, 在所有 java 提交中击败了100.00%的用户
     内存消耗 :33.7 MB, 在所有 java 提交中击败了84.66%的用户
     *
     */
    static class Solution {
        public String convertToTitle(int n) {
            StringBuffer sb = new StringBuffer();
            int remainder;
            if (n <= 26) {
                sb.append((char)('A' + n - 1));
                return sb.toString();
            }

            //扫掉个位后就是26的倍数
            remainder = n % 26;
            if (remainder == 0) {
                remainder = 26;
            }
            sb.append((char)(remainder + 'A' -1));

            //分离出各个位
            do {
                n = n - remainder;
                n = n / 26;
                remainder = n %26;
                if (remainder == 0) {
                    remainder = 26;
                }
                sb.insert(0,(char)(remainder + 'A' -1));//本来用的是append，最后reverse，发现这个insert性能更好，直接往前面插
            } while (n > 26);
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().convertToTitle(28));
    }

}
