package com.roy.miscellaneous.leetcode;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/9/16.
 *
 *泰波那契序列 Tn 定义如下： 

 T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2

 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。

  

 示例 1：

 输入：n = 4
 输出：4
 解释：
 T_3 = 0 + 1 + 1 = 2
 T_4 = 1 + 1 + 2 = 4
 示例 2：

 输入：n = 25
 输出：1389537

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/n-th-tribonacci-number
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TestSolution1137 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1137.class);

    /**
     */
    static class Solution {
        /**
         * 递归法
         * @param n
         * @return
         */
        public int tribonacci(int n) {
            if (n == 0) {
                return 0;
            } else if(n==1) {
                return 1;
            } else if (n==2) {
                return 1;
            } else {
                return tribonacci(n-1) + tribonacci(n-2) + tribonacci(n-3);
            }
        }

        /**
         * 循环法
         * @param n
         * @return
         */
        public int tribonacci_1(int n) {
            if (n == 0) {
                return 0;
            } else if(n==1) {
                return 1;
            } else if (n==2) {
                return 1;
            } else {
                int a0 = 0, a1=1,a2=1, an=0;
                for (int i=3; i<=n;i++) {
                    an = a0 + a1 +a2;
                    a0= a1;
                    a1 = a2;
                    a2 = an;
                }
                return an;
            }
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().tribonacci_1(25));
    }

}
