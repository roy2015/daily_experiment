package com.roy.miscellaneous.leetcode.stage2.stage20;

import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author guojun
 * @date 2020/1/21 10:40
 *
 * 面试题 16.01. 交换数字
 * 编写一个函数，不用临时变量，直接交换numbers = [a, b]中a与b的值。
 *
 * 示例：
 *
 * 输入: numbers = [1,2]
 * 输出: [2,1]
 * 提示：
 *
 * numbers.length == 2
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/bracket-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestInterview16_01 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestInterview16_01.class);


    static class Solution {
        /**
         * 距离法， 一般情况下是对，当11位就会Integer超界计算会错,主要原因是2a,2b会超
         *
         * @param numbers
         * @return
         */
        public int[] swapNumbers(int[] numbers) {
            numbers[0] = numbers[0] + (numbers[0] -  numbers[1]); //2a-b, b
            numbers[1] = (numbers[0] +  numbers[1]) /2 ; //(2a-b +b)=a  2a-b, a
            numbers[0] = (numbers[1] * 2 -  numbers[0]) ;
            return numbers;
        }

        /**
         * xor, 瞎碰的，也不知道写的啥，写几个测试用例却证明是对的~~
         *
         *执行结果：
         * 通过
         * 显示详情
         * 执行用时：
         * 0 ms, 在所有 Java 提交中击败了100.00%的用户
         * 内存消耗：
         * 37.5 MB, 在所有 Java 提交中击败了100.00%的用户
         *
         * @param numbers
         * @return
         */
        public int[] swapNumbers1(int[] numbers) {
            numbers[0] ^= ~numbers[1];// A = A ^(~B)
            numbers[1] ^= ~numbers[0];// B= B ^(~A)
            numbers[0] ^= ~numbers[1];// A = A ^(~B)
            return numbers;
        }

        public int[] swapNumbers2(int[] numbers) {
            numbers[0] = numbers[0] + numbers[1];
            numbers[1] = numbers[0] - numbers[1];
            numbers[0] = numbers[0] - numbers[1];
            return numbers;
        }
    }

    public static void main(String[] args) {
        logger.info("{}", Integer.MAX_VALUE);
        logger.info("{}" , new Solution().swapNumbers1(new int[]{2147483647,2147483647}));//55,33
        logger.info("{}" , new Solution().swapNumbers1(new int[]{33,55}));//55,33
        logger.info("{}" , new Solution().swapNumbers1(new int[]{1758650493,46142079}));//46142079 1758650493
    }
}
