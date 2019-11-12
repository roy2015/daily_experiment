package com.roy.miscellaneous.leetcode.stage1;

import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2019/10/12.
 *
 *
 */
public class TestSolution342 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution342.class);

    /**
     *
     *
     *
     * 执行用时 :1 ms, 在所有 Java 提交中击败了100.00%的用户
       内存消耗 :33.4 MB, 在所有 Java 提交中击败了14.23%的用户
     *
     * 思路：
     * (k & num) !=0 : 该有的要有
     * ((~k & 0x7fffffff) & num )==0： 不该有的不能有  (~k & 0x7fffffff) 求补码并最高位抹成0
     * ((num >>2) &((num >>2) -1))==0： 除4后还是2的幂
     *
     */
    static class Solution {
        public boolean isPowerOfFour(int num) {
            if (num == 1) {
                return true;
            }
//            int k = Integer.parseInt("01010101010101010101010101010100",2);
//            return ((k & num) !=0 && (((~k & 0x7fffffff) & num )==0) && (((num >>2) &((num >>2) -1))==0)) ;
            return ((0x55555554 & num) !=0 && ((  0xaaaaaaab & num )==0) && (((num >>2) &((num >>2) -1))==0)) ;
        }

        /**
         * 执行用时 :1 ms, 在所有 Java 提交中击败了100.00%的用户
         内存消耗 :33.5 MB, 在所有 Java 提交中击败了13.56%的用户
         *
         * @param num
         * @return
         */
        public boolean isPowerOfFour1(int num) {
            if (num == 1) {
                return true;
            }
            // int k = Integer.parseInt("0101 0101 0101 0101 0101 0101 0101 0100",2);
            return (( 0x55555554 & num) !=0 && ((num  &(num -1))==0)) ;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution().isPowerOfFour(1));
    }

}
