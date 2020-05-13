package com.roy.miscellaneous.leetcode.stage11;

import org.slf4j.LoggerFactory;

/**
 * @author guojun
 * @date 2020/5/13 17:05
 *
 * 633. 平方数之和
给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。

示例1:

输入: 5
输出: True
解释: 1 * 1 + 2 * 2 = 5


示例2:

输入: 3
输出: False
 */
public class TestSolution633 {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestSolution633.class);


    static class Solution {
        /**
         *
         * 超出时间限制 >1s
         * @param c
         * @return
         */
        public boolean judgeSquareSum(int c) {
            int max = (int) Math.floor(Math.sqrt(c));

            for(int i =0; i<= max; i++) {
                int a1 = i * i;
                for (int j =i; j<= max; j++) {
                    int a2 = j * j;
                    if (a1 + a2 > c) {
                        break;
                    } else if (a1 + a2 == c) {
                        return true;
                    }

                }
            }
            return false;
        }

        /**
         *
         * 参考题解的，  双指针，好巧妙，咋没想到？？
         *
         * 执行结果：通过
         * 显示详情
         * 执行用时 :2 ms, 在所有 Java 提交中击败了97.62%的用户
         * 内存消耗 :36.4 MB, 在所有 Java 提交中击败了14.29%的用户
         *
         * @param c
         * @return
         */
        public boolean judgeSquareSum_1(int c) {
            int max = (int) Math.sqrt(c);
            int left =0;
            int right = max;

            while (left <= right) {
                int sum = left * left + right *right;
                if (sum == c) {
                    return true;
                } else if(sum < c) {
                    left ++;
                } else{
                    right --;
                }

            }
            return false;

        }
    }

    public static void main(String[] args) {
        logger.info("{}", new Solution());
    }
}
