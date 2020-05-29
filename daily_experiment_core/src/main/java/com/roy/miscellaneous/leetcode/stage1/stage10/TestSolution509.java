package com.roy.miscellaneous.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/10/21.
 *斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：

 F(0) = 0,   F(1) = 1
 F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 给定 N，计算 F(N)。

 示例 1：

 输入：2
 输出：1
 解释：F(2) = F(1) + F(0) = 1 + 0 = 1.

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/fibonacci-number
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestSolution509 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution509.class);

    /**
     *
     * 执行用时 :0 ms, 在所有 java 提交中击败了100.00%的用户
     内存消耗 :33.1 MB, 在所有 java 提交中击败了61.46%的用户
     *
     */
    static class Solution {
        public int fib(int N) {
            if ( N <= 0) {
                return 0;
            }
            if ( N==1) {
                return 1;
            }
            int  f0 = 0,  f1 =1, f2 = 0, tmp;
            for (int i = 2; i <= N; i++) {
                f2 = f0 + f1;
                f0 =  f1;
                f1 = f2;
            }
            return f2;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().fib(4));
    }

}
