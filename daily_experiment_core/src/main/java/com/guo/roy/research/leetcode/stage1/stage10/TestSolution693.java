package com.guo.roy.research.leetcode.stage1.stage10;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/10/21.
 *给定一个正整数，检查他是否为交替位二进制数：换句话说，就是他的二进制数相邻的两个位数永不相等。

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

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/binary-number-with-alternating-bits
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestSolution693 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution693.class);

    /**
     *
     * 执行用时 :1 ms, 在所有 java 提交中击败了86.22%的用户
     * 内存消耗 :33.1 MB, 在所有 java 提交中击败了73.80%的用户
     *
     *
     * 思路 n ^ (n >>1) 后所以位都为 1，然后判断各位是不是1，用了循环
     */
    static class Solution {
        public boolean hasAlternatingBits(int n) {
            int k = n ^ (n >>1);

            while ((k & 0x1) !=0) {
                k = k >>1;
                if (k ==0) {
                    return true;
                }
            }
            return false;
        }

        /**
         * 执行用时 :0 ms, 在所有 java 提交中击败了100.00%的用户
         * 内存消耗 :33 MB, 在所有 java 提交中击败了73.80%的用户
         * 同上 思路 n ^ (n >>1) 后所以位都为 1，然后判断各位是不是1
         *
         * 优化点: 判断各位是不是都为1  不走循环，直接 k &(k+1) ==0
         * @param n
         * @return
         */
        public boolean hasAlternatingBits1(int n) {
            int k = n ^ (n >>1);
            return  (k & (k + 1)) == 0 ? true : false;


        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().hasAlternatingBits1(5));
    }

}
