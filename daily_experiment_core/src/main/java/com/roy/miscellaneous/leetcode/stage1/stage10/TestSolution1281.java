package com.roy.miscellaneous.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/2/9 15:20
 *
 * 给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。

 

示例 1：

输入：n = 234
输出：15
解释：
各位数之积 = 2 * 3 * 4 = 24
各位数之和 = 2 + 3 + 4 = 9
结果 = 24 - 9 = 15
示例 2：

输入：n = 4421
输出：21
解释：
各位数之积 = 4 * 4 * 2 * 1 = 32
各位数之和 = 4 + 4 + 2 + 1 = 11
结果 = 32 - 11 = 21
 

提示：

1 <= n <= 10^5

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TestSolution1281 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1281.class);


    static class Solution {
        /**
         执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
         内存消耗 :32.8 MB, 在所有 Java 提交中击败了93.02%的用户
         * @param n
         * @return
         */
        public int subtractProductAndSum(int n) {
            int sum =0;
            int mul = 1;
            int k =0;
            do {
                k = n % 10;
                if (mul != 0) {
                    mul *= k;
                }
                sum += k;
                n = n / 10;
            } while (n != 0);
            return mul - sum;
        }
    }

    public static void main(String[] args) {
        logger.info(new Solution().subtractProductAndSum(4421) + "");
    }
}
