package com.roy.miscellaneous.leetcode.stage12;

import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * @author guojun
 * @date 2020/5/18
 *
 * 66. 加一
给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

你可以假设除了整数 0 之外，这个整数不会以零开头。

示例 1:

输入: [1,2,3]
输出: [1,2,4]
解释: 输入数组表示数字 123。
示例 2:

输入: [4,3,2,1]
输出: [4,3,2,2]
解释: 输入数组表示数字 4321。
 *
 *
 */
public class TestSolution66 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution66.class);


    static class Solution {

        /**
         *
         * 要考虑进位的情况，特别是最高位进位，因为数组长度不够的
         *
         *
         * 执行结果：
         通过
         显示详情
         执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
         内存消耗 :38.2 MB, 在所有 Java 提交中击败了5.63%的用户
         *
         * @param digits
         * @return
         */
        public int[] plusOne(int[] digits) {
            int len = digits.length;
            int[] retArray = new int[digits.length +1];
            int k = len;
            int  jw = 0;
            int val = 0;
            for (int i = len -1 ;i>= 0; i --) {
                if (i == len -1 ) {
                    val = digits[i] + 1;
                } else{
                    val = digits[i];
                }

                val =  val + jw;
                if(val > 9) {
                    retArray[k] = val - 10;
                    jw = 1;
                } else {
                    retArray[k] = val;
                    jw =0;
                }
                k --;
            }

            if (jw ==1) {
                retArray[0] =1;
                return retArray;
            } else{
                return Arrays.copyOfRange(retArray, 1, len +1 );
            }
        }

    }

    public static void main(String[] args) {
        logger.info("{}", new Solution());
    }
}
