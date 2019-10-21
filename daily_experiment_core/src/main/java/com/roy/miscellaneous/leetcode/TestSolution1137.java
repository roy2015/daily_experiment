package com.roy.miscellaneous.leetcode;

import org.slf4j.LoggerFactory;

/**
 * 给定一个正整数，检查他是否为交替位二进制数：换句话说，就是他的二进制数相邻的两个位数永不相等。

 示例 1:

 输入: 5
 输出: True
 解释:
 5的二进制数是: 101
 示例 2:

 输入: 7
 输出: False
 解释:
 7的二进制数是: 111
 示例 3:

 输入: 11
 输出: False
 解释:
 11的二进制数是: 1011
  示例 4:

 输入: 10
 输出: True
 解释:
 10的二进制数是: 1010

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/binary-number-with-alternating-bits
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TestSolution1137 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution1137.class);

    /**
     */
    static class Solution {
        /**
         * 超出时间限制
         *
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
         *
         * 执行用时 :0 ms, 在所有 java 提交中击败了100.00%的用户
         内存消耗 :33.1 MB, 在所有 java 提交中击败了100.00%的用户
         *
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
