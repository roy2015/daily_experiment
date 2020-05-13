package com.roy.miscellaneous.leetcode.stage11;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/5/12 14:10
 * 给你一个仅由数字 6 和 9 组成的正整数 num。

你最多只能翻转一位数字，将 6 变成 9，或者把 9 变成 6 。

请返回你可以得到的最大数字。

 

示例 1：

输入：num = 9669
输出：9969
解释：
改变第一位数字可以得到 6669 。
改变第二位数字可以得到 9969 。
改变第三位数字可以得到 9699 。
改变第四位数字可以得到 9666 。
其中最大的数字是 9969 。
示例 2：

输入：num = 9996
输出：9999
解释：将最后一位从 6 变到 9，其结果 9999 是最大的数。
示例 3：

输入：num = 9999
输出：9999
解释：无需改变就已经是最大的数字了。
 

提示：

1 <= num <= 10^4
num 每一位上的数字都是 6 或者 9 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-69-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 */
public class TestSolution1323 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1323.class);


    static class Solution {
        /**
         * 执行结果：通过显示详情
         * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗 :36.3 MB, 在所有 Java 提交中击败了100.00%的用户
         * @param num
         * @return
         */
        public int maximum69Number (int num) {
            int k = num;
            int ys;//余数
            int js = 1;//基数
            int syjs = 0;//要使用的基数
            do {
                ys = k % 10;
                if (ys ==6) {
                    syjs = js;
                }
                k = k /10;
                js = js * 10;
            } while(k != 0);
            return num + 3 * syjs;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().maximum69Number(9696));
    }
}
